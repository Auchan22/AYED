package tp5.ej4;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class VisitaOslo {

    public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
        List<String> camino = new LinkedList<>();

        if(!lugares.isEmpty()){
            Vertex<String> o = lugares.search("Ayuntamiento");
            Vertex<String> d = lugares.search(destino);
            if(o != null && d != null){
                boolean[] marcas = new boolean[lugares.getSize()];
                this.marcarRestringidos(marcas, lugaresRestringidos, lugares);
                this.dfs(o, d, marcas, lugares, camino, maxTiempo);
            }
        }

        return camino;
    }

    private void marcarRestringidos(boolean[] marcas, List<String> r, Graph<String> l){
        for (String n: r){
            Vertex<String> v = l.search(n);
            if(v != null){
                marcas[v.getPosition()] = true;
            }
        }
    }

    private boolean dfs(Vertex<String> o, Vertex<String> d, boolean[] marcas, Graph<String> lugares, List<String> camino, int tiempo){
        boolean encontre = false;
        marcas[o.getPosition()] = true;
        camino.add(o.getData());
        if(o == d){
            return true;
        }else {
            List<Edge<String>> adyacencias = lugares.getEdges(o);
            Iterator<Edge<String>> it = adyacencias.iterator();
            while(it.hasNext() && !encontre){
                Edge<String> v = it.next();
                int pos = v.target().getPosition();
                if(!marcas[pos] && tiempo - v.getWeight() >= 0){
                    encontre = dfs(v.target(), d, marcas, lugares, camino, tiempo - v.getWeight());
                }
            }
        }
        if(!encontre){
            camino.remove(camino.size()-1);
        }
        marcas[o.getPosition()] = false;
        return encontre;
    }
}
