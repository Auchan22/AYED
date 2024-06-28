package Parciales.Grafos.Ejer5;

public class Sitio {
    private String nombre;
    private int controlada;

    public Sitio(String nombre, int controlada) {
        this.nombre = nombre;
        this.controlada = controlada;
    }

    public String getNombre() {
        return nombre;
    }

    public int getControlada() {
        return controlada;
    }

    public boolean estaControlada(){
        return this.controlada == 1;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
