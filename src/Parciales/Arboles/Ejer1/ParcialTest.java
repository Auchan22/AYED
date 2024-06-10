package Parciales.Arboles.Ejer1;

import tp3.ejercicio1.GeneralTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ParcialTest {

    public static void main(String[] args){
        List<GeneralTree<Character>> hijos_f = new LinkedList<>();
        hijos_f.add(new GeneralTree<>('H'));
        hijos_f.add(new GeneralTree<>('I'));
        GeneralTree<Character> f = new GeneralTree<>('F', hijos_f);

        List<GeneralTree<Character>> hijos_c = new LinkedList<>();
        hijos_c.add(f);
        hijos_c.add(new GeneralTree<>('G'));
        GeneralTree<Character> c = new GeneralTree<>('C', hijos_c);

        GeneralTree<Character> b = new GeneralTree<>('B');
        b.addChild(new GeneralTree<>('E'));

        GeneralTree<Character> d = new GeneralTree<>('D');

        List<GeneralTree<Character>> hijos_a = new LinkedList<>();
        hijos_a.add(b);
        hijos_a.add(c);
        hijos_a.add(d);
        GeneralTree<Character> a = new GeneralTree<>('A', hijos_a);

        Parcial p = new Parcial();

        List<Character> result = p.caminosPares(a);

        Iterator<Character> it = result.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
