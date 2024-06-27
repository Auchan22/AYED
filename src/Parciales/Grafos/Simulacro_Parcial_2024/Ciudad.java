package Parciales.Grafos.Simulacro_Parcial_2024;

public class Ciudad {
    private String nombre;
    private int cantDias;

    public Ciudad(int cantDias, String nombre) {
        this.nombre = nombre;
        this.cantDias = cantDias;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantDias() {
        return cantDias;
    }
}
