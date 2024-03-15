package tp1.ej5;

public class Calculadora {
	public static Datos metodoA(int[] valores) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = 0; i < valores.length; i++) {
			if(valores[i] >= max) {
				max = valores[i];
			}
			if(valores[i] <= min) {
				min = valores[i];
			}
			sum += valores[i];
		}
		double prom = sum/valores.length;
		Datos d = new Datos();
		d.setMax(max);
		d.setMin(min);
		d.setPromedio(prom);
		
		return d;
	}
	
	public static void metodoB(int[] valores, Datos d) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = 0; i < valores.length; i++) {
			if(valores[i] >= max) {
				max = valores[i];
			}
			if(valores[i] <= min) {
				min = valores[i];
			}
			sum += valores[i];
		}
		double prom = sum/valores.length;
		d.setMax(max);
		d.setMin(min);
		d.setPromedio(prom);
	}
	
	
	public static void metodoC(int[] valores) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = 0; i < valores.length; i++) {
			if(valores[i] >= max) {
				max = valores[i];
			}
			if(valores[i] <= min) {
				min = valores[i];
			}
			sum += valores[i];
		}
		double prom = sum/valores.length;
		Datos d = new Datos();
		d.setMax(max);
		d.setMin(min);
		d.setPromedio(prom);
		
		d.imprimir();
	}
}
