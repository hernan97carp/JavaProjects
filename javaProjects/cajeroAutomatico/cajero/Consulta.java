package cajero;

public class Consulta extends Abstracta{
	@Override
	public void Transacciones() {
	        System.out.println("------------------------------------");
	        System.out.println("Tu saldo actual es: " + getSaldo());
	        System.out.println("------------------------------------");
	}

}
