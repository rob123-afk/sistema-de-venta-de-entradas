package ticketek;

public class Miniestadio extends Sede{
	double consumicion;
	
	public Miniestadio(String nombre, String direccion, int capacidad,double consumicion) {
		super(nombre,direccion,capacidad);
		this.consumicion=consumicion;
	}
	

	

	
	
	void sumarConsumision(){};
	void sumarCantidadDePuestos(){};
	
}
