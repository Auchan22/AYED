package tp3.ej9;

import tp3.ejercicio1.GeneralTree;

import java.util.Iterator;
import java.util.List;

public class ParcialArboles {


    public static boolean esDeSeleccion(GeneralTree<Integer> arbol){
        if(arbol.isEmpty()){
            return false;
        }else{
            return helperSeleccion(arbol);
        }
    }

    private static boolean helperSeleccion(GeneralTree<Integer> a){
        if (a.isLeaf()) {
          return true; //Se asume que los hijos siempre seran de seleccion
        }else{
            Integer min = Integer.MAX_VALUE;
            boolean ok = true; // Inicialmente asumimos que los hijos cumplen las condiciones
            List<GeneralTree<Integer>> children = a.getChildren();
            Iterator<GeneralTree<Integer>> iterator = children.iterator();
            while((iterator.hasNext()) && ok){
                GeneralTree<Integer> child = iterator.next();
                min = Math.min(min, child.getData());
                ok = helperSeleccion(child);
            }

            return ((min.equals(a.getData())) && (ok)); // Devolver el resultado lógico de los hijos
        }
    }
}
