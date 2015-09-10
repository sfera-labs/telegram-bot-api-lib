/**
 * Copyright (C) 2014-2015 Sfera Labs, a division of Home Systems Consulting S.p.A.
 * 
 *     http://www.hsyco.com/
 * 
 * This code is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * See file LICENSE.txt for further informations on licensing terms.
 * 
 */

package cc.sferalabs.libs.telegram.bot.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cc.sferalabs.libs.telegram.bot.api.requests.GetMeRequest;
import cc.sferalabs.libs.telegram.bot.api.requests.GetUpdatesRequest;
import cc.sferalabs.libs.telegram.bot.api.requests.Request;
import cc.sferalabs.libs.telegram.bot.api.requests.SendFileRequest;
import cc.sferalabs.libs.telegram.bot.api.types.Update;

/**
 *
 * @author Giampiero Baggiani
 *
 * @version 1.0.0
 *
 */
public class TelegramBot {

	private static final Logger log = LoggerFactory.getLogger(TelegramBot.class);
	private static final JSONParser parser = new JSONParser();
	private final String baseUrl;

	/**
	 * Constructs a Telegram Bot that uses the specified authentication token.
	 * 
	 * @param token
	 *            the authentication token
	 */
	public TelegramBot(String token) {
		if (token == null) {
			throw new NullPointerException("token null");
		}
		this.baseUrl = "https://api.telegram.org/bot" + token + "/";
	}

	/**
	 * Sends a request to the server
	 * 
	 * @param request
	 *            the request to be sent
	 * @param timeout
	 *            the read timeout value (in milliseconds) to be used for server
	 *            response. A timeout of zero is interpreted as an infinite
	 *            timeout.
	 * @return the JSON object representing the value of the field "result" of
	 *         the response JSON object cast to the specified type parameter
	 * @throws ResponseError
	 *             if the server returned an error response, i.e. the value of
	 *             the field "ok" of the response JSON object is {@code false}
	 * @throws ParseException
	 *             if an error occurs while parsing the server response
	 * @throws IOException
	 *             if an I/O exception occurs
	 */
	@SuppressWarnings("unchecked")
	public <T> T sendRequest(Request request, int timeout)
			throws IOException, ParseException, ResponseError {
		HttpURLConnection connection = null;
		try {
			URL url = buildUrl(request);
			log.debug("Performing request: {}", url);
			connection = (HttpURLConnection) url.openConnection();
			connection.setReadTimeout(timeout);

			if (request instanceof SendFileRequest) {
				MultipartEntityBuilder builder = MultipartEntityBuilder.create();
				Path filePath = ((SendFileRequest) request).getFilePath();
				builder.addBinaryBody(((SendFileRequest) request).getFileParamName(),
						filePath.toFile());
				HttpEntity multipart = builder.build();

				connection.setRequestMethod("POST");
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type",
						multipart.getContentType().getValue());
				connection.setRequestProperty("Content-Length", "" + multipart.getContentLength());

				try (OutputStream out = connection.getOutputStream()) {
					multipart.writeTo(out);
				}
			} else {
				connection.setRequestMethod("GET");
				connection.setRequestProperty("Content-Length", "0");
			}

			boolean httpOk = connection.getResponseCode() == HttpURLConnection.HTTP_OK;
			try (InputStream in = httpOk ? connection.getInputStream()
					: connection.getErrorStream();
					BufferedReader br = new BufferedReader(
							new InputStreamReader(in, StandardCharsets.UTF_8))) {
				JSONObject resp = (JSONObject) parser.parse(br);
				log.debug("Response: {}", resp);

				boolean ok = (boolean) resp.get("ok");
				if (!ok) {
					String description = (String) resp.get("description");
					if (description == null) {
						description = "ok=false";
					}
					throw new ResponseError(description);
				}
				return (T) resp.get("result");
			}
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	/**
	 * @param request
	 * @return
	 * @throws MalformedURLException
	 */
	private URL buildUrl(Request request) throws MalformedURLException {
		StringBuilder urlString = new StringBuilder(baseUrl + request.getMethodName());
		Map<String, String> params = request.getParameters();
		if (params != null && !params.isEmpty()) {
			char sep = '?';
			for (Entry<String, String> param : params.entrySet()) {
				urlString.append(sep);
				urlString.append(param.getKey());
				urlString.append('=');
				urlString.append(param.getValue());
				sep = '&';
			}
		}

		return new URL(urlString.toString());
	}

	/**
	 * Sends a 'getUpdates' requests with the specified parameters to receive
	 * incoming updates using long polling.
	 * 
	 * @param offset
	 *            the offset parameter
	 * @param limit
	 *            the limit parameter
	 * @param timeout
	 *            the timeout parameter
	 * @return a list containing the received updates
	 * @throws ResponseError
	 *             if the server returned an error response
	 * @throws ParseException
	 *             if an error occurs while parsing the server response
	 * @throws IOException
	 *             if an I/O exception occurs
	 */
	@SuppressWarnings("unchecked")
	public List<Update> pollUpdates(Integer offset, Integer limit, Integer timeout)
			throws IOException, ParseException, ResponseError {
		JSONArray updates = sendRequest(new GetUpdatesRequest(offset, limit, timeout),
				timeout + 5000);
		return (List<Update>) updates.stream().map(u -> new Update((JSONObject) u))
				.collect(Collectors.toList());
	}

	/**
	 * A simple method to test the connection to the server and the bot auth
	 * token
	 * 
	 * @param timeout
	 *            the read timeout value (in milliseconds) to be used for server
	 *            response. A timeout of zero is interpreted as an infinite
	 *            timeout.
	 * @return the name of the bot
	 * @throws ResponseError
	 *             if the server returned an error response
	 * @throws ParseException
	 *             if an error occurs while parsing the server response
	 * @throws IOException
	 *             if an I/O exception occurs
	 */
	@SuppressWarnings("rawtypes")
	public String getBotName(int timeout) throws IOException, ParseException, ResponseError {
		Map result = sendRequest(GetMeRequest.INSTANCE, timeout);
		return (String) result.get("username");
	}

}
