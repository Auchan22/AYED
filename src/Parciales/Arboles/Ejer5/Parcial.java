package Parciales.Arboles.Ejer5;

import tp2.ejercicio1.BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class Parcial {
    public List<Integer> resolver(BinaryTree<Integer> a){
        List<Integer> camino = new LinkedList<>();

        if(!a.isEmpty()){
            resolver(a, camino);
        }

        return camino;
    }

    private int resolver(BinaryTree<Integer> a, List<Integer> c){
        if(a.isLeaf()) {
            c.add(a.getData());
            return 0;
        }else{
            int sumIzq = 0, sumDer = 0;
            if(a.hasLeftChild()){
                sumIzq++;
                sumIzq += resolver(a.getLeftChild(), c);
            }
            if(a.hasRightChild()){
                sumDer++;
                sumDer += resolver(a.getRightChild(), c);
            }
            System.out.println(a.getData()+"|"+sumIzq+"|"+sumDer);
            if(sumIzq == sumDer){
                c.add(a.getData());
            }
            return sumIzq + sumDer;
        }
    }
}
