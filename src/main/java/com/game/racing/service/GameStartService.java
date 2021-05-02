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

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println(GAME_START_MESSAGE);
		String input = scanner.next();

		System.out.println(GAME_TRY_MESSAGE);
		int moveCount = scanner.nextInt();

		GamePlayer gamePlayer = new GamePlayer(input);
		gamePlayer.setMoveCount(moveCount);

		System.out.println(GAME_PLAY_MESSAGE);
		gamePlayer.start();
	}
}
