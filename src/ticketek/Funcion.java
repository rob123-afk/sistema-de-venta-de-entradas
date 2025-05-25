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
    
    public double devolverPrecio() {
    	
    	return precioBase;
    }
    
    public double devolverPrecioPlateaBaja() {
    	return precioBase * 1.40;
    }
    
    public double devolverPrecioVIP() {
    	return precioBase * 1.70;
    }
    
    public double devolverPrecioPlateaComun() {
    	return precioBase * 1.40;
    }
}