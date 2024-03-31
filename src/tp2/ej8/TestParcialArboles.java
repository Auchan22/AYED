package tp2.ej8;

import tp2.ejercicio1.BinaryTree;

public class TestParcialArboles {
    public static void main(String[] args) throws Exception {
        BinaryTree<Integer> a65_1 = new BinaryTree<Integer>(65);
        BinaryTree<Integer> a37_1 = new BinaryTree<Integer>(37);
        BinaryTree<Integer> a81_1 = new BinaryTree<Integer>(81);
        BinaryTree<Integer> a22_1 = new BinaryTree<Integer>(22);
        BinaryTree<Integer> a47_1 = new BinaryTree<Integer>(47);
        BinaryTree<Integer> a11_1 = new BinaryTree<Integer>(11);
        BinaryTree<Integer> a29_1 = new BinaryTree<Integer>(29);
        BinaryTree<Integer> a76_1 = new BinaryTree<Integer>(76);
        BinaryTree<Integer> a93_1 = new BinaryTree<Integer>(93);
        BinaryTree<Integer> a85_1 = new BinaryTree<Integer>(85);
        BinaryTree<Integer> a94_1 = new BinaryTree<Integer>(94);

        BinaryTree<Integer> a65_2 = new BinaryTree<Integer>(65);
        BinaryTree<Integer> a37_2 = new BinaryTree<Integer>(37);
        BinaryTree<Integer> a81_2 = new BinaryTree<Integer>(81);
        BinaryTree<Integer> a47_2 = new BinaryTree<Integer>(47);
        BinaryTree<Integer> a93_2 = new BinaryTree<Integer>(93);

        a93_1.addRightChild(a94_1);
        a93_1.addLeftChild(a85_1);

        a22_1.addLeftChild(a11_1);
        a22_1.addRightChild(a29_1);

        a37_1.addRightChild(a47_1);
        a37_1.addLeftChild(a22_1);

        a81_1.addRightChild(a93_1);
        a81_1.addLeftChild(a76_1);

        a65_1.addLeftChild(a37_1);
        a65_1.addRightChild(a81_1);

        a81_2.addRightChild(a93_2);
        a37_2.addRightChild(a47_2);

        a65_2.addRightChild(a81_2);
        a65_2.addLeftChild(a37_2);

        ParcialArboles p = new ParcialArboles();
        System.out.println("Es prefijo?:"+p.esPrefijo(a65_2, a65_1));
    }
}
