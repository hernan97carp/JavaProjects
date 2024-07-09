package ejercicios;

/*
 * Escribe un programa que imprima los 50 primeros números de la sucesión
 * de Fibonacci empezando en 0.
 * - La serie Fibonacci se compone por una sucesión de números en
 *   la que el siguiente siempre es la suma de los dos anteriores.
 *   0, 1, 1, 2, 3, 5, 8, 13...
 */
public class _03_Fibonacci {

	public _03_Fibonacci() {
		// TODO Auto-generated constructor stub
		int n = 50;
		long[] fibonacchi = new long[n]; // Array para almacenar los términos

		fibonacchi[0] = 0;
		fibonacchi[1] = 1;

		for (int i = 2; i < n; i++) {
			fibonacchi[i] = fibonacchi[i - 1] + fibonacchi[i - 2];
		}

		for (int i = 0; i < n; i++) {
			System.out.println(fibonacchi[i]);
			if (i < n - 1) {
				System.out.println(", ");
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_03_Fibonacci fibonacciPlay = new _03_Fibonacci();

	}

}

/*
 * En Java, long es un tipo de dato primitivo que se utiliza para almacenar
 * enteros de gran tamaño. Un valor long ocupa 64 bits (8 bytes) de memoria y
 * puede representar valores enteros en el rango de − 2 63 −2 63 a 2 63 − 1 2 63
 * −1. Esto es útil cuando se necesita almacenar números que exceden el rango de
 * un int, que ocupa 32 bits y tiene un rango de − 2 31 −2 31 a 2 31 − 1 2 31
 * −1.
 * 
 * En el contexto de la sucesión de Fibonacci, los valores pueden crecer
 * rápidamente y superar el límite de un int, especialmente cuando se calcula
 * una cantidad significativa de términos, como los primeros 50. Por esta razón,
 * se utiliza long para evitar desbordamientos y asegurar que los valores se
 * almacenen correctamente.
 * 
 *  La sucesión de Fibonacci es una serie de números
 * enteros en la que cada número es la suma de los dos números anteriores.
 * Comienza con 0 y 1, y continúa de la siguiente manera:
 * 
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
 * 
 * Es decir, después de los dos primeros números, cada número en la serie se
 * calcula sumando los dos números anteriores. En términos matemáticos, la
 * sucesión de Fibonacci se define por la siguiente relación de recurrencia:
 * 
 * 𝐹 ( 𝑛 ) = 𝐹 ( 𝑛 − 1 ) + 𝐹 ( 𝑛 − 2 ) F(n)=F(n−1)+F(n−2)
 * 
 * con las condiciones iniciales:
 * 
 * 𝐹 ( 0 ) = 0 F(0)=0 𝐹 ( 1 ) = 1 F(1)=1
 * 
 */