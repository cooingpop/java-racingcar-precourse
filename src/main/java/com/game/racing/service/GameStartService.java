/*
 * @(#) GameStartService.java 2021. 05. 02.
 *
 * Created by cooingpop
 */

package com.game.racing.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.game.racing.model.GamePlayer;
import com.game.racing.utils.ValidationUtils;

/**
 * @author 박준영
 **/
public class GameStartService {
	private static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
	private static final String GAME_TRY_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String GAME_PLAY_MESSAGE = "실행 결과";
	private static final String GAME_UNAVAILABLE_MESSAGE = "현재 경주할 수 있는 상태가 아닙니다.";
	private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "입력한 값이 숫자형식이 아닙니다.";

	public static void main(String[] args) throws Exception {
		GamePlayer gamePlayer = new GamePlayer(inputCarName());

		if (gamePlayer.isAvailableRacing()) {
			start(gamePlayer, inputTryCount());
			result(gamePlayer);
		} else {
			System.out.println(GAME_UNAVAILABLE_MESSAGE);
		}
	}

	public static String inputCarName() throws IOException {
		System.out.println(GAME_START_MESSAGE);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		return br.readLine();
	}

	public static int inputTryCount() throws IOException, NumberFormatException {
		System.out.println(GAME_TRY_MESSAGE);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		if (!ValidationUtils.isValidNumber(input)) {
			throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
		}

		return Integer.parseInt(input);
	}

	public static void start(GamePlayer gamePlayer, int tryRunCount) {
		for (int i = 0; i < tryRunCount; ++i) {
			gamePlayer.race();
			gamePlayer.printGameCurrent();
		}
	}

	public static void result(GamePlayer gamePlayer) {
		System.out.println(GAME_PLAY_MESSAGE);
		gamePlayer.printGameResult();
	}
}
