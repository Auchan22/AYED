package Parciales.Arboles.Ejer2;

import tp2.ejercicio1.BinaryTree;

public class ParcialTest {
    public static void main(String[] args){
        BinaryTree<Integer> a_43 = new BinaryTree<>(43);
        a_43.addLeftChild(new BinaryTree<>(9));
        a_43.addRightChild(new BinaryTree<>(10));

        BinaryTree<Integer> a_16 = new BinaryTree<>(16);
        a_16.addRightChild(a_43);

        BinaryTree<Integer> a_77 = new BinaryTree<>(77);
        a_77.addLeftChild(a_16);

        BinaryTree<Integer> a_38 = new BinaryTree<>(38);
        a_38.addLeftChild(new BinaryTree<>(87));
        a_38.addRightChild(a_77);

        BinaryTree<Integer> a_2 = new BinaryTree<>(2);
        a_2.addLeftChild(new BinaryTree<>(1));

        BinaryTree<Integer> a_94 = new BinaryTree<>(94);
        a_94.addRightChild(a_2);

        BinaryTree<Integer> a_31 = new BinaryTree<>(31);
        a_31.addRightChild(a_94);

        BinaryTree<Integer> a_56 = new BinaryTree<>(56);
        a_56.addRightChild(a_31);
        a_56.addLeftChild(a_38);

        BinaryTree<Integer> a_25 = new BinaryTree<>(25);
        a_25.addLeftChild(new BinaryTree<>(5));
        a_25.addRightChild(new BinaryTree<>(6));

        BinaryTree<Integer> a_7 = new BinaryTree<>(7);
        a_7.addRightChild(a_25);
        a_7.addLeftChild(a_56);

        Parcial p = new Parcial();
        System.out.println("Suma total: "+p.sumaImparesPosOrderMayorA(a_7, 30));
    }
}
