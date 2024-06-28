package Parciales.Grafos.Ejer12;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;

public class Parcial {
    public int resolver(Graph<Ciudad> ciudades, String origen, String destino, int maxControles){
        int tiempo = 0;

        if(!ciudades.isEmpty()){
            Vertex<Ciudad> o = this.buscar(ciudades, origen);
            Vertex<Ciudad> d = this.buscar(ciudades, destino);

            if(o != null && d != null){
                tiempo = this.resolver(ciudades, o, d, maxControles, new boolean[ciudades.getSize()], o.getData().getLimite());
            }
        }

        return tiempo;
    }

    private int resolver(Graph<Ciudad> grafo, Vertex<Ciudad> o, Vertex<Ciudad> d, int maxControles, boolean[] marcas, int limiteActual){
        marcas[o.getPosition()] = true;
        int max = limiteActual;
        if(o == d){
            return max;
        }else{
            Iterator<Edge<Ciudad>> it = grafo.getEdges(o).iterator();
            while (it.hasNext()){
                Edge<Ciudad> e = it.next();
                Vertex<Ciudad> v = e.target();
                int pos = v.getPosition();
                if(!marcas[pos] && e.getWeight() <= maxControles){
                    max = Math.max(max, this.resolver(grafo, v, d, maxControles, marcas, limiteActual + v.getData().getLimite()));
                }
            }
        }
        marcas[o.getPosition()] = false;
        return max;
    }

    private Vertex<Ciudad> buscar(Graph<Ciudad> grafo, String n){
        Vertex<Ciudad> res = null;

        Iterator<Vertex<Ciudad>> it = grafo.getVertices().iterator();

        while(it.hasNext() && res == null){
            Vertex<Ciudad> v = it.next();
            if(v.getData().getNombre().equals(n)){
                res = v;
            }
        }

        return res;
    }
}
