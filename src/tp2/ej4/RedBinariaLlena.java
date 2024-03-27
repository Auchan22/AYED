package tp2.ej4;

import tp2.ejercicio1.BinaryTree;

public class RedBinariaLlena {
	BinaryTree<Integer> arbol = new BinaryTree<Integer>();
	
	public BinaryTree<Integer> getArbol(){
		BinaryTree<Integer> copy = this.arbol;
		
		return copy;
	}
	
	public void setArbol(BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	public int retardoReenvio() {
		return this.retardoReenvio(arbol);
	}
	
	private int retardoReenvio(BinaryTree<Integer> a) {
		int HI = -1, HD = -1, max;
		
		if(a.isLeaf()) {
			return a.getData();
		}else {
			if(a.hasLeftChild()) {
				HI = retardoReenvio(a.getLeftChild());
			}
			if(a.hasRightChild()) {
				HD = retardoReenvio(a.getRightChild());
			}
			
			max = Math.max(HI, HD);
			System.out.println(max);
			
			return max + a.getData();
		}
	}
}
