package tp3.ej7;

import tp3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class Caminos {
        private GeneralTree<Integer> arbol;
        public Caminos(GeneralTree<Integer> a){
            this.arbol = a;
        }

        public List<Integer> caminoAHojaMasLejana(){
            List<Integer> camAct = new LinkedList<Integer>();
            List<Integer> camMax = new LinkedList<Integer>();
            if(!this.arbol.isEmpty()) caminoHelper(this.arbol, camAct, camMax);
            return camMax;
        }

    private void caminoHelper(GeneralTree<Integer> a, List<Integer> camAct, List<Integer> camMax) {
        camAct.add(a.getData());
        if(!a.isLeaf()) {
            for(GeneralTree<Integer>h: a.getChildren()) {
                caminoHelper(h, camAct, camMax);
                camAct.remove(camAct.size()-1);
            }
        } else if(camAct.size() > camMax.size()) {
            camMax.removeAll(camMax);
            camMax.addAll(camAct);
        }
    }
}
