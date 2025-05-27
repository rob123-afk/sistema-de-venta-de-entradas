package ticketek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Espectaculo {

	protected String nombre;
	protected HashMap<String,Funcion> funciones=new HashMap<>();//key fecha de la funcion
	protected String Codigo;
	
	
	public Espectaculo(String nombre) {
		this.nombre = nombre;
		this.funciones = new HashMap<>();
		generarCodigo();
		
	}
	
	  public Funcion obtenerFuncion(String fecha) {
	        // Validación básica del parámetro
	        if (fecha == null || fecha.trim().isEmpty()) {
	            throw new IllegalArgumentException("La fecha no puede ser nula o vacía");
	        }
	        
	        // Buscar la función
	        Funcion funcion = funciones.get(fecha);
	        
	        if (funcion == null) {
	            // Mensaje detallado con fechas disponibles para debugging
	            String fechasDisponibles = String.join(", ", funciones.keySet());
	            throw new RuntimeException(
	                "No existe función programada para " + fecha + 
	                ". Fechas disponibles: [" + fechasDisponibles + "]"
	            );
	        }
	        
	        return funcion;
	    }
	  public void agregarFuncion(String fecha, Sede sede, double precioBase) {
	        // Implementación previa corregida
	        String fechaNormalizada = normalizarFecha(fecha);
	        if (funciones.containsKey(fechaNormalizada)) {
	            throw new RuntimeException("Ya existe función para " + fechaNormalizada);
	        }
	        funciones.put(fechaNormalizada, new Funcion(sede, fechaNormalizada, precioBase));
	    }
	    
	    private String normalizarFecha(String fecha) {
	        return fecha.trim().replace("-", "/");
	    }
	    
	    // ... otros métodos existentes

	
	public HashMap<String, Funcion> devolverFunciones(){
		return funciones;
	}
	
	public double consultarPrecio(String fecha) {
		if(!funciones.containsKey(fecha)) 
		{
			throw new RuntimeException("no hay espectaculos en la fecha indicada");
			}
		else{
			return funciones.get(fecha).devolverPrecio();}
	}
	
	private void generarCodigo() {
		
	}
	
	public String listarFunciones() {
		if (funciones.isEmpty()) {
			throw new RuntimeException ("No hay funciones cargadas para este espectáculo.");		
					}
		StringBuilder funcionesListadas = new StringBuilder();
		for (Funcion funcion : funciones.values()) {
			String fecha = funcion.getFecha();
			Sede sede = funcion.devolverSede();
			
			if (sede instanceof Estadio) {
				int vendidas = funcion.devolverEntradasVendidas().size();
				int capacidad = ((Estadio) sede).devolverCapacidadTotal();
				funcionesListadas.append(String.format(" - (%s) %s - %d/%d\n", fecha, sede.devolverNombre(), vendidas, capacidad));
			}else if (sede instanceof Teatro || sede instanceof Miniestadio) {
				funcionesListadas.append(" - (").append(fecha).append(") ").append(sede.devolverNombre()).append(" - ");
				int vip = funcion.entradasVendidasPorSector("VIP");
				int comun = funcion.entradasVendidasPorSector("Comun");
				int baja = funcion.entradasVendidasPorSector("Baja");
				int alta = funcion.entradasVendidasPorSector("Alta");
				
				int capacidadVIP =  sede.capacidadPorSector("VIP");
				int capacidadComun = sede.capacidadPorSector("Comun");
				int capacidadBaja = sede.capacidadPorSector("Baja");
				int capacidadAlta = sede.capacidadPorSector("Alta");
				
				funcionesListadas.append(String.format("VIP: %d/%d | Comun: %d/%d | Baja: %d/%d | Alta: %d/%d\n"
						 ,vip, capacidadVIP, comun,capacidadComun,baja,capacidadBaja,alta,capacidadAlta));
				
			}
		}
		return funcionesListadas.toString();
	}
	
	public List<IEntrada> listarTodasLasEntradas(){
		List<IEntrada> todasLasEntradas = new ArrayList<>();
		for (Funcion funcion : funciones.values()) {
			todasLasEntradas.addAll(funcion.devolverEntradasDisponibles());
			todasLasEntradas.addAll(funcion.devolverEntradasVendidas());
		}
		return todasLasEntradas;
	}
		
}
