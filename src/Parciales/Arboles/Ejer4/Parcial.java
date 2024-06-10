package Parciales.Arboles.Ejer4;

import tp3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class Parcial {
    public List<Integer> camino(GeneralTree<Integer> a){
        List<Integer> caminoAct = new LinkedList<>();
        List<Integer> caminoMax = new LinkedList<>();

        if(!a.isEmpty()){
            resolver(a, caminoAct, caminoMax);
        }

        return caminoMax;
    }

    private void resolver(GeneralTree<Integer> a, List<Integer> caminoAct, List<Integer> caminoMax){
        caminoAct.add(a.getData());
        if(!a.isLeaf()){
            for(GeneralTree<Integer> aux: a.getChildren()){
                resolver(aux, caminoAct, caminoMax);
            }
        } else if (caminoAct.size() > caminoMax.size()){
            caminoMax.removeAll(caminoMax);
            caminoMax.addAll(caminoAct);
        }
        caminoAct.remove(caminoAct.size()-1);
    }
}
