package ticketek;

import java.util.Arrays;

public class Miniestadio extends Sede{
	private double consumicion;
	private int asientosPorFila;
	private	int cantidadPuestos;
	private String[] sectores;
	private int[] capacidad;
	private int[] porcentajeAdicional;
		 public Miniestadio(String nombre, String direccion, int capacidadMaxima, double consumicion,
             int asientosPorFila, int cantidadPuestos, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
		 super(nombre, direccion, capacidadMaxima);
		 if(asientosPorFila <= 0) {
			 throw new RuntimeException("Los asientos por fila deben ser positivos");
		 }
		 this.consumicion = consumicion;
		 this.asientosPorFila = asientosPorFila;
		 this.cantidadPuestos = cantidadPuestos;
		 this.sectores = sectores;
		 this.capacidad = capacidad;
		 this.porcentajeAdicional = porcentajeAdicional;
	 }
	








	void sumarConsumision(){};
	void sumarCantidadDePuestos(){};
	
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
		        if (nombreSector.equals(sectores[i])) {
		             capacidadBuscada = capacidad[i];
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









	public String[] tomarSectores() {
		return this.sectores;
	}
	
	public int[] tomarConsumiciones() {
		return this.porcentajeAdicional;
	}
}
