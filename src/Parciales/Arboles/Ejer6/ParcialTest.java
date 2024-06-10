package Parciales.Arboles.Ejer6;

import tp1.ej8.Queue;
import tp2.ejercicio1.BinaryTree;

public class ParcialTest {
    public static void recorrerArbol(BinaryTree<String> a) throws Exception {
        Queue<BinaryTree<String>> cola = new Queue<>();
        BinaryTree<String> aux;

        cola.enqueue(a);

        while(!cola.isEmpty()){
            aux = cola.dequeue();
            System.out.println(aux.getData());
            if(aux.hasLeftChild()){
                cola.enqueue(aux.getLeftChild());
            }
            if(aux.hasRightChild()){
                cola.enqueue(aux.getRightChild());
            }
        }
    }

    public static void main(String[] args){

    }
}
