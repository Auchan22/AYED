package tp2.ej9;

import tp2.ejercicio1.BinaryTree;

public class TestParcialArboles {

	public static void imprimirArbol(BinaryTree<SumDiff> a) {
		if(a.hasLeftChild()) {
			imprimirArbol(a.getLeftChild());
		}
		System.out.println(a.toString());
		if(a.hasRightChild()) {
			imprimirArbol(a.getRightChild());
		}
	}

	public static void main(String[] args) {
		BinaryTree<Integer> a20 = new BinaryTree<Integer>(20);
		BinaryTree<Integer> a5 = new BinaryTree<Integer>(5);
		BinaryTree<Integer> a30 = new BinaryTree<Integer>(30);
		BinaryTree<Integer> a5_minus= new BinaryTree<Integer>(-5);
		BinaryTree<Integer> a10 = new BinaryTree<Integer>(10);
		BinaryTree<Integer> a1 = new BinaryTree<Integer>(2);
		BinaryTree<Integer> a50 = new BinaryTree<Integer>(50);
		BinaryTree<Integer> a9_minus = new BinaryTree<Integer>(-9);
		BinaryTree<Integer> a4 = new BinaryTree<Integer>(4);
		BinaryTree<Integer> a6 = new BinaryTree<Integer>(6);
		
		a4.addRightChild(a6);
		a50.addRightChild(a4);
		a30.addRightChild(a9_minus);
		a30.addLeftChild(a50);
		
		a10.addLeftChild(a1);
		a5.addRightChild(a10);
		a5.addLeftChild(a5_minus);
		
		a20.addRightChild(a30);
		a20.addLeftChild(a5);
		
		ParcialArboles p = new ParcialArboles();
		BinaryTree<SumDiff> sad = p.sumAndDiff(a20);
		imprimirArbol(sad);
	}

}
