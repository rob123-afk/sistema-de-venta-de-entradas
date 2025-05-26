package ticketek;

public class Teatro extends Sede {
	
	private int asientosPorFila;
	private String[] sectores;
	private int[] capacidad;
	private int[] porcentajeAdicional;

	public Teatro(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,
			String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
		super(nombre, direccion, capacidadMaxima);
		if(asientosPorFila <=0) {
			throw new RuntimeException("Los asientos por fila deben ser positivos");
		}
		this.asientosPorFila = this.asientosPorFila;
		this.capacidad = capacidad;
		this.sectores = sectores;
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
	
	@Override
	
	public int capacidadPorSector(String nombreSector) {
	if(sectores == null || capacidad == null) {
		throw new RuntimeException("Capacidad y/o sectores no se inicializaron correctamente");
		}
	if(sectores.length != capacidad.length) {
		throw new RuntimeException("Los arreglos de sectores y capacidad no coinciden");
	}
	if (nombreSector == null) {
		throw new RuntimeException("El nombre del sector es invalido");
	}
	
	for (int i = 0; i<sectores.length; i++) {
		if (nombreSector.equals(sectores[i])) {
			return capacidad[i];
		}
	}
	throw new RuntimeException("El sector ingresado no existe");
	}
	
	public int devolverCapacidadTotal() {
		int total = 0;
		for(int capacida : capacidad) {
			total += capacida;
		}
		return total;
	}

}
