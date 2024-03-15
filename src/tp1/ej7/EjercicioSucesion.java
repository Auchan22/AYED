package tp1.ej7;

import java.util.ArrayList;
import java.util.List;

public class EjercicioSucesion {
	public List<Integer> calcularSucesion(int n){
		List<Integer> arr = new ArrayList<Integer>();
		calc(n, arr);
		return arr;
	}
	
	private Integer calc(int n, List<Integer> arr) {
		arr.add(n);
		if(n != 1) {
			if(Math.floorMod(n, 2) == 0) {
				return calc(n/2, arr);
			}else {
				return calc(3*n + 1, arr);
			}
		}else {
			return 1;
		}
	}
	
	public static void main(String[] args) {
		 if (args.length  == 0){
        	 System.out.println("El programa se ejecuto sin parametros");
        	 return;
		 }
		 EjercicioSucesion E = new EjercicioSucesion();
		 List<Integer> arr = E.calcularSucesion(Integer.parseInt(args[0]));
		 System.out.println(args[0]);
		 arr.forEach(s -> System.out.println(s));
	}
}
