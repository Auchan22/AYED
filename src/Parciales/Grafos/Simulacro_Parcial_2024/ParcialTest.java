package Parciales.Grafos.Simulacro_Parcial_2024;

import tp5.ej1.Graph;
import tp5.ej1.ListaAdyacencia.AdjListGraph;
import tp5.ej1.Vertex;

import java.util.List;

public class ParcialTest {
    public static void main(String[] args){
        Ciudad c1 = new Ciudad("Mar del Plata", 7);
        Ciudad c2 = new Ciudad("Pila", 1);
        Ciudad c3 = new Ciudad("Dolores", 7);
        Ciudad c4 = new Ciudad("Chascomus", 1);
        Ciudad c5 = new Ciudad("Mar Azul", 3);
        Ciudad c6 = new Ciudad("Pinamar", 4);
        Ciudad c7 = new Ciudad("Madariaga", 1);
        Ciudad c8 = new Ciudad("La Plata", 5);
        Ciudad c9 = new Ciudad("Las Gaviotas", 1);
        Ciudad c10 = new Ciudad("Querandi", 1);
        Ciudad c11 = new Ciudad("Hudson", 1);

        Graph<Ciudad> mapa = new AdjListGraph<>();
        Vertex<Ciudad> v1 = mapa.createVertex(c1);
        Vertex<Ciudad> v2 = mapa.createVertex(c2);
        Vertex<Ciudad> v3 = mapa.createVertex(c3);
        Vertex<Ciudad> v4 = mapa.createVertex(c4);
        Vertex<Ciudad> v5 = mapa.createVertex(c5);
        Vertex<Ciudad> v6 = mapa.createVertex(c6);
        Vertex<Ciudad> v7 = mapa.createVertex(c7);
        Vertex<Ciudad> v8 = mapa.createVertex(c8);
        Vertex<Ciudad> v9 = mapa.createVertex(c9);
        Vertex<Ciudad> v10 = mapa.createVertex(c10);
        Vertex<Ciudad> v11 = mapa.createVertex(c11);

        mapa.connect(v1, v2);
        mapa.connect(v1, v5);
        mapa.connect(v2,v3);
        mapa.connect(v3,v4);
        mapa.connect(v3,v7);
        mapa.connect(v4, v8);
        mapa.connect(v5,v6);
        mapa.connect(v5,v9);
        mapa.connect(v5,v10);
        mapa.connect(v6,v7);
        mapa.connect(v7,v8);
        mapa.connect(v8,v11);

        Parcial p = new Parcial();
        List<String> res = p.resolver(mapa, "Mar del Plata", 15);
        for(String c: res){
            System.out.println(c);
        }
    }
}
