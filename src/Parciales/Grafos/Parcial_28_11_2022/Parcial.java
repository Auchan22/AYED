package Parciales.Grafos.Parcial_28_11_2022;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

public class Parcial {
	public List<String> estadios(Graph<Estadio> mapaEstadios, String estadioOrigen, int cantKm){
		List<String> camino = new LinkedList<String>();
		
		if(!mapaEstadios.isEmpty()) {
			Vertex<Estadio> o = this.buscar(mapaEstadios, estadioOrigen);
			if(o != null) {
				this.resolver(mapaEstadios, o, cantKm, camino, new LinkedList<String>(), new boolean[mapaEstadios.getSize()]);
			}
		}
		
		return camino;
	}
	
	private Vertex<Estadio> buscar(Graph<Estadio> grafo, String n){
		List<Vertex<Estadio>> vertices = grafo.getVertices();
		boolean encontre = false;
		Vertex<Estadio> res = null;
		Iterator<Vertex<Estadio>> it = vertices.iterator();
		while(it.hasNext() && !encontre) {
			Vertex<Estadio> v = it.next();
			if(v.getData().getNombreEstadio().equals(n)) {
				encontre = true;
				res = v;
			}
		}
		return res;
	}
	
	private void resolver(Graph<Estadio> grafo, Vertex<Estadio> o, int cantKm, List<String> l, List<String> c, boolean[] marcas) {
	       marcas[o.getPosition()] = true;
	        c.add(o.getData().getNombreEstadio());
	        //Hago en postorden
	        for(Edge<Estadio> a: grafo.getEdges(o)) {
	            int peso = a.getWeight();
	            Vertex<Estadio> destino = a.target();
	            if(!marcas[destino.getPosition()] && peso <= cantKm) {
	                this.resolver(grafo, destino, cantKm-peso, l, c, marcas);
	            }
	        }
	        if(c.size() > l.size()) {
	            l.clear();
	            l.addAll(c);
	        }
	        marcas[o.getPosition()] = false;
	        c.remove(c.size()-1);
	}
}
