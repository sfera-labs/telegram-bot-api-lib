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
public abstract class ReplyMarkup {

	private final String jsonString;

	/**
	 * 
	 * @param fields
	 *            the fields-values pairs
	 */
	@SuppressWarnings("unchecked")
	public ReplyMarkup(Object[]... fields) {
		JSONObject obj = new JSONObject();
		for (Object[] field : fields) {
			if (field[1] != null) {
				obj.put(field[0], field[1]);
			}
		}
		this.jsonString = obj.toString();
	}

	/**
	 * @param json
	 *            the JSON string
	 */
	public ReplyMarkup(String json) {
		this.jsonString = json;
	}

	@Override
	public String toString() {
		return jsonString;
	}
}
