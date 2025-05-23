package ticketek;

public class Teatro extends Sede {
	
	int asientosPorFila;
	String[] sectores;
	int[] capacidad;
	int[] porcentajeAdicional;

	public Teatro(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,
			String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
		super(nombre, direccion, capacidadMaxima);
		
	}
	
	double calcularPrecio(double precioBase, String sector) {
    	if (sector.equals("Vip")) {
    		return precioBase * (porcentajeAdicional[0]/100)+precioBase;
    	}
    	if (sector.equals("común")) {
    		return precioBase * (porcentajeAdicional[1]/100)+precioBase;
    	}
    	if (sector.equals("baja")) {
    		return precioBase * (porcentajeAdicional[2]/100)+precioBase;
    	}
    	
    	return precioBase;    
    }
	
	

}
