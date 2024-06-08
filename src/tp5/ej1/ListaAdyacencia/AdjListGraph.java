package tp5.ej1.ListaAdyacencia;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.ArrayList;
import java.util.List;

public class AdjListGraph<T> implements Graph<T> {

    private List<AdjListVertex<T>> vertices;

    public AdjListGraph(){
        this.vertices = new ArrayList<>();
    }
    @Override
    public Vertex<T> createVertex(T data) {
        int newPos = this.vertices.size();
        AdjListVertex<T> vertex = new AdjListVertex<>(data, newPos);
        this.vertices.add(vertex);
        return vertex;
    }

    @Override
    public void removerVertex(Vertex<T> vertex) throws Exception {
        int pos = vertex.getPosition();
        if(this.vertices.get(pos) == vertex){
            this.vertices.remove(pos);
            for(; pos < this.vertices.size(); pos++){
                this.vertices.get(pos).decrementPosition();
            }
            for (Vertex<T> otro: this.vertices){
                this.disconnect(otro, vertex);
            }
        }else throw new Exception("No existe el vertice");
    }

    @Override
    public Vertex<T> search(T data) {
        for (Vertex<T> v: this.vertices){
            if(v.getData().equals(data)){
                return v;
            }
        }
        return null;
    }

    private boolean existe(Vertex<T> v){
        int pos = v.getPosition();
        return pos >= 0 && pos < this.vertices.size() && this.vertices.get(pos) == v;
    }

    @Override
    public void connect(Vertex<T> origin, Vertex<T> destination) {
        if (this.existe(origin) && this.existe(destination)) {
            ((AdjListVertex<T>) origin).connect(destination);
        }
    }

    @Override
    public void connect(Vertex<T> origin, Vertex<T> destination, int weight) {
        if (this.existe(origin) && this.existe(destination)) {
            ((AdjListVertex<T>) origin).connect(destination, weight);
        }
    }

    @Override
    public void disconnect(Vertex<T> origin, Vertex<T> destination) {
        if (this.existe(origin)) {
            ((AdjListVertex<T>) origin).disconnect(destination);
        }
    }

    private Edge<T> getEdge(Vertex<T> o, Vertex<T> d){
        if(this.existe(o)){
            return ((AdjListVertex<T>) o).getEdge(d);
        }
        return null;
    }

    @Override
    public boolean existsEdge(Vertex<T> origin, Vertex<T> destination) {
        return this.getEdge(origin, destination) != null;
    }

    @Override
    public boolean isEmpty() {
        return this.vertices.isEmpty();
    }

    @Override
    public List<Vertex<T>> getVertices() {
        return new ArrayList<>(this.vertices);
    }

    @Override
    public int weight(Vertex<T> origin, Vertex<T> destination) {
        Edge<T> e = this.getEdge(origin, destination);
        return e != null ?  e.getWeight() : 0;
    }

    @Override
    public List<Edge<T>> getEdges(Vertex<T> v) {
        if(this.existe(v)){
            return ((AdjListVertex<T>) v).getEdges();
        }
        return null;
    }

    @Override
    public Vertex<T> getVertex(int position) {
        if(position < 0 || this.vertices.size() <= position){
            return null;
        }
        return this.vertices.get(position);
    }

    @Override
    public int getSize() {
        return this.vertices.size();
    }
}
