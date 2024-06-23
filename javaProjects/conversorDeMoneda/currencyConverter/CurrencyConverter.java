package currencyConverter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static final double USD_TO_EUR = 0.85;
    private static final double USD_TO_GBP = 0.75;
    private static final double USD_TO_INR = 74.85;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> currencyOptions = new LinkedHashMap<>();
        currencyOptions.put(1, "EUR");
        currencyOptions.put(2, "GBP");
        currencyOptions.put(3, "INR");

        System.out.println("Welcome to Currency Converter!");

        double usd = 0;
        boolean newAmount = true;
        while (true) {
            if (newAmount) {
                System.out.print("Enter amount in USD: ");
                usd = getValidDouble(scanner);
                System.out.println("You entered: " + ANSI_GREEN + usd + " USD" + ANSI_RESET);
                newAmount = false;
            }

            int choice;
            do {
                System.out.println("\nSelect the currency to convert to:");
                for (Map.Entry<Integer, String> entry : currencyOptions.entrySet()) {
                    System.out.println(entry.getKey() + ". " + entry.getValue());
                }
                System.out.println("4. Convert to USD");
                System.out.println("5. Enter new amount");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");
                choice = getValidInt(scanner);

                if (choice >= 1 && choice <= 3) {
                    double convertedAmount = convertCurrency(usd, choice);
                    System.out.println("Amount in " + currencyOptions.get(choice) + ": " + ANSI_GREEN + convertedAmount + ANSI_RESET);
                } else if (choice == 4) {
                    System.out.println("Amount in USD: " + ANSI_GREEN + usd + ANSI_RESET);
                } else if (choice == 5) {
                    newAmount = true;
                    break; // Break the inner loop to allow re-entering a new amount
                } else if (choice == 6) {
                    System.out.println("Exiting program...");
                    scanner.close();
                    return; // Exit the program
                } else {
                    System.out.println(ANSI_RED + "Invalid choice!" + ANSI_RESET);
                }

            } while (choice != 5); // Continue the inner loop unless user wants to enter a new amount
        }
    }

    public static double convertCurrency(double usd, int choice) {
        switch (choice) {
            case 1:
                return usd * USD_TO_EUR;
            case 2:
                return usd * USD_TO_GBP;
            case 3:
                return usd * USD_TO_INR;
            default:
                return -1;
        }
    }

    public static double getUSDToEUR() {
        return USD_TO_EUR;
    }

    public static double getUSDToGBP() {
        return USD_TO_GBP;
    }

    public static double getUSDToINR() {
        return USD_TO_INR;
    }

    private static double getValidDouble(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                throw new RuntimeException("User opted to exit.");
            }
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print(ANSI_RED + "Invalid input. Please enter a valid amount (or 'q' to quit): " + ANSI_RESET);
            }
        }
    }

    private static int getValidInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print(ANSI_RED + "Invalid input. Please enter a valid choice: " + ANSI_RESET);
            }
        }
    }
}
