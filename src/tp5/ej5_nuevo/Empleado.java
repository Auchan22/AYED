package tp5.ej5_nuevo;

public class Empleado extends Persona{
    public Empleado(String n, String d) {
        super(n, d);
    }

    @Override
    public String getEstado() {
        return "Empleado";
    }
}
