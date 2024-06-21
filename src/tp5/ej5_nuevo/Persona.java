package tp5.ej5_nuevo;

public abstract class Persona {
    private String nombre;
    private String domicilio;

    public Persona(String n, String d){
        this.nombre = n;
        this.domicilio = d;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public abstract String getEstado();

    public boolean cumple(){
        return false;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
