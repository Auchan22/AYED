package tp1;

import java.util.Scanner;

public class ejercicio_2 {
	
	public static int[] multiplos(int n) {
		int [] m = new int[n];
		
		for(int i = 0; i < m.length; i++) {
			m[i] = (i+1)*n;
		}
		
		return m;
	}
	
	public static void imprimirMultiplos(int[] m) {
		for (int i = 0; i < m.length; i++) {
            System.out.print(m[i]);
            if (i < m.length - 1) {
                System.out.print("; ");
            }
        }
	}
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el valor de n: ");
        int n = scanner.nextInt();
        
        int[] resultado = multiplos(n);
        
        System.out.println("Los " + n + " primeros múltiplos de " + n + " son:");
        imprimirMultiplos(resultado);
        
        scanner.close();
    }
}
