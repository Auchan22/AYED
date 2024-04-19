package tp3.ej4;

import tp3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class TestAnalizador {
    public static void main(String[] args) throws Exception {
        List<GeneralTree<AreaEmpresa>> children13 = new LinkedList<GeneralTree<AreaEmpresa>>();

        children13.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("A", 4)));
        children13.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("B", 7)));
        children13.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("C", 5)));

        GeneralTree<AreaEmpresa> a13 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("J", 13), children13);

        List<GeneralTree<AreaEmpresa>> children25 = new LinkedList<GeneralTree<AreaEmpresa>>();

        children25.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("D", 6)));
        children25.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("E", 10)));
        children25.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("F", 18)));

        GeneralTree<AreaEmpresa> a25 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("K", 25), children25);

        List<GeneralTree<AreaEmpresa>> children10 = new LinkedList<GeneralTree<AreaEmpresa>>();

        children10.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("G", 9)));
        children10.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("H", 12)));
        children10.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("I", 19)));

        GeneralTree<AreaEmpresa> a10 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("L", 10), children10);

        List<GeneralTree<AreaEmpresa>> children14 = new LinkedList<GeneralTree<AreaEmpresa>>();

        children14.add(a13);
        children14.add(a25);
        children14.add(a10);

        GeneralTree<AreaEmpresa> a14 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("M", 14), children14);

        AnalizadorArbol analizadorArbol = new AnalizadorArbol();

        System.out.println("El mayor promedio es: "+ analizadorArbol.devolverMaximoPromedio(a14));
    }
}
