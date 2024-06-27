package Parciales.Grafos.Ejer3;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.LinkedList;
import java.util.List;

public class Parcial {

    public List<List<String>> resolver(Graph<String> ciudades, String origen, String destino, String pasandoPor){
        List<List<String>> lista = new LinkedList<>();

        if(!ciudades.isEmpty()){
            Vertex<String> o = ciudades.search(origen);
            Vertex<String> d = ciudades.search(destino);

            if(o != null && d != null){
                this.resolver(ciudades, o, d, lista, new LinkedList<String>(), new boolean[ciudades.getSize()], pasandoPor);
            }
        }
        return lista;
    }

    private void resolver(Graph<String> grafo, Vertex<String> o, Vertex<String> d, List<List<String>> lista, List<String> camino, boolean[] marcas, String pasandoPor){
        marcas[o.getPosition()] = true;
        camino.add(o.getData());
//        System.out.println(camino);
        if(o==d && camino.contains(pasandoPor)){
            lista.add(new LinkedList<>(camino));
        }else{
            for(Edge<String> e: grafo.getEdges(o)){
                Vertex<String> v = e.target();
                int pos = v.getPosition();
                if(!marcas[pos] && e.getWeight() == 1){
                    this.resolver(grafo, v, d, lista, camino, marcas, pasandoPor);
                }
            }
        }
        marcas[o.getPosition()] = false;
        camino.remove(camino.size() - 1);
    }
}
