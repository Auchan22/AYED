package tp3.ej8;

import tp1.ej8.Queue;
import tp3.ejercicio1.GeneralTree;

import java.util.List;

public class Navidad {
    private GeneralTree<Integer> arbol;

    public Navidad(GeneralTree<Integer> a){
        this.arbol = a;
    }

//    public String esAbetoNavidenio() throws Exception {
//        if(this.arbol.isEmpty() || this.arbol.isLeaf()){
//            return "No";
//        }else {
//            Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
//            GeneralTree<Integer> ag;
//            cola.enqueue(this.arbol);
//            cola.enqueue(null);
//            boolean ok = true;
//            while (!cola.isEmpty() && ok) {
//                ag = cola.dequeue();
//                if (ag != null) {
//                    if (contarHojas(ag.getChildren()) < 3) {
//                        ok = false;
//                    } else {
//                        for (GeneralTree<Integer> child : ag.getChildren()) {
//                            cola.enqueue(child);
//                        }
//                    }
//                } else {
//                    if (!cola.isEmpty()) {
//                        cola.enqueue(null);
//                    }
//                }
//            }
//
//            if (ok) return "Yes";
//            else return "No";
//        }
//    }
//
//    private int contarHojas(List<GeneralTree<Integer>> children){
//        int cant = 0;
//        for(GeneralTree<Integer> c: children){
//            if(c.isLeaf()) cant++;
//        }
//        return cant;
//    }

    public String esAbetoNavidenio(){
        boolean res = isAbeto(this.arbol);
        return res ? "Yes" : "No";
    }
    public boolean isAbeto(GeneralTree<Integer> a){
        if (a.isLeaf()){
            return true;
        }
        int nodosHijo = 0;
        for(GeneralTree<Integer> child: a.getChildren()){
            if(child.isLeaf()) nodosHijo++;
            if(!isAbeto(child)) return false;
        }
        return nodosHijo>= 3;
    }
}
