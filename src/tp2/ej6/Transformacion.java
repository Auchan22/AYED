package tp2.ej6;

import tp1.ej8.Queue;
import tp2.ejercicio1.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> arbol = new BinaryTree<Integer>();
	public Transformacion() {
	}
	
	public void setArbol(BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	public int sumarNodos(BinaryTree<Integer> a) {
		
		if(a.isEmpty()) {
			return 0;
		}else {
			int sum = a.getData();
			if(a.hasLeftChild()) {
				sum += this.sumarNodos(a.getLeftChild());
			}
			if(a.hasRightChild()) {
				sum+= this.sumarNodos(a.getRightChild());
			}
			
			return sum;
		}
	}
	
	private BinaryTree<Integer> clonarArbol(BinaryTree<Integer> a){
		if(a == null) return null;
		
		BinaryTree<Integer> nuevo = new BinaryTree<Integer>(a.getData());
		nuevo.addLeftChild(clonarArbol(a.getLeftChild()));
		nuevo.addRightChild(clonarArbol(a.getRightChild()));
		
		return nuevo;
	}
	
	public BinaryTree<Integer> suma() throws Exception{
		BinaryTree<Integer> copy = clonarArbol(this.arbol);
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		BinaryTree<Integer> a;
		cola.enqueue(copy);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			a = cola.dequeue();
			if(a == null) {
				if(!cola.isEmpty()) {
					cola.enqueue(a);
				}
			}else {
				int sumHI = 0, sumHD = 0;
				if(a.hasLeftChild()) {
					sumHI = this.sumarNodos(a.getLeftChild());
					cola.enqueue(a.getLeftChild());
				}
				if(a.hasRightChild()) {
					sumHD = this.sumarNodos(a.getRightChild());
					cola.enqueue(a.getRightChild());
				}
				a.setData(sumHI +sumHD);
			}
		}
		return copy;
		
	}
	
}
