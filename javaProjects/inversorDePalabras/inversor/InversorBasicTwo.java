package inversor;
public class InversorBasicTwo {
    public static void main(String[] args) {
        String str = "hello world";

        // Método 1: Utilizando un bucle
        String reversedStr1 = reverseStringWithLoop(str);
        System.out.println("Con bucle: " + reversedStr1);  // Salida: "dlrow olleh"

        // Método 2: Utilizando StringBuilder
        String reversedStr2 = reverseStringWithStringBuilder(str);
        System.out.println("Con StringBuilder: " + reversedStr2);  // Salida: "dlrow olleh"
    }

    // Método 1: Utilizando un bucle
    public static String reverseStringWithLoop(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    // Método 2: Utilizando StringBuilder
    public static String reverseStringWithStringBuilder(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}