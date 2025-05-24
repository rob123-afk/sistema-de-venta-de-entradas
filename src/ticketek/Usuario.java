package ticketek;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private String contraseña;
	private String email;
	private HashMap<String, IEntrada> entradasCompradas;
	
	public Usuario(String nombre, String apellido, String contraseña){
		
		this.nombre=nombre;
		
		this.apellido=apellido;
		
		this.contraseña=contraseña;
	}
	
	
	private void comprarEntrada(Espectaculo espectaculo, Sede sede, String asientos, String contraseña) {
	}
	
	public void consultarEntradaPorFechas(String fecha) {
	}
	
	public void consultarEntradasPasadas() {
		
		System.out.println(entradasCompradas.toString());
	}
	
	public boolean comprobarEmail(String email) {
		return this.email.equals(email);
	}
	
	public boolean comprobarContraseña(String contraseña) {
		return this.contraseña.equals(contraseña);
	}
	
	public List<IEntrada> devolverEntradasCompradas(){
		return new ArrayList<>(entradasCompradas.values());
	}
	
	public boolean anularEntrada(String codigo) {
		return entradasCompradas.remove(codigo) != null;
	}
	
//	public List<IEntrada> entradasCompradasPorUsuario(String email, String contraseña){
//		if (ListaDeUsuarios.containsKey(email)) {
//			Usuario usuario = ListaDeUsuarios.get(email);
//		if (usuario.comprobarContraseña(contraseña) && usuario.comprobarEmail(email)) {
//			return usuario.devolverEntradasCompradas();
//		} else {
//			System.out.println("Contraseña incorrecta.");
//			}
//		}
//		else {
//			System.out.println("Usuario no encontrado");
//		}
//		return null;
//	}
	
}
