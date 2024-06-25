package Parciales.Grafos.Parcial_28_11_2022;

import tp5.ej1.Graph;
import tp5.ej1.Vertex;
import tp5.ej1.ListaAdyacencia.AdjListGraph;

public class ParcialTest {
    public static void main(String args[]) {
        Graph<Estadio> grafo = new AdjListGraph<Estadio>();
        Vertex<Estadio> v1 = grafo.createVertex(new Estadio("Jor", "AI BAYT STADIUM"));
        Vertex<Estadio> v2 = grafo.createVertex(new Estadio("Lusail", "LUSAIL STADIUM"));
        Vertex<Estadio> v3 = grafo.createVertex(new Estadio("Rayán", "EDUCATION CITY STADIUM"));
        Vertex<Estadio> v4 = grafo.createVertex(new Estadio("Rayán", "AL RAYYAN STADIUM"));
        Vertex<Estadio> v5 = grafo.createVertex(new Estadio("Doha", "STADIUM 947"));
        Vertex<Estadio> v6 = grafo.createVertex(new Estadio("Doha", "KHALIFA INTERNATIONAL STADIUM"));
        Vertex<Estadio> v7 = grafo.createVertex(new Estadio("Doha", "AL THUMAMA STADIUM"));
        Vertex<Estadio> v8 = grafo.createVertex(new Estadio("Wakrah", "AL JANOUB STADIUM"));
        
        grafo.connect(v1, v2, 42);
        grafo.connect(v2, v1, 42);
        grafo.connect(v2, v3, 24);
        grafo.connect(v3, v2, 24);
        grafo.connect(v2, v5, 52);
        grafo.connect(v5, v2, 52);
        grafo.connect(v3, v4, 11);
        grafo.connect(v4, v3, 11);
        grafo.connect(v4, v6, 8);
        grafo.connect(v6, v4, 8);
        grafo.connect(v6, v7, 12);
        grafo.connect(v7, v6, 12);
        grafo.connect(v7, v8, 12);
        grafo.connect(v8, v7, 12);
        grafo.connect(v8, v5, 19);
        grafo.connect(v5, v8, 19);
        
        Parcial p = new Parcial();
        
        System.out.println(p.estadios(grafo, "AI BAYT STADIUM", 100));
    }
}
