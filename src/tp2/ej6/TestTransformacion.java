package tp2.ej6;

import tp2.ejercicio1.BinaryTree;

public class TestTransformacion {
	public static void main(String[] args) throws Exception {
		BinaryTree<Integer> a1 = new BinaryTree<Integer>(1);
		BinaryTree<Integer> a2 = new BinaryTree<Integer>(2);
		BinaryTree<Integer> a3 = new BinaryTree<Integer>(3);
		BinaryTree<Integer> a4 = new BinaryTree<Integer>(4);
		BinaryTree<Integer> a5 = new BinaryTree<Integer>(5);
		BinaryTree<Integer> a6 = new BinaryTree<Integer>(6);
		BinaryTree<Integer> a7 = new BinaryTree<Integer>(7);
		BinaryTree<Integer> a8 = new BinaryTree<Integer>(8);
		
		//       1
		//    2     3
		//  4     5   6
		//      7  8
		
		a5.addLeftChild(a7);
		a5.addRightChild(a8);
		
		a3.addLeftChild(a5);
		a3.addRightChild(a6);
		
		a2.addLeftChild(a4);
		
		a1.addLeftChild(a2);
		a1.addRightChild(a3);
		
		Transformacion t = new Transformacion();
		t.setArbol(a1);
		
		BinaryTree<Integer> sumaArbol = t.suma();
		sumaArbol.imprimirPreOrder(sumaArbol);
	}
}
