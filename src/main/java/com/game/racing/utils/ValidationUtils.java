/*
 * @(#) ValidationUtils.java 2021. 05. 03.
 *
 * Created by cooingpop
 */

package com.game.racing.utils;

/**
 * @author 박준영
 **/
public class ValidationUtils {

	public static boolean isValidNumber(String input) {
		String regExp = "^[1-9]+$";
		return input.matches(regExp);
	}
}
