package ticketek;

import java.util.ArrayList;

public class Espectaculo {

	protected String nombre;
	protected ArrayList<String> funciones;
	protected String Codigo;
	
	
	public Espectaculo(String nombre) {
		this.nombre = nombre;
		
		generarCodigo();
		
	}

	private void generarCodigo() {
		
	}
	
}
