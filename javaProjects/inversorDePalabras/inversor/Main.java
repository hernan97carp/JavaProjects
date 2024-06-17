package inversor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialChoice;
        int choice;

        do {
            // Preguntar al usuario si quiere introducir una cadena o salir
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1: Introducir una cadena");
            System.out.println("2: Salir de la aplicación");
            initialChoice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea restante

            switch (initialChoice) {
                case 1:
                    do {
                        // Pedir al usuario que ingrese una cadena
                        System.out.print("Introduce una cadena: ");
                        String str = scanner.nextLine();

                        // Invertir la cadena
                        String reversedStr = reverseStringWithStringBuilder(str);

                        // Mostrar la cadena invertida
                        System.out.println("Cadena invertida: " + reversedStr);

                        // Preguntar al usuario si quiere continuar o salir
                        System.out.println("¿Deseas invertir otra cadena? (1: Sí, 2: No): ");
                        choice = scanner.nextInt();
                        scanner.nextLine();  // Consumir el salto de línea restante

                        switch (choice) {
                            case 1:
                                // Continuar con el bucle
                                break;
                            case 2:
                                // Salir del bucle
                                System.out.println("Regresando al menú principal...");
                                break;
                            default:
                                // Opción inválida
                                System.out.println("Opción inválida, regresando al menú principal...");
                                choice = 2;  // Salir del bucle
                                break;
                        }
                    } while (choice != 2);
                    break;
                case 2:
                    // Salir de la aplicación
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    // Opción inválida
                    System.out.println("Opción inválida, por favor elige 1 o 2.");
                    break;
            }
        } while (initialChoice != 2);

        scanner.close();
    }

    public static String reverseStringWithStringBuilder(String str) {
        // Crear un StringBuilder a partir de la cadena original
        StringBuilder sb = new StringBuilder(str);

        // Invertir el contenido del StringBuilder
        sb.reverse();

        // Convertir el StringBuilder a String y devolverlo
        return sb.toString();
    }
}