package Parciales.Grafos.Ejer2;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Parcial {
    public List<Ciudad> resolver(Graph<Ciudad> ciudades, String origen, String destino, List<Ciudad> pasandoPor){
        List<Ciudad> camino = new LinkedList<>();
        if(!ciudades.isEmpty()){
            Vertex<Ciudad> o = this.buscarCiudad(ciudades, origen);
            Vertex<Ciudad> d = this.buscarCiudad(ciudades, destino);
            if(o != null && d != null){
                this.resolver(ciudades, o, d, pasandoPor,camino, 0, new boolean[ciudades.getSize()]);
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
            if(aux.getData().getNombre().equals(n)){
                encontre = true;
                res = aux;
            }
        }
        return res;
    }

    private boolean resolver(Graph<Ciudad> c, Vertex<Ciudad> o, Vertex<Ciudad> d, List<Ciudad> pasandoPor, List<Ciudad> l, int cant, boolean[] marcas){
        boolean encontre = false;
        l.add(o.getData());
        marcas[o.getPosition()] = false;
        if(o == d){
            encontre = true;
//            encontre = pasandoPor.indexOf(o) != -1;
            return encontre;
        }else{
            List<Edge<Ciudad>> ady = c.getEdges(o);
            Iterator<Edge<Ciudad>> it = ady.iterator();
            while(it.hasNext() && !encontre){
                Vertex<Ciudad> v = it.next().target();
                int pos = v.getPosition();
                if(!marcas[pos] && !encontre){
                    encontre = resolver(c,v, d, pasandoPor, l, cant-1, marcas);
                }
            }
        }
        if(!encontre){
            marcas[o.getPosition()] = false;
            l.remove(l.size()-1);
        }
        return encontre;
    }

}
