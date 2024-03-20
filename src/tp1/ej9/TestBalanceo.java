package tp1.ej9;

import java.util.Scanner;
import java.util.Stack;

public class TestBalanceo {
	public static boolean estaBalanceado(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false; // No hay carácter de apertura correspondiente
                }
                char top = stack.pop(); //Es el caracter del principio
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false; // Carácter de cierre sin correspondencia
                }
            }
        }
        
        return stack.isEmpty(); // Si la pila está vacía, entonces el string está balanceado
    }
	
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        
	     System.out.print("Ingrese el valor del string: ");
	     String s = scanner.next();
        
        System.out.println("¿El string '" + s + "' está balanceado? " + estaBalanceado(s)); // Debería imprimir true
        //System.out.println("¿El string '" + input2 + "' está balanceado? " + estaBalanceado(input2)); // Debería imprimir false
    }
}
