package tp2.ej7;

import tp2.ejercicio1.BinaryTree;

public class TestParcialArboles {

	public static void main(String[] args) throws Exception {
		BinaryTree<Integer> a2 = new BinaryTree<Integer>(2);
		BinaryTree<Integer> a7 = new BinaryTree<Integer>(7);
		BinaryTree<Integer> a23 = new BinaryTree<Integer>(23);
		BinaryTree<Integer> a3_minus = new BinaryTree<Integer>(-3);
		BinaryTree<Integer> a6 = new BinaryTree<Integer>(6);
		BinaryTree<Integer> a55 = new BinaryTree<Integer>(55);
		BinaryTree<Integer> a11 = new BinaryTree<Integer>(11);
		BinaryTree<Integer> a5_minus = new BinaryTree<Integer>(-5);
		BinaryTree<Integer> a19 = new BinaryTree<Integer>(19);
		BinaryTree<Integer> a4 = new BinaryTree<Integer>(4);
		BinaryTree<Integer> a18 = new BinaryTree<Integer>(18);
		
		a23.addLeftChild(a3_minus);
		
		a6.addLeftChild(a55);
		a6.addRightChild(a11);
		
		a7.addLeftChild(a23);
		a7.addRightChild(a6);
		
		a4.addLeftChild(a18);
		
		a19.addRightChild(a4);
		
		a5_minus.addLeftChild(a19);
		
		a2.addLeftChild(a7);
		a2.addRightChild(a5_minus);
		
		ParcialArboles p = new ParcialArboles();
		p.setArbol(a2);
		
		System.out.println("Caso 1: "+p.isLeftTree(7));
		System.out.println("Caso 2: "+p.isLeftTree(2));
		System.out.println("Caso 3: "+p.isLeftTree(-5));
		System.out.println("Caso 4: "+p.isLeftTree(19));
		System.out.println("Caso 5: "+p.isLeftTree(-3));
		System.out.println("Caso 6: "+p.isLeftTree(22));
		System.out.println("Caso 7: "+p.isLeftTree(4));

	}

}
