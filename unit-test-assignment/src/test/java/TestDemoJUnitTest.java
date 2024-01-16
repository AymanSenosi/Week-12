import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() ->

			testDemo.addPositive(a, b))

					.isInstanceOf(IllegalArgumentException.class);
		}
	}

	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {

		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	}

	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(

		// @formatter:off
				Arguments.of(2, 4, 6, false), 
				Arguments.of(1, 4, 5, false), 
				Arguments.of(0, 5, 5, false),
				Arguments.of(1, 9, 10, false)
		//@formatter:on

		);

	}

	// I used a ParameterizedTest to test if two numbers are multiplied correctly
	// using arguments in my argumentsForMultiplyNumbers stream method.
	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForMultiplyNumbers")
	void assertThatTwoNumbersAreMultipliedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.multiplyNumbers(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() ->

			testDemo.multiplyNumbers(a, b))

					.isInstanceOf(IllegalArgumentException.class);
		}
	}

	static Stream<Arguments> argumentsForMultiplyNumbers() {
		return Stream.of(

		// @formatter:off
				Arguments.of(2, 2, 4, false), 
				Arguments.of(5, 8, 40, false), 
				Arguments.of(10, 10, 100, false),
				Arguments.of(1, 9, 9, false)
		//@formatter:on

		);

	}

	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);

		doReturn(5).when(mockDemo).getRandomInt();

		int fiveSquared = mockDemo.randomNumberSquared();

		assertThat(fiveSquared).isEqualTo(25);
	}

}
