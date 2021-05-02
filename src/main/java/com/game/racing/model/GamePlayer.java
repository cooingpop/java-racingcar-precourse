/*
 * @(#) GamePlayer.java 2021. 05. 02.
 *
 * Created by cooingpop
 */

package com.game.racing.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 박준영
 **/
public class GamePlayer {
	private List<Car> carList;

	public GamePlayer(String input) {
		carList = new ArrayList<>();
		String[] playerName = input.trim().split(",");

		for (String name : playerName) {
			carList.add(new Car(name));
		}
	}

	public List<Car> getCarList() {
		return carList;
	}

	public int getPlayerCount() {
		return getCarList().size();
	}
}
