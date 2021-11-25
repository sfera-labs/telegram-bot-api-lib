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
public abstract class Type {

	protected final JSONObject obj;

	/**
	 * @param obj
	 *            the JSON object
	 */
	public Type(JSONObject obj) {
		this.obj = obj;
	}

	/**
	 * Returns the value of the specified field, or {@code null} if there is no
	 * such field
	 * 
	 * @param field
	 *            the field name
	 * @return the value of the specified field
	 */
	public Object get(String field) {
		return obj.get(field);
	}

	/**
	 * Returns the value of the specified filed as int. The field must exist
	 * 
	 * @param field
	 *            the field name
	 * @return the value of the specified filed as int
	 */
	public long getInt(String field) {
		return (long) get(field);
	}

	/**
	 * Returns the value of the specified filed as String
	 * 
	 * @param field
	 *            the field name
	 * @return the value of the specified filed as String
	 */
	public String getString(String field) {
		return (String) get(field);
	}

	/**
	 * Returns the value of the specified filed as Boolean
	 * 
	 * @param field
	 *            the field name
	 * @return the value of the specified filed as Boolean
	 */
	public Boolean getBoolean(String field) {
		return (Boolean) get(field);
	}

	/**
	 * Returns the value of the specified filed as JSON object
	 * 
	 * @param field
	 *            the field name
	 * @return the value of the specified filed as JSON object
	 */
	public JSONObject getJsonObject(String field) {
		return (JSONObject) get(field);
	}

	/**
	 * Returns this type as JSON object
	 * 
	 * @return this type as JSON object
	 */
	public JSONObject toJson() {
		return obj;
	}

	@Override
	public String toString() {
		return obj.toString();
	}
}
