package tp5.ej1.ListaAdyacencia;

import tp5.ej1.Edge;
import tp5.ej1.Vertex;

import java.util.List;

public class AdjListEdge<T> implements Edge<T> {
    private Vertex<T> target;
    private int weight;

    public AdjListEdge(Vertex<T> t, int w){
        this.target = t;
        this.weight = w;
    }


    @Override
    public Vertex<T> target() {
        return this.target;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }
}
