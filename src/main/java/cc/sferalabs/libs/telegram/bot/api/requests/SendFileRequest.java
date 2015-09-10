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
	 * @param chatId
	 * @param path
	 * @param parameter
	 * @param replyToMessageId
	 * @param replyMarkup
	 */
	public SendFileRequest(String methodName, int chatId, Path path, String parameter,
			Integer replyToMessageId, ReplyMarkup replyMarkup) {
		super(methodName);
		addParameter("chat_id", chatId);
		this.path = path;
		this.parameter = parameter;
		addParameter("reply_to_message_id", replyToMessageId);
		addParameter("reply_markup", replyMarkup);
	}

	/**
	 * @return
	 */
	public Path getFilePath() {
		return path;
	}

	/**
	 * @return
	 */
	public String getFileParamName() {
		return parameter;
	}
}
