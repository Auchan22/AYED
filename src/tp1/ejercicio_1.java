package tp1;

public class ejercicio_1 {
	public static void metodoA(int a, int b) {
		for(int i = a; i <= b; i++) {
			System.out.println(i);
		}
	}
	
	public static void metodoB(int a, int b) {
		int i = a;
		while (i <= b) {
			System.out.println(i);
			i++;
		}
	}

	public static void metodoC(int a, int b) {
		if(a <= b) {
			System.out.println(a);
			metodoC(a + 1, b);
		}
	}
	
	public static void main(String[] args) {
        // Llamadas de ejemplo a los métodos
        System.out.println("Imprimir con for:");
        metodoA(1, 5);
        
        System.out.println("\nImprimir con while:");
        metodoB(3, 8);
        
        System.out.println("\nImprimir sin iterativos:");
        metodoC(10, 15);
    }
}


