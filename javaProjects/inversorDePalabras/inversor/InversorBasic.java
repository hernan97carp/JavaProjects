
package inversor;

public class InversorBasic{
    public static void main(String[] args) {
        String str = "hello world";
        String reversedStr = reverseStringUsingSubstring(str);
        System.out.println(reversedStr);  // Salida: "dlrow olleh"
    }

    public static String reverseStringUsingSubstring(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.substring(i, i + 1);
        }
        return reversed;
    }
}