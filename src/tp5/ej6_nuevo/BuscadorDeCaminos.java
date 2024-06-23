package tp5.ej6_nuevo;

import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.LinkedList;
import java.util.List;

public class BuscadorDeCaminos {
    private Graph<String> bosque;

    public BuscadorDeCaminos(Graph<String> b){
        this.bosque = b;
    }

    public List<List<String>> recorridoMasSeguro(){
        List<List<String>> listado = new LinkedList<>();
        List<String> camino = new LinkedList<>();

        if(!this.bosque.isEmpty()){
            Vertex<String> o = this.bosque.search("Casa Caperucita");
            if(o != null){
                this.resolver(listado, camino, o, new boolean[this.bosque.getSize()]);
            }
        }
        return listado;
    }

    private void resolver(List<List<String>> listado, List<String> camino, Vertex<String> o, boolean[] marcas){
        camino.add(o.getData());
        marcas[o.getPosition()] = true;
        if(o.getData().equals("Casa Abuelita")){
            listado.add(new LinkedList<>(camino));
        }else{
            int size = camino.size();

        }
    }
}
