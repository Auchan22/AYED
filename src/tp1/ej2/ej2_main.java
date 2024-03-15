package tp1.ej2;

import java.util.Scanner;

public class ej2_main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el valor de n: ");
        int n = scanner.nextInt();
        
        int[] resultado = Calculadora.multiplos(n);
        
        System.out.println("Los " + n + " primeros múltiplos de " + n + " son:");
        Calculadora.imprimirMultiplos(resultado);
        
        scanner.close();
    }
}
