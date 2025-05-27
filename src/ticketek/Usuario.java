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
	
	public Usuario(String email,String nombre, String apellido, String contraseña){
		
		this.nombre=nombre;
		
		this.apellido=apellido;
		
		this.contraseña=contraseña;
		
		this.email = email;
		
		this.entradasCompradas = new HashMap<>();
	}
	//comprar entrada sin sector
		public IEntrada comprarEntrada(String contraseña, String nombreEspectaculo,String fecha, double precio, String nombreSede){
			
			if(!this.contraseña.equals(contraseña)) {
				throw new RuntimeException("Contraseña incorrecta");
				}
			String codigo = generarCodigo();
			Entrada entrada = new Entrada(contraseña,codigo, nombreEspectaculo, fecha, precio,nombreSede);
			
			entradasCompradas.put(codigo, entrada);
			
			return entrada;
			}
		
	//comprar entrada con sector
	public IEntrada comprarEntrada(String contraseña,String categoria, String nombreEspectaculo,String fecha,int silla,double precio,
			String nombreSede){
		
		if(!this.contraseña.equals(contraseña)) {
			throw new RuntimeException("Contraseña incorreccta");
		}
		
		if(silla <= 0) {
			throw new RuntimeException("Numero de asiento invalido");
		}
		String codigo=generarCodigo();
		
		Entrada entrada=new Entrada(contraseña,categoria,codigo,nombreEspectaculo,fecha,silla,precio,nombreSede);
		
		entradasCompradas.put(codigo, entrada);
		
		return entrada;
		}
	
	
	private String generarCodigo() {
		Random random = new Random();
		String codigo="";
		
		do {
			codigo="";
			
	        for (int i = 0; i < 5; i++) {
	            // Genera una letra mayúscula aleatoria (A=65, Z=90 en ASCII)
	            char letra = (char) (random.nextInt(26) + 'A');
	            codigo=codigo+letra;
	        }
	    }while(entradasCompradas.containsKey(codigo));
		
			return codigo;
	    }
		
	
	
	public void consultarEntradaPorFechas(String fecha) {
	}
	
	public void consultarEntradasPasadas() {
		
		
	}
	
	
	
	public boolean comprobarContraseña(String contraseña) {
		return this.contraseña.equals(contraseña);
	}
	
	public List<IEntrada> devolverEntradasCompradas(){
		return new ArrayList<>(entradasCompradas.values());
	}
	
	public boolean anularEntrada(String codigo) {
		if(!entradasCompradas.containsKey(codigo)) {
			throw new RuntimeException("codigo no existente");

		}
		else{ 
			entradasCompradas.remove(codigo);
		return true;}				
	}
	
	public IEntrada cambiarEntradaEstadio(IEntrada entradaVieja, String nuevaFecha) {
		Entrada entradaNueva = ((Entrada) entradaVieja).entradaConNuevaFechaEstadio(nuevaFecha);
		entradasCompradas.put(((Entrada) entradaNueva).obtenerCodigo(), entradaNueva);
		anularEntrada(entradaVieja.obtenerCodigo());		
		return entradaNueva;
	}
	
	public IEntrada cambiarEntradaTeatro(IEntrada entradaVieja, String nuevaFecha,String sector, int asiento) {
		 Entrada entradaNueva = ((Entrada) entradaVieja).entradaConNuevaFechaTeatro(nuevaFecha, sector, asiento);
		    entradasCompradas.put(entradaNueva.obtenerCodigo(), entradaNueva);
		    anularEntrada(entradaVieja.obtenerCodigo());
		    return entradaNueva;
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
