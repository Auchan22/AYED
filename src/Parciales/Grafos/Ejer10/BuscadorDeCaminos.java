package Parciales.Grafos.Ejer10;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BuscadorDeCaminos {
    private Graph<String> grafo;

    public BuscadorDeCaminos(Graph<String> g){
        this.grafo = g;
    }
    public List<List<String>> recorridoMasSeguro(){
        List<List<String>> listas = new LinkedList<>();

        if(!grafo.isEmpty()){
            Vertex<String> o = this.grafo.search("Casa Caperucita");
            Vertex<String> d = this.grafo.search("Casa Abuelita");

            if(o != null && d != null){
                this.resolver(o, d, listas, new LinkedList<String>(), new boolean[grafo.getSize()]);
            }
        }

        return listas;
    }

    private void resolver(Vertex<String> o, Vertex<String> d, List<List<String>> listas, List<String> camino, boolean[] marcas){
        camino.add(o.getData());
        marcas[o.getPosition()] = true;
        if(o == d){
            listas.add(new LinkedList<>(camino));
        }else{
            Iterator<Edge<String>> it = grafo.getEdges(o).iterator();
            while(it.hasNext()){
                Edge<String> e = it.next();
                Vertex<String> v = e.target();
                int pos = v.getPosition();
                if(!marcas[pos] && e.getWeight() < 5){
                    this.resolver(v, d, listas, camino, marcas);
                }
            }
        }
        camino.removeLast();
        marcas[o.getPosition()] = false;
    }
}
