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
	private final int MOVE_MAX_RANGE = 9;
	private final int MOVE_MIN_RANGE = 0;

	private List<Car> carList;
	private int moveCount;
	private int tryCount;

	public GamePlayer(String input) {
		this.carList = new ArrayList<>();
		String[] playerName = input.trim().split(",");

		for (String name : playerName) {
			this.carList.add(new Car(name));
		}
	}

	public List<Car> getCarList() {
		return this.carList;
	}

	public int getPlayerCount() {
		return getCarList().size();
	}

	public void setTryCount(int tryCount) {
		this.tryCount = tryCount;
	}

	public int getMoveCount() {
		return this.moveCount;
	}

	public int getTryCount() {
		return this.tryCount;
	}

	public boolean isAvailableRacing() {
		if (getCarList().size() > 1) {
			return true;
		}

		return false;
	}

	public boolean isGameCompleted() {
		if (this.moveCount == this.tryCount) {
			return true;
		}

		return false;
	}

	public void race() {
		for (Car car : this.carList) {
			car.goForward();
		}

		this.moveCount++;
	}

	public int getWinnerPosition() {
		int maxValue = 0;

		for (Car car : this.carList) {
			maxValue = Math.max(car.getPosition(), maxValue);
		}

		return maxValue;
	}

	public List<Car> getWinners(List<Car> carList) {
		List<Car> winners = new ArrayList<>();
		int maxValue = getWinnerPosition();
		for (Car car : carList) {
			if (maxValue == car.getPosition()) {
				winners.add(car);
			}
		}

		return winners;
	}


	public void printGameResult() {
		for (Car car : this.carList) {
			System.out.println(String.format("%s : %s", car.getName(), car.getCurrentPositionResult()));
		}
		System.out.println();
	}


}
