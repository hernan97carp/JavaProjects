package cajero;

import java.util.Scanner;

public abstract class Abstracta {
	protected int transacciones, retiro, deposito;
	private static int saldo;
	Scanner entrada = new Scanner(System.in);

	public void Operaciones() {
		int bandera = 0;
		int seleccion = 0;
		do {
			do {
				System.out.println("Por favor seleccione una opcion:");
				System.out.println("    1. Consulta de saldo.");
				System.out.println("    2. Retiro de dinero");
				System.out.println("    3. Deposito de dinero");
				System.out.println("    4. Salir");
				seleccion = entrada.nextInt();

				if (seleccion >= 1 && seleccion <= 4) {
					bandera = 1;
				} else {
					System.out.println("-------------------------");
					System.out.println("opcion no disponible");
					System.out.println("-------------------------");
				}
			} while (bandera == 0);
			if (seleccion == 1) {
				Abstracta transaccion = new Consulta();
				transaccion.Transacciones();

			} else if (seleccion == 2) {
				Abstracta transaccion = new Retiro();
                transaccion.Transacciones();
			} else if (seleccion == 3) {
				Abstracta transaccion = new Deposito();
                transaccion.Transacciones();
			}
			 else if (seleccion == 4) {
			        System.out.println("--------------------------");
	                System.out.println("¡Gracias!, vuelva pronto.");
	                System.out.println("--------------------------");
	                bandera = 2;
				}
		} while (bandera != 2);
	}
	//metodos
	public void Retiro(){
		retiro = entrada.nextInt();
	}
	public void Deposito(){
		deposito = entrada.nextInt();
	}
	
	
	//Polimorfismo abstract 
	public abstract void Transacciones();
	
	//metodos getter y setter
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
}
