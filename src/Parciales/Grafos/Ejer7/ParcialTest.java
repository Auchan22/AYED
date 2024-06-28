package Parciales.Grafos.Ejer7;

import tp5.ej1.Graph;
import tp5.ej1.ListaAdyacencia.AdjListGraph;
import tp5.ej1.Vertex;

public class ParcialTest {
    public static void main(String[] args) throws Exception {
        Graph<String> grafo = new AdjListGraph<>();

        /*1*/	Vertex<String> PC1 = grafo.createVertex("PC 1");
        /*2*/	Vertex<String> PC2 = grafo.createVertex("PC 2");
        /*3*/	Vertex<String> PC3 = grafo.createVertex("PC 3");
        /*4*/	Vertex<String> PC4 = grafo.createVertex("PC 4");
        /*5*/	Vertex<String> PC5 = grafo.createVertex("PC 5");
        /*6*/	Vertex<String> PC6 = grafo.createVertex("PC 6");

        grafo.connect(PC1, PC2);
        grafo.connect(PC2, PC1);
        grafo.connect(PC1, PC4);
        grafo.connect(PC4, PC1);
        grafo.connect(PC2, PC5);
        grafo.connect(PC5, PC2);
        grafo.connect(PC2, PC3);
        grafo.connect(PC3, PC2);
        grafo.connect(PC4, PC3);
        grafo.connect(PC3, PC4);


        Parcial parcial = new Parcial();

        System.out.println("TIEMPO EN INFECTAR: " + parcial.resolver(grafo, PC1));


    }
}
