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

/**
 *
 * @author Giampiero Baggiani
 *
 * @version 1.0.0
 *
 */
public class SendChatActionRequest extends Request {

	public static final String ACTION_TYPING = "typing";
	public static final String ACTION_UPLOAD_PHOTO = "upload_photo";
	public static final String ACTION_RECORD_VIDEO = "record_video";
	public static final String ACTION_UPLOAD_VIDEO = "upload_video";
	public static final String ACTION_RECORD_AUDIO = "record_audio";
	public static final String ACTION_UPLOAD_AUDIO = "upload_audio";
	public static final String ACTION_UPLOAD_DOCUMENT = "upload_document";
	public static final String ACTION_FIND_LOCATION = "find_location";

	/**
	 * 
	 * @param chatId
	 *            the chat_id parameter
	 * @param action
	 *            the action parameter
	 */
	public SendChatActionRequest(int chatId, String action) {
		super("sendChatAction");
		addParameter("chat_id", chatId);
		addParameter("action", action);
	}

}
