package Parciales.Grafos.Simulacro_Parcial_2024;

import tp5.ej1.Graph;
import tp5.ej1.ListaAdyacencia.AdjListGraph;
import tp5.ej1.Vertex;

public class ParcialTest {
    public static void main(String args[]) {
        Graph<Ciudad> mapa = new AdjListGraph<>();
        Vertex<Ciudad> MarDelPlata = mapa.createVertex(new Ciudad(7, "Mar Del Plata"));
        Vertex<Ciudad> Pila = mapa.createVertex(new Ciudad(1, "Pila"));
        Vertex<Ciudad> Dolores = mapa.createVertex(new Ciudad(1, "Dolores"));
        Vertex<Ciudad> Chascomus = mapa.createVertex(new Ciudad(1, "Chascomús"));
        Vertex<Ciudad> MarAzul = mapa.createVertex(new Ciudad(3, "Mar Azul"));
        Vertex<Ciudad> Pinamar = mapa.createVertex(new Ciudad(4, "Pinamar"));
        Vertex<Ciudad> Madariaga = mapa.createVertex(new Ciudad(1, "Madariaga"));
        Vertex<Ciudad> LaPlata = mapa.createVertex(new Ciudad(5, "La Plata"));
        Vertex<Ciudad> LasGaviotas = mapa.createVertex(new Ciudad(1, "Las Gaviotas"));
        Vertex<Ciudad> Querandi = mapa.createVertex(new Ciudad(1, "Querandi"));
        Vertex<Ciudad> Hudson = mapa.createVertex(new Ciudad(1, "Hudson"));

        mapa.connect(MarDelPlata, Pila);
        mapa.connect(Pila, MarDelPlata);
        mapa.connect(Pila, Dolores);
        mapa.connect(Dolores, Pila);
        mapa.connect(Dolores, Chascomus);
        mapa.connect(Chascomus, Dolores);

        mapa.connect(MarDelPlata, MarAzul);
        mapa.connect(MarAzul, MarDelPlata);
        mapa.connect(MarAzul, Pinamar);
        mapa.connect(Pinamar, MarAzul);
        mapa.connect(Pinamar, Madariaga);
        mapa.connect(Madariaga, Pinamar);
        mapa.connect(Dolores, Madariaga);
        mapa.connect(Madariaga, Dolores);
        mapa.connect(Madariaga, LaPlata);
        mapa.connect(LaPlata, Madariaga);
        mapa.connect(Chascomus, LaPlata);
        mapa.connect(LaPlata, Chascomus);

        mapa.connect(MarAzul, LasGaviotas);
        mapa.connect(LasGaviotas, MarAzul);
        mapa.connect(MarAzul, Querandi);
        mapa.connect(Querandi, MarAzul);
        mapa.connect(LaPlata, Hudson);
        mapa.connect(Hudson, LaPlata);

        Parcial p = new Parcial();
        System.out.println(p.resolver(mapa, "Mar Del Plata", 15));
    }
}
