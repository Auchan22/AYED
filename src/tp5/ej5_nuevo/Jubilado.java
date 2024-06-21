package tp5.ej5_nuevo;

public class Jubilado extends Persona{
    private boolean cumple;
    public Jubilado(String n, String d, boolean c) {
        super(n, d);
        this.cumple = c;
    }

    @Override
    public String getEstado() {
        return "Jubilado";
    }

    @Override
    public boolean cumple(){
        return cumple;
    }
}
