package tp5.ej2;

import tp1.ej8.Queue;
import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.ListaAdyacencia.AdjListGraph;
import tp5.ej1.Vertex;

import java.util.LinkedList;
import java.util.List;

public class Recorridos<T> {

    /**
     * main
     * @param grafo
     * @return
     */
    public List<T> dfs(Graph<T> grafo){
        boolean[] marca = new boolean[grafo.getSize()];
        List<T> l = new LinkedList<>();
        for(int i = 0; i < grafo.getSize(); i++){
            if(!marca[i]){
                this.dfs(i, marca, l, grafo);
            }
        }
        return l;
    }

    // Posee un Orden O(|E|+|V|), ya que se recorren todos los vértices no visitados (una unica vez cada vértice) y las aristas
    /**
     * Porque i y no vertex? Porque ya que paso el grafo, puedo obtenerlo de ahi y realizar la marca
     * @param i
     * @param marca
     * @param l
     * @param grafo
     */
    private void dfs(int i, boolean[] marca, List<T> l, Graph<T> grafo){
        marca[i] = true;
        Vertex<T> v = grafo.getVertex(i);
            l.add(v.getData());
            List<Edge<T>> adyacencias = grafo.getEdges(v);
            for (Edge<T> a: adyacencias){
                int pos = a.target().getPosition();
                if(!marca[pos]){
                    this.dfs(pos, marca, l, grafo);
                }
            }
    }

    public List<T> bfs(Graph<T> grafo) throws Exception {
        boolean[] marca = new boolean[grafo.getSize()];
        List<T> l = new LinkedList<>();
        for(int i = 0; i < grafo.getSize();i++){
            if(!marca[i]){
                bfs(i, grafo, l, marca);
            }
        }
        return l;
    }

    private void bfs(int i, Graph<T> graph, List<T> l, boolean[] marca) throws Exception {
        marca[i] = true;
        Vertex<T> v = graph.getVertex(i);
            Queue<Vertex<T>> cola = new Queue<>();
            cola.enqueue(v);
            while(!cola.isEmpty()){
                Vertex<T> aux = cola.dequeue();
                l.add(aux.getData());
                List<Edge<T>> adyacencias = graph.getEdges(v);
                for(Edge<T> a: adyacencias ){
                    int pos = a.target().getPosition();
                    if(!marca[pos]){
                        marca[pos] = true;
                        cola.enqueue(a.target());
                    }
                }
            }
    }

    public static void main(String[] args) throws Exception {
        Graph<String> ciudades = new AdjListGraph<>();
        Recorridos<String> rec = new Recorridos<String>();
        Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
        Vertex<String> v2 = ciudades.createVertex("Santiago");
        Vertex<String> v3 = ciudades.createVertex("Asunción");
        Vertex<String> v4 = ciudades.createVertex("Tokio");
        Vertex<String> v5 = ciudades.createVertex("Roma");
        Vertex<String> v6 = ciudades.createVertex("Paris");
        Vertex<String> v7 = ciudades.createVertex("Madrid");
        Vertex<String> v8 = ciudades.createVertex("Caracas");
        ciudades.connect(v1, v2);
        ciudades.connect(v1, v3);
        ciudades.connect(v2, v5);
        ciudades.connect(v3, v7);
        ciudades.connect(v3, v8);
        ciudades.connect(v8, v7);
        ciudades.connect(v8, v4);
        ciudades.connect(v5, v4);
        ciudades.connect(v7, v4);
        ciudades.connect(v6, v5);
        ciudades.connect(v6, v7);
        ciudades.connect(v6, v4);
        ciudades.connect(v4, v1);

        List<String> lisDFS = rec.dfs(ciudades);
        List<String> lisBFS = rec.bfs(ciudades);
        ciudades.getVertex(1);

        System.out.print("Lista DFS: ");
        for (String e: lisDFS){
            System.out.print(e + " ~ ");
        }

        System.out.println("");

        System.out.print("Lista BFS: ");
        for (String e: lisBFS){
            System.out.print(e + " ~ ");
        }
    }
}
