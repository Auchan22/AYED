package Parciales.Grafos.Ejer6;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Parcial {
    public List<List<String>> resolver(Graph<String> grafo){
        List<List<String>> listas = new LinkedList<>();

        if(!grafo.isEmpty()){
            for(Vertex<String> v: grafo.getVertices()){
                this.resolver(grafo, v, 10, listas, new LinkedList<String>(), new boolean[grafo.getSize()]);
            }
        }

        return listas;
    }

    private void resolver(Graph<String> grafo, Vertex<String> v, int total, List<List<String>> listas, List<String> camino, boolean[] marcas){
        camino.add(v.getData());
        marcas[v.getPosition()] = true;
        if(total == 0){
            listas.add(new LinkedList<>(camino));
        }else{
            List<Edge<String>> ady = grafo.getEdges(v);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext()){
                Edge<String> e = it.next();
                Vertex<String> aux = e.target();
                int pos = aux.getPosition();
                if(!marcas[pos] && e.getWeight() <= total){
                    this.resolver(grafo, aux, total - e.getWeight(), listas, camino, marcas);
                }
            }
        }
        camino.remove(camino.size()-1);
        marcas[v.getPosition()] = false;
    }

}
