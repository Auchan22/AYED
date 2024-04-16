package tp3.ej2;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class TestEjercicio2 {
	public static void main(String[] args) {
		GeneralTree<Integer> a15 = new GeneralTree<Integer>(15);
		GeneralTree<Integer> a18 = new GeneralTree<Integer>(18);
		
		a18.addChild(a15);
		
		GeneralTree<Integer> a21 = new GeneralTree<Integer>(21);
		
		GeneralTree<Integer> a11 = new GeneralTree<Integer>(11);
		GeneralTree<Integer> a7 = new GeneralTree<Integer>(7);
		
		List<GeneralTree<Integer>> children9 = new LinkedList<GeneralTree<Integer>>();
		children9.add(a11);
		children9.add(a7);
		
		GeneralTree<Integer> a9 = new GeneralTree<Integer>(9, children9);
		
		List<GeneralTree<Integer>> children50 = new LinkedList<GeneralTree<Integer>>();
		
		children50.add(a21);
		children50.add(a9);
		
		GeneralTree<Integer> a50 = new GeneralTree<Integer>(50, children50);
		
		GeneralTree<Integer> a4 = new GeneralTree<Integer>(4);
		GeneralTree<Integer> a6 = new GeneralTree<Integer>(6);
		GeneralTree<Integer> a10 = new GeneralTree<Integer>(10);
		
		List<GeneralTree<Integer>> children19 = new LinkedList<GeneralTree<Integer>>();
		children19.add(a4);
		children19.add(a6);
		children19.add(a10);
		
		GeneralTree<Integer> a19 = new GeneralTree<Integer>(19, children19);
		
		List<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
		children.add(a18);
		children.add(a50);
		children.add(a19);
		
		GeneralTree<Integer> a180 = new GeneralTree<Integer>(180, children);
		
		RecorridosAg r = new RecorridosAg();
		List<Integer> l_preorden = r.numeroImparesMayoresQuePreOrden(a180, 2);
		for(Integer i: l_preorden) {
			System.out.println(i);
		}
		System.out.println("");
		/*List<Integer> l_inorden = r.numeroImparesMayoresQueInOrden(a180, 2);
		for(Integer i: l_inorden) {
			System.out.println(i);
		}*/
		
		List<Integer> l_posorden = r.numeroImparesMayoresQuePosOrden(a180, 2);
		for(Integer i: l_posorden) {
			System.out.println(i);
		}
	}
}
