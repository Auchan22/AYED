package tp5.ej1.MatrizAdyacencia;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.ArrayList;
import java.util.List;

public class AdjMatrixGraph<T> implements Graph<T> {
    private static final int EMPTY_VALUE = 0;
    private int maxVertices;
    private List<AdjMatrixVertex<T>> vertices;
    private int [][] adjMatrix;

    public AdjMatrixGraph(int max){
        this.maxVertices = max;
        this.vertices = new ArrayList<AdjMatrixVertex<T>>();
        this.adjMatrix = new int[maxVertices][maxVertices];
        for(int i = 0; i < maxVertices; i++){
            for(int j = 0; j < maxVertices; j++){
                adjMatrix[i][j] = EMPTY_VALUE;
            }
        }
    }

    /*
        Aca creo el vertice y lo agrego en la lista de vértices.
        Todavía no creo el enlace con ningun otro.
     */
    @Override
    public Vertex<T> createVertex(T data) {
        if(this.vertices.size() == maxVertices){
            //La matriz esta llena
            return null;
        }
        AdjMatrixVertex<T> v = new AdjMatrixVertex<T>(data, vertices.size());
        vertices.add(v);
        return v;
    }

    @Override
    public void removerVertex(Vertex<T> vertex) {

        if (!vertices.remove(vertex)) {
            // el vértice no está en el grafo
            return;
        }

        int index = vertex.getPosition();
        int total = vertices.size();
        // Elimino la fila
        for (int fila = index; fila < total; fila++) {
            adjMatrix[fila] = adjMatrix[fila + 1];
        }
        // Elimino la columna
        for (int fila = 0; fila < total; fila++) {
            for (int col = index; col < total; col++) {
                adjMatrix[fila][col] = adjMatrix[fila][col + 1];
            }
        }
        // Reasigno las posiciones
        for (int fila = index; fila < total; fila++) {
            vertices.get(fila).decrementPosition();
        }
        // Limpio la ultima fila
        for (int col = 0; col < total; col++) {
            adjMatrix[total][col] = EMPTY_VALUE;
        }
        // Limpio la ultima columna
        for (int fila = 0; fila < total; fila++) {
            adjMatrix[fila][total] = EMPTY_VALUE;
        }
    }

    @Override
    public Vertex<T> search(T data) {
        for(Vertex<T> v: this.vertices){
            if(v.getData().equals(data)){
                return v;
            }
        }

        return null;
    }

    private boolean existe(Vertex<T> vertex){
        int pos = vertex.getPosition();
        return pos >= 0 && pos < this.vertices.size() && this.vertices.get(pos) == vertex;
    }

    @Override
    public void connect(Vertex<T> origin, Vertex<T> destinatio, int weight) {
        if(this.existe(origin) && this.existe(destinatio)){
            this.adjMatrix[origin.getPosition()][destinatio.getPosition()] = weight;
        }
    }

    @Override
    public void connect(Vertex<T> origin, Vertex<T> destinatio) {
        connect(origin, destinatio, 1);
    }

    @Override
    public void disconnect(Vertex<T> origin, Vertex<T> destination) {
        if(this.existe(origin) && this.existe(destination)){
            this.adjMatrix[origin.getPosition()][destination.getPosition()] = EMPTY_VALUE;
        }
    }

    @Override
    public boolean existsEdge(Vertex<T> origin, Vertex<T> destination) {
        return this.weight(origin, destination) != EMPTY_VALUE;
    }

    @Override
    public boolean isEmpty() {
        return this.vertices.isEmpty();
    }

    @Override
    public List<Vertex<T>> getVertices() {
        return new ArrayList<Vertex<T>>(this.vertices);
    }

    @Override
    public int weight(Vertex<T> origin, Vertex<T> destination) {
        if(this.existe(origin) && this.existe(destination)){
            return this.adjMatrix[origin.getPosition()][destination.getPosition()] ;
        }

        return EMPTY_VALUE;
    }

    @Override
    public List<Edge<T>> getEdges(Vertex<T> v) {
        List<Edge<T>> l = new ArrayList<>();
        int pos = v.getPosition();
        for (int i = 0; i < this.vertices.size();i++){
            if(adjMatrix[pos][i] != EMPTY_VALUE){
                l.add(new AdjMatrixEdge<>(vertices.get(i), adjMatrix[pos][i]));
            }
        }
        return l;
    }

    @Override
    public Vertex<T> getVertex(int position) {
        if(position < 0 || position >= this.vertices.size()){
            return null;
        }
        return vertices.get(position);
    }

    @Override
    public int getSize() {
        return this.vertices.size();
    }
}
