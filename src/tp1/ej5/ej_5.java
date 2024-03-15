package tp1.ej5;

public class ej_5 {
	public static void main(String[] args) {
		int[] valores = {5, 10, 3, 8, 15};
        
        // Usando método con "return"
        Datos d = Calculadora.metodoA(valores);
        System.out.println("Obteniendo datos con return");
        d.imprimir();
        
        // Usando método con parámetro
        Datos d1 = new Datos();
        Calculadora.metodoB(valores, d1);
        System.out.println("Obteniendo datos con return");
        d1.imprimir();
        
        // Usando método sin parámetros ni "return"
        Calculadora.metodoC(valores);
	}
}
