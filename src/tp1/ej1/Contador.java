package tp1.ej1;

public class Contador {
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
}


