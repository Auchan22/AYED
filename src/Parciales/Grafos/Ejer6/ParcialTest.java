package Parciales.Grafos.Ejer6;

import tp5.ej1.Graph;
import tp5.ej1.ListaAdyacencia.AdjListGraph;
import tp5.ej1.Vertex;

import java.util.List;

public class ParcialTest {
    public static void main(String[] args){
        Graph<String> grafo = new AdjListGraph<>();

        Vertex<String> BuenosAires = grafo.createVertex("Buenos Aires");
        Vertex<String> Santiago = grafo.createVertex("Santiago");
        Vertex<String> Montevideo = grafo.createVertex("Montevideo");
        Vertex<String> Lima = grafo.createVertex("Lima");
        Vertex<String> Asuncion = grafo.createVertex("Asunción");
        Vertex<String> LaHabana = grafo.createVertex("La Habana");
        Vertex<String> Caracas = grafo.createVertex("Caracas");

        grafo.connect(BuenosAires, Santiago, 3);
        grafo.connect(BuenosAires, Asuncion, 10);
        grafo.connect(BuenosAires, Montevideo, 4);
        grafo.connect(BuenosAires, Lima, 2);

        grafo.connect(Santiago, Asuncion, 500);
        grafo.connect(Santiago, LaHabana, 4);

        grafo.connect(Montevideo, Asuncion, 6);

        grafo.connect(Lima, Asuncion, 4);

        grafo.connect(Caracas, Asuncion, 11);
        grafo.connect(Caracas, LaHabana, 10);

        Parcial p = new Parcial();
        List<List<String>> listas = p.resolver(grafo);

        for (List<String> l : listas){
            System.out.println(l);
        }
    }
}
