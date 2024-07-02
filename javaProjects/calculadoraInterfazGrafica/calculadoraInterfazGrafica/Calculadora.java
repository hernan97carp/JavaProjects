package calculadoraInterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Calculadora extends JFrame implements ActionListener {

	// Declaring all the components
	private JTextField pantalla;
	private JButton[] numeros;
	private JButton suma, resta, multiplicacion, division, igual, clear;
	private JPanel panel;

	// Variables for calculation
	private double num1, num2, resultado;
	private char operador;

	public Calculadora() {
		// Set the frame properties
		setTitle("Calculadora");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// Create the display field
		pantalla = new JTextField();
		pantalla.setEditable(false);
		pantalla.setFont(new Font("Arial", Font.BOLD, 24));
		add(pantalla, BorderLayout.NORTH);

		// Initialize the panel and set its layout
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		// rows,colm,x,y

		// Initialize number buttons
		numeros = new JButton[10];
		for (int i = 0; i < 10; i++) {
			numeros[i] = new JButton(String.valueOf(i));
			// (String.valueOf(i) convierte el entero i en una cadena de caracteres).
			// el constructor de JButton espera un String como argumento para establecer el
			// texto que se mostrará en el botón.
			numeros[i].setFont(new Font("Arial", Font.BOLD, 24));
			numeros[i].addActionListener(this);
			panel.add(numeros[i]);
		}

		// Initialize operator buttons
		suma = new JButton("+");
		resta = new JButton("-");
		multiplicacion = new JButton("*");
		division = new JButton("/");
		igual = new JButton("=");
		clear = new JButton("C");

		// Set the font for operator buttons
		JButton[] botonesOperadores = { suma, resta, multiplicacion, division, igual, clear };
		for (JButton boton : botonesOperadores) {
			boton.setFont(new Font("Arial", Font.BOLD, 24));
			boton.addActionListener(this);
		}

		// Add operator buttons to the panel
		panel.add(suma);
		panel.add(resta);
		panel.add(multiplicacion);
		panel.add(division);
		panel.add(igual);
		panel.add(clear);

		// Add the panel to the frame
		add(panel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// recorre los índices del 0 al 9 para comprobar si el origen del evento
		// (e.getSource())
		// es uno de los botones numéricos (numeros[i]).
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numeros[i]) {
				pantalla.setText(pantalla.getText().concat(String.valueOf(i)));
				// pantalla.getText() obtiene el texto actual en la pantalla, y
				// concat(String.valueOf(i))
				// añade el número correspondiente al final de este texto.
				// actualiza la pantalla con el nuevo texto.
			}
		}
		if (e.getSource() == suma) {
			num1 = Double.parseDouble(pantalla.getText());
			operador = '+';
			pantalla.setText("");
		}
		if (e.getSource() == resta) {
			// Double que convierte una cadena que representa un número decimal en un valor
			// double.
			num1 = Double.parseDouble(pantalla.getText());
			operador = '-';
			pantalla.setText("");
		}
		if (e.getSource() == multiplicacion) {
			num1 = Double.parseDouble(pantalla.getText());
			operador = '*';
			pantalla.setText("");
		}
		if (e.getSource() == division) {
			num1 = Double.parseDouble(pantalla.getText());
			operador = '/';
			pantalla.setText("");
		}
		if (e.getSource() == igual) {
			num2 = Double.parseDouble(pantalla.getText());
			switch (operador) {
			case '+':
				resultado = num1 + num2;
				break;
			case '-':
				resultado = num1 - num2;
				break;
			case '*':
				resultado = num1 * num2;
				break;
			case '/':
				resultado = num1 / num2;
				break;
			}
			pantalla.setText(String.valueOf(resultado));
			num1 = resultado;
		}
		if (e.getSource() == clear) {
			pantalla.setText("");
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			Calculadora calc = new Calculadora();
			calc.setVisible(true);
		});
	}

	// EventQueue.invokeLater es un método utilizado para asegurar que el código
	// dentro
	// de su bloque se ejecute en el hilo de despacho de eventos (Event Dispatch
	// Thread, EDT).
    //El EDT es responsable de manejar la creación y actualización de componentes de la interfaz gráfica en Swing.
    // El uso de invokeLater garantiza que la interfaz gráfica se construya y manipule de manera segura dentro del EDT,
    //    evitando posibles problemas de concurrencia.

}