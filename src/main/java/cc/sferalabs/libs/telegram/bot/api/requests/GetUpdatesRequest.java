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

/**
 *
 * @author Giampiero Baggiani
 *
 * @version 1.0.0
 *
 */
public class GetUpdatesRequest extends Request {

	/**
	 * 
	 * @param offset
	 * @param limit
	 * @param timeout
	 */
	public GetUpdatesRequest(Integer offset, Integer limit, Integer timeout) {
		super("getUpdates");
		addParameter("offset", offset);
		addParameter("limit", limit);
		addParameter("timeout", timeout);
	}

}
