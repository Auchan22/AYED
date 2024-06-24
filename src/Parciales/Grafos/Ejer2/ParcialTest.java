package Parciales.Grafos.Ejer2;

import tp5.ej1.Graph;
import tp5.ej1.ListaAdyacencia.AdjListGraph;
import tp5.ej1.Vertex;

import java.util.LinkedList;
import java.util.List;

public class ParcialTest {

    public static void main(String[] args) {
        Graph<Ciudad> ciudades = new AdjListGraph<>();

        Ciudad ciudad = new Ciudad("La Plata");
        Vertex<Ciudad> LaPlata = ciudades.createVertex(ciudad);
        Ciudad ciudad2 = new Ciudad("Abasto");
        Vertex<Ciudad> Abasto = ciudades.createVertex(ciudad2);
        Ciudad ciudad3 = new Ciudad("Cañuelas");
        Vertex<Ciudad> Cañuelas = ciudades.createVertex(ciudad3);
        Ciudad ciudad4 = new Ciudad("Navarro");
        Vertex<Ciudad> Navarro = ciudades.createVertex(ciudad4);
        Ciudad ciudad5 = new Ciudad("Quilmes");
        Vertex<Ciudad> Quilmes = ciudades.createVertex(ciudad5);
        Ciudad ciudad6 = new Ciudad("Moreno");
        Vertex<Ciudad> Moreno = ciudades.createVertex(ciudad6);
        Ciudad ciudad7 = new Ciudad("Carlos Keen");
        Vertex<Ciudad> CarlosKeen = ciudades.createVertex(ciudad7);
        Ciudad ciudad8 = new Ciudad("Suipacha");
        Vertex<Ciudad> Suipacha = ciudades.createVertex(ciudad8);
        Ciudad ciudad9 = new Ciudad("Pinamar");
        Vertex<Ciudad> Pinamar = ciudades.createVertex(ciudad9);
        Ciudad ciudad10 = new Ciudad("Lobos");
        Vertex<Ciudad> Lobos = ciudades.createVertex(ciudad10);
        Ciudad ciudad11 = new Ciudad("Saladillo");
        Vertex<Ciudad> Saladillo = ciudades.createVertex(ciudad11);

        ciudades.connect(LaPlata, Quilmes);
        ciudades.connect(Quilmes,LaPlata);
        ciudades.connect(Pinamar,LaPlata);
        ciudades.connect(LaPlata,Pinamar);
        ciudades.connect(LaPlata,Abasto);
        ciudades.connect(Abasto,LaPlata);
        ciudades.connect(Moreno,Quilmes);
        ciudades.connect(Quilmes,Moreno);
        ciudades.connect(Moreno,Abasto);
        ciudades.connect(Abasto,Moreno);
        ciudades.connect(Abasto,Cañuelas);
        ciudades.connect(Cañuelas,Abasto);
        ciudades.connect(Moreno,CarlosKeen);
        ciudades.connect(CarlosKeen,Moreno);
        ciudades.connect(CarlosKeen,Suipacha);
        ciudades.connect(Suipacha,CarlosKeen);
        ciudades.connect(Cañuelas,Navarro);
        ciudades.connect(Navarro,Cañuelas);
        ciudades.connect(Navarro,Suipacha);
        ciudades.connect(Suipacha,Navarro);
        ciudades.connect(Navarro,Saladillo);
        ciudades.connect(Saladillo,Navarro);
        ciudades.connect(Navarro,Lobos);
        ciudades.connect(Lobos,Navarro);

        Parcial2 parcial = new Parcial2();

        List<Ciudad> pasandoPor = new LinkedList<>();
        pasandoPor.add(Quilmes.getData());
        pasandoPor.add(CarlosKeen.getData());

        List<Ciudad> lis = parcial.resolver(ciudades, "La Plata", "Suipacha", pasandoPor);
        for(Ciudad c : lis){
            System.out.println(c.getNombre());
        }
    }
}
