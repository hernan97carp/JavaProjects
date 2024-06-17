package currencyConverter;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to Currency Converter!");
   

        do {
            System.out.print("1.Enter amount in USD: ");
      
            double usd = scanner.nextDouble();
            
            System.out.println("Select the currency to convert to:");
            System.out.println("1. EUR");
            System.out.println("2. GBP");
            System.out.println("3. INR");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            double convertedAmount = 0;
            switch (choice) {
                case 1:
                    convertedAmount = usd * 0.85; // Example conversion rate
                    System.out.println("Amount in EUR: " + convertedAmount);
                    break;
                case 2:
                    convertedAmount = usd * 0.75; // Example conversion rate
                    System.out.println("Amount in GBP: " + convertedAmount);
                    break;
                case 3:
                    convertedAmount = usd * 74.85; // Example conversion rate
                    System.out.println("Amount in INR: " + convertedAmount);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

        } while (choice != 4);

        scanner.close();
    }
}
