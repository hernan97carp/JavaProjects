package cajero;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Abstracta transaccion = new Consulta();
      transaccion.setSaldo(500);
      transaccion.Operaciones();
	}

}
