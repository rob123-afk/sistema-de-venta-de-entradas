package ticketek;

import java.time.LocalDate;

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
	
	/*public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,
			String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
		
		if(!ListaDeSedes.containsKey(nombre)) {
			ListaDeSedes.put(nombre, new Teatro(nombre,direccion,capacidadMaxima,asientosPorFila,
			sectores, capacidad, porcentajeAdicional));
			} else {
				System.out.println("teatro ya registrado");
			}		
	}*/
	public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,
	        String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
	    
	    // Validaciones de parámetros
	    if (nombre == null || nombre.trim().isEmpty()) {
	        throw new IllegalArgumentException("El nombre de la sede no puede ser nulo o vacío");
	    }
	    
	    if (ListaDeSedes.containsKey(nombre)) {
	        throw new IllegalStateException("Teatro ya registrado: " + nombre);
	    }
	    
	    if (direccion == null || direccion.trim().isEmpty()) {
	        throw new IllegalArgumentException("La dirección no puede ser nula o vacía");
	    }
	    
	    if (capacidadMaxima <= 0) {
	        throw new IllegalArgumentException("La capacidad máxima debe ser mayor a 0");
	    }
	    
	    if (asientosPorFila <= 0) {
	        throw new IllegalArgumentException("Los asientos por fila deben ser mayores a 0");
	    }
	    
	    validarArreglos(sectores, capacidad, porcentajeAdicional);
	    
	    // Registro de la sede
	    ListaDeSedes.put(nombre, new Teatro(
	        nombre,
	        direccion,
	        capacidadMaxima,
	        asientosPorFila,
	        sectores,
	        capacidad,
	        porcentajeAdicional
	    ));
	}

	private void validarArreglos(String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
	    if (sectores == null || capacidad == null || porcentajeAdicional == null) {
	        throw new IllegalArgumentException("Los arreglos de sectores no pueden ser nulos");
	    }
	    
	    if (sectores.length == 0 || capacidad.length == 0 || porcentajeAdicional.length == 0) {
	        throw new IllegalArgumentException("Los arreglos de sectores no pueden estar vacíos");
	    }
	    
	    if (sectores.length != capacidad.length || sectores.length != porcentajeAdicional.length) {
	        throw new IllegalArgumentException("Los arreglos de sectores deben tener la misma longitud");
	    }
	    
	    for (int i = 0; i < capacidad.length; i++) {
	        if (capacidad[i] <= 0) {
	            throw new IllegalArgumentException("La capacidad del sector " + sectores[i] + " debe ser mayor a 0");
	        }
	        if (porcentajeAdicional[i] < 0) {
	            throw new IllegalArgumentException("El porcentaje adicional del sector " + sectores[i] + " no puede ser negativo");
	        }
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
	/*public void registrarEspectaculo(String nombre) {
		if(!ListaDeEspectaculos.containsKey(nombre)) {
			ListaDeEspectaculos.put(nombre, new Espectaculo(nombre));;
			} else {
				System.out.println("espectaculo ya registrado");
			}
				
	}*/
	
	public void registrarEspectaculo(String nombre) {
	    // Validación de parámetros
	    if (nombre == null || nombre.trim().isEmpty()) {
	        throw new IllegalArgumentException("El nombre del espectáculo no puede ser nulo o vacío");
	    }
	    
	    // Validación de estado
	    if (ListaDeEspectaculos.containsKey(nombre)) {
	        throw new IllegalStateException("El espectáculo '" + nombre + "' ya está registrado");
	    }
	    
	    // Registro del espectáculo
	    ListaDeEspectaculos.put(nombre, new Espectaculo(nombre));
	}
	
/*
	public void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase) {
		
		if(!ListaDeSedes.containsKey(sede)) {
			
				System.out.println("ingresaste una sede no registrada");
			}		
		
		
		ListaDeEspectaculos.get(nombreEspectaculo).agregarFuncion(fecha, ListaDeSedes.get(sede), precioBase);
	}*/
	
	public void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase) {
	    // Validación de parámetros
	    if (nombreEspectaculo == null || nombreEspectaculo.trim().isEmpty()) {
	        throw new IllegalArgumentException("El nombre del espectáculo no puede ser nulo o vacío");
	    }
	    
	    if (fecha == null || !fecha.matches("\\d{2}/\\d{2}/\\d{2}")) {
	        throw new IllegalArgumentException("Formato de fecha inválido. Debe ser dd/mm/YY");
	    }
	    
	    if (sede == null || sede.trim().isEmpty()) {
	        throw new IllegalArgumentException("El nombre de la sede no puede ser nulo o vacío");
	    }
	    
	    if (precioBase <= 0) {
	        throw new IllegalArgumentException("El precio base debe ser mayor a cero");
	    }
	    
	    // Validación de estado del sistema
	    if (!ListaDeEspectaculos.containsKey(nombreEspectaculo)) {
	        throw new IllegalStateException("El espectáculo '" + nombreEspectaculo + "' no está registrado");
	    }
	    
	    if (!ListaDeSedes.containsKey(sede)) {
	        throw new IllegalStateException("La sede '" + sede + "' no está registrada");
	    }
	    
	    // Operación principal
	    try {
	        ListaDeEspectaculos.get(nombreEspectaculo)
	            .agregarFuncion(fecha, ListaDeSedes.get(sede), precioBase);
	    } catch (RuntimeException e) {
	        throw new IllegalStateException("Error al agregar la función: " + e.getMessage(), e);
	    }
	}

	/**
     * 4) Vende una o varias entradas a un usuario para funciones
     * en sedes no numeradas
     * 
     * Devuelve una lista con las entradas vendidas (Ver interfaz IEntrada).
     *  
     * Se debe lanzar una excepcion si:
     *  - Si la sede de la funcion está numerada
     *  - si el usuario no está registrado
     *  - si el espectaculo no está registrado
     *  - si la contraseña no es valida
     *  - etc...
     * 
     * @param nombreEspectaculo
     * @param fecha en formato: dd/mm/YY
     * @param email
     * @param contrasenia
     * @param cantidadEntradas
     * @return
     */
	public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contraseña,
			int cantidadEntradas) {
		if(!ListaDeUsuarios.containsKey(email)) {System.out.println("email no registrado");
		return null;}
		if(!ListaDeEspectaculos.containsKey(nombreEspectaculo)) {System.out.println("espectaculo inexistente");
		return null;}
		if(!ListaDeUsuarios.get(email).comprobarContraseña(contraseña)) {System.out.println("contraseña incorrecta");
		return null;}
		
		for(int i=0; i<cantidadEntradas; i++) {
			
		ListaDeUsuarios.get(email).comprarEntrada(contraseña, nombreEspectaculo, fecha);}
		
		return listarEntradasFuturas(email,contraseña);
		}
		
	/**
     * 4) Vende una o varias entradas a un usuario para funciones 
     * con sedes numeradas.
     * 
     * Devuelve una lista con las entradas vendidas (Ver interfaz IEntrada).
     * 
     * Se debe lanzar una excepcion si:
     *  - Si la sede de la funcion no es numerada
     *  - si el usuario no está registrado
     *  - si el espectaculo no está registrado
     *  - si la contraseña no es valida
     *  - etc...
     *  
     * @param nombreEspectaculo
     * @param fecha en formato: dd/mm/YY
     * @param email
     * @param contrasenia
     * @param sector
     * @param asientos
     * @return
     */	

	@Override
	public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contraseña,
			String sector, int[] asientos) {
		if(!ListaDeUsuarios.containsKey(email)) {System.out.println("email no registrado");
		return null;}
		if(!ListaDeEspectaculos.containsKey(nombreEspectaculo)) {System.out.println("espectaculo inexistente");
		return null;}
		if(!ListaDeUsuarios.get(email).comprobarContraseña(contraseña)) {System.out.println("contraseña incorrecta");
		return null;}
		
		
		for(int asiento: asientos) {	
		ListaDeUsuarios.get(email).comprarEntrada(contraseña,sector,nombreEspectaculo,fecha,asiento);
		}
		
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
	public List<IEntrada> listarEntradasFuturas(String email, String contraseña) {
		List<IEntrada> entradas=listarTodasLasEntradasDelUsuario(email, contraseña);
		
		ArrayList <IEntrada>entradasFuturas=new ArrayList<IEntrada>();
				
		for (IEntrada entrada : entradas) {
			
			if(entrada.esFuturo()) { entradasFuturas.add(entrada);} 
		}
	        
		return entradasFuturas;
	}

	@Override
	public List<IEntrada> listarTodasLasEntradasDelUsuario(String email, String contraseña) {
		if (!ListaDeUsuarios.containsKey(email)) {
			System.out.println("Usuario no encontrado");
		}
		else {
			Usuario usuario = ListaDeUsuarios.get(email);
			
			if (usuario.comprobarContraseña(contraseña)) {
				return usuario.devolverEntradasCompradas();
			} else {
				System.out.println("Contraseña incorrecta.");}
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

	/**
     * 9) Si puede asignar la entrada en la nueva fecha, anula la 
     * entrada anterior.
     * Devuelve una entrada nueva (Ver interfaz IEntrada).
     * 
     * Lanza excepcion si:
     *  - Si la entrada original está en el pasado.
     *  - Si la contraseña no es valida.
     *  - etc...
     * 
     * 
     * @param Entrada
     * @param contrasenia
     * @param fecha en formato: dd/mm/YY
     * @param sector
     * @param asiento
     * @return
     */
	public Entrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha, String sector, int asiento) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
     * 9) Si puede asignar la ebtrada en la nueva fecha, anula la 
     * entrada anterior.
     * Devuelve una entrada nueva (Ver interfaz IEntrada).
     * 
     * Lanza excepcion si:
     *  - la entrada original está en el pasado
     *  - Si la contraseña no es valida.
     *  - etc...
     *  
     * 
     * @param Entrada
     * @param contrasenia
     * @param fecha en formato: dd/mm/YY
     * @return
     */
	@Override
	public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double costoEntrada(String nombreEspectaculo, String fecha) {
		if(!ListaDeEspectaculos.containsKey(nombreEspectaculo)) 
		{System.out.println("espectaculo no registrado");
		return 0.0;}
		Espectaculo espectaculo = ListaDeEspectaculos.get(nombreEspectaculo);
		
		/*rompe el encapsulamiento
		Funcion funcion = espectaculo.devolverFunciones().get(fecha);
		if(funcion == null) {
			System.out.println("En esa fecha no está registrado ningun espectaculo");
			return 0.0;
		}*/
		return espectaculo.consultarPrecio(fecha);
	}

	@Override
	public double costoEntrada(String nombreEspectaculo, String fecha, String sector) {
		if(!ListaDeEspectaculos.containsKey(nombreEspectaculo)) 
		{System.out.println("espectaculo no registrado");
		Espectaculo espectaculo = ListaDeEspectaculos.get(nombreEspectaculo);
		
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
		return 0.0;}
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
