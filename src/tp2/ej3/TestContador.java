package tp2.ej3;

import java.util.List;

import tp2.ejercicio1.BinaryTree;

public class TestContador {
	
	public static void main(String[] args) {
		
		BinaryTree<Integer> a1 = new BinaryTree<Integer>(1);
		BinaryTree<Integer> a2 = new BinaryTree<Integer>(2);
		BinaryTree<Integer> a5 = new BinaryTree<Integer>(5);
		BinaryTree<Integer> a7 = new BinaryTree<Integer>(7);
		BinaryTree<Integer> a8 = new BinaryTree<Integer>(8);
		BinaryTree<Integer> a10 = new BinaryTree<Integer>(10);
		BinaryTree<Integer> a21 = new BinaryTree<Integer>(21);
		
		//         a5
		//      a2    a7
		//   a1          a8
		//                  a10
		//                      a21
		
		a2.addLeftChild(a1);
		
		a10.addRightChild(a21);
		
		a8.addRightChild(a10);
		
		a7.addRightChild(a8);
		
		a5.addLeftChild(a2);
		a5.addRightChild(a7);
		
		ContadorArbol contador = new ContadorArbol(a5);
		List<Integer> lista = contador.numeroParesInOrden();
		List<Integer> lista2 = contador.numeroParesPosOrden();
		
		lista.stream().forEach(i -> System.out.println("In orden: "+i));
		lista2.stream().forEach(i -> System.out.println("Pos orden: "+i));
	}
	
}
