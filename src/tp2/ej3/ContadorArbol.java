package tp2.ej3;

import java.util.ArrayList;
import java.util.List;

import tp2.ejercicio1.BinaryTree;

public class ContadorArbol {
	BinaryTree<Integer> arbol;
	
	public ContadorArbol(BinaryTree<Integer> a){
		arbol=a;
	}
	
	public List<Integer> numeroParesInOrden(){
		List<Integer> res = new ArrayList<Integer>();
		this.getNumerosParesInOrden(arbol, res);
		return res;
	}
	
	public List<Integer> numeroParesPosOrden(){
		List<Integer> res = new ArrayList<Integer>();
		this.getNumerosParesPostOrden(arbol, res);
		
		return res;
	}
	
	private List<Integer> getNumerosParesInOrden(BinaryTree<Integer> a, List<Integer> l) {
		if(a.hasLeftChild()) {
			getNumerosParesInOrden(a.getLeftChild(), l);
		}
		
		if(a.getData() % 2 == 0) {
			l.add(a.getData());
		}
		
		if(a.hasRightChild()) {
			getNumerosParesInOrden(a.getRightChild(), l);
		}
		
		return l;
	}
	
	private List<Integer> getNumerosParesPostOrden(BinaryTree<Integer> a, List<Integer> l) {
		if(a.hasLeftChild()) {
			getNumerosParesPostOrden(a.getLeftChild(), l);
		}
		
		if(a.hasRightChild()) {
			getNumerosParesPostOrden(a.getRightChild(), l);
		}
		
		if(a.getData() % 2 == 0) {
			l.add(a.getData());
		}
		
		return l;
	}
}
