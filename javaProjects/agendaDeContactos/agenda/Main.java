
package agenda;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Contact");
            System.out.println("2. Find Contact");
            System.out.println("3. Display All Contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    contactBook.addContact(name, phoneNumber);
                    break;
                case 2:
                    System.out.print("Enter name to search: ");
                    name = scanner.nextLine();
                    Contact contact = contactBook.findContact(name);
                    if (contact != null) {
                        System.out.println("Contact found: " + contact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 3:
                    contactBook.displayContacts();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
