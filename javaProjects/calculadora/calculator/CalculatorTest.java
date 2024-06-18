package calculator;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Random;

public class CalculatorTest {

	private Calculator calculator;
	private Random random;
	private double num1;
	private double num2;
	double expected;
	double result;
	@BeforeMethod
	public void setUp() {
		calculator = new Calculator();
		random = new Random();
	}

	private double getRandomNumber() {
		return random.nextDouble() * 100;
	}

	private double[] generateNumbersForDivision() {
		num1 = getRandomNumber();
		num2 = getRandomNumber();
		return new double[] { num1, num2 };
	}

	@Test
	public void testAdd() {
		num1 = getRandomNumber();
		num2 = getRandomNumber();
		expected = num1 + num2;
	    result = calculator.add(num1, num2);
		assertOperationResult(result, expected, num1, num2, "+");
	}

	@Test
	public void testSubtract() {
		num1 = getRandomNumber();
		num2 = getRandomNumber();
	 expected = num1 - num2;
		result = calculator.subtract(num1, num2);
		assertOperationResult(result, expected, num1, num2, "-");
	}

	@Test
	public void testMultiply() {
		num1 = getRandomNumber();
		num2 = getRandomNumber();
	    expected = num1 * num2;
		 result = calculator.multiply(num1, num2);
		assertOperationResult(result, expected, num1, num2, "*");
	}

	@Test
	public void testDivide() {
		double[] numbers = generateNumbersForDivision();
		num1 = numbers[0];
		num2 = numbers[1];
		
		if (num2 == 0) {
			// Handle division by zero case
			 throw new IllegalArgumentException("Skipping test for division by zero: num2 is " + num2);

		} else {
			expected = num1 / num2;
			result = calculator.divide(num1, num2);
			assertOperationResult(result, expected, num1, num2, "/");
		}
	}

	private void assertOperationResult(double result, double expected, double num1, double num2, String operator) {
		Assert.assertEquals(result, expected,
				String.format("Incorrect %s operation for %.2f and %.2f. Expected %.2f but got %.2f.", operator, num1,
						num2, expected, result));
		System.out.println(
				String.format("Test passed: Calculated result for %.2f %s %.2f is %.2f, expected result is %.2f.", num1,
						operator, num2, result, expected));
	}

	/*
	 * %d: Entero decimal %f: Número de punto flotante (decimal) para mostrar el
	 * número con la precisión predeterminada %s: Cadena de texto %c: Carácter %b:
	 * Valor booleano %t: Fecha/hora (seguido por un carácter que define el tipo de
	 * fecha) %.2f indica dos lugares decimales.
	 * 
	 */
}
