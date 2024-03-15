package tp1.ej7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EjercicioListas {
	public void invertirArrayList(ArrayList<Integer> lista) {
		
		if(lista.size() > 1) {
			Integer item = lista.remove(0);
			invertirArrayList(lista);
			lista.add(item);
		}
	}
	
	public int sumarLinkedList(LinkedList<Integer> lista) {
		if(lista.size() == 0) {
			return 0;
		}else {
			return lista.removeFirst() + sumarLinkedList(lista);
		}
	}
	
	public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
		List<Integer> new_arr = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		
		while(i < lista1.size() && j < lista2.size()) {
			int elem1 = lista1.get(i);
			int elem2 = lista2.get(j);
			
			if(elem1 < elem2) {
				new_arr.add(elem1);
				i++;
			}else {
				new_arr.add(elem2);
				j++;
			}
		}
		
		 // Agregamos los elementos restantes de lista1 (si los hay)
        while (i < lista1.size()) {
            new_arr.add(lista1.get(i));
            i++;
        }

        // Agregamos los elementos restantes de lista2 (si los hay)
        while (j < lista2.size()) {
            new_arr.add(lista2.get(j));
            j++;
        }
        
        return (ArrayList<Integer>)new_arr;
	}
	
	public static void main(String[] args) {
		EjercicioListas e = new EjercicioListas();
		List<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
		System.out.println("-- INICIANDO EJECUCION --");
		System.out.println("Lista original: ");
		arr.forEach(n -> System.out.println("Numero: "+ n));
		System.out.println("");
		System.out.println("Lista Modificada: ");
		e.invertirArrayList((ArrayList<Integer>)arr);
		arr.forEach(n -> System.out.println("Numero: "+ n));
		System.out.println("");
		System.out.println("---------------");
		System.out.println("");
		List<Integer> arr_l = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
		System.out.println("Lista original: ");
		arr_l.forEach(n -> System.out.println("Numero: "+ n));
		System.out.println("");
		System.out.println("Total: "+e.sumarLinkedList((LinkedList<Integer>)arr_l));
		System.out.println("");
		System.out.println("---------------");
		System.out.println("");
        ArrayList<Integer> lista1 = new ArrayList<>();
        lista1.add(1);
        lista1.add(3);
        lista1.add(5);
        
        ArrayList<Integer> lista2 = new ArrayList<>();
        lista2.add(2);
        lista2.add(4);
        lista2.add(6);
        ArrayList<Integer> new_arr = e.combinarOrdenado(lista1, lista2);
		System.out.println("Lista generada: ");
		new_arr.forEach(n -> System.out.println("Numero: "+ n));
        
	}
}
