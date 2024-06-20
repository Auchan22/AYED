package tp5.ej3_nuevo;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Mapa {
    private Graph<String> mapaCiudades;

    public Mapa(Graph<String> g){
        this.mapaCiudades = g;
    }

    /* --------- Inciso 1 --------- */
    public List<String> devolverCamino(String c1, String c2){
        List<String> camino = new LinkedList<>();

        if(!this.mapaCiudades.isEmpty()){
            Vertex<String> o = this.mapaCiudades.search(c1);
            Vertex<String> d = this.mapaCiudades.search(c2);

            if(o != null && d != null){
                this.devolverCamino(o, d, camino, new boolean[this.mapaCiudades.getSize()]);
            }
        }

        return camino;
    }

    private boolean devolverCamino(Vertex<String> o, Vertex<String> d, List<String> camino, boolean[] marcas){
        boolean encontre = false;
        marcas[o.getPosition()] = true;
        camino.add(o.getData());
        if(o == d){
            return true;
        }else{
            List<Edge<String>> ady = this.mapaCiudades.getEdges(o);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && !encontre){
                Edge<String> aux = it.next();
                int pos = aux.target().getPosition();
                if(!marcas[pos]){
                    encontre = this.devolverCamino(aux.target(), d, camino, marcas);
                }
            }
        }
        if(!encontre){
            marcas[o.getPosition()] = false;
            camino.removeLast();
        }

        return encontre;
    }

    /* --------- Inciso 2 --------- */
    public List<String> devolverCaminoExceptuando(String c1, String c2, List<String> ciudades){
        List<String> camino = new LinkedList<>();

        if(!this.mapaCiudades.isEmpty()){

            if(!ciudades.contains(c1) && !ciudades.contains(c2)){
                Vertex<String> o = this.mapaCiudades.search(c1);
                Vertex<String> d = this.mapaCiudades.search(c2);

                if(o != null && d != null){
                    this.devolverCaminoExceptuando(o, d, camino, new boolean[this.mapaCiudades.getSize()], ciudades);
                }
            }
        }

        return camino;
    }

    private boolean devolverCaminoExceptuando(Vertex<String> o, Vertex<String> d, List<String> l, boolean[] marcas, List<String> ciudades){
        boolean encontre = false;
        marcas[o.getPosition()] = true;
        l.add(o.getData());
        if(o == d){
            return true;
        }else{
            List<Edge<String>> ady = this.mapaCiudades.getEdges(o);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && !encontre){
                Vertex<String> v = it.next().target();
                int pos = v.getPosition();
                if(!marcas[pos] && !ciudades.contains(v.getData())){
                    encontre = this.devolverCaminoExceptuando(v, d, l, marcas, ciudades);
                }
            }
        }
        if(!encontre){
            marcas[o.getPosition()] = false;
            l.removeLast();
        }
        return encontre;
    }

    /* --------- Inciso 3 --------- */
    public List<String> caminoMasCorto(String c1, String c2){
        List<String> camino = new LinkedList<>();

        if(!this.mapaCiudades.isEmpty()){
                Vertex<String> o = this.mapaCiudades.search(c1);
                Vertex<String> d = this.mapaCiudades.search(c2);

                if(o != null && d != null){
                    this.caminoMasCorto(o, d, camino, new LinkedList(), new boolean[this.mapaCiudades.getSize()], 0, Integer.MAX_VALUE);
                }
        }

        return camino;
    }

    private int caminoMasCorto(Vertex<String> o ,Vertex<String> d, List<String> cMin, List<String> cAux, boolean[] marcas, int distancia, int min){
        marcas[o.getPosition()] = true;
        cAux.add(o.getData());
        if(o == d && distancia < min){
            min = distancia;
            cMin.clear();
            cMin.addAll(cAux);
        }else{
            List<Edge<String>> ady = this.mapaCiudades.getEdges(o);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && distancia < min){
                Edge<String> e = it.next();
                int pos = e.target().getPosition();
                int aux = distancia + e.getWeight();
                if(!marcas[pos] && aux < min){
                    min = caminoMasCorto(e.target(), d, cMin, cAux, marcas, aux, min);
                }
            }
        }
        marcas[o.getPosition()] = false;
        cAux.removeLast();
        return min;
    }

    /* --------- Inciso 4 --------- */
    public List<String> caminoSinCargarCombustible(String c1, String c2, int tanqueAuto){
        List<String> camino = new LinkedList<>();

        if(!this.mapaCiudades.isEmpty()){
            Vertex<String> o = this.mapaCiudades.search(c1);
            Vertex<String> d = this.mapaCiudades.search(c2);

            if(o != null && d != null){
                this.caminoSinCargarCombustible(o, d, camino, new boolean[this.mapaCiudades.getSize()],tanqueAuto);
            }
        }

        return camino;
    }

    private boolean caminoSinCargarCombustible(Vertex<String> o, Vertex<String> d, List<String> c, boolean[] marcas, int tanqueAuto){
        boolean encontre = false;
        marcas[o.getPosition()] = true;
        c.add(o.getData());
        if(o == d){
            return true;
        }else{
            List<Edge<String>> ady = this.mapaCiudades.getEdges(o);
            Iterator<Edge<String>> it = ady.iterator();
            while (it.hasNext() && !encontre){
                Edge<String> e = it.next();
                int pos = e.target().getPosition();
                if(!marcas[pos] && tanqueAuto - e.getWeight() > 0){
                    encontre = caminoSinCargarCombustible(e.target(), d, c, marcas, tanqueAuto - e.getWeight());
                }
            }
        }
        if(!encontre){
            marcas[o.getPosition()] = false;
            c.removeLast();
        }
        return encontre;
    }

    /* --------- Inciso 5 --------- */
//    public List<String> caminoConMenorCargaDeCombustible(String c1, String c2, int tanqueAuto){
//        List<String> camino = new LinkedList<>();
//
//        if(!this.mapaCiudades.isEmpty()){
//            Vertex<String> o = this.mapaCiudades.search(c1);
//            Vertex<String> d = this.mapaCiudades.search(c2);
//
//            if(o != null && d != null){
//                this.caminoConMenorCargaDeCombustible(o, d, camino, new boolean[this.mapaCiudades.getSize()],tanqueAuto);
//            }
//        }
//
//        return camino;
//    }
}
