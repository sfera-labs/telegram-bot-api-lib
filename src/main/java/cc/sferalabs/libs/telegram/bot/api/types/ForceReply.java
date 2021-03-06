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

/**
 *
 * @author Giampiero Baggiani
 *
 * @version 1.0.0
 *
 */
public class ForceReply extends ReplyMarkup {

	/**
	 * 
	 * @param selective
	 *            the selective parameter
	 */
	public ForceReply(Boolean selective) {
		super(new Object[] { "force_reply", true }, new Object[] { "selective", selective });
	}

}
