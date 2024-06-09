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
    /*----------------------- Inciso 2 -----------------------*/
    public List<String> devolverCaminoExceptuando(String c1, String c2, List<String> ciudades){
        List<String> camino = new LinkedList<String>();

        if(!this.mapaCiudades.isEmpty()){
            Vertex<String> origen = this.mapaCiudades.search(c1);
            Vertex<String> destino = this.mapaCiudades.search(c2);
            if(origen != null && destino != null){
                boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
                this.marcarRestringidos(ciudades, marcas);
                this.devolverCamino(origen, destino, camino, marcas);
            }
        }

        return camino;
    }

    private void marcarRestringidos(List<String> c, boolean[] m){
        for (String n: c){
            Vertex<String> v = this.mapaCiudades.search(n);
            if(v!=null){
                //Ya lo marco, por lo que si en el recorrido lo encuentra visitado, no pasara por ahi
                m[v.getPosition()]=true;
            }
        }
    }
    /*----------------------- Inciso 3 -----------------------*/
    public List<String> caminoMasCorto(String c1, String c2){
        List<String> min = new LinkedList<>();

        if(!this.mapaCiudades.isEmpty()){
            Vertex<String> origen = this.mapaCiudades.search(c1);
            Vertex<String> destino = this.mapaCiudades.search(c2);
            if(origen != null && destino != null){
                boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
                this.caminoMasCorto(origen, destino, min, new LinkedList<String>(), marcas, 0, Integer.MAX_VALUE);
            }
        }

        return min;
    }

    private int caminoMasCorto(Vertex<String> o, Vertex<String> d, List<String> caminoMin, List<String> caminoAct, boolean[] marcas, int total, int min){
        marcas[o.getPosition()] = true;
        caminoAct.add(o.getData());
        if(o == d && total < min){
            caminoMin.removeAll(caminoMin);
            caminoMin.addAll(caminoAct);
            min = total;
        }else{
            List<Edge<String>> adyacencias = this.mapaCiudades.getEdges(o);
            Iterator<Edge<String>> it = adyacencias.iterator();
            while(it.hasNext() && total < min){
                Edge<String> v = it.next();
                int pos = v.target().getPosition();
                int aux = total + v.getWeight();
                if(!marcas[pos] && aux < min){
                    min = caminoMasCorto(v.target(), d, caminoMin, caminoAct, marcas, aux, min);
                }
            }
        }
        marcas[o.getPosition()] = false;
        caminoAct.remove(caminoAct.size()-1);
        return min;
    }
    /*----------------------- Inciso 4 -----------------------*/
    public List<String> caminoSinCargarCombustible(String c1, String c2, int tanqueAuto){
        List<String> camino = new LinkedList<String>();

        if(!this.mapaCiudades.isEmpty()){
            Vertex<String> origen = this.mapaCiudades.search(c1);
            Vertex<String> destino = this.mapaCiudades.search(c2);
            if(origen != null && destino != null){
                boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
                this.caminoSinCargarCombustible(origen, destino, camino, marcas, tanqueAuto);
            }
        }

        return camino;
    }

    private boolean caminoSinCargarCombustible(Vertex<String> o, Vertex<String> d, List<String> camino, boolean[] marcas, int tanque){
        boolean encontre = false;
        marcas[o.getPosition()] = true;
        camino.add(o.getData());
        if(o == d){
            //Llegamos al final
            return true;
        }else{
            List<Edge<String>> adyacencias = this.mapaCiudades.getEdges(o);
            Iterator<Edge<String>> it = adyacencias.iterator();
            while (it.hasNext() && !encontre){
                Edge<String> e = it.next();
                int pos = e.target().getPosition();
                if(!marcas[pos] && tanque-e.getWeight() > 0){
                    encontre = caminoSinCargarCombustible(e.target(), d, camino, marcas, tanque-e.getWeight());
                }
            }
        }
        marcas[o.getPosition()] = false;
        camino.remove(o.getData());
        return encontre;
    }
    /*----------------------- Inciso 5 -----------------------*/
}
