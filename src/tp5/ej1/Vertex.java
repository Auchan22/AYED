package tp5.ej1;

public interface Vertex<T> {

    /**
     * Retorna el dato del vértice
     *
     * @return T
     */
    public T getData();

    /**
     * Reemplaza el dato del vértice
     *
     * @param data
     */
    public void setData(T data);

    /**
     * Retorna la posición del vértice en el grafo
     *
     * @return int
     */
    public int getPosition();
}
