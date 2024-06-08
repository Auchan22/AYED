package tp5.ej1.MatrizAdyacencia;

import tp5.ej1.Edge;
import tp5.ej1.Vertex;

public class AdjMatrixEdge<T> implements Edge<T> {

    private int weight;
    private Vertex<T> target;

    public AdjMatrixEdge(Vertex<T> t, int w){
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
