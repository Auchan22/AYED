package Parciales.Arboles.Ejer4;

import tp3.ejercicio1.GeneralTree;

import java.util.List;

public class ParcialTest {
    public static void main(String[] args){
        GeneralTree<Integer> a_7 = new GeneralTree<>(7);
        a_7.addChild(new GeneralTree<>(2));

        GeneralTree<Integer> a_3 = new GeneralTree<>(3);
        a_3.addChild(new GeneralTree<>(4));
        a_3.addChild(a_7);
        a_3.addChild(new GeneralTree<>(6));

        GeneralTree<Integer> a_5 = new GeneralTree<>(5);
        a_5.addChild(new GeneralTree<>(1));
        a_5.addChild(new GeneralTree<>(9));
        a_5.addChild(new GeneralTree<>(10));

        GeneralTree<Integer> a_8 = new GeneralTree<>(8);
        a_8.addChild(a_3);
        a_8.addChild(a_5);

        Parcial p = new Parcial();
        List<Integer> res = p.camino(a_8);

        System.out.println(res);
    }
}
