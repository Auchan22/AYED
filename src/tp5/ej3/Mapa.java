package tp5.ej3;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.ListaAdyacencia.AdjListGraph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Mapa {
    private Graph<String> mapaCiudades;

    public Mapa(Graph<String> m){
        this.mapaCiudades = m;
    }

    /*----------------------- Inciso 1 -----------------------*/
    public List<String> devolverCamino(String c1, String c2){
        List<String> camino = new LinkedList<String>();

        if(!this.mapaCiudades.isEmpty()){
            Vertex<String> origen = this.mapaCiudades.search(c1);
            Vertex<String> destino = this.mapaCiudades.search(c2);
            if(origen != null && destino != null){
                this.devolverCamino(origen, destino, camino, new boolean[this.mapaCiudades.getSize()]);
            }
        }

        return camino;
    }

    private boolean devolverCamino(Vertex<String> o, Vertex<String> d, List<String> l, boolean[] marcas){
        boolean encontre = false;
        marcas[o.getPosition()] = true;
        l.add(o.getData());
        if(o == d){
            return true;
        }else{
            List<Edge<String>> adyacencias = this.mapaCiudades.getEdges(o);
            Iterator<Edge<String>> it = adyacencias.iterator();
            while(it.hasNext() && !encontre){
                Vertex<String> v = it.next().target();
                int pos = v.getPosition();
                if(!marcas[pos]){
                    encontre = devolverCamino(v, d, l, marcas);
                }
            }
        }
        if(!encontre) {
            l.remove(l.size()-1); //marcas[origen.getPosition()] = false; Cuando haya encontrado el camino hacia destino, deja marcadas las posiciones del vector de marcas
        }
        marcas[o.getPosition()] = false; //Deja desmarcadas todas las posiciones del vector de marcas: no es necesario desmarcar en este ejemplo.
        return encontre;
    }
}
