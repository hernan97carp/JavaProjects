package calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Random;

public class CalculatorTest {

    private Calculator calculator;
    private Random random;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
        random = new Random();
    }

    private double getRandomNumber() {
        return random.nextDouble() * 100;
    }
    private double[] generateNumbersForDivision() {
        double num1= getRandomNumber();
        double num2 = getRandomNumber();
        return new double[]{num1, num2};
    }
    @Test
    public void testAdd() {
        double num1 = getRandomNumber();
        double num2 = getRandomNumber();
        double expected = num1 + num2;
        double result = calculator.add(num1, num2);
        assertOperationResult(result, expected, num1, num2, "+");
    }

    @Test
    public void testSubtract() {
        double num1 = getRandomNumber();
        double num2 = getRandomNumber();
        double expected = num1 - num2;
        double result = calculator.subtract(num1, num2);
        assertOperationResult(result, expected, num1, num2, "-");
    }

    @Test
    public void testMultiply() {
        double num1 = getRandomNumber();
        double num2 = getRandomNumber();
        double expected = num1 * num2;
        double result = calculator.multiply(num1, num2);
        assertOperationResult(result, expected, num1, num2, "*");
    }

    @Test
    public void testDivide() {
        double[] numbers = generateNumbersForDivision();
        double num1 = numbers[0];
        double num2 = numbers[1];

        double expected;
        double result;
        if (num2 != 0) {
            expected = num1 / num2;
            result = calculator.divide(num1, num2);
            assertOperationResult(result, expected, num1, num2, "/");
        } else {
            // Handle division by zero case
            System.out.println("Skipping test for division by zero: num2 is " + num2);
        }
    }
    

    private void assertOperationResult(double result, double expected, double num1, double num2, String operator) {
        Assert.assertEquals(result, expected, String.format("Incorrect %s operation for %.2f and %.2f. Expected %.2f but got %.2f.", operator, num1, num2, expected, result));
        System.out.println(String.format("Test passed: Calculated result for %.2f %s %.2f is %.2f, expected result is %.2f.", num1, operator, num2, result, expected));
    }
    


/*
 * %d: Entero decimal
%f: Número de punto flotante (decimal) para mostrar el número con la precisión predeterminada
%s: Cadena de texto
%c: Carácter
%b: Valor booleano
%t: Fecha/hora (seguido por un carácter que define el tipo de fecha)
%.2f indica dos lugares decimales.

 * */
}
