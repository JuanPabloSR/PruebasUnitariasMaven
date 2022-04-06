package co.com.sofka.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class BasicCalculatorTest {

	private final BasicCalculator basicCalculator = new BasicCalculator();
	private static final Logger logger = LoggerFactory.getLogger(BasicCalculatorTest.class);

	@Test
	@DisplayName("Testing sum: 1+1=2")
	public void suma(){
		// aranque
		Long number1 = 1L;
		Long number2 = 1L;
		Long expectedValue = 2l;

		// accion
		long result = basicCalculator.suma(number1, number2);

		//assert
		assertEquals(expectedValue, result);
	}

	@DisplayName("Testing several sums")
	@ParameterizedTest(name = "{3} + {1} = {4}")
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})
	void severalSums(Long first, Long second, Long expectedResult) {
		assertEquals(expectedResult, basicCalculator.suma(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}

	@DisplayName("Testing several subs")
	@ParameterizedTest(name= "{5} - {1} = {4}")
	@CsvSource({
			"2,    1,   1",
			"5,    2,   3",
			"11,  1, 10",
			"150,  100, 50"
	})

	void SeveralSubs(Long first, Long second, Long expectedResult){
		assertEquals(expectedResult, basicCalculator.resta(first, second),
				() -> first + " - " + second + " should equal " + expectedResult);
	}

	@DisplayName("Testing several mults")
	@ParameterizedTest(name = "{10} * {5} = {50}")
	@CsvSource({
			"3,    1,   3",
			"7,    2,   14",
			"10,  1, 10",
			"1,  1, 1",
			"2, 4, 8",
			"6, 7, 42"
	})
	void severalMults(Long first, Long second, Long expectedResult) {
		Assertions.assertEquals(expectedResult, basicCalculator.multiplicacion(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}

	@DisplayName("Testing several divides")
	@ParameterizedTest(name = "{10} / {1} = {5}")
	@CsvSource({
			"40,    2,   20",
			"15,    3,   5",
			"10,  2, 5",
			"100,  4, 25",
			"2, 1, 2",
			"8, 2, 4"
	})
	void severalDivides(Long first, Long second, Long expectedResult) {
		Assertions.assertEquals(expectedResult, basicCalculator.division(first, second),
				() -> first + " / " + second + " should equal " + expectedResult);
	}
}
