/*
 * Escribe una función que reciba dos palabras (String) y retorne
 * verdadero o falso (Bool) según sean o no anagramas.
 * - Un Anagrama consiste en formar una palabra reordenando TODAS
 *   las letras de otra palabra inicial.
 * - NO hace falta comprobar que ambas palabras existan.
 * - Dos palabras exactamente iguales no son anagrama.
 * 
 */
package ejercicios;

import java.util.Arrays;

public class _02_Anagrama {

	public static boolean sonanagramas(String palabra1, String palabra2) {
		if (palabra1.length() != palabra2.length()) {
			return false;
		}
		char[] arr1 = palabra1.toCharArray();
		char[] arr2 = palabra2.toCharArray();

		Arrays.sort(arr1);
		Arrays.sort(arr2);
		return Arrays.equals(arr1, arr2);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String palabra1 = "roma";
		String palabra2 = "amor";
		if (sonanagramas(palabra1, palabra2)) {
			System.out.print(palabra1 + " y " + palabra2 + " son anagramas.");
		} else {
			System.out.print(palabra1 + " y " + palabra2 + " No son anagramas.");
		}
	}

}
