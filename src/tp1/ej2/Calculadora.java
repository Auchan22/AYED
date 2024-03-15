package tp1.ej2;

public class Calculadora {
	
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
}
