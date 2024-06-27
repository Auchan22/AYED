package Parciales.Grafos.Parcial_15_6_2024_T1;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
public class Parcial {
    public int resolver(Graph<Sitio> sitios, int tiempo){
        int cantVisitados = 0;

        if(!sitios.isEmpty()){
            Vertex<Sitio> o = this.buscar(sitios, "Entrada");
            if(o != null && o.getData().getTiempo() <= tiempo){
                cantVisitados = this.resolver(sitios, o, 1, new boolean[sitios.getSize()], tiempo - o.getData().getTiempo());
            }
        }

        return cantVisitados;
    }

    private Vertex<Sitio> buscar(Graph<Sitio> grafo, String n){
        Vertex<Sitio> res = null;
        Iterator<Vertex<Sitio>> it = grafo.getVertices().iterator();
        while(it.hasNext() && res == null){
            Vertex<Sitio> v = it.next();
            if(v.getData().getNombre().equals(n)){
                res = v;
            }
        }

        return res;
    }

    private int resolver(Graph<Sitio> grafo, Vertex<Sitio> o, int cantVisitados, boolean[] marcas, int tiempo){
        marcas[o.getPosition()] = true;
        int maxVisitados = cantVisitados;
        for(Edge<Sitio> e: grafo.getEdges(o)){
            Vertex<Sitio> v = e.target();
            int pos = v.getPosition();
            int peso = e.getWeight() + v.getData().getTiempo();
            if(!marcas[pos] && peso <= tiempo){
                maxVisitados = Math.max(maxVisitados, this.resolver(grafo, v, cantVisitados+1, marcas, tiempo-peso));
            }
        }
        marcas[o.getPosition()] = false;
        return maxVisitados;
    }
}
