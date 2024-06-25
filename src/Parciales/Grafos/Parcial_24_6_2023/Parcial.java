package Parciales.Grafos.Parcial_24_6_2023;

import java.util.LinkedList;
import java.util.List;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

public class Parcial {
	public List<ListaCaminos> resolver(Graph<String> sitios, String origen, String destino, List<String> evitarPasarPor){
		List<ListaCaminos> lista = new LinkedList<ListaCaminos>();
		
		if(!sitios.isEmpty()) {
			Vertex<String> o = sitios.search(origen);
			Vertex<String> d = sitios.search(destino);
			if(o != null && d != null) {
				if(!evitarPasarPor.contains(origen) && !evitarPasarPor.contains(destino)) {
					boolean[] marcas = new boolean[sitios.getSize()];
					this.marcar(sitios, evitarPasarPor, marcas);
					this.resolver(sitios, o, d, lista, new LinkedList<String>(), marcas, 0);
				}
			}
		}
		
		return lista;
	}
	
	private void marcar(Graph<String> sitios, List<String> evitar, boolean[] marcas) {
		for(String nom: evitar) {
            Vertex<String> v = sitios.search(nom);
            if(v!= null) {
                marcas[v.getPosition()] = true;
            }
        }
	}
	
	private void resolver(Graph<String> grafo, Vertex<String> o, Vertex<String> d, List<ListaCaminos> listas, List<String> camino, boolean[] marcas, int cuadras) {
		marcas[o.getPosition()] = true;
		camino.add(o.getData());
		if(o == d) {
			listas.add(new ListaCaminos(new LinkedList<String>(camino), cuadras));
			//Por que lo reseteo?
			//Porque puede haber mas de un listado
			marcas[o.getPosition()] = false;
		}else {
			for(Edge<String> e: grafo.getEdges(o)) {
				Vertex<String> v = e.target();
				int pos = v.getPosition();
				if(!marcas[pos]) {
					this.resolver(grafo, v, d, listas, camino, marcas, cuadras + e.getWeight());
				}
			}
		}
		//Permite el backtracking
		camino.remove(camino.size()-1);
	}
}
