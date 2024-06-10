package Parciales.Arboles.Ejer5;

import tp2.ejercicio1.BinaryTree;

import java.util.List;

public class ParcialTest {
    public static void main(String[] args){
        BinaryTree<Integer> a_1 = new BinaryTree<>(1);
        a_1.addLeftChild(new BinaryTree<>(16));
        a_1.addRightChild(new BinaryTree<>(6));

        BinaryTree<Integer> a_8 = new BinaryTree<>(8);
        a_8.addLeftChild(new BinaryTree<>(22));

        BinaryTree<Integer> a_5 = new BinaryTree<>(5);
        a_5.addRightChild(a_8);

        BinaryTree<Integer> a_2 = new BinaryTree<>(2);
        a_2.addRightChild(a_5);
        a_2.addLeftChild(a_1);

        Parcial p = new Parcial();
        List<Integer> res = p.resolver(a_2);

        System.out.println(res);
    }
}
