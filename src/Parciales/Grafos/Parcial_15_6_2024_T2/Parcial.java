package Parciales.Grafos.Parcial_15_6_2024_T2;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.List;

public class Parcial {
    public String resolver(Graph<Sitio> sitios, int tiempo){
        boolean ok = false;

        if(!sitios.isEmpty()){
            Vertex<Sitio> o = this.buscar(sitios, "Entrada");
            if(o != null){
                if(o.getData().getTiempo() <= tiempo){
                    ok = this.resolver(sitios, o, 1, sitios.getSize(), tiempo - o.getData().getTiempo(), new boolean[sitios.getSize()]);
                }
            }
        }

        return ok ? "Alcanzable" : "No Alcanzable";
    }

    private boolean resolver(Graph<Sitio> grafo, Vertex<Sitio> o, int cantAct, int cantMax, int tiempo, boolean[] marcas){
        marcas[o.getPosition()] = true;
        boolean termine = false;
        if(cantAct == cantMax){
            return true;
        }else{
            List<Edge<Sitio>> ady = grafo.getEdges(o);
            Iterator<Edge<Sitio>> it = ady.iterator();
            while(it.hasNext() && !termine){
                Edge<Sitio> e = it.next();
                Vertex<Sitio> v = e.target();
                int pos = v.getPosition();
                int peso = e.getWeight() + v.getData().getTiempo();
                if(!marcas[pos] && peso <= tiempo){
                    termine = this.resolver(grafo, v, cantAct+1, cantMax, tiempo - peso, marcas);
                }
            }
        }
        marcas[o.getPosition()] = false;
        return termine;
    }

    private Vertex<Sitio> buscar(Graph<Sitio> grafo, String n){
        Vertex<Sitio> res = null;
        List<Vertex<Sitio>> vertices = grafo.getVertices();
        Iterator<Vertex<Sitio>> it = vertices.iterator();
        while(it.hasNext() && res == null){
            Vertex<Sitio> act = it.next();
            if(act.getData().getNombre().equals(n)){
                res = act;
            }
        }

        return res;
    }
}
