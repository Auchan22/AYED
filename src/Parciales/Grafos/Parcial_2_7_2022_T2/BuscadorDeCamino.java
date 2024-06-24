package Parciales.Grafos.Parcial_2_7_2022_T2;

import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.LinkedList;
import java.util.List;

public class BuscadorDeCamino {
    public List<String> caminoConPresupuesto(Graph<String> ciudades, String origen, String destino, int montoMinimo){
        List<String> camino = new LinkedList<>();

        if(!ciudades.isEmpty()){
            Vertex<String> o = ciudades.search(origen);
            Vertex<String> d = ciudades.search(destino);

            if(o != null && d != null){
                this.resolver(o, d, ciudades, new boolean[ciudades.getSize()], montoMinimo, 0, camino, new LinkedList<String>());
            }
        }

        return camino;
    }

    private boolean resolver(Vertex<String> o, Vertex<String> d, Graph<String> ciudades, boolean[] marcas, int montoMin, int act, List<String> l, List<String> aux){
        boolean encontre = false;
        marcas[o.getPosition()] = true;
        aux.add(o.getData());
        if(o == d && montoMin <= act){
            l.clear();
            l.addAll(aux);
            montoMin = act;
            return true;
        }else{

        }
    }
}
