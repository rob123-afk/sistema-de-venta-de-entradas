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
		 if(sectores == null || sectores.length < 0 ) {
				throw new RuntimeException("Por favor ingrese los sectores");
			}
		 if(capacidad == null || capacidad.length < 0) {
				throw new RuntimeException("Por favor ingrese la capacidad de los sectores");
			}
		 if(porcentajeAdicional == null || porcentajeAdicional.length < 0) {
				throw new RuntimeException("Por favor ingrese los porcentajes adicionales de las consumiciones para los sectores");
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

	public String[] tomarSectores() {
		return this.sectores;
	}
	
	public int[] tomarConsumiciones() {
		return this.porcentajeAdicional;
	}
}
