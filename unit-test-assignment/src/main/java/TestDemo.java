import java.util.Random;

public class TestDemo {
	public int addPositive(int a, int b) {

		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}

		return a + b;
	}
	
	// here I created a method to multiple two given parameters.
	public int multiplyNumbers(int a, int b) {
		return a * b;
	}

	int getRandomInt() {

		Random random = new Random();

		return random.nextInt(10) + 1;

	}

	public int randomNumberSquared() {
		int a = getRandomInt();

		return a * a;
	}
}
