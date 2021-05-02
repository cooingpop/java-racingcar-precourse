/*
 * @(#) GeneratedUtils.java 2021. 05. 02.
 *
 * Created by cooingpop
 */

package com.game.racing.utils;

import java.util.Random;

/**
 * @author 박준영
 **/
public class GeneratedUtils {

	/**
	 * 랜덤 숫자 생성
	 * @param min : 최소값
	 * @param max : 최대값
	 * @return min ~ max 랜덤 숫자
	 */
	public static int getRandomNumber(int min, int max) {
		return new Random().nextInt(max - min + 1) + min;
	}
}
