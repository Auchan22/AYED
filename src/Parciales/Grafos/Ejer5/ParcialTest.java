package Parciales.Grafos.Ejer5;

import tp5.ej1.Graph;
import tp5.ej1.ListaAdyacencia.AdjListGraph;
import tp5.ej1.Vertex;

import java.util.List;

public class ParcialTest {
    public static void main(String[] args){
        Graph<Sitio> ciudad = new AdjListGraph<>();
        Vertex<Sitio> municipalidad = ciudad.createVertex(new Sitio("Municipalidad", 0));
        Vertex<Sitio> sitio1 = ciudad.createVertex(new Sitio("Sitio 1", 0));
        Vertex<Sitio> sitio2 = ciudad.createVertex(new Sitio("Sitio 2", 0));
        Vertex<Sitio> casa = ciudad.createVertex(new Sitio("Casa del Intendente", 0));
        Vertex<Sitio> sitio3 = ciudad.createVertex(new Sitio("Sitio 3", 1));
        Vertex<Sitio> sitio4 = ciudad.createVertex(new Sitio("Sitio 4", 0));

        ciudad.connect(municipalidad, sitio1, 0);
        ciudad.connect(sitio1, municipalidad, 0);
        ciudad.connect(municipalidad, sitio4, 1);
        ciudad.connect(sitio4, municipalidad, 1);
        ciudad.connect(municipalidad, sitio3, 1);
        ciudad.connect(sitio3, municipalidad, 1);

        ciudad.connect(sitio1, sitio2, 0);
        ciudad.connect(sitio2, sitio1, 0);

        ciudad.connect(sitio2, casa, 0);
        ciudad.connect(casa, sitio2, 0);

        ciudad.connect(sitio3, sitio4, 0);
        ciudad.connect(sitio4, sitio3, 0);
        ciudad.connect(sitio3, casa, 1);
        ciudad.connect( casa,sitio3, 1);

        ciudad.connect(sitio4, casa, 0);
        ciudad.connect(casa, sitio4, 0);

        Parcial p = new Parcial();
        List<Sitio> lista = p.resolver(ciudad);

        System.out.println(lista);
    }
}
