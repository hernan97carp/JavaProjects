package ejericiciosBasic;

import java.util.Scanner;

public class _01_Exercise {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        helloWorld();
        
        sumarDosNumeros(2, 2);
        
        sumarDosNumerosScanner(scanner);
        parImpar(scanner);
        
       
        scanner.close();
    }

    public static void helloWorld() {
        System.out.println("Hello World");
    }
    
    
    public static void sumarDosNumeros(int a, int b) {
    	int result = a + b;
    	
     System.out.println(result);
    }
    
    public static void sumarDosNumerosScanner(Scanner scanner) {
    	System.out.println("Ingresa el primer numero :");
    	int a = scanner.nextInt();
    	System.out.println("Ingresa el segundo numero");
    	int b = scanner.nextInt();
    	 int suma = a + b;
         System.out.println("La suma es: " + suma);
    	
    }
    
    public static void parImpar(Scanner scanner) {
    	System.out.println("Par o impar--ingresa un numero: ");
        int num = scanner.nextInt();
        if(num % 2 == 0) {
         System.out.println("Es par");
        	
        }
        else {
        	System.out.println("Es impar");
        }
   
    }
    
    
}