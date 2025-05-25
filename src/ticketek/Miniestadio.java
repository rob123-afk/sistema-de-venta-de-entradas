package ticketek;

public class Miniestadio extends Sede{
	double consumicion;
	int asientosPorFila;
	String[] sectores;
	int[] capacidad;
	int[] porcentajeAdicional;
	
	public Miniestadio(String nombre, String direccion, int capacidadMaxima, double consumicion) {
		super(nombre, direccion, capacidadMaxima);
		this.consumicion = consumicion;
	}
	








	void sumarConsumision(){};
	void sumarCantidadDePuestos(){};
	
	@Override
	
	public int capacidadPorSector(String nombreSector) {
		switch (nombreSector) {
		case "Platea VIP":
			return capacidad[0];
		case "Platea Común":
			return capacidad[1];
		case "Platea Baja":
			return capacidad[2];
		case "Platea Alta":
			return capacidad[3];
		default:
			return 0;
		}
	}
	
	public int devolverCapacidadTotal() {
		int total = 0;
		for(int capacida : capacidad) {
			total += capacida;
		}
		return total;
	}
}
