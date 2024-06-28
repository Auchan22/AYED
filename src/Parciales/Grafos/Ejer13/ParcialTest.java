package Parciales.Grafos.Ejer13;

import tp5.ej1.Graph;
import tp5.ej1.ListaAdyacencia.AdjListGraph;
import tp5.ej1.Vertex;

import java.util.List;

public class ParcialTest {
    public static void main(String[] args) {
        Graph<String> ciudades = new AdjListGraph<>();

        Vertex<String> RioCuarto = ciudades.createVertex("Rio Cuarto");
        Vertex<String> VillaMaria= ciudades.createVertex("Villa Maria");
        Vertex<String> CruzDelEje= ciudades.createVertex("Cruz del Eje");
        Vertex<String> VillaGralBelgrano= ciudades.createVertex("Villa Gral Belgrano");
        Vertex<String> JesusMaria= ciudades.createVertex("Jesus Maria");
        Vertex<String> Tulumba= ciudades.createVertex("Tulumba");
        Vertex<String> VillaDolores= ciudades.createVertex("Villa Dolores");
        Vertex<String> Cordoba= ciudades.createVertex("Cordoba");

        ciudades.connect(RioCuarto, VillaMaria,70);
        ciudades.connect(VillaMaria, RioCuarto,70);

        ciudades.connect(RioCuarto, VillaGralBelgrano,50);
        ciudades.connect(VillaGralBelgrano, RioCuarto,50);

        ciudades.connect(VillaMaria, JesusMaria,60);
        ciudades.connect(JesusMaria, VillaMaria,60);

        ciudades.connect(VillaMaria, CruzDelEje,80);
        ciudades.connect(CruzDelEje, VillaMaria,80);

        ciudades.connect(VillaGralBelgrano, CruzDelEje,85);
        ciudades.connect(CruzDelEje, VillaGralBelgrano,85);

        ciudades.connect(RioCuarto, VillaDolores,90);
        ciudades.connect(VillaDolores, RioCuarto,90);

        ciudades.connect(VillaDolores, Tulumba,70);
        ciudades.connect(Tulumba, VillaDolores,70);

        ciudades.connect(VillaDolores, JesusMaria,70);
        ciudades.connect(JesusMaria, VillaDolores,70);

        ciudades.connect(Tulumba, VillaGralBelgrano,90);
        ciudades.connect(VillaGralBelgrano, Tulumba,90);

        ciudades.connect(CruzDelEje, Cordoba,60);
        ciudades.connect(Cordoba, CruzDelEje,60);

        ciudades.connect(JesusMaria, Cordoba,90);
        ciudades.connect(Cordoba, JesusMaria,90);

        ciudades.connect(Tulumba, Cordoba,75);
        ciudades.connect(Cordoba, Tulumba,75);

        Parcial parcial = new Parcial();

        List<String> lis = parcial.caminoDistanciaMaxima(ciudades, "Rio Cuarto", "Cordoba", 80);
        System.out.println(lis);


    }
}
