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
            Vertex<Ciudad> v = this.buscar(mapa, ciudad);
            if(v != null){
                List<String> l = new LinkedList<>();
                this.resolver(mapa, v, cantDiasVacas, camino, l, new boolean[mapa.getSize()]);
            }
        }

        return camino;
    }

    private Vertex<Ciudad> buscar(Graph<Ciudad> m, String c){
        List<Vertex<Ciudad>> vertices = m.getVertices();
        Iterator<Vertex<Ciudad>> it = vertices.iterator();
        boolean encontre = false;
        Vertex<Ciudad> res = null;
        while(it.hasNext() && !encontre){
            Vertex<Ciudad> aux = it.next();
            if(aux.getData().getNombre().equals(c)){
                encontre = true;
                res = aux;
            }
        }

        return res;
    }

    private void resolver(Graph<Ciudad> m, Vertex<Ciudad> o, int cantDias, List<String> camMax, List<String> camActual, boolean[] marcas){
        marcas[o.getPosition()] = true;
        camActual.add(o.getData().getNombre());
        cantDias-=o.getData().getDias();
        if(cantDias >= 0 && camActual.size() > camMax.size()){
            camMax.clear();
            camMax.addAll(camActual);
        }
        if (cantDias > 0){
            List<Edge<Ciudad>> adyacencias = m.getEdges(o);
            Iterator<Edge<Ciudad>> it = adyacencias.iterator();
            while(it.hasNext()){
                Edge<Ciudad> aux = it.next();
                int pos = aux.target().getPosition();
                int dias = aux.target().getData().getDias();
                //System.out.println(o.getData().getNombre()+"|"+aux.target().getData().getNombre());
                if(!marcas[pos] && cantDias - dias > 0 ){
                    resolver(m, aux.target(), cantDias - dias, camMax, camActual, marcas);
                }
            }
        }
        cantDias+=o.getData().getDias();
        camActual.remove(camActual.size()-1);
        marcas[o.getPosition()] = false;
    }
}
