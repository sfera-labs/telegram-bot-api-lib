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

import cc.sferalabs.libs.telegram.bot.api.types.ReplyMarkup;

/**
 *
 * @author Giampiero Baggiani
 *
 * @version 1.0.0
 *
 */
public class SendMessageRequest extends Request {

	/**
	 * 
	 * @param chatId
	 *            the chat_id parameter
	 * @param text
	 *            the text parameter
	 * @param parseMode
	 *            the parse_mode parameter
	 * @param disableWebPagePreview
	 *            the disable_web_page_preview parameter
	 * @param replyToMessageId
	 *            the reply_to_message_id parameter
	 * @param replyMarkup
	 *            the reply_markup parameter
	 */
	public SendMessageRequest(int chatId, String text, String parseMode,
			Boolean disableWebPagePreview, Integer replyToMessageId, ReplyMarkup replyMarkup) {
		super("sendMessage");
		addParameter("chat_id", chatId);
		addParameter("text", text);
		addParameter("parse_mode", parseMode);
		addParameter("disable_web_page_preview", disableWebPagePreview);
		addParameter("reply_to_message_id", replyToMessageId);
		addParameter("reply_markup", replyMarkup);
	}

}
