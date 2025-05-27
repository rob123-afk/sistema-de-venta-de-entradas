package ticketek;
import java.util.ArrayList;
import java.util.List;

public class Funcion {
    
    private Sede sede;
    private String fecha;
    private double precioBase;
    private List<IEntrada> entradasDisponibles;
    private List<IEntrada> entradasVendidas;

    public Funcion(Sede sede, String fecha, double precioBase) {
        
        this.sede = sede;
        this.fecha = fecha;
        this.precioBase = precioBase;
        this.entradasDisponibles = new ArrayList<>();
        this.entradasVendidas = new ArrayList<>();
    }

    public String getFecha() {
        return fecha;
    }
    
    public double devolverPrecio() {
    	return precioBase;
    }
    
    public double devolverPrecioPlateaBaja() {
    	return precioBase * 1.50;
    }
    
    public double devolverPrecioVIP() {
    	return precioBase * 1.70;
    }
    
    public double devolverPrecioPlateaComun() {
    	return precioBase * 1.40;
    }
    
    public String toString() {
    	return "Sede: " + sede + ", Fecha: " + fecha + ", Precio base: $" + precioBase;
    }
    
    public void agregarEntradaDisponible(IEntrada entrada) {
    	entradasDisponibles.add(entrada);
    }
    
    public void agregarEntradaVendida(IEntrada entrada) {
    	entradasVendidas.add(entrada);
    }
    
    
    public boolean venderEntrada(IEntrada entrada) {
    	if (entradasDisponibles.remove(entrada)) {
    		entradasVendidas.add(entrada);
    		return true;
    	}
    	return false;
    }
    
    public List<IEntrada> devolverEntradasVendidas(){
    	return new ArrayList<>(entradasVendidas);
    }
    public List<IEntrada> devolverEntradasDisponibles(){
    	return new ArrayList<>(entradasDisponibles);
    }
    
   public int entradasVendidasPorSector(String nombreSector) {
	   int contador = 0;
	   for (IEntrada entrada : entradasVendidas) {
		   if (entrada instanceof Entrada entradaConcreta) {
			   String sector = entradaConcreta.ubicacion();
			   System.out.println(sector + nombreSector);
			   if (sector != null && nombreSector.equalsIgnoreCase(sector)) {
				   contador++;
			   }
		   }
	   }
	   return contador;
   }

public Sede devolverSede() {
	return sede;
}
    
    
}