package Parciales.Grafos.Parcial_16_7_2022;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

public class Parcial {
	public List<String> resolver(Graph<String> grafo, int cantLocalidades, int cantNafta, List<String> localidadesExceptuadas){
		List<String> camino = new LinkedList<String>();
		
		if(!grafo.isEmpty()) {
			Vertex<String> o = grafo.search("Mendoza");
			
			if(o != null) {
				if(!localidadesExceptuadas.contains("Mendoza")) {
					boolean[] marcas = new boolean[grafo.getSize()];
					this.marcar(grafo, marcas, localidadesExceptuadas);
					this.resolver(grafo, o, camino, cantLocalidades-1, cantNafta, marcas);
				}
			}
		}
		
		return camino;
	}
	
	private void marcar(Graph<String> grafo, boolean[] marcas, List<String> localidades) {
        for(String l: localidades) {
            Vertex<String> v = grafo.search(l);
            if(v != null) {
                marcas[v.getPosition()] = true;
            }
        }
    }
	
	private boolean resolver(Graph<String> grafo, Vertex<String> o, List<String> l, int cantLocalidades, int cantNafta, boolean[] marcas) {
		boolean encontre = false;
		marcas[o.getPosition()] = true;
		l.add(o.getData());
		if(cantLocalidades <= 0) {
			return true;
		}else {
			List<Edge<String>> ady = grafo.getEdges(o);
			Iterator<Edge<String>> it = ady.iterator();
			while(it.hasNext() && !encontre) {
				Edge<String> e = it.next();
				Vertex<String> v = e.target();
				int pos = v.getPosition();
				if(!marcas[pos] && e.getWeight() <= cantNafta) {
					encontre = this.resolver(grafo, v, l, cantLocalidades -1, cantNafta-e.getWeight(), marcas);
				}
			}
		}
		marcas[o.getPosition()] = false;
		if(!encontre) {
			l.remove(l.size()-1);
		}
		return encontre;
	}
}
