package tp3.ej2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;
import tp3.ejercicio1.GeneralTree;

public class RecorridosAg {
	public List<Integer> numeroImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> lista = new LinkedList<Integer>(); 
		if(!a.isEmpty()) this.numeroImparesMayoresQuePreOrden(a, n, lista);
		return lista;
	}
	
	private void numeroImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n, List<Integer> l){
			if(a.getData() > n && a.getData() % 2 != 0) {
				l.add(a.getData());
			}
			List<GeneralTree<Integer>> children = a.getChildren();
			for(GeneralTree<Integer> child: children) {
				this.numeroImparesMayoresQuePreOrden(child, n, l);
			}
		
	}
	
	public List<Integer> numeroImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> lista = new LinkedList<Integer>(); 
		if(!a.isEmpty()) this.numeroImparesMayoresQueInOrden(a, n, lista);
		return lista;
	}
	
	private void numeroImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n, List<Integer> l){
		
			List<GeneralTree<Integer>> children = a.getChildren();
			if(a.hasChildren()) {
				this.numeroImparesMayoresQueInOrden(children.get(0), n, l);
			}
			if(a.getData() > n && a.getData() % 2 != 0) {
				l.add(a.getData());
			}
			for(int i=1; i < children.size(); i++) {
	            this.numeroImparesMayoresQueInOrden(children.get(i), n, l);
	        }		
	}
	
	public List<Integer> numeroImparesMayoresQuePosOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> lista = new LinkedList<Integer>(); 
		if(!a.isEmpty()) this.numeroImparesMayoresQuePosOrden(a, n, lista);
		return lista;
	}
	
	private void numeroImparesMayoresQuePosOrden(GeneralTree<Integer> a, Integer n, List<Integer> l){
		
			List<GeneralTree<Integer>> children = a.getChildren();
			for(GeneralTree<Integer> child: children) {
				this.numeroImparesMayoresQuePosOrden(child, n, l);
			}
			if(a.getData() > n && a.getData() % 2 != 0) {
				l.add(a.getData());
			}
		
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n) throws Exception{
		List<Integer> lista = new LinkedList<Integer>(); 
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		GeneralTree<Integer> ag;
		cola.enqueue(a);
		while(!cola.isEmpty()) {
			ag = cola.dequeue();
			if(!ag.isEmpty()) {
				if(ag.getData() > n && ag.getData() % 2 != 0) {
					lista.add(ag.getData());
				}
				List<GeneralTree<Integer>> children = ag.getChildren();
	            for(GeneralTree<Integer> child: children) {
	                cola.enqueue(child);
	            }
			}
		}
		
		return lista;
	}
	
}
