package Parciales.Grafos.Ejer7;

import tp1.ej8.Queue;
import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.List;

public class Parcial {
    //Se aplica un bfs
    public int resolver(Graph<String> grafo, Vertex<String> origen) throws Exception {
        int tiempo = 0;

        if(!grafo.isEmpty()){
            if(grafo.getVertices().contains(origen)){
                tiempo = this.resolver(grafo, origen, new boolean[grafo.getSize()]);
            }
        }

        return tiempo;
    }

    private int resolver(Graph<String> grafo, Vertex<String> v, boolean[] marcas) throws Exception {
        int t = 0;

        Queue<Vertex<String>> cola = new Queue<>();
        Vertex<String> aux = null;
        marcas[v.getPosition()] = true;
        cola.enqueue(v);
        cola.enqueue(null);
        while(!cola.isEmpty()){
            aux = cola.dequeue();
            if(aux != null){
                List<Edge<String>> ady = grafo.getEdges(aux);
                Iterator<Edge<String>> it = ady.iterator();
                while(it.hasNext()){
                    Edge<String> e = it.next();
                    Vertex<String> ve = e.target();
                    int pos = ve.getPosition();
                    if(!marcas[pos]){
                        cola.enqueue(ve);
                        marcas[pos] = true;
                    }
                }
            }else if(!cola.isEmpty()){
                t++;
                cola.enqueue(null);
            }
        }

        return t;
    }
}
