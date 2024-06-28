package Parciales.Grafos.Ejer11;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CaminoSinControles {
    private Graph<String> mapa;

    public CaminoSinControles(Graph<String> m){
        this.mapa = m;
    }

    public List<List<String>> devolverCaminos(String origen, String destino){
        List<List<String>> listas = new LinkedList<>();

        if(!mapa.isEmpty()){
            Vertex<String> o = mapa.search(origen);
            Vertex<String> d = mapa.search(destino);

            if(o != null && d != null){
                this.resolver(o, d, listas, new LinkedList<String>(), new boolean[mapa.getSize()]);
            }
        }

        return listas;
    }

    private void resolver(Vertex<String> o, Vertex<String> d, List<List<String>> listas, List<String> camino, boolean[] marcas){
        camino.add(o.getData());
        marcas[o.getPosition()] = true;
        if(o == d){
            listas.add(new LinkedList<>(camino));
        }else{
            Iterator<Edge<String>> it = mapa.getEdges(o).iterator();
            while(it.hasNext()){
                Edge<String> e = it.next();
                Vertex<String> v = e.target();
                int pos = v.getPosition();
                if(!marcas[pos] && e.getWeight() == 0){
                    this.resolver(v, d, listas, camino, marcas);
                }
            }
        }
        marcas[o.getPosition()] = false;
        camino.removeLast();
    }
}
