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
public class SendPhotoRequest extends SendFileRequest {

	/**
	 * @param chatId
	 *            the chat_id parameter
	 * @param path
	 *            the path of the file to send
	 * @param caption
	 *            the caption parameter
	 * @param replyToMessageId
	 *            the reply_to_message_id parameter
	 * @param replyMarkup
	 *            the reply_markup parameter
	 */
	public SendPhotoRequest(long chatId, Path path, String caption, Long replyToMessageId,
			ReplyMarkup replyMarkup) {
		super("sendPhoto", chatId, path, "photo", replyToMessageId, replyMarkup);
		addParameter("caption", caption);
	}

}
