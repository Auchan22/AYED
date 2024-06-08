package tp5.ej1;

public interface Edge<T> {

    /**
     * Retorna el vértice destino de la arista
     *
     * @return Vertex<T>
     */
    public Vertex<T> target();

    /**
     * Retorna el peso de la arista
     *
     * @return int
     */
    public int getWeight();
}
