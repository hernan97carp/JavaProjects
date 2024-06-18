package calculator;
import java.util.Scanner;
public class CalculatorApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter first number: ");
			double num1 = scanner.nextDouble();

			System.out.print("Enter an operator (+, -, *, /): ");
			char operator = scanner.next().charAt(0);

			System.out.print("Enter second number: ");
			double num2 = scanner.nextDouble();
            Calculator calculator = new Calculator();
            
			double result;

			switch (operator) {
			    case '+':
			        result = calculator.add(num1, num2);
			        break;
			    case '-':
			        result = calculator.subtract(num1, num2);
			        break;
			    case '*':
			        result = calculator.multiply(num1, num2);
			        break;
			    case '/':
			  result = calculator.divide(num1, num2);
			        break;
			    default:
			        System.out.println("Invalid operator!");
			        return;
			}

			System.out.println("The result is: " + result);
		}
    }
}

