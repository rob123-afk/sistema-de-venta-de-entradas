package ticketek;

public class Funcion {
    
    private Sede sede;
    private String fecha;
    private double precioBase;

    public Funcion(Sede sede, String fecha, double precioBase) {
        
        this.sede = sede;
        this.fecha = fecha;
        this.precioBase = precioBase;
    }

    public String getFecha() {
        return fecha;
    }
}