package Parciales.Grafos.Ejer12;

public class Ciudad {
    private String nombre;
    private int limite;

    public Ciudad(String nombre, int limite) {
        this.nombre = nombre;
        this.limite = limite;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLimite() {
        return limite;
    }
}
