package Parciales.Arboles.Ejer8;

import tp1.ej8.Queue;
import tp3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class Parcial {
    public List<String> resolver(GeneralTree<Objeto> a) throws Exception {
        List<String> camino = new LinkedList<>();
        if(!a.isEmpty()){
            camino.add(a.getData().getLetra());
            Queue<GeneralTree<Objeto>> cola = new Queue<>();
            GeneralTree<Objeto> ab = null;
            cola.enqueue(a);
            while(!cola.isEmpty()){
                ab = cola.dequeue();
                List<GeneralTree<Objeto>> hijos = ab.getChildren();
                System.out.println(hijos);
                for(int i = 0; i< hijos.size(); i++){
                    if(ab.getData().getPos()-1==i){
                        camino.add(hijos.get(i).getData().getLetra());
                    }
                    cola.enqueue(hijos.get(i));
                }
            }
        }
        return camino;
    }
}
