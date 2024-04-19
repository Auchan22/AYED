package tp3.ej2;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class TestEjercicio2 {
	public static void main(String[] args) throws Exception {
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(21));
        children2.add(new GeneralTree<Integer>(22));
        children2.add(new GeneralTree<Integer>(23));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);
        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
        children3.add(new GeneralTree<Integer>(31));
        children3.add(new GeneralTree<Integer>(32));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);
        List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>();
        childen.add(a1);childen.add(a2);childen.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(11, childen);
        
        System.out.println("AlturaMax=" + a.altura());
        System.out.println("Ancho=" + a.ancho());
        System.out.println("Nivel=" + a.nivel(9));
        System.out.println("ES ANCESTRO 11 DE 2:" + a.esAncestro(11, 2));
        System.out.println("ES ANCESTRO 2 DE 11:" + a.esAncestro(2, 11));
        System.out.println("ES ANCESTRO 11 DE 21:" + a.esAncestro(11, 21));
        System.out.println("ES ANCESTRO 3 DE 32:" + a.esAncestro(3, 32));
        System.out.println("ES ANCESTRO 7 DE 22:" + a.esAncestro(7, 22));

        /*
         * 
         *            11
         *       1     2        3
         *          21 22 23  31  32
         * 
         */
        
        RecorridosAg rec = new RecorridosAg();
        
        System.out.println("PREORDEN:" + rec.numeroImparesMayoresQuePreOrden(a, 0));
        System.out.println("INORDEN:" + rec.numeroImparesMayoresQueInOrden(a, 0));
        System.out.println("POSTORDEN:" + rec.numeroImparesMayoresQuePosOrden(a, 0));
        System.out.println("POR NIVELES:" + rec.numerosImparesMayoresQuePorNiveles(a, 0));
	}
}
