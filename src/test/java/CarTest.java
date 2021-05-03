/*
 * @(#) Car.java 2021. 05. 02.
 *
 * Created by cooingpop
 */

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

	@ParameterizedTest()
	@DisplayName("자동차 위치에 따라 실행결과 '-' 표시")
	@CsvSource(value = {"5:-----", "4:-----","1:-","2:-- "}, delimiter = ':')
	public void setCarName2(int position, String bar) {
		Car car = new Car();
		car.setPosition(position);
		assertThat(car.getCurrentPositionResult().equals(bar)).isTrue();
	}

	@RepeatedTest(100)
	@DisplayName("랜덤값이 4이상인 경우 움직일 수 있다.")
	public void getRandomNumber() {
		Car car = new Car();
		int number = car.getRandomNumber();
		System.out.println(number);
		assertThat(car.canGoForward(number) == true).isTrue();
	}

}
