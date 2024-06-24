package Parciales.Grafos.Ejer2;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Parcial2 {
    public List<Ciudad> resolver(Graph<Ciudad> ciudades, String origen, String destino, List<Ciudad> pasandoPor){
        List<Ciudad> camino = new LinkedList<>();

        if(!ciudades.isEmpty()){
            Vertex<Ciudad> o = this.buscar(ciudades, origen);
            Vertex<Ciudad> d = this.buscar(ciudades, destino);

            if(o != null && d != null){
                this.resolver(o, d, new boolean[ciudades.getSize()], camino, pasandoPor, ciudades);
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
            if(aux.getData().getNombre().equals(n)){
                encontre = true;
                res = aux;
            }
        }
        return res;
    }

    private boolean resolver(Vertex<Ciudad> o, Vertex<Ciudad> d, boolean[] marcas, List<Ciudad> c, List<Ciudad> p, Graph<Ciudad> grafo){
        boolean encontre = false;
        marcas[o.getPosition()] = true;
        c.add(o.getData());
        if(o == d){
            encontre=true;
            Iterator<Ciudad> it = p.iterator();
            while(it.hasNext() && encontre){
                encontre = c.contains(it.next());
            }
            return encontre;
        }else{
            List<Edge<Ciudad>> ady = grafo.getEdges(o);
            Iterator<Edge<Ciudad>> it = ady.iterator();
            while(it.hasNext() && !encontre){
                Vertex<Ciudad> v = it.next().target();
                int pos = v.getPosition();
                if(!marcas[pos] && !encontre){
                    encontre = resolver(v,d, marcas, c, p, grafo);
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
