package Parciales.Arboles.Ejer1;

import tp3.ejercicio1.GeneralTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Parcial {
    public List<Character> caminosPares(GeneralTree<Character> arbol){
        List<Character> camino = new LinkedList<>();
        List<Character> caminoActual = new LinkedList<>();

        if(!arbol.isEmpty()){
            caminoActual.add(arbol.getData());
            caminosPares(0, camino, caminoActual, arbol);
        }

        return camino;
    }

    private void caminosPares(int cant, List<Character> min, List<Character> actual, GeneralTree<Character> a){
        cant++;
        if(a.isLeaf()){
            if(cant % 2 == 0){
                min.removeAll(min);
                min.addAll(actual);
            }
        }
        if(a.hasChildren()){
            List<GeneralTree<Character>> hijos = a.getChildren();
            Iterator<GeneralTree<Character>> it = hijos.iterator();
            while(it.hasNext()){
                GeneralTree<Character> aux = it.next();
                actual.add(aux.getData());
                caminosPares(cant, min, actual, a);
                actual.remove(actual.size());
            }
        }
    }
}
