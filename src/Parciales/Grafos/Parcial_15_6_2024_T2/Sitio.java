package Parciales.Grafos.Parcial_15_6_2024_T2;

public class Sitio {
    private String nombre;
    private int tiempo;

    public Sitio(String nombre, int tiempo) {
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempo() {
        return tiempo;
    }
}
