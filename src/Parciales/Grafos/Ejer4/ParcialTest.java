package Parciales.Grafos.Ejer4;

import tp5.ej1.Graph;
import tp5.ej1.ListaAdyacencia.AdjListGraph;
import tp5.ej1.Vertex;

public class ParcialTest {
    public static void main(String[] args) throws Exception {
        Graph<String> personas = new AdjListGraph<>();

        /*1*/	Vertex<String> Jorge = personas.createVertex("Jorge");
        /*2*/	Vertex<String> Ariel = personas.createVertex("Ariel");
        /*3*/	Vertex<String> Juan = personas.createVertex("Juan");
        /*4*/	Vertex<String> Matias = personas.createVertex("Matias");

        //Primer CASO
		personas.connect(Jorge, Matias);
		personas.connect(Matias, Jorge);
		personas.connect(Matias, Ariel);
		personas.connect(Ariel, Matias);
		personas.connect(Juan, Matias);
		personas.connect(Matias, Juan);
		personas.connect(Ariel, Juan);
		personas.connect(Juan, Ariel);

        //Segundo CASO
//        personas.connect(Jorge, Juan);
//        personas.connect(Juan, Jorge);
//
//        personas.connect(Matias, Ariel);
//        personas.connect(Ariel, Matias);

        GradosDeSeparacion parcial = new GradosDeSeparacion();

        System.out.println("MAXIMO GRADO DE SEPARACION: " + parcial.maximoGradoDeSeparacion(personas));
    }
}
