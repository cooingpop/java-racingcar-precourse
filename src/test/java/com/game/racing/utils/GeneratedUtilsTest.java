package com.game.racing.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

/**
 * @author 박준영
 **/
class GeneratedUtilsTest {

	@RepeatedTest(100)
	@DisplayName("0 에서 9사이 랜덤 값 생성")
	public void getRandomNumber() {
		int randomNumber = GeneratedUtils.getRandomNumber(0, 9);
		System.out.println(randomNumber);
		assertThat(randomNumber >= 0 && randomNumber <= 9).isTrue();
	}
}