package cajero;

public class Deposito extends Abstracta {
	@Override
	public void Transacciones() {
        System.out.print("Cuanto deseas depositar: ");
        Deposito();
        
        transacciones = getSaldo();
        setSaldo(transacciones + deposito);
        System.out.println("-----------------------------------");
        System.out.println("Depositaste: " + deposito);
        System.out.println("Tu saldo actual es: " + getSaldo());
        System.out.println("-----------------------------------");
	}

}
