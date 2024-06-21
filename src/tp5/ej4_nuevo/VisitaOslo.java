package tp5.ej4_nuevo;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.security.interfaces.EdECKey;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class VisitaOslo {
    public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
        List<String> camino = new LinkedList<>();

        if(!lugaresRestringidos.contains("Ayuntamieno") && !lugaresRestringidos.contains(destino)){
            if(!lugares.isEmpty()){
                Vertex<String> o = lugares.search("Ayuntamiento");
                Vertex<String> d = lugares.search(destino);

                if(o != null && d != null){
                    this.paseoEnBici(lugares, o, d, maxTiempo, lugaresRestringidos, camino, new boolean[lugares.getSize()]);
                }
            }
        }

        return camino;
    }

    private boolean paseoEnBici(Graph<String> lugares, Vertex<String> o, Vertex<String> d, int maxTiempo, List<String> lugaresRestringidos, List<String> l, boolean[] marcas){
        boolean encontre = false;
        l.add(o.getData());
        marcas[o.getPosition()] = true;
        if(o == d && maxTiempo >= 0){
            return true;
        }else{
            List<Edge<String>> ady = lugares.getEdges(o);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && !encontre){
                Edge<String> e = it.next();
                int pos = e.target().getPosition();
                if(!marcas[pos] && maxTiempo - e.getWeight() >= 0 && !lugaresRestringidos.contains(o.getData())){
                    encontre = paseoEnBici(lugares, e.target(), d, maxTiempo-e.getWeight(), lugaresRestringidos, l, marcas);
                }
            }
        }
        if(!encontre){
            marcas[o.getPosition()] = false;
            l.removeLast();
        }
        return encontre;
    }
}
