package Parciales.Arboles.Ejer2;

import tp2.ejercicio1.BinaryTree;

public class Parcial {
    public Integer sumaImparesPosOrderMayorA(BinaryTree<Integer> ab, int limite){
        int sum = 0;

        if(!ab.isEmpty()){
            sum = suma(ab, limite);
        }

        return sum;
    }

    private int suma(BinaryTree<Integer>ab, int l){
        Integer sum = 0;
        if (!ab.isEmpty()){
            if(ab.hasLeftChild()){
                sum += suma(ab.getLeftChild(), l);
            }
            if(ab.hasRightChild()){
                sum += suma(ab.getRightChild(), l);
            }
            if(ab.getData()%2==1 && ab.getData()>l){
                sum += ab.getData();
            }
        }
        return sum;
    }
}
