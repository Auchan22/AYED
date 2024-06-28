package Parciales.Grafos.Ejer11;

import tp5.ej1.Graph;
import tp5.ej1.ListaAdyacencia.AdjListGraph;
import tp5.ej1.Vertex;

import java.util.List;

public class ParcialTest {
    public static void main(String[] args) {
        Graph<String> mapa = new AdjListGraph<>();

        Vertex<String> Stavenger = mapa.createVertex("Stavenger");
        Vertex<String> Lofoten= mapa.createVertex("Lofoten");
        Vertex<String> Tromso= mapa.createVertex("Tromso");
        Vertex<String> Trondheim= mapa.createVertex("Trondheim");
        Vertex<String> Berger= mapa.createVertex("Berger");
        Vertex<String> Drammen= mapa.createVertex("Drammen");
        Vertex<String> Oslo= mapa.createVertex("Oslo");
        Vertex<String> Mosjeem= mapa.createVertex("Mosjeem");
        Vertex<String> Nordland= mapa.createVertex("Nordland");

        mapa.connect(Berger, Stavenger,0);
        mapa.connect(Stavenger, Berger,0);
        mapa.connect(Stavenger, Trondheim,2);
        mapa.connect(Trondheim, Stavenger,2);
        mapa.connect(Stavenger, Tromso,0);
        mapa.connect(Tromso, Stavenger,0);
        mapa.connect(Trondheim, Tromso,1);
        mapa.connect(Tromso, Trondheim,1);
        mapa.connect(Stavenger, Lofoten,3);
        mapa.connect(Lofoten, Stavenger,3);
        mapa.connect(Lofoten, Mosjeem,3);
        mapa.connect(Mosjeem, Lofoten,3);
        mapa.connect(Berger, Oslo,0);
        mapa.connect(Oslo, Berger,0);
        mapa.connect(Oslo, Drammen,0);
        mapa.connect(Drammen, Oslo,0);
        mapa.connect(Drammen, Mosjeem,1);
        mapa.connect(Mosjeem, Drammen,1);
        mapa.connect(Tromso, Mosjeem,0);
        mapa.connect(Mosjeem, Tromso,0);
        mapa.connect(Lofoten, Nordland,1);
        mapa.connect(Nordland, Lofoten,1);
        mapa.connect(Mosjeem, Nordland,1);
        mapa.connect(Nordland, Mosjeem,1);
        mapa.connect(Mosjeem, Oslo,0);
        mapa.connect(Oslo, Mosjeem,0);

        CaminoSinControles parcial = new CaminoSinControles (mapa);

        List<List<String>> lis = parcial.devolverCaminos("Stavenger","Oslo");
        for (List<String> l : lis){
            System.out.println(l);
        }

    }
}
