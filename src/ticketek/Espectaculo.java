package ticketek;

import java.util.ArrayList;

public class Espectaculo {

	protected String nombre;
	protected ArrayList<String> funciones;
	protected Sede sede;
	
	
	public Espectaculo(String nombre, ArrayList<String> funciones, Sede sede) {
		this.nombre = nombre;
		this.funciones = funciones;
		this.sede = sede;
	}
	
}
