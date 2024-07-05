package calculadoraInterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {

    // Declaring all the components
    private JTextField pantalla;
    private JButton[] numeros;
    private JButton suma, resta, multiplicacion, division, igual, clear;
    private JPanel panel;

    // Variables for calculation
    private double num1, num2, resultado;
    private char operador;
    private boolean resultadoMostrado;

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
        pantalla.setHorizontalAlignment(JTextField.RIGHT); // Align text to the right
        add(pantalla, BorderLayout.NORTH);

        // Initialize the panel and set its layout
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Initialize number buttons
        numeros = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numeros[i] = new JButton(String.valueOf(i));
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

        resultadoMostrado = false; // Initialize resultadoMostrado to false
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numeros[i]) {
                if (resultadoMostrado) {
                    pantalla.setText(""); // Clear the display if a result was previously shown
                    resultadoMostrado = false;
                }
                pantalla.setText(pantalla.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == suma) {
            if (resultadoMostrado) {
                operador = '+';
                num1 = resultado; // Usar el último resultado como primer operando
                pantalla.setText(String.valueOf(resultado) + " + ");
                resultadoMostrado = false;
            } else {
                num1 = Double.parseDouble(pantalla.getText());
                operador = '+';
                pantalla.setText(pantalla.getText() + " + ");
            }
        }
        if (e.getSource() == resta) {
            if (resultadoMostrado) {
                operador = '-';
                num1 = resultado; // Usar el último resultado como primer operando
                pantalla.setText(String.valueOf(resultado) + " - ");
                resultadoMostrado = false;
            } else {
                num1 = Double.parseDouble(pantalla.getText());
                operador = '-';
                pantalla.setText(pantalla.getText() + " - ");
            }
        }
        if (e.getSource() == multiplicacion) {
            if (resultadoMostrado) {
                operador = '*';
                num1 = resultado; // Usar el último resultado como primer operando
                pantalla.setText(String.valueOf(resultado) + " * ");
                resultadoMostrado = false;
            } else {
                num1 = Double.parseDouble(pantalla.getText());
                operador = '*';
                pantalla.setText(pantalla.getText() + " * ");
            }
        }
        if (e.getSource() == division) {
            if (resultadoMostrado) {
                operador = '/';
                num1 = resultado; // Usar el último resultado como primer operando
                pantalla.setText(String.valueOf(resultado) + " / ");
                resultadoMostrado = false;
            } else {
                num1 = Double.parseDouble(pantalla.getText());
                operador = '/';
                pantalla.setText(pantalla.getText() + " / ");
            }
        }
        if (e.getSource() == igual) {
            if (resultadoMostrado) {
                return; // Do nothing if the result is already shown
            }
            String[] partes = pantalla.getText().split(" ");
            if (partes.length < 3) {
                JOptionPane.showMessageDialog(this, "Operación incompleta", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            num2 = Double.parseDouble(partes[partes.length - 1]);
            try {
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
                        if (num2 == 0) {
                            throw new ArithmeticException("División por cero");
                        }
                        resultado = num1 / num2;
                        break;
                }
                pantalla.setText(pantalla.getText() + " = " + String.valueOf(resultado));
                num1 = resultado;
                resultadoMostrado = true;
            } catch (ArithmeticException ex) {
            	pantalla.setText("");
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == clear) {
            pantalla.setText("");
            resultadoMostrado = false;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Calculadora calc = new Calculadora();
            calc.setVisible(true);
        });
    }
}

