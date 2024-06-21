package tp5.ej5_nuevo;

import tp5.ej1.Graph;
import tp5.ej1.ListaAdyacencia.AdjListGraph;
import tp5.ej1.Vertex;

public class Test {
    public static void main(String[] args) throws Exception {
        Graph<Persona> grafo = new AdjListGraph<>();
        Persona e1 = new Empleado("Matias", "AAA");
        Persona e2 = new Empleado("Valentin", "BBB");
        Persona e3 = new Empleado("Rosanna", "CCC");

        Persona j1 = new Jubilado("Julian", "BBB", false);
        Persona j2 = new Jubilado("Francisco", "DDD", false);
        Persona j3 = new Jubilado("Omar", "EEE", true);
        Persona j4 = new Jubilado("Maria", "GGG", true);
        Persona j5 = new Jubilado("Sandra", "FFF", true);
        Persona j6 = new Jubilado("Matheo", "HHH", false);

        Vertex v1 = grafo.createVertex(e1);
        Vertex v2 = grafo.createVertex(j1);
        Vertex v3 = grafo.createVertex(j2);
        Vertex v4 = grafo.createVertex(e2);
        Vertex v5 = grafo.createVertex(j3);
        Vertex v6 = grafo.createVertex(e3);
        Vertex v7 = grafo.createVertex(j4);
        Vertex v8 = grafo.createVertex(j5);
        Vertex v9 = grafo.createVertex(j6);

        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);

        grafo.connect(v1, v9);
        grafo.connect(v9, v1);
        grafo.connect(v9, v8);
        grafo.connect(v8, v9);

        grafo.connect(v1, v4);
        grafo.connect(v4, v1);
        grafo.connect(v1, v6);
        grafo.connect(v6, v1);
        grafo.connect(v4, v5);
        grafo.connect(v5, v4);
        grafo.connect(v5, v7);
        grafo.connect(v7, v5);


        Banco banco = new Banco();

//        System.out.println(banco.resolver(grafo, e1, 1));
        System.out.println(banco.resolver(grafo, e1, 2));
        //System.out.println(banco.carteraJubilados(grafo, "Matias", 3, 40));

        System.out.println(banco.resolver(grafo, e3, 2));

        //System.out.println(banco.carteraJubilados(grafo, "Matias", 2, 1));
    }
}
