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
public class Update extends Type {

	/**
	 * Constructs an Update object from the passed JSON object
	 * 
	 * @param obj the JSON object
	 */
	public Update(JSONObject obj) {
		super(obj);
	}

	/**
	 * @return the updateId
	 */
	public long getUpdateId() {
		return getInt("update_id");
	}

	/**
	 * @return the message
	 */
	public Message getMessage() {
		Object m = get("message");
		if (m == null) {
			return null;
		} else {
			return new Message((JSONObject) m);
		}
	}
}
