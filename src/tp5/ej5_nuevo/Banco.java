package tp5.ej5_nuevo;

import tp1.ej8.Queue;
import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Banco {

    private static final int MAX = 40;
    public List<Persona> resolver(Graph<Persona> grafo, Persona e, int grado) throws Exception {
        List<Persona> lista = new LinkedList<>();

        if(!grafo.isEmpty()){
            Vertex<Persona> v = grafo.search(e);

            if(v != null){
                this.resolver(grafo, v, grado, lista, new boolean[grafo.getSize()]);
            }
        }

        return lista;
    }

    private void resolver(Graph<Persona> grafo, Vertex<Persona> v, int grado, List<Persona> l, boolean[] marcas) throws Exception {
        Queue<Vertex<Persona>> cola = new Queue<>();
        Vertex<Persona> aux = null;
        marcas[v.getPosition()] = true;
        cola.enqueue(v);
        cola.enqueue(null);
        while(!cola.isEmpty()){
            aux = cola.dequeue();
            if(aux != null){
                List<Edge<Persona>> ady = grafo.getEdges(aux);
                Iterator<Edge<Persona>> it = ady.iterator();
                while(it.hasNext() && l.size() < MAX){
                    Edge<Persona> ed = it.next();
                    int pos = ed.target().getPosition();
                    if(!marcas[pos]){
                        marcas[pos] = true;
                        cola.enqueue(ed.target());
                        if((ed.target().getData().getEstado().equals("Jubilado")) && (ed.target().getData().cumple())){
                            l.add(ed.target().getData());
                        }
                    }
                }
            }else if(!cola.isEmpty()){
                cola.enqueue(null);
                grado--;
            }
        }
    }
}
