package ejercitacion.ej1;

import tp2.ejercicio1.BinaryTree;

public class Test_ej1 {
    public static void main(String[] args){
        BinaryTree<Character> a = new BinaryTree<Character>('A');
        BinaryTree<Character> b = new BinaryTree<Character>('B');
        BinaryTree<Character> c = new BinaryTree<Character>('C');
        BinaryTree<Character> d = new BinaryTree<Character>('D');
        BinaryTree<Character> e = new BinaryTree<Character>('E');
        BinaryTree<Character> f = new BinaryTree<Character>('F');
        BinaryTree<Character> g = new BinaryTree<Character>('G');
        BinaryTree<Character> h = new BinaryTree<Character>('H');
        BinaryTree<Character> i = new BinaryTree<Character>('i');
        BinaryTree<Character> j = new BinaryTree<Character>('j');

        h.addLeftChild(j);
        h.addRightChild(i);

        c.addLeftChild(h);

        f.addLeftChild(e);

        g.addRightChild(f);

        b.addLeftChild(a);
        b.addRightChild(g);

        d.addLeftChild(b);
        d.addRightChild(c);

        d.imprimirInOrder(d);
        d.imprimirPosOrder(d);
    }
}
