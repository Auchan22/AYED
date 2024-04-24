package tp3.ej10;

import tp3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {
    public static List<Integer> resolver(GeneralTree<Integer> arbol){
        List<Integer> camAct = new LinkedList<Integer>();
        List<Integer> camMax = new LinkedList<Integer>();
        if(!arbol.isEmpty()) helperResolver(arbol, camAct, camMax, 0, -1,0);
        return camMax;
    }

    private static void helperResolver(GeneralTree<Integer> a, List<Integer> camAct, List<Integer> camMax, int nivel, int max, int valorTotal){
        int datoActual = a.getData();
        valorTotal += datoActual*nivel;
        if(!a.isLeaf()){
            for(GeneralTree<Integer>h: a.getChildren()) {
                helperResolver(h, camAct, camMax, nivel+1, max, valorTotal);

            }
        }else if (valorTotal > max) {
            max = valorTotal;
            valorTotal = 0;
            camMax.removeAll(camMax);
            camMax.addAll(camAct);
        }
        //camAct.remove(camAct.size()-1);
    }

    public static void main(String[] args){
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(1));
        subChildren1.add(new GeneralTree<Integer>(1));
        subChildren1.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subA = new GeneralTree<Integer>(1, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(subA);
        subChildren2.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(0, subChildren2);

        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subB = new GeneralTree<Integer>(0, subChildren3);
        List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
        subChildren4.add(subB);
        GeneralTree<Integer> subC = new GeneralTree<Integer>(0, subChildren4);
        List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
        subChildren5.add(new GeneralTree<Integer>(1));
        subChildren5.add(subC);
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(1, subChildren5);

        List<GeneralTree<Integer>> subChildren6 = new LinkedList<GeneralTree<Integer>>();
        subChildren6.add(new GeneralTree<Integer>(0));
        subChildren6.add(new GeneralTree<Integer>(0));
        GeneralTree<Integer> subD = new GeneralTree<Integer>(0, subChildren6);
        List<GeneralTree<Integer>> subChildren7 = new LinkedList<GeneralTree<Integer>>();
        subChildren7.add(subD);
        GeneralTree<Integer> subE = new GeneralTree<Integer>(0, subChildren7);
        List<GeneralTree<Integer>> subChildren8 = new LinkedList<GeneralTree<Integer>>();
        subChildren8.add(subE);
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(1, subChildren8);

        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(1, arbol);

        System.out.println(resolver(a));

    }
}
