package Parciales.Grafos.Ejer13;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Parcial {
    public List<String> caminoDistanciaMaxima(Graph<String> ciudades, String origen, String destino, int distanciaMaxima){
        List<String> camino = new LinkedList<>();

        if(!ciudades.isEmpty()){
            Vertex<String> o = ciudades.search(origen);
            Vertex<String> d = ciudades.search(destino);

            if(o != null && d != null){
                this.resolver(ciudades, o, d, distanciaMaxima, camino, new boolean[ciudades.getSize()]);
            }
        }

        return camino;
    }

    private boolean resolver(Graph<String> grafo, Vertex<String> o, Vertex<String> d, int distanciaMaxima, List<String> camino, boolean[] marcas){
        boolean encontre = false;
        marcas[o.getPosition()] = true;
        camino.add(o.getData());
        if(o == d){
            return true;
        }else{
            Iterator<Edge<String>> it = grafo.getEdges(o).iterator();
            while(it.hasNext() && !encontre){
                Edge<String> e = it.next();
                Vertex<String> v = e.target();
                int pos = v.getPosition();
                if(!marcas[pos] && e.getWeight() <= distanciaMaxima){
                    encontre = this.resolver(grafo, v, d, distanciaMaxima, camino, marcas);
                }
            }
        }
        if(!encontre){
             marcas[o.getPosition()] = false;
             camino.removeLast();
        }
        return encontre;
    }
}
