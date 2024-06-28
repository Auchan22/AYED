package Parciales.Grafos.Ejer10;

import tp5.ej1.Graph;
import tp5.ej1.ListaAdyacencia.AdjListGraph;
import tp5.ej1.Vertex;

import java.util.List;

public class ParcialTest {
    public static void main(String[] args) {
        Graph<String> bosque = new AdjListGraph<>();

        Vertex<String> CasaCaperucita = bosque.createVertex("Casa Caperucita");
        Vertex<String> Claro1 = bosque.createVertex("Claro 1");
        Vertex<String> Claro2 = bosque.createVertex("Claro 2");
        Vertex<String> Claro3 = bosque.createVertex("Claro 3");
        Vertex<String> Claro4 = bosque.createVertex("Claro 4");
        Vertex<String> Claro5 = bosque.createVertex("Claro 5");
        Vertex<String> CasaAbuelita = bosque.createVertex("Casa Abuelita");

        bosque.connect(CasaCaperucita, Claro1,3);
        bosque.connect(Claro1, CasaCaperucita,3);
        bosque.connect(CasaCaperucita, Claro2,4);
        bosque.connect(Claro2, CasaCaperucita,4);
        bosque.connect(CasaCaperucita, Claro3,4);
        bosque.connect(Claro3, CasaCaperucita,4);
        bosque.connect(Claro1, Claro2,4);
        bosque.connect(Claro2, Claro1,4);
        bosque.connect(Claro1, Claro5,3);
        bosque.connect(Claro5, Claro1,3);
        bosque.connect(Claro2, Claro5,11);
        bosque.connect(Claro5, Claro2,11);
        bosque.connect(Claro2, Claro4,10);
        bosque.connect(Claro4, Claro2,10);
        bosque.connect(Claro3, Claro5,15);
        bosque.connect(Claro5, Claro3,15);
        bosque.connect(Claro5, CasaAbuelita,4);
        bosque.connect(CasaAbuelita, Claro5,4);
        bosque.connect(Claro4, CasaAbuelita,9);
        bosque.connect(CasaAbuelita, Claro4,9);

        BuscadorDeCaminos parcial = new BuscadorDeCaminos (bosque);

        List<List<String>> lis = parcial.recorridoMasSeguro();
        for (List<String> l: lis){
            System.out.println(l);
        }
    }
}
