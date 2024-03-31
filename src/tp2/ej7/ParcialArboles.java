package tp2.ej7;

import tp1.ej8.Queue;
import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> arbol;
	
	public ParcialArboles() {
		
	}
	
	public void setArbol(BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	public boolean isLeftTree(int num) throws Exception {
		if(this.arbol == null) return false;
		boolean existe = false;
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		BinaryTree<Integer> a = null;;
		cola.enqueue(arbol);
		while(!cola.isEmpty() && !existe) {
			a = cola.dequeue();
			if(a.getData() == num) {
				existe= true;
			}else {
				if(a.hasLeftChild()) {
					cola.enqueue(a.getLeftChild());
				}
				if(a.hasRightChild()) {
					cola.enqueue(a.getRightChild());
				}
			}
		}
		
		if(!existe) {
			return false;
		}
		
		
		int hijosHI = a.hasLeftChild() ? contarUnicosHijos(a.getLeftChild()) : -1;
		int hijosHD= a.hasRightChild() ? contarUnicosHijos(a.getRightChild()) : -1;
		
		return hijosHI > hijosHD;
	}
	
	private int contarUnicosHijos(BinaryTree<Integer> a) {
		if (a.isLeaf()) {
			return 1;
		}else {
			if(a.hasLeftChild() &&  a.hasRightChild()) return 0;
			int aux = 0;
			if(a.hasLeftChild()) {
				aux += contarUnicosHijos(a.getLeftChild());
			}
			if(a.hasRightChild()) {
				aux += contarUnicosHijos(a.getRightChild());
			}
			return aux;
		}
	}
}
