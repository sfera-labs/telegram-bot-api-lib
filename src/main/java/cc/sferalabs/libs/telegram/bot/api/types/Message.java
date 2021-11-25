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

package cc.sferalabs.libs.telegram.bot.api.types;

import org.json.simple.JSONObject;

/**
 *
 * @author Giampiero Baggiani
 *
 * @version 1.0.0
 *
 */
public class Message extends Type {

	/**
	 * Constructs a Message object from the passed JSON object
	 * 
	 * @param obj teh JSON object
	 */
	public Message(JSONObject obj) {
		super(obj);
	}

	/**
	 * @return the message id
	 */
	public long getMessageId() {
		return getInt("message_id");
	}

	/**
	 * @return the sender
	 */
	public User getFrom() {
		return new User(getJsonObject("from"));
	}

	/**
	 * @return the date the message was sent in Unix time
	 */
	public long getDate() {
		return getInt("date");
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return getString("text");
	}

}
