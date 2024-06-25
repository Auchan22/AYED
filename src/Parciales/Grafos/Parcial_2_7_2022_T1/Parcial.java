package Parciales.Grafos.Parcial_2_7_2022_T1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

public class Parcial {
	public List<String> caminoConPresupuesto(Graph<String> ciudades, String origen, String destino, int montoMaximo){
		List<String> camino = new LinkedList<String>();
		
		if(!ciudades.isEmpty()) {
			Vertex<String> o = ciudades.search(origen);
			Vertex<String> d = ciudades.search(destino);
			
			if(o != null && d != null) {
				this.resolver(ciudades, o, d, camino, montoMaximo, 0, new boolean[ciudades.getSize()]);
			}
		}
		
		return camino;
	}
	
	private boolean resolver(Graph<String> ciudades, Vertex<String> o, Vertex<String> d, List<String> l, int montoMax, int montoAct, boolean[] marcas) {
		boolean encontre = false;
		marcas[o.getPosition()] = true;
		l.add(o.getData());
		if(o == d && montoAct <= montoMax) {
			return true;
		}else {
			List<Edge<String>> ady = ciudades.getEdges(o);
			Iterator<Edge<String>> it = ady.iterator();
			while(it.hasNext() && !encontre) {
				Edge<String> e = it.next();
				Vertex<String> v = e.target();
				int pos = v.getPosition();
				if(!marcas[pos] && e.getWeight() + montoAct <= montoMax) {
					encontre = this.resolver(ciudades, v, d, l, montoMax, montoAct + e.getWeight(), marcas);
				}
			}
		}
		if(!encontre) {
			l.remove(l.size()-1);
		}
		marcas[o.getPosition()] = false;
		return encontre;
	}
}
