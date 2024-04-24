package tp3.ej11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;
import tp3.ejercicio1.GeneralTree;

public class ParcialArboles {

	public static boolean resolver(GeneralTree<Integer> arbol) throws Exception {
		if(arbol.isEmpty()) return false;

		int cantNodos = 1;
		int ant = 0;
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		GeneralTree<Integer> ag;
		cola.enqueue(arbol);
		while(!cola.isEmpty()){
			if(cantNodos != ant + 1){
				return false;
			}else{
				for(int i = 0; i < cantNodos; i++){
					ag = cola.dequeue();
					for(GeneralTree<Integer> child: ag.getChildren()){
						cola.enqueue(child);
					}
				}
			}
			ant = cantNodos;
			cantNodos = cola.size();
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
		children3.add(new GeneralTree<Integer>(33));
		children3.add(new GeneralTree<Integer>(12));
		children3.add(new GeneralTree<Integer>(17));
		children3.add(new GeneralTree<Integer>(9));
		
		List<GeneralTree<Integer>> children4 = new LinkedList<GeneralTree<Integer>>();
		children4.add(new GeneralTree<Integer>(7));
		children4.add(new GeneralTree<Integer>(11));
		children4.add(new GeneralTree<Integer>(3, children3));
		
		GeneralTree<Integer> a83 = new GeneralTree<Integer>(83);
		GeneralTree<Integer> a18 = new GeneralTree<Integer>(18);
		a18.addChild(a83);
		GeneralTree<Integer> a5 = new GeneralTree<Integer>(5);
		a5.addChild(a18);
		
		List<GeneralTree<Integer>> children1 = new LinkedList<GeneralTree<Integer>>();
		children1.add(a5);
		children1.add(new GeneralTree<Integer>(4, children4));
		
		GeneralTree<Integer> a25 = new GeneralTree<Integer>(25);
		a25.addChild(new GeneralTree<Integer>(13));
		
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(2);
		
		a2.addChild(new GeneralTree<Integer>(1, children1));
		a2.addChild(a25);
		
		System.out.println(ParcialArboles.resolver(a2));
	}
}
