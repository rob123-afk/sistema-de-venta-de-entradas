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
		
		generarCodigo();
		
	}
	
	public void agregarFuncion(String fecha, Sede sede, double precioBase) {
		
		if(!funciones.containsKey(fecha)) {
			funciones.put(nombre, new Funcion(sede,fecha,precioBase));;
			} else {
				System.out.println("esta fecha no esta disponible");
			}
	}
	
	public HashMap<String, Funcion> devolverFunciones(){
		return funciones;
	}
	
	public double consultarPrecio(String fecha) {
		if(!funciones.containsKey(fecha)) 
		{System.out.println("no hay espectaculos en la fecha indicada");
		return 0;}
		else{return funciones.get(fecha).devolverPrecio();}
	}
	
	private void generarCodigo() {
		
	}
	
	public String listarFunciones() {
		if (funciones.isEmpty()) {
			return "No hay funciones cargadas para este espectáculo.";		
					}
		StringBuilder funcionesListadas = new StringBuilder();
		for (Funcion funcion : funciones.values()) {
			String fecha = funcion.getFecha();
			Sede sede = funcion.devolverSede();
			
			if (sede instanceof Estadio) {
				int vendidas = funcion.devolverEntradasVendidas().size();
				int capacidad = ((Estadio) sede).devolverCapacidadTotal();
				funcionesListadas.append(String.format("(%s) %s - %d/%d\n", fecha, sede.devolverNombre(), vendidas, capacidad));
			}else if (sede instanceof Teatro || sede instanceof Miniestadio) {
				funcionesListadas.append(String.format("(%s) %s - ", fecha, sede.devolverNombre()));
				int vip = funcion.entradasVendidasPorSector("Platea VIP");
				int comun = funcion.entradasVendidasPorSector("Platea Común");
				int baja = funcion.entradasVendidasPorSector("Platea Baja");
				int alta = funcion.entradasVendidasPorSector("Platea Alta");
				
				int capacidadVIP = sede.capacidadPorSector("Platea VIP");
				int capacidadComun = sede.capacidadPorSector("Platea Común");
				int capacidadBaja = sede.capacidadPorSector("Platea Baja");
				int capacidadAlta = sede.capacidadPorSector("Platea Alta");
				
				funcionesListadas.append(String.format("(%s) %s - Platea VIP: %d/%d | Platea Común: %d/%d | Platea Baja: %d/%d | Platea Alta: %d/%d\n"
						,fecha, sede, vip, capacidadVIP, comun,capacidadComun,baja, capacidadBaja, alta, capacidadAlta));
				
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
