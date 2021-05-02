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
}
