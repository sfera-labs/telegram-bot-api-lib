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

package cc.sferalabs.libs.telegram.bot.api.types;

import java.util.Arrays;

import org.json.simple.JSONArray;

/**
 *
 * @author Giampiero Baggiani
 *
 * @version 1.0.0
 *
 */
public class ReplyKeyboardMarkup extends ReplyMarkup {

	/**
	 * @param keyboard
	 * @param resizeKeyboard
	 * @param oneTimeKeyboard
	 * @param selective
	 */
	public ReplyKeyboardMarkup(String[][] keyboard, Boolean resizeKeyboard, Boolean oneTimeKeyboard,
			Boolean selective) {
		super(new Object[] { "keyboard", toJsonArray(keyboard) },
				new Object[] { "resize_keyboard", resizeKeyboard },
				new Object[] { "one_time_keyboard", oneTimeKeyboard },
				new Object[] { "selective", selective });
	}

	/**
	 * @param keyboard
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static JSONArray toJsonArray(String[][] keyboard) {
		JSONArray matrix = new JSONArray();
		for (String[] line : keyboard) {
			JSONArray array = new JSONArray();
			array.addAll(Arrays.asList(line));
			matrix.add(array);
		}
		return matrix;
	}

}
