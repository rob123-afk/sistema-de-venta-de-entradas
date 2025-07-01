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
		if(sectores == null || sectores.length < 0 ) {
			throw new RuntimeException("Por favor ingrese los sectores");
		}
		if(capacidad == null || capacidad.length < 0) {
			throw new RuntimeException("Por favor ingrese la capacidad de los sectores");
		}
		if(porcentajeAdicional == null || porcentajeAdicional.length < 0) {
			throw new RuntimeException("Por favor ingrese los porcentajes adicionales de las consumiciones para los sectores");
		}
		this.asientosPorFila = asientosPorFila;
		this.capacidad = capacidad;
		this.sectores = sectores;
	}
	
	double calcularPrecio(double precioBase, String sector) {
    	if (sector.equals("Platea VIP")) {
    		return precioBase * (porcentajeAdicional[0]/100)+precioBase;
    	}
    	if (sector.equals("Platea Común")) {
    		return precioBase * (porcentajeAdicional[1]/100)+precioBase;
    	}
    	if (sector.equals("Platea Baja")) {
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
		int capacidadBuscada = 0;
		   for (int i = 0; i < sectores.length; i++) {
			   if (normalizarSector(nombreSector).equals(normalizarSector(sectores[i]))){
		             capacidadBuscada += capacidad[i];
		        }
		    }
		return capacidadBuscada;
		}
	
	public int devolverCapacidadTotal() {
		int total = 0;
		for(int capacida : capacidad) {
			total += capacida;
		}
		return total;
	}
	
	public String normalizarSector(String sector) {
		if (sector == null) return "";
		sector = sector.trim().toLowerCase();
		switch (sector) {
		case "vip":
		case "platea vip":
			return "VIP";
		case "comun":
		case "común":
		case "platea comun":
		case "platea común":
			return "Comun";
		case "baja":
		case "platea baja":
			return "Baja";
		case "alta":
		case "platea alta":
			return "Alta";
		default:
			return sector;
		}
	}
	
}
