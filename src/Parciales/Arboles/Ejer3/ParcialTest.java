package Parciales.Arboles.Ejer3;

import tp3.ejercicio1.GeneralTree;

import java.util.Iterator;
import java.util.List;

public class ParcialTest {
    public static void main(String[] args){
        GeneralTree<Integer> a_4 = new GeneralTree<>(4);
        a_4.addChild(new GeneralTree<>(9));
        a_4.addChild(new GeneralTree<>(10));
        a_4.addChild(new GeneralTree<>(5));

        GeneralTree<Integer> a_5 = new GeneralTree<>(5);

        GeneralTree<Integer> a_1 = new GeneralTree<>(1);
        a_1.addChild(a_5);
        a_1.addChild(a_4);

        GeneralTree<Integer> a_8 = new GeneralTree<>(8);
        a_8.addChild(new GeneralTree<>(3));

        GeneralTree<Integer> a_7 = new GeneralTree<>(7);
        a_7.addChild(new GeneralTree<>(13));

        GeneralTree<Integer> a_12 = new GeneralTree<>(12);
        a_12.addChild(a_8);
        a_12.addChild(new GeneralTree<>(4));
        a_12.addChild(a_7);

        GeneralTree<Integer> a_2 = new GeneralTree<>(2);
        a_2.addChild(a_1);
        a_2.addChild(a_12);
        a_2.addChild(new GeneralTree<>(14));

        Parcial p = new Parcial(a_2);

        List<Integer> l = p.resolver();
        System.out.println(l);
        Iterator<Integer> it = l.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
     }
}
