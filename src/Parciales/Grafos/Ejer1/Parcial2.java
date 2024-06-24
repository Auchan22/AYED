package Parciales.Grafos.Ejer1;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Parcial2 {
    public List<Ciudad> resolver(Graph<Ciudad> ciudades, String origen, String destino){
        List<Ciudad> camino = new LinkedList<>();

        if(!ciudades.isEmpty()){
            Vertex<Ciudad> o = this.buscar(ciudades, origen);
            Vertex<Ciudad> d = this.buscar(ciudades, destino);

            if(o != null && d != null){
                this.resolver(ciudades, camino, new boolean[ciudades.getSize()], o, d);
            }
        }

        return camino;
    }

    private Vertex<Ciudad> buscar(Graph<Ciudad> ciudades, String n){
        Vertex<Ciudad> res = null;
        boolean encontre = false;
        List<Vertex<Ciudad>> vertices = ciudades.getVertices();
        Iterator<Vertex<Ciudad>> it = vertices.iterator();
        while(it.hasNext() && !encontre){
            Vertex<Ciudad> aux = it.next();
            if(aux.getData().getNombre().equals(n) && aux.getData().getFase() != 1){
                encontre = true;
                res = aux;
            }
        }
        return res;
    }

    private boolean resolver(Graph<Ciudad> grafo, List<Ciudad> c, boolean[] marcas, Vertex<Ciudad> o, Vertex<Ciudad> d){
        boolean encontre = false;
        marcas[o.getPosition()] = true;
        c.add(o.getData());
        if(o == d){
            return true;
        }else{
            List<Edge<Ciudad>> ady = grafo.getEdges(o);
            Iterator<Edge<Ciudad>> it = ady.iterator();
            while (it.hasNext() && !encontre){
                Edge<Ciudad> e = it.next();
                int pos = e.target().getPosition();
                if(!marcas[pos] && e.target().getData().getFase() != 1){
                    encontre = this.resolver(grafo, c, marcas, e.target(), d);
                }
            }
        }
        if(!encontre){
            marcas[o.getPosition()] = false;
            c.removeLast();
        }
        return encontre;
    }
}
