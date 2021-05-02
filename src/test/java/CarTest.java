/*
 * @(#) Car.java 2021. 05. 02.
 *
 * Created by cooingpop
 */

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.game.racing.model.Car;

/**
 * @author 박준영
 **/
public class CarTest {

	@ParameterizedTest()
	@DisplayName("자동차 이름은 5자 이하만 가능하다.")
	@ValueSource( strings = {"Sun", "River", "Fire", "SpeedShot"})
	public void setCarName(String input) {
		assertThat(new Car(input).getName().length() <= 5).isTrue();
	}

	@ParameterizedTest()
	@DisplayName("자동차 이름은 5자리 초과할 경우 오류 발생")
	@ValueSource( strings = {"", " ", "speedspeed", "Sun"})
	public void setCarName2(String input) {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy( () -> {
			new Car(input);
		}).withMessageMatching(new Car().EXCEPTION_MESSAGE_INPUT_LENGTH);
	}

}
