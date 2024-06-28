package Parciales.Grafos.Ejer5;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Parcial {
    public List<Sitio> resolver(Graph<Sitio> ciudad){
        List<Sitio> camino = new LinkedList<>();

        if(!ciudad.isEmpty()){
            Vertex<Sitio> o = this.buscar(ciudad, "Municipalidad");
            Vertex<Sitio> d = this.buscar(ciudad, "Casa del Intendente");

            if(o != null && d != null){
                this.resolver(ciudad, o, d, camino, new boolean[ciudad.getSize()]);
            }
        }

        return camino;
    }

    private boolean resolver(Graph<Sitio> grafo, Vertex<Sitio> o, Vertex<Sitio> d, List<Sitio> l, boolean[] marcas){
        boolean encontre = false;
        marcas[o.getPosition()] = true;
        l.add(o.getData());
        if(o == d){
            return true;
        }else{
            List<Edge<Sitio>> ady = grafo.getEdges(o);
            Iterator<Edge<Sitio>> it = ady.iterator();
            while(it.hasNext() && !encontre){
                Edge<Sitio> e = it.next();
                Vertex<Sitio> v = e.target();
//                System.out.println(v.getData().getNombre()+"|"+e.getWeight());
                int pos = v.getPosition();
                if(e.getWeight() != 1){
                    if(!marcas[pos] && !v.getData().estaControlada()){
                        encontre = this.resolver(grafo, v, d, l, marcas);
                    }
                }
            }
        }
        if(!encontre){
            marcas[o.getPosition()] = false;
            l.remove(l.size()-1);
        }
        return encontre;
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
}
