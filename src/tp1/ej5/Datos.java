package tp1.ej5;

public class Datos {
	private int max, min;
	private double promedio;
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
	public void imprimir() {
		System.out.println("Imprimiendo datos - Maximo: " + getMax() + ", Mínimo: " + getMin() + ", Promedio: " + getPromedio());
	}
}
