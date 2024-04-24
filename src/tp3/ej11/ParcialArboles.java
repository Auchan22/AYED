package tp3.ej11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;
import tp3.ejercicio1.GeneralTree;

public class ParcialArboles {
	public static boolean resolver(GeneralTree<Integer> arbol) throws Exception {
		if(arbol.isEmpty()) return false;
		List<List<GeneralTree<Integer>>> nodosPorNivel = new ArrayList<>();
	    if (recopilarNodosPorNivel(arbol, 1, nodosPorNivel)) {
	        for (int nivel = 0; nivel < nodosPorNivel.size(); nivel++) {
	            List<Integer> nodosNivel = nodosPorNivel.get(nivel);
	            System.out.println("Nivel " + (nivel + 1) + ": " + nodosNivel.size() + " nodos");
	            System.out.println("Nodos: " + nodosNivel);
	        }
	    }
		return true;
	}
	
	private boolean recopilarNodosPorNivel(GeneralTree<Integer> nodo, int nivel, List<List<GeneralTree<Integer>>> nodosPorNivel) {
	    if (nodo == null) {
	        return true;
	    }
	    if (nivel > nodosPorNivel.size()) {
	        nodosPorNivel.add(new ArrayList<>());
	    }
	    if (nivel > 1 && nodosPorNivel.get(nivel - 2).size() + 1 != nodosPorNivel.get(nivel - 1).size()) {
	        return false; // La cantidad de nodos en el nivel actual no es creciente
	    }
	    nodosPorNivel.get(nivel - 1).add(nodo.getData());
	    List<GeneralTree<Integer>> hijos = nodo.getChildren();
	    for (GeneralTree<Integer> hijo : hijos) {
	        if (!recopilarNodosPorNivel(hijo, nivel + 1, nodosPorNivel)) {
	            return false; // Si uno de los niveles inferiores no es creciente, no lo es el actual
	        }
	    }
	    return true;
	}
	
	private static boolean resolverRecursivo(GeneralTree<Integer> nodo, int nivel) {
	    if (nodo == null) return true; // Si el nodo es nulo, el árbol sigue siendo creciente

	    List<GeneralTree<Integer>> hijos = nodo.getChildren();
	    int cantidadHijos = hijos.size();

	    // Verifica si la cantidad de hijos es igual a la cantidad de nodos del nivel anterior + 1
	    if (cantidadHijos != nivel) {
	        return false;
	    }

	    // Verifica recursivamente los hijos del nodo actual
	    for (GeneralTree<Integer> hijo : hijos) {
	        if (!resolverRecursivo(hijo, nivel + 1)) {
	            return false; // Si uno de los hijos no cumple la condición, el árbol no es creciente
	        }
	    }

	    return true; // Si todos los hijos cumplen la condición, el árbol es creciente
	}

	
	public static void main(String[] args) throws Exception {
		List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
		children3.add(new GeneralTree<Integer>(33));
		children3.add(new GeneralTree<Integer>(12));
		children3.add(new GeneralTree<Integer>(17));
		children3.add(new GeneralTree<Integer>(9));
		
		List<GeneralTree<Integer>> children4 = new LinkedList<GeneralTree<Integer>>();
		children4.add(new GeneralTree<Integer>(7));
		children4.add(new GeneralTree<Integer>(11));
		children4.add(new GeneralTree<Integer>(3, children3));
		
		GeneralTree<Integer> a83 = new GeneralTree<Integer>(83);
		GeneralTree<Integer> a18 = new GeneralTree<Integer>(18);
		a18.addChild(a83);
		GeneralTree<Integer> a5 = new GeneralTree<Integer>(5);
		a5.addChild(a18);
		
		List<GeneralTree<Integer>> children1 = new LinkedList<GeneralTree<Integer>>();
		children1.add(a5);
		children1.add(new GeneralTree<Integer>(4, children4));
		
		GeneralTree<Integer> a25 = new GeneralTree<Integer>(25);
		a25.addChild(new GeneralTree<Integer>(13));
		
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(2);
		
		a2.addChild(new GeneralTree<Integer>(1, children1));
		a2.addChild(a25);
		
		System.out.println(ParcialArboles.resolver(a2));
	}
}
