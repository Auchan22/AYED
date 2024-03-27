package tp2.ej4;

import tp2.ejercicio1.BinaryTree;

public class TestRetardo {
	public static void main(String[] args) {
		BinaryTree<Integer> a20 = new BinaryTree<Integer>(20);
		BinaryTree<Integer> a10 = new BinaryTree<Integer>(10);
		BinaryTree<Integer> a15 = new BinaryTree<Integer>(45);
		BinaryTree<Integer> a5 = new BinaryTree<Integer>(5);
		BinaryTree<Integer> a30 = new BinaryTree<Integer>(30);
		BinaryTree<Integer> a25 = new BinaryTree<Integer>(25);
		BinaryTree<Integer> a50 = new BinaryTree<Integer>(40);
		BinaryTree<Integer> a100 = new BinaryTree<Integer>(100);
		
		a10.addLeftChild(a5);
		a10.addRightChild(a15);
		
		a50.addRightChild(a100);
		
		a30.addRightChild(a50);
		a30.addLeftChild(a25);
		
		a20.addLeftChild(a10);
		a20.addRightChild(a30);
		
		RedBinariaLlena r = new RedBinariaLlena();
		r.setArbol(a20);
		
		System.out.println("El reenvío máximo calculado es: "+r.retardoReenvio());
	}
}
