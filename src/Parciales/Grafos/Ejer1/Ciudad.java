package Parciales.Grafos.Ejer1;

public class Ciudad {
    private String nombre;
    private int fase;

    public Ciudad(String nombre, int fase) {
        this.nombre = nombre;
        this.fase = fase;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFase() {
        return fase;
    }
}
