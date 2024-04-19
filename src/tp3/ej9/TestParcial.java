package tp3.ej9;

import tp3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class TestParcial {
    public static void main(String[] args){

        List<GeneralTree<Integer>> children33 = new LinkedList<>();
        children33.add(new GeneralTree<Integer>(35));
        children33.add(new GeneralTree<Integer>(83));
        children33.add(new GeneralTree<Integer>(90));
        children33.add(new GeneralTree<Integer>(33));

        List<GeneralTree<Integer>> children12 = new LinkedList<>();
        children12.add(new GeneralTree<>(14));
        children12.add(new GeneralTree<>(12));
        children12.add(new GeneralTree<>(33, children33));

        GeneralTree<Integer> a35_a = new GeneralTree<>(35);
        a35_a.addChild(new GeneralTree<>(35));

        GeneralTree<Integer> a35 = new GeneralTree<Integer>(35);
        a35.addChild(a35_a);

        GeneralTree<Integer> a12_a = new GeneralTree<>(12);
        a12_a.addChild(a35);
        a12_a.addChild(new GeneralTree<>(12, children12));

        GeneralTree<Integer> a12 = new GeneralTree<>(12);
        a12.addChild(a12_a);
        a12.addChild(new GeneralTree<>(25));

//        imprimirPreOrden(a12_b);
        System.out.println("Es de seleccion?: "+ParcialArboles.esDeSeleccion(a12));
    }

    private static void imprimirPreOrden(GeneralTree<Integer> a){
        if(!a.isEmpty()){
            System.out.println(a.getData());
            for(GeneralTree<Integer> child: a.getChildren()){
                imprimirPreOrden(child);
            }
        }
    }
}
