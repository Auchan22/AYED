package tp5.ej6;

public class Persona {
    private String tipo;
    private String nombre;
    private String domicilio;

    public Persona(String tipo, String nombre, String domicilio) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public boolean cumple(){
        return  this.tipo.equals("Jubilado");
    }
}
