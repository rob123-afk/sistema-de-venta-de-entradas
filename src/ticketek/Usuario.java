package ticketek;

import java.util.ArrayList;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private String contraseña;
	private ArrayList<String> entradasCompradas;
	
	public Usuario(String nombre, String apellido, String contraseña){
		
		this.nombre=nombre;
		
		this.apellido=apellido;
		
		this.contraseña=contraseña;
	}
	
	
	private void comprarEntrada(Espectaculo,sede,asientos,contraseña) {}
	
	public void consultarEntradaPorFechas(Fecha) {}
	
	private void consultarEntradasPasadas() {
		
		System.out.println(entradasCompradas.toString());
	}
}
