package ticketek;

public class Estadio extends Sede{
	
	final int precio=0;

	public Estadio(String nombre, String direccion, int capacidad) {
		
		super(nombre, direccion, capacidad);
		
	}

	public int capacidadPorSector(String nombreSector) {
		return capacidad;
	}
	
	public int devolverCapacidadTotal() {
		return capacidad;
	}

}
