package Parciales.Arboles.Ejer3;

import tp3.ejercicio1.GeneralTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Parcial {
    public GeneralTree<Integer> arbol;

    public Parcial(){
        this.arbol = new GeneralTree<>();
    }

    public Parcial(GeneralTree<Integer> a){
        this.arbol = a;
    }

    public List<Integer> resolver(){
        List<Integer> camino = new LinkedList<>();

        if(!this.arbol.isEmpty()){
            resolver(this.arbol, camino);
        }

        return camino;
    }

    private void resolver(GeneralTree<Integer> a, List<Integer> c){
        Integer suma = 0;
        Boolean ok = false;
        if(a.hasChildren()){
            List<GeneralTree<Integer>> children = a.getChildren();
            Iterator<GeneralTree<Integer>> it = children.iterator();
            while(it.hasNext()){
                GeneralTree<Integer> aux = it.next();
                if(aux.getChildren().size() % 2 == 1){
                    ok = true;
                    suma+= aux.getData();
                }
                resolver(aux, c);
            }
        }
        if(!a.isLeaf()){
            if(ok){
                c.add(suma);
            }
        }
    }
}
