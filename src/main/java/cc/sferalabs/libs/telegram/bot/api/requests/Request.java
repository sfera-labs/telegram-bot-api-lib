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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Giampiero Baggiani
 *
 * @version 1.0.0
 *
 */
public abstract class Request {

	private final String methodName;
	private Map<String, String> parameters;

	/**
	 * @param methodName
	 */
	public Request(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * @return the methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * @return
	 */
	public Map<String, String> getParameters() {
		return parameters;
	}

	/**
	 * 
	 * @param name
	 * @param value
	 */
	protected void addParameter(String name, Object value) {
		if (value == null) {
			return;
		}
		if (parameters == null) {
			parameters = new HashMap<>();
		}
		parameters.put(name, value.toString());
	}

}
