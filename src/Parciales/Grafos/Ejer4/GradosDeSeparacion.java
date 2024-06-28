package Parciales.Grafos.Ejer4;

import tp1.ej8.Queue;
import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.List;

public class GradosDeSeparacion {
    //SUPOCICISONES:
    //→ Tengo que analizar el número de aristas? Si, es un inicio de analisis, quiero conocer cuanta aristas hay
    // desde un vertice origen hasta un vertice destino
    //→ DFS o BFS? Conviene BFS, hacerlo por niveles e ir aumentando el grado a medida que se pasa un nivel
    //→ Hay que recorrer todos los vertices, ya que nos interesa conocer todos los grados de todos los vertices origen
    public int maximoGradoDeSeparacion(Graph<String> grafo) throws Exception {
        int max = -1;

        if(!grafo.isEmpty()){
            for(Vertex<String> v: grafo.getVertices()){
                boolean[] marcas = new boolean[grafo.getSize()];
                if(!marcas[v.getPosition()]){
                    max = Math.max(max, this.resolver(grafo, v, marcas));
                    if(max == 0){
                        return 0;
                    }
                }
            }
        }

        return max;
    }

    private int resolver(Graph<String> grafo, Vertex<String> o, boolean[] marcas) throws Exception {
        int grado = 0;
        int visitas = 1;

        Vertex<String> aux = null;
        Queue<Vertex<String>> cola = new Queue<>();
        cola.enqueue(o);
        cola.enqueue(null);
        marcas[o.getPosition()] = true;
        while(!cola.isEmpty()){
            aux = cola.dequeue();
            if(aux != null){
                List<Edge<String>> ady = grafo.getEdges(aux);
                Iterator<Edge<String>> it = ady.iterator();
                while (it.hasNext()){
                    Edge<String> e = it.next();
                    Vertex<String> v = e.target();
                    int pos = v.getPosition();
                    if(!marcas[pos]){
                        visitas++;
                        marcas[pos] = true;
                        cola.enqueue(v);
                    }
                }
            }else if (!cola.isEmpty()){
                grado++;
                cola.enqueue(null);
            }
        }

        //Se evalua esta condicion para ver si todos los vertices estan visitados
        if(visitas < grafo.getSize()){
            return 0;
        }else return grado;
    }
}
