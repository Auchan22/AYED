package Parciales.Grafos.Ejer12;

import tp5.ej1.Graph;
import tp5.ej1.ListaAdyacencia.AdjListGraph;
import tp5.ej1.Vertex;

public class ParcialTest {
    public static void main(String[] args) {
        Graph<Ciudad> ciudades = new AdjListGraph<>();

        /*1*/Ciudad ciudad = new Ciudad("La Plata",1);
        Vertex<Ciudad> LaPlata = ciudades.createVertex(ciudad);
        /*2*/Ciudad ciudad2 = new Ciudad("Abasto",3);
        Vertex<Ciudad> Abasto = ciudades.createVertex(ciudad2);
        /*3*/Ciudad ciudad3 = new Ciudad("Cañuelas",2);
        Vertex<Ciudad> Cañuelas = ciudades.createVertex(ciudad3);
        /*4*/Ciudad ciudad4 = new Ciudad("Navarro",1);
        Vertex<Ciudad> Navarro = ciudades.createVertex(ciudad4);
        /*5*/Ciudad ciudad5 = new Ciudad("Quilmes",3);
        Vertex<Ciudad> Quilmes = ciudades.createVertex(ciudad5);
        /*6*/Ciudad ciudad6 = new Ciudad("Moreno",2);
        Vertex<Ciudad> Moreno = ciudades.createVertex(ciudad6);
        /*7*/Ciudad ciudad7 = new Ciudad("Carlos Keen",2);
        Vertex<Ciudad> CarlosKeen = ciudades.createVertex(ciudad7);
        /*8*/Ciudad ciudad8 = new Ciudad("Suipacha",3);
        Vertex<Ciudad> Suipacha = ciudades.createVertex(ciudad8);
        /*9*/Ciudad ciudad9 = new Ciudad("Pinamar",0);
        Vertex<Ciudad> Pinamar = ciudades.createVertex(ciudad9);
        /*10*/Ciudad ciudad10 = new Ciudad("Lobos",1);
        Vertex<Ciudad> Lobos = ciudades.createVertex(ciudad10);
        /*11*/Ciudad ciudad11 = new Ciudad("Saladillo",2);
        Vertex<Ciudad> Saladillo = ciudades.createVertex(ciudad11);

        ciudades.connect(LaPlata, Quilmes,2);
        ciudades.connect(Quilmes,LaPlata,2);
        ciudades.connect(Pinamar,LaPlata,2);
        ciudades.connect(LaPlata,Pinamar,2);
        ciudades.connect(LaPlata,Abasto,2);
        ciudades.connect(Abasto,LaPlata,2);
        ciudades.connect(Moreno,Quilmes,2);
        ciudades.connect(Quilmes,Moreno,2);
        ciudades.connect(Moreno,Abasto,3);
        ciudades.connect(Abasto,Moreno,3);
        ciudades.connect(Abasto,Cañuelas,2);
        ciudades.connect(Cañuelas,Abasto,2);
        ciudades.connect(Moreno,CarlosKeen,2);
        ciudades.connect(CarlosKeen,Moreno,2);
        ciudades.connect(CarlosKeen,Suipacha,2);
        ciudades.connect(Suipacha,CarlosKeen,2);
        ciudades.connect(Cañuelas,Navarro,2);
        ciudades.connect(Navarro,Cañuelas,2);
        ciudades.connect(Navarro,Suipacha,2);
        ciudades.connect(Suipacha,Navarro,2);
        ciudades.connect(Navarro,Saladillo,2);
        ciudades.connect(Saladillo,Navarro,2);
        ciudades.connect(Navarro,Lobos,4);
        ciudades.connect(Lobos,Navarro,4);


        Parcial parcial = new Parcial();

        System.out.println(parcial.resolver(ciudades,"Cañuelas", "Navarro",2));

    }
}
