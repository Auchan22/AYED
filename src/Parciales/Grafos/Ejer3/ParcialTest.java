package Parciales.Grafos.Ejer3;

import tp5.ej1.Graph;
import tp5.ej1.ListaAdyacencia.AdjListGraph;
import tp5.ej1.Vertex;

import java.util.Iterator;
import java.util.List;

public class ParcialTest {
    public static void main(String[] args) {
        Graph<String> ciudades = new AdjListGraph<>();

        String ciudad = new String("La Plata");
        Vertex<String> LaPlata = ciudades.createVertex(ciudad);
        String ciudad2 = new String("Abasto");
        Vertex<String> Abasto = ciudades.createVertex(ciudad2);
        String ciudad3 = new String("Cañuelas");
        Vertex<String> Cañuelas = ciudades.createVertex(ciudad3);
        String ciudad4 = new String("Navarro");
        Vertex<String> Navarro = ciudades.createVertex(ciudad4);
        String ciudad5 = new String("Quilmes");
        Vertex<String> Quilmes = ciudades.createVertex(ciudad5);
        String ciudad6 = new String("Moreno");
        Vertex<String> Moreno = ciudades.createVertex(ciudad6);
        String ciudad7 = new String("Carlos Keen");
        Vertex<String> CarlosKeen = ciudades.createVertex(ciudad7);
        String ciudad8 = new String("Suipacha");
        Vertex<String> Suipacha = ciudades.createVertex(ciudad8);
        String ciudad9 = new String("Pinamar");
        Vertex<String> Pinamar = ciudades.createVertex(ciudad9);
        String ciudad10 = new String("Lobos");
        Vertex<String> Lobos = ciudades.createVertex(ciudad10);
        String ciudad11 = new String("Saladillo");
        Vertex<String> Saladillo = ciudades.createVertex(ciudad11);

        ciudades.connect(LaPlata, Quilmes, 1);
        ciudades.connect(Quilmes,LaPlata, 1);
        ciudades.connect(Pinamar,LaPlata, 1);
        ciudades.connect(LaPlata,Pinamar, 1);
        ciudades.connect(LaPlata,Abasto, 1);
        ciudades.connect(Abasto,LaPlata, 1);
        ciudades.connect(Moreno,Quilmes, 0);
        ciudades.connect(Quilmes,Moreno, 0);
        ciudades.connect(Moreno,Abasto, 0);
        ciudades.connect(Abasto,Moreno, 0);
        ciudades.connect(CarlosKeen,Abasto, 1);
        ciudades.connect(Abasto,CarlosKeen, 1);
        ciudades.connect(Abasto,Cañuelas, 1);
        ciudades.connect(Cañuelas,Abasto, 1);
        ciudades.connect(Moreno,CarlosKeen, 1);
        ciudades.connect(CarlosKeen,Moreno, 1);
        ciudades.connect(CarlosKeen,Suipacha, 1);
        ciudades.connect(Suipacha,CarlosKeen, 1);
        ciudades.connect(Cañuelas,Navarro, 1);
        ciudades.connect(Navarro,Cañuelas, 1);
        ciudades.connect(Navarro,Suipacha, 1);
        ciudades.connect(Suipacha,Navarro, 1);
        ciudades.connect(Navarro,Saladillo, 1);
        ciudades.connect(Saladillo,Navarro, 1);
        ciudades.connect(Navarro,Lobos, 0);
        ciudades.connect(Lobos,Navarro, 0);

        Parcial parcial = new Parcial();

        List<List<String>> lis = parcial.resolver(ciudades,"Moreno","Suipacha","Carlos Keen");
        Iterator<List<String>> it = lis.iterator();
        while(it.hasNext()) {
            List<String> l = it.next();
            System.out.println(l);
        }

    }
}
