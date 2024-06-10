package Parciales.Arboles.Ejer6;

import tp1.ej8.Queue;
import tp2.ejercicio1.BinaryTree;

public class Parcial {
    public void colorearArbol(BinaryTree<String> arbol, int maxColor) throws Exception {
        Queue<BinaryTree<String>> cola = new Queue<>();
        BinaryTree<String> aux;

        cola.enqueue(arbol);
        cola.enqueue(null);

        String color = "NEGRO";

        int c = 0;

        while(!cola.isEmpty()){
            aux = cola.dequeue();
            if(aux != null){
                if(c > maxColor){
                    aux.setData("VERDE");
                }else{
                    aux.setData(color);
                }
                if(aux.hasLeftChild()){
                    cola.enqueue(aux.getLeftChild());
                }
                if(aux.hasRightChild()){
                    cola.enqueue(aux.getRightChild());
                }
            }else{
                if(!cola.isEmpty()){
                    cola.enqueue(null);
                    c = 0;
                    if (color.equals("NEGRO")){
                        color = "ROJO";
                    }else if (color.equals("ROJO")){
                        color = "NEGRO";
                    }
                }
            }
        }
    }
}
