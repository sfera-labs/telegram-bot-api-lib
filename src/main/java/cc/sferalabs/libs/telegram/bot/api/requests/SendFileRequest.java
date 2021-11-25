/**
 * Copyright (C) 2014-2016 Sfera Labs Srl
 * 
 *     http://www.sferalabs.cc/
 * 
 * This code is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * See file LICENSE.txt for further informations on licensing terms.
 * 
 */

package cc.sferalabs.libs.telegram.bot.api.requests;

import java.nio.file.Path;

import cc.sferalabs.libs.telegram.bot.api.types.ReplyMarkup;

/**
 *
 * @author Giampiero Baggiani
 *
 * @version 1.0.0
 *
 */
public abstract class SendFileRequest extends Request {

	private final Path path;
	private final String parameter;

	/**
	 * 
	 * @param methodName
	 *            the method name
	 * @param chatId
	 *            the chat_id parameter
	 * @param path
	 *            the path of the file to send
	 * @param parameter
	 *            the name of the parameter identifying the file type
	 * @param replyToMessageId
	 *            the reply_to_message_id parameter
	 * @param replyMarkup
	 *            the reply_markup parameter
	 */
	public SendFileRequest(String methodName, long chatId, Path path, String parameter,
			Long replyToMessageId, ReplyMarkup replyMarkup) {
		super(methodName);
		addParameter("chat_id", chatId);
		this.path = path;
		this.parameter = parameter;
		addParameter("reply_to_message_id", replyToMessageId);
		addParameter("reply_markup", replyMarkup);
	}

	/**
	 * @return the file path
	 */
	public Path getFilePath() {
		return path;
	}

	/**
	 * @return the name of the parameter identifying the file type
	 */
	public String getFileParamName() {
		return parameter;
	}
}
