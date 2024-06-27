package Parciales.Grafos.Simulacro_Parcial_2024;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Parcial {
    public List<String> resolver(Graph<Ciudad> mapa, String ciudad, int cantDiasVacas){
        List<String> camino = new LinkedList<>();

        if(!mapa.isEmpty()){
            Vertex<Ciudad> o = this.buscar(mapa, ciudad);
            if(o!= null && o.getData().getCantDias() <= cantDiasVacas){
                this.resolver2(mapa, o, camino, new LinkedList<String>(), cantDiasVacas-o.getData().getCantDias(), new boolean[mapa.getSize()]);
            }
        }

        return camino;
    }

    private void resolver(Graph<Ciudad> grafo, Vertex<Ciudad> o, List<String> camMax, List<String> camAct, int cantDias, boolean[] marcas){
        marcas[o.getPosition()] = true;
        camAct.add(o.getData().getNombre());
        if(cantDias == 0 && camAct.size() > camMax.size()){
            camMax.clear();
            camMax.addAll(camAct);
        }else{
            List<Edge<Ciudad>> ady = grafo.getEdges(o);
            for(Edge<Ciudad> e: grafo.getEdges(o)){
                Vertex<Ciudad> v = e.target();
                int pos = v.getPosition();
                if(!marcas[pos] && cantDias >= v.getData().getCantDias()){
                    this.resolver(grafo, v, camMax, camAct, cantDias - v.getData().getCantDias(), marcas);
                }
            }
        }
        marcas[o.getPosition()] = false;
        camAct.remove(camAct.size() - 1);
    }

    private void resolver2(Graph<Ciudad> grafo, Vertex<Ciudad> o, List<String> camMax, List<String> camAct, int cantDias, boolean[] marcas){
        marcas[o.getPosition()] = true;
        camAct.add(o.getData().getNombre());
        List<Edge<Ciudad>> ady = grafo.getEdges(o);
        for(Edge<Ciudad> e: grafo.getEdges(o)){
            Vertex<Ciudad> v = e.target();
            int pos = v.getPosition();
            if(!marcas[pos] && cantDias >= v.getData().getCantDias()){
                this.resolver(grafo, v, camMax, camAct, cantDias - v.getData().getCantDias(), marcas);
            }
        }
        if(cantDias == 0 && camAct.size() > camMax.size()){
            camMax.clear();
            camMax.addAll(camAct);
        }
        marcas[o.getPosition()] = false;
        camAct.remove(camAct.size() - 1);
    }

    private Vertex<Ciudad> buscar(Graph<Ciudad> grafo, String n){
        Vertex<Ciudad> res = null;

        Iterator<Vertex<Ciudad>> it = grafo.getVertices().iterator();
        while(it.hasNext() && res == null){
            Vertex<Ciudad> v = it.next();
            if(v.getData().getNombre().equals(n)){
                res = v;
            }
        }

        return res;
    }
}
