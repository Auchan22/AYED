package Parciales.Grafos.Parcial_2_7_2022_T2;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BuscadorDeCamino {
    public List<String> caminoConPresupuesto(Graph<String> ciudades, String origen, String destino, int montoMinimo){
        List<String> camino = new LinkedList<>();

        if(!ciudades.isEmpty()){
            Vertex<String> o = ciudades.search(origen);
            Vertex<String> d = ciudades.search(destino);

            if(o != null && d != null){
                this.resolver(o, d, ciudades, new boolean[ciudades.getSize()], montoMinimo, 0, camino);
            }
        }

        return camino;
    }

    private boolean resolver(Vertex<String> o, Vertex<String> d, Graph<String> ciudades, boolean[] marcas, int montoMin, int act, List<String> l){
        boolean encontre = false;
        marcas[o.getPosition()] = true;
        l.add(o.getData());
        if(o == d && montoMin < act){
            return true;
        }else{
        	List<Edge<String>> ady = ciudades.getEdges(o);
        	Iterator<Edge<String>> it = ady.iterator();
        	while(it.hasNext() && !encontre) {
        		Edge<String> e = it.next();
        		int pos = e.target().getPosition();
        		if(!marcas[pos]) {
        			encontre = this.resolver(e.target(), d, ciudades, marcas, montoMin, act + e.getWeight(), l);
        		}
        	}
        }
        if(!encontre) {
        	l.remove(l.size()-1);
        }
        marcas[o.getPosition()] = false;
        return encontre;
    }
}
