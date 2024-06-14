package Parciales.Grafos.Ejer1;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Parcial {

    public List<Ciudad> resolver(Graph<Ciudad> ciudades, String origen, String destino){
        List<Ciudad> camino = new LinkedList<>();
        if(!ciudades.isEmpty()){
            Vertex<Ciudad> o = this.buscarCiudad(ciudades, origen);
            Vertex<Ciudad> d = this.buscarCiudad(ciudades, destino);
            if(o != null && d!= null){
                this.resolver(ciudades, o, d, camino, new boolean[ciudades.getVertices().size()]);
            }
        }
        return camino;
    }

    private Vertex<Ciudad> buscarCiudad(Graph<Ciudad> c, String n){
        List<Vertex<Ciudad>> ciudades = c.getVertices();
        boolean encontre = false;
        Vertex<Ciudad> res = null;
        Iterator<Vertex<Ciudad>> it = ciudades.iterator();
        while(it.hasNext() && !encontre){
            Vertex<Ciudad> aux = it.next();
            if(aux.getData().getNombre().equals(n) && aux.getData().getFase() != 1){
                encontre = true;
                res = aux;
            }
        }
        return res;
    }

    private boolean resolver(Graph<Ciudad> c, Vertex<Ciudad> o, Vertex<Ciudad> d, List<Ciudad> l, boolean[] marcas){
        boolean encontre = false;
        l.addLast(o.getData());
        marcas[o.getPosition()] = true;
        if(o == d){
            encontre = true;
            return true;
        }else{
            List<Edge<Ciudad>> ady = c.getEdges(o);
            Iterator<Edge<Ciudad>> it = ady.iterator();
            while(it.hasNext() && !encontre){
                Edge<Ciudad> aux = it.next();
                int pos = aux.target().getPosition();
                if(!marcas[pos] && aux.target().getData().getFase() != 1){
                    encontre = resolver(c, aux.target(), d, l, marcas);
                }
            }
        }
        if(!encontre){
            l.remove(l.size()-1);
            marcas[o.getPosition()] = false;
        }

        return encontre;
    }
}
