package ticketek;
import java.util.HashMap;
import java.util.List;

public class Ticketek implements ITicketek{
	
	private HashMap<String ,Usuario> ListaDeUsuarios=new HashMap<>();
	
	private HashMap<String ,Sede> ListaDeSedes=new HashMap<>();

	
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
		
		ListaDeSedes.put(nombre, new Teatro(nombre,direccion,capacidadMaxima));
		
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
			ListaDeSedes.put(nombre, new Miniestadio(nombre,direccion,capacidadMaxima,precioConsumicion));
			
		
		
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

		ListaDeSedes.put(direccion, new Estadio(nombre,direccion,capacidadMaxima));

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
	public void registrarEspectaculo(String nombreEspectaculo, String fecha, Sede sede, int precioBase) {
		
		
	}

	@Override
	public void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IEntrada> listarEntradasEspectaculo(String nombreEspectaculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IEntrada> listarEntradasFuturas(String email, String contrasenia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IEntrada> listarTodasLasEntradasDelUsuario(String email, String contrasenia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean anularEntrada(IEntrada entrada, String contrasenia) {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double costoEntrada(String nombreEspectaculo, String fecha, String sector) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double totalRecaudado(String nombreEspectaculo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double totalRecaudadoPorSede(String nombreEspectaculo, String nombreSede) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void registrarEspectaculo(String nombre) {
		// TODO Auto-generated method stub
		
	}




}
