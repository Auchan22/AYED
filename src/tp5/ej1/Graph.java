package tp5.ej1;

import java.util.List;

public interface Graph<T>{
    /**
     * Crea un vertice del tipo de dato recibido y lo retorna
     *
     * @param data
     * @return Vertex<T>
     */
    public Vertex<T> createVertex(T data);

    /**
     * Elimina el vértice del grafo.
     * Si esta relacionado con otros vértices, tambien se eliminan
     *
     * @param Vertex<T> vertex
     */
    public void removerVertex(Vertex<T> vertex) throws Exception;

    /**
     * Buscar y retorna el vértice cuyo dato se recibe por parametro
     *
     * @param data
     * @return Vertex<T>
     */
    public Vertex<T> search(T data);

    /**
     * Conecta el vértice origen con el destino, manteniendo un peso en la arista.
     * Verifica que ambos existan, sino no hace el enlace
     *
     * @param origin
     * @param destinatio
     * @param weight
     */
    public void connect(Vertex<T> origin, Vertex<T> destinatio, int weight);

    /**
     *
     * @param origin
     * @param destinatio
     */
    public void connect(Vertex<T> origin, Vertex<T> destinatio);

    /**
     * Desconecta el vértice origen con el destino.
     * Verifica que ambos existan, caso contrario, no realiza la desconexión.
     * Si existe la conexión inversa, esta se mantiene destino->origen
     *
     * @param origin
     * @param destination
     */
    public void disconnect(Vertex<T> origin, Vertex<T> destination);

    /**
     * Retorna true si existe una arista entre el vértice origen y el destino.
     *
     * @param origin
     * @param destination
     * @return boolean
     */
    public boolean existsEdge(Vertex<T> origin, Vertex<T> destination);

    /**
     * Retorna si el grafo no contiene datos
     *
     * @return boolean
     */
    public boolean isEmpty();

    /**
     * Retorna la lista de vértices
     *
     * @return List<Vertex<T>>
     */
    public List<Vertex<T>> getVertices();

    /**
     * Retorna el peso entre los dos vértices.
     * Si no existe la arista, retorna 0
     *
     * @param origin
     * @param destination
     * @return int
     */
    public int weight(Vertex<T> origin, Vertex<T> destination);

    /**
     * Retorna la lista de adyacencias al vértice recibido
     *
     * @param v
     * @return List<Edge<T>>
     */
    public List<Edge<T>> getEdges(Vertex<T> v);

    /**
     * Obtiene le vértice de la posición recibida.
     *
     * @param position
     * @return Vertex<T>
     */
    public Vertex<T> getVertex(int position);

    /**
     * Retorna la cantidad de vérties del grafo
     *
     * @return int
     */
    public int getSize();
}
