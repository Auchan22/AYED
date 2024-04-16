package tp3.ej2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

public class RecorridosAg {
	public List<Integer> numeroImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> lista = new LinkedList<Integer>(); 
		this.numeroImparesMayoresQuePreOrden(a, n, lista);
		return lista;
	}
	
	private void numeroImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n, List<Integer> l){
		
		if(!a.isEmpty()) {
			if(a.getData() > n && a.getData() % 2 != 0) {
				l.add(a.getData());
			}
			List<GeneralTree<Integer>> children = a.getChildren();
			for(GeneralTree<Integer> child: children) {
				this.numeroImparesMayoresQuePreOrden(child, n, l);
			}
		}
		
	}
	
	public List<Integer> numeroImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> lista = new LinkedList<Integer>(); 
		this.numeroImparesMayoresQueInOrden(a, n, lista);
		return lista;
	}
	
	private void numeroImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n, List<Integer> l){
		
		if(!a.isEmpty()) {
			List<GeneralTree<Integer>> lchildren = a.getChildren();
			Iterator<GeneralTree<Integer>> next = lchildren.iterator();
			this.numeroImparesMayoresQueInOrden(next.next(), n, l);
			if(a.getData() > n && a.getData() % 2 != 0) {
				l.add(a.getData());
			}
			List<GeneralTree<Integer>> children = a.getChildren();
			for(GeneralTree<Integer> child: children) {
				this.numeroImparesMayoresQuePreOrden(child, n, l);
			}
		}
		
	}
	
	public List<Integer> numeroImparesMayoresQuePosOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> lista = new LinkedList<Integer>(); 
		this.numeroImparesMayoresQuePosOrden(a, n, lista);
		return lista;
	}
	
	private void numeroImparesMayoresQuePosOrden(GeneralTree<Integer> a, Integer n, List<Integer> l){
		
		if(!a.isEmpty()) {
			List<GeneralTree<Integer>> children = a.getChildren();
			Iterator<GeneralTree<Integer>> it = children.iterator();
			
			while(it.hasNext()) {
				this.numeroImparesMayoresQuePosOrden(it.next(), n, l);
			}
			if(a.getData() > n && a.getData() % 2 != 0) {
				l.add(a.getData());
			}
		}
		
	}
}
