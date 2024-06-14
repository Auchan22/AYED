package Parciales.Arboles.Ejer8;

import tp3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class ParcialTest {

    public static void main(String[] args) throws Exception {
        List<GeneralTree<Objeto>> hijos_e = new LinkedList<>();
        hijos_e.add(new GeneralTree<>(new Objeto("A", 7)));
        hijos_e.add(new GeneralTree<>(new Objeto("B", 9)));
        hijos_e.add(new GeneralTree<>(new Objeto("C", 6)));
        GeneralTree<Objeto> e = new GeneralTree<>(new Objeto("E", 3), hijos_e);

        List<GeneralTree<Objeto>> hijos_f = new LinkedList<>();
        hijos_f.add(new GeneralTree<>(new Objeto("D", 10)));
        GeneralTree<Objeto> f = new GeneralTree<>(new Objeto("F", 2), hijos_f);

        List<GeneralTree<Objeto>> hijos_j = new LinkedList<>();
        hijos_j.add(new GeneralTree<>(new Objeto("H", 5)));
        hijos_j.add(new GeneralTree<>(new Objeto("I", 10)));
        GeneralTree<Objeto> j = new GeneralTree<>(new Objeto("J", 3), hijos_j);

        List<GeneralTree<Objeto>> hijos_g = new LinkedList<>();
        hijos_g.add(e);
        hijos_g.add(f);
        hijos_g.add(j);
        GeneralTree<Objeto> g = new GeneralTree<>(new Objeto("G",1),hijos_g);

        Parcial p = new Parcial();
        System.out.println(p.resolver(g));
    }
}
