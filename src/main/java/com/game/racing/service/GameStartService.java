/*
 * @(#) GameStartService.java 2021. 05. 02.
 *
 * Created by cooingpop
 */

package com.game.racing.service;

import java.util.Scanner;

import com.game.racing.model.GamePlayer;

/**
 * @author 박준영
 **/
public class GameStartService {
	private static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
	private static final String GAME_TRY_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String GAME_PLAY_MESSAGE = "실행 결과";
	private static final String GAME_UNAVAILABLE_MESSAGE = "자동차는 2대 이상있어야 경주가 가능합니다.";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println(GAME_START_MESSAGE);
		String input = scanner.nextLine();

		System.out.println(GAME_TRY_MESSAGE);
		int tryCount = scanner.nextInt();

		GamePlayer gamePlayer = new GamePlayer(input);
		gamePlayer.setTryCount(tryCount);

		if (gamePlayer.isAvailableRacing()) {
			start(gamePlayer, tryCount);
			System.out.println(GAME_PLAY_MESSAGE);
			result(gamePlayer);
		} else {
			System.out.println(GAME_UNAVAILABLE_MESSAGE);
		}
	}

	public static void start(GamePlayer gamePlayer, int tryRunCount) {
		for (int i = 0; i < tryRunCount; ++i) {
			gamePlayer.race();
			gamePlayer.printGameCurrent();
		}
	}

	public static void result(GamePlayer gamePlayer) {
		gamePlayer.printGameResult();
	}
}
