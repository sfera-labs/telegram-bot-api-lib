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
public class User extends Type {

	/**
	 * Constructs a User object from the passed JSON object.
	 * 
	 * @param obj
	 *            the JSON object
	 */
	public User(JSONObject obj) {
		super(obj);
	}

	/**
	 * @return the user id
	 */
	public int getId() {
		return getInt("id");
	}

	/**
	 * @return the user's first name
	 */
	public String getFirstName() {
		return getString("first_name");
	}

	/**
	 * @return the user's last name
	 */
	public String getLastName() {
		return getString("last_name");
	}

	/**
	 * @return the user's username
	 */
	public String getUsername() {
		return getString("username");
	}

}
