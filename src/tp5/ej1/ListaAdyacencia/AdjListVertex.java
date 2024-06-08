package tp5.ej1.ListaAdyacencia;

import tp5.ej1.Edge;
import tp5.ej1.Vertex;

import java.util.ArrayList;
import java.util.List;

public class AdjListVertex<T> implements Vertex<T> {

    private T data;
    private int position;

    private List<Edge<T>> edges;

    public AdjListVertex(T data, int pos){
        this.data = data;
        this.position = pos;
        this.edges = new ArrayList<>();
    }
    @Override
    public T getData() {
        return this.data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public int getPosition() {
        return this.position;
    }

    public List<Edge<T>> getEdges(){
        return new ArrayList<>(this.edges);
    }

    public Edge<T> getEdge(Vertex<T> d){
        for(Edge<T> e: this.edges){
            if(e.target() == d){
                return e;
            }
        }
        return null;
    }

    void decrementPosition(){
        this.position--;
    }

    void connect(Vertex<T> v){
        this.connect(v, 1);
    }

    void connect(Vertex<T> v, int weight){
        Edge<T> e = this.getEdge(v);
        if(e == null){
            this.edges.add(new AdjListEdge<>(v, weight));
        }
    }

    void disconnect(Vertex<T> v){
        Edge<T> e = this.getEdge(v);
        if (e != null) {
            this.edges.remove(e);
        }
    }
}
