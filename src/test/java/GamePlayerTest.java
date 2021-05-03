/*
 * @(#) GamePlayer.java 2021. 05. 02.
 *
 * Created by cooingpop
 */

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.game.racing.model.Car;
import com.game.racing.model.GamePlayer;

/**
 * @author 박준영
 **/
public class GamePlayerTest {

	@ParameterizedTest()
	@DisplayName("입력받은 이름만큼 게임 플레이어 생성")
	@CsvSource(value = {"Sun, Speed, Mate:3", "Sun, Speed, Mate, Silk:4",
						"Sun, Speed:2","Bio, Logic, XAM, DEO, LIO:5 "}, delimiter = ':')
	public void checkPlayerCount(String input, int expected) {
		assertThat(new GamePlayer(input).getPlayerCount() == expected).isTrue();
	}

	@ParameterizedTest()
	@DisplayName("자동차 2대 이상인 경우에 레이싱 가능 여부 확인")
	@CsvSource(value = {"Sun :false", "Sun, Speed, Mate, Silk:true",
		"Sun, Speed:true","Bio, Logic, XAM, DEO, LIO:true "}, delimiter = ':')
	public void checkAvailableRaceing(String input, boolean expected) {
		assertThat(new GamePlayer(input).isAvailableRacing() == expected).isTrue();
	}

	@Test
	@DisplayName("가장 멀리간 자동차 승자 확인")
	public void checkWinner() {
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Car car3 = new Car("car3");

		car1.setPosition(3);
		car2.setPosition(5);
		car3.setPosition(2);
		List<Car> carList = new ArrayList<>();

		carList.add(car1);
		carList.add(car2);
		carList.add(car3);

		GamePlayer gamePlayer = new GamePlayer();
		assertThat(gamePlayer.getWinners(carList).contains(car2)).isTrue();

	}

}
