package tp3.ej9;

import tp3.ejercicio1.GeneralTree;

public class ParcialArboles {


    public static boolean esDeSeleccion(GeneralTree<Integer> arbol){
        if(arbol.isEmpty()){
            return false;
        }else{
            return helperSeleccion(arbol, Integer.MAX_VALUE);
        }
    }

    private static boolean helperSeleccion(GeneralTree<Integer> a, int minAnt){
        if (a.hasChildren()) {
            int padre = a.getData();
            boolean resultadoHijos = true; // Inicialmente asumimos que los hijos cumplen las condiciones
            for (GeneralTree<Integer> child : a.getChildren()) {
                minAnt = Math.min(minAnt, child.getData());
                if(padre != minAnt) return false;
                resultadoHijos = resultadoHijos && helperSeleccion(child, child.getData()); // Operación lógica con el resultado de los hijos
            }
            return resultadoHijos; // Devolver el resultado lógico de los hijos
        }

        return true; // Si no hay hijos, entonces este nodo es un nodo de selección
    }
}
