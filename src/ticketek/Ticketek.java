package ticketek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ticketek implements ITicketek{
	
	private HashMap<String ,Usuario> ListaDeUsuarios=new HashMap<>();
	private HashMap<String ,Espectaculo> ListaDeEspectaculos=new HashMap<>(); //key nombre
	private HashMap<String ,Sede> ListaDeSedes=new HashMap<>(); //key nombre

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

    /**
     * 1) Registra las sedes con asientos y sin puestos de venta, teatros.
     * Estos reciben la informacion de los sectores como parámetros.
     * 
     * Si el nombre ya está registrado, se debe lanzar una excepcion.
     * Si algun dato no es aceptable, se debe lanzar una excepcion.
     * 
     * @param nombre
     * @param direccion
     * @param capacidadMaxima
     * @param asientosPorFila
     * @param sectores
     * @param capacidad
     * @param porcentajeAdicional
     */
	
	public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,
			String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
		
		if(!ListaDeSedes.containsKey(nombre)) {
			ListaDeSedes.put(nombre, new Teatro(nombre,direccion,capacidadMaxima,asientosPorFila,
			sectores, capacidad, porcentajeAdicional));
			} else {
				System.out.println("teatro ya registrado");
			}		
	}

    /**
     * 1) Registra las sedes con asientos y puestos de venta, miniestadios.
     * Estos reciben la informacion de los sectores como parámetros.
     * tambien el adicional por consumición y tambien la cantidad de puestos.
     * 
     * Si el nombre ya está registrado, se debe lanzar una excepcion.
     * Si algun dato no es aceptable, se debe lanzar una excepcion.
     * 
     * @param nombre
     * @param direccion
     * @param capacidadMaxima
     * @param asientosPorFila
     * @param cantidadPuestos
     * @param precioConsumicion
     * @param sectores
     * @param capacidad
     * @param porcentajeAdicional
     */
	
	
	public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,
			int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad,
			int[] porcentajeAdicional) {	
			
			if(!ListaDeSedes.containsKey(nombre)) {
				ListaDeSedes.put(nombre, new Miniestadio(nombre,direccion,capacidadMaxima,precioConsumicion));
				} else {
					System.out.println("miniestadio ya registrada");
				}		
		
		
	}
			
	 /**
	 * 1) Registra las sedes que no tienen asientos,(estadios).
	 * Estas tienen un unico sector llamado campo.
	 * 
	 * Si el nombre ya está registrado, se debe lanzar una excepcion.
	 * Si algun dato no es aceptable, se debe lanzar una excepcion.
	 * 
	 * @param nombre
	 * @param direccion
	 * @param capacidadMaxima
	 */

	public void registrarSede(String nombre, String direccion, int capacidadMaxima) {
		
		if(!ListaDeSedes.containsKey(nombre)) {
			ListaDeSedes.put(direccion, new Estadio(nombre,direccion,capacidadMaxima));
			} else {
				System.out.println("Estadio ya registrada");
			}		
		

		}

	/**
     * 2) Registrar un nuevo usuario en el sistema
     * 
     * Si el email ya está registrado, se debe lanzar una excepcion
     * Si algun dato no es aceptable, se debe lanzar una excepcion.
     * 
     * @param email
     * @param nombre
     * @param apellido
     * @param contraseña
     */
	public void registrarUsuario(String email, String nombre, String apellido, String contraseña) {
		if(!ListaDeUsuarios.containsKey(email)) {
		ListaDeUsuarios.put(email, new Usuario(nombre,apellido,contraseña));
		} else {
			System.out.println("Email ya registrado");
		}
		
	}

/*
    * @param nombreEspectaculo
    * @param fecha en formato: dd/mm/YY
    * @param sede
    * @param precioBase*/
	public void registrarEspectaculo(String nombre) {
		if(!ListaDeEspectaculos.containsKey(nombre)) {
			ListaDeEspectaculos.put(nombre, new Espectaculo(nombre));;
			} else {
				System.out.println("espectaculo ya registrado");
			}
				
	}

	public void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase) {
		
		if(!ListaDeSedes.containsKey(sede)) {
			
				System.out.println("ingresaste una sede no registrada");
			}		
		
		
		ListaDeEspectaculos.get(nombreEspectaculo).agregarFuncion(fecha, ListaDeSedes.get(sede), precioBase);
	}

	@Override
	public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia,
			int cantidadEntradas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia,
			String sector, int[] asientos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listarFunciones(String nombreEspectaculo) {
		Espectaculo espectaculoSolicitado = ListaDeEspectaculos.get(nombreEspectaculo);
		if (espectaculoSolicitado == null) {
			return "Espectáculo no encontrado";
		}
		return espectaculoSolicitado.listarFunciones();
	}

	@Override
	public List<IEntrada> listarEntradasEspectaculo(String nombreEspectaculo) {
		Espectaculo espectaculo = ListaDeEspectaculos.get(nombreEspectaculo);
		if (espectaculo != null) {
			return espectaculo.listarTodasLasEntradas();
		}
		return new ArrayList<>();
	}

	@Override
	public List<IEntrada> listarEntradasFuturas(String email, String contrasenia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IEntrada> listarTodasLasEntradasDelUsuario(String email, String contraseña) {
		if (ListaDeUsuarios.containsKey(email)) {
			Usuario usuario = ListaDeUsuarios.get(email);
		if (usuario.comprobarContraseña(contraseña) && usuario.comprobarEmail(email)) {
			return usuario.devolverEntradasCompradas();
		} else {
			System.out.println("Contraseña incorrecta.");
			}
		}
		else {
			System.out.println("Usuario no encontrado");
		}
		return null;
	}

	@Override
	public boolean anularEntrada(IEntrada entrada, String contraseña) {
		Usuario usuarioEncontrado = ListaDeUsuarios.get(contraseña);
		if (usuarioEncontrado != null) {
			System.out.println("Entrada anulada con exito");
			return usuarioEncontrado.anularEntrada(entrada.obtenerCodigo());
		} else {
			System.out.println("No se encontró ningún usuario");
			return false;
		}
	}

	@Override
	public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha, String sector, int asiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double costoEntrada(String nombreEspectaculo, String fecha) {
		Espectaculo espectaculo = ListaDeEspectaculos.get(nombreEspectaculo);
		if(espectaculo== null) {
			System.out.println("Espectaculo no encontrado");
			return 0.0;
		}
		Funcion funcion = espectaculo.devolverFunciones().get(fecha);
		if(funcion == null) {
			System.out.println("En esa fecha no está registrado el espectaculo");
			return 0.0;
		}
		return funcion.devolverPrecio();
	}

	@Override
	public double costoEntrada(String nombreEspectaculo, String fecha, String sector) {
		Espectaculo espectaculo = ListaDeEspectaculos.get(nombreEspectaculo);
		if(espectaculo== null) {
			System.out.println("Espectaculo no encontrado");
			return 0.0;
		}
		Funcion funcion = espectaculo.devolverFunciones().get(fecha);
		if(funcion == null) {
			System.out.println("En esa fecha no está registrado el espectaculo");
			return 0.0;
		}
		if(sector.equals("Platea baja")) {
		return funcion.devolverPrecioPlateaBaja();
		}
		if(sector.equals("Platea Alta")) {
		return funcion.devolverPrecio();
		}
		if(sector.equals("Platea VIP")) {
		return funcion.devolverPrecioVIP();
		}
		if(sector.equals("Platea Comun")) {
		return funcion.devolverPrecioPlateaComun();
		}
		return 0.0;
	}

	@Override
	public double totalRecaudado(String nombreEspectaculo) {
		Espectaculo espectaculo = ListaDeEspectaculos.get(nombreEspectaculo);
		
		if (espectaculo == null) {
			System.out.println("No se encontró el espectaculo");
			return 0.0;
		}
		double total = 0.0;
		
		for (Funcion funcion: espectaculo.devolverFunciones().values()) {
			for (IEntrada entrada : funcion.devolverEntradasVendidas()) {
				total += entrada.precio();
			}
		}
		return total;
	}

	@Override
	public double totalRecaudadoPorSede(String nombreEspectaculo, String nombreSede) {
		Espectaculo espectaculo = ListaDeEspectaculos.get(nombreSede);
		
		if (espectaculo == null) {
			System.out.println("No se encontró el espectáculo");
			return 0.0;
		}
		double total = 0.0;
		
		for(Funcion funcion : espectaculo.devolverFunciones().values()) {
			if (funcion.devolverSede().devolverNombre().equals(nombreSede)) {
				for (IEntrada entrada : funcion.devolverEntradasVendidas()) {
					total += entrada.precio();
				}
			}
		}
		return total;
	}

	




}
