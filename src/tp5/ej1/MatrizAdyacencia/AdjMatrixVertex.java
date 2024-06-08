package tp5.ej1.MatrizAdyacencia;

import tp5.ej1.Vertex;

public class AdjMatrixVertex<T> implements Vertex<T> {

    private T data;
    private int position;

    public AdjMatrixVertex(T d, int p){
        this.data = d;
        this.position = p;
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

    void setPosition(int position){
        this.position = position;
    }

    void decrementPosition(){
        this.position--;
    }
}
