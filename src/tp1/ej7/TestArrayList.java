package tp1.ej7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tp1.ej3.Estudiante;

public class TestArrayList {
	public static void main(String[] args) {
		 if (args.length  == 0){
        	 System.out.println("El programa se ejecuto sin parametros");
        	 return;
		 }
		 // Inciso a, b, c
		 /*List<Integer> arr = new ArrayList<Integer>();
		 for(String i: args) {
			 arr.add(Integer.parseInt(i));
		 }
		 arr.stream().forEach(i -> System.out.println("Numero: "+i));;
		 ArrayList:

			Es más eficiente para acceder a elementos por índice, ya que almacena los elementos en un arreglo dinámico y el acceso por índice es de complejidad O(1).
			La inserción y eliminación de elementos al final de la lista (o cerca de ella) es rápida, pero puede ser costosa si se insertan o eliminan elementos 
			en posiciones intermedias, ya que puede requerir reorganizar los elementos en el arreglo interno.
			LinkedList:
			
			Es más eficiente para la inserción y eliminación de elementos en el medio de la lista, ya que no requiere reorganizar la estructura de datos. 
			Sin embargo, el acceso por índice es menos eficiente (de complejidad O(n)), 
			ya que necesita recorrer la lista desde el principio o desde el final hasta la posición deseada.
			*/
		 
		 // Inciso D
		 //incisod();
		 
		 //Inciso F
		 /*
		 System.out.print("Es capicua?: ");
		 System.out.println(esCapicua(arr) ? "Si" : "No");
		 */
		 
		 //Inciso G
	}
	
	private static void incisod() {
		List<Estudiante> arr_estudiantes = new LinkedList<Estudiante>();
		Estudiante e1, e2, e3;
		
		e1 = new Estudiante();
		e2= new Estudiante();
		e3= new Estudiante();
		
		e1.setNombre("Agustin");
		e1.setApellido("Surila");
		e1.setEmail("agustinsurila@gmail.com");
		e1.setDireccion("Calle 1");
		e1.setComision("Maniana");
		
		e2.setApellido("Sanchez");
		e2.setEmail("pepesanchez@gmail.com");
		e2.setNombre("Pepe");
		e2.setDireccion("Calle 2");
		e2.setComision("Tarde");
		
		e3.setApellido("Gutierrez");
		e3.setEmail("g@gmail.com");
		e3.setNombre("Gaston");
		e3.setDireccion("Calle 3");
		e3.setComision("Maniana");
		
		arr_estudiantes.add(e3);
		arr_estudiantes.add(e2);
		arr_estudiantes.add(e1);
		
		List<Estudiante> arr_estudiantes_2 = new ArrayList<Estudiante>(arr_estudiantes);
		System.out.println("Lista Original");
		ImprimirLista(arr_estudiantes);
		System.out.println("");
		System.out.println("Lista copia");
		ImprimirLista(arr_estudiantes_2);
		arr_estudiantes_2.get(1).setApellido("Mendez");
		System.out.println("Lista Original");
		ImprimirLista(arr_estudiantes);
		System.out.println("");
		System.out.println("Lista copia");
		ImprimirLista(arr_estudiantes_2);
		
	}
	
	public static boolean esCapicua(List<Integer> lista) {
		int inicio = 0;
        int fin = lista.size() - 1;

        while (inicio < fin) {
            if (!lista.get(inicio).equals(lista.get(fin))) {
                return false;
            }
            inicio++;
            fin--;
        }
        return true;
		/*boolean par = Math.floorMod(lista.size(), 2) == 0;
		if(!par) {
			int mitad_length = lista.size() / 2;
			int[] primer = new int[mitad_length];
			int[] segundo = new int[mitad_length];
			boolean ok = true;
			for(int i = 0; i < mitad_length; i++) {
				segundo[i] = lista.get((lista.size()-1) - i);
				//System.out.println(lista.get((lista.size()-1) - i));
			}
			for(int j = 0; j < mitad_length; j++) {
				primer[j] = lista.get(j);
				//System.out.println(lista.get(j));
			}
			for(int i = 0; i < primer.length; i++) {
				if(primer[i] != segundo[i]) {
					ok = false;
					break;
				}
			}
			return ok;
		}
		return false;*/
	}
	
	private static void ImprimirLista(List<Estudiante> l) {
		l.stream().forEach(e -> System.out.println(e.tusDatos()));
	}
}
