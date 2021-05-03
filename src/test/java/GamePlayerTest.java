/*
 * @(#) GamePlayer.java 2021. 05. 02.
 *
 * Created by cooingpop
 */

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

}
