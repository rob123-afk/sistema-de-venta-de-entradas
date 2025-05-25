package ticketek;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.HashMap;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private String contraseña;
	private String email;
	private HashMap<String, Entrada> entradasCompradas;//key del HashMap
	
	public Usuario(String nombre, String apellido, String contraseña){
		
		this.nombre=nombre;
		
		this.apellido=apellido;
		
		this.contraseña=contraseña;
	}
	
	
	private void comprarEntrada(String contraseña,String categoria,String codigo, String nombreEspectaculo,String fecha,String sillas){
		
		Entrada entrada=new Entrada( contraseña, categoria, codigo,  nombreEspectaculo, fecha, sillas);
		
		entradasCompradas.put(generarCodigo(), entrada);
		}
	
	
	private String generarCodigo() {
		Random random = new Random();
		String codigo="";
		
		
		while(entradasCompradas.containsKey(codigo)) {
			codigo="";
			
	        for (int i = 0; i < 5; i++) {
	            // Genera una letra mayúscula aleatoria (A=65, Z=90 en ASCII)
	            char letra = (char) (random.nextInt(26) + 'A');
	            codigo=codigo+letra;
	        }}
			return codigo;
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
		if(!entradasCompradas.containsKey(codigo)) {System.out.println("codigo no existente");
		return false;}
		else{ entradasCompradas.remove(codigo);
		return true;}
		
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
