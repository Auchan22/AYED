package tp5.ej6;

import tp1.ej8.Queue;
import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Banco {
    public List<Persona> percibirSueldos(Graph<Persona> personas, Persona empleado, int maxDistancia, int maxLista) throws Exception {
        List<Persona> p = new LinkedList<>();
        if(!personas.isEmpty()){
            Vertex<Persona> o = personas.search(empleado);
            if(o != null){
                p = this.resolver(personas, o, maxDistancia, maxLista);
            }
        }
        return p;
    }

    // Hago un bfs, porque me interesa buscar alrededor de la persona
    private List<Persona> resolver(Graph<Persona> personas, Vertex<Persona> o, int maxDistancia, int maxLista) throws Exception {
        List<Persona> jubilados = new LinkedList<>();
        Queue<Vertex<Persona>> cola = new Queue<>();
        Vertex<Persona> v;
        boolean[] marcas = new boolean[personas.getSize()];
        cola.enqueue(o);
        cola.enqueue(null);
        while(!cola.isEmpty() && maxDistancia > 0 && jubilados.size() < maxLista){
            v = cola.dequeue();
            if (v != null){
                List<Edge<Persona>> adyacencias = personas.getEdges(o);
                Iterator<Edge<Persona>> it = adyacencias.iterator();
                while(it.hasNext() && jubilados.size() < maxLista){
                    Edge<Persona> d = it.next();
                    int pos = d.target().getPosition();
                    if(!marcas[pos]){
                        marcas[pos] = true;
                        cola.enqueue(d.target());
                        if(d.target().getData().cumple()){
                            jubilados.add(d.target().getData());
                        }
                    }
                }
            }
        }
        return jubilados;
    }
}
