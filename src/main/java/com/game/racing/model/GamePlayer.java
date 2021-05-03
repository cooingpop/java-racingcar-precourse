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

	public GamePlayer() {

	}

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

	public boolean isAvailableRacing() {
		if (getCarList().size() > 1) {
			return true;
		}

		return false;
	}

	public void race() {
		for (Car car : this.carList) {
			car.goForward();
		}
	}

	public int getWinnerPosition(List<Car> carList) {
		int maxValue = 0;

		for (Car car : carList) {
			maxValue = Math.max(car.getPosition(), maxValue);
		}

		return maxValue;
	}

	public List<Car> getWinners(List<Car> carList) {
		List<Car> winners = new ArrayList<>();
		int maxValue = getWinnerPosition(carList);
		for (Car car : carList) {
			if (maxValue == car.getPosition()) {
				winners.add(car);
			}
		}

		return winners;
	}

	public void printGameCurrent() {
		for (Car car : this.carList) {
			System.out.println(String.format("%s : %s", car.getName(), car.getCurrentPositionResult()));
		}

		System.out.println();
	}

	public void printGameResult() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Car car : getWinners(this.carList)) {
			stringBuilder.append(car.getName()).append(",");
		}

		stringBuilder.delete(stringBuilder.length() -1, stringBuilder.length());
		System.out.println(String.format("%s 가 최종 우승했습니다.", stringBuilder.toString()));
	}

}
