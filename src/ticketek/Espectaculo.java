package ticketek;

import java.util.HashMap;

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
	
}
