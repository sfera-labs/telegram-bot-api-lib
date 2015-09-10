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
public class SendAudioRequest extends SendFileRequest {

	/**
	 * @param chatId
	 * @param path
	 * @param duration
	 * @param performer
	 * @param title
	 * @param replyToMessageId
	 * @param replyMarkup
	 */
	public SendAudioRequest(int chatId, Path path, Integer duration, String performer, String title,
			Integer replyToMessageId, ReplyMarkup replyMarkup) {
		super("sendAudio", chatId, path, "audio", replyToMessageId, replyMarkup);
		addParameter("duration", duration);
		addParameter("performer", performer);
		addParameter("title", title);
	}

}
