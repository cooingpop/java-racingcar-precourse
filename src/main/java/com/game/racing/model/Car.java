/*
 * @(#) Car.java 2021. 05. 02.
 *
 * Created by cooingpop
 */

package com.game.racing.model;

/**
 * @author 박준영
 **/
public class Car {
	private final int MAX_LENGTH_CAR_NAME = 5;
	private final int MIN_LENGTH_CAR_NAME = 1;

	public final String EXCEPTION_MESSAGE_INPUT_LENGTH = "이름의 길이는 1 ~ 5자만 가능합니다.";
	public final String EXCEPTION_MESSAGE_INPUT_NULL = "이름은 null 입력할 수 없습니다.";

	private String name;
	private int position;

	public Car() {

	}

	public Car(String input) {
		if (input == null) {
			throw new NullPointerException(EXCEPTION_MESSAGE_INPUT_NULL);
		}

		input = input.trim();

		if (MAX_LENGTH_CAR_NAME < input.length() || MIN_LENGTH_CAR_NAME >= input.length()) {
			throw new IllegalArgumentException(EXCEPTION_MESSAGE_INPUT_LENGTH);
		}

		this.name = input;
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}
