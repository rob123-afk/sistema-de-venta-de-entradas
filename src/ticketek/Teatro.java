package ticketek;

public class Teatro extends Sede {

	public Teatro(String nombre, String direccion, int capacidad) {
		super(nombre, direccion, capacidad);
		
	}
	
	double calcularPrecio(double precioBase, String sector) {
    	if (sector.equals("Vip")) {
    		return precioBase * 1.70;
    	}
    	if (sector.equals("común")) {
    		return precioBase * 1.40;
    	}
    	if (sector.equals("baja")) {
    		return precioBase * 1.50;
    	}
    	
    	return precioBase;
    
    }

}
