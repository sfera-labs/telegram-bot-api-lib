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
	 *            the method name
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
	 * @return the parameters map
	 */
	public Map<String, String> getParameters() {
		return parameters;
	}

	/**
	 * Adds the specified parameter.
	 * 
	 * @param name
	 *            the parameter name
	 * @param value
	 *            the parameter value
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
