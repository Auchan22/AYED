package tp2.ej5;

import tp1.ej8.Queue;
import tp2.ejercicio1.BinaryTree;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol = new BinaryTree<Integer>();
	
	public ProfundidadDeArbolBinario() {};
	
	public BinaryTree<Integer> getArbol(){
		return this.arbol;
	}
	
	public void setArbol(BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	public int sumaElementosProfundidad(int p) throws Exception {
		if(p == 0) {
			return 0;
		}
		
		int altura = arbol.getAltura();
		
		if(p > altura) {
			System.out.println("La profundidad no puede ser mayor a la altura del arbol");
			return -1;
		}
		
		int suma = 0;
		int nivel = 0;
		Queue<BinaryTree<Integer>> cola= new Queue<BinaryTree<Integer>>();
		BinaryTree<Integer> a;
		cola.enqueue(this.arbol);
		cola.enqueue(null);
		
		while(!cola.isEmpty() && nivel < p) {
			a = cola.dequeue();
			if(a == null) {
				if(!cola.isEmpty()) {
					cola.enqueue(a);
					nivel++;
				}
			}else {
				suma += a.getData();
				if(a.hasLeftChild()) {
					cola.enqueue(a.getLeftChild());
				}
				if(a.hasRightChild()) {
					cola.enqueue(a.getRightChild());
				}
			}
		}
		
		return suma;
	}
	
}
