package tp2.ejercicio1;

public class TestArbol {
	public static void main(String[] args) throws Exception {
		BinaryTree<Integer> a1 = new BinaryTree<Integer>(1);
		BinaryTree<Integer> a2 = new BinaryTree<Integer>(2);
		BinaryTree<Integer> a3 = new BinaryTree<Integer>(3);
		BinaryTree<Integer> a4 = new BinaryTree<Integer>(4);
		BinaryTree<Integer> a5 = new BinaryTree<Integer>(5);
		BinaryTree<Integer> a6 = new BinaryTree<Integer>(6);
		BinaryTree<Integer> a7 = new BinaryTree<Integer>(7);
		
		a2.addLeftChild(a1);
		
		//a6.addRightChild(a7);
		
		a5.addLeftChild(a4);
		a5.addRightChild(a6);
		
		a3.addLeftChild(a2);
		a3.addRightChild(a5);
		
		System.out.println("--El arbol posee n° de hojas: "+a3.contarHojas());
		System.out.println("--El arbol posee n° de nodos: "+a3.contarNodos());
		System.out.println("--Altura del arbol: "+a3.getAltura());
		a3.entreNiveles(1, 2);
	}
}
