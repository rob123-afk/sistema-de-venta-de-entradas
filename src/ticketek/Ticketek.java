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
				throw new RuntimeException("teatro ya registrado");
			}		
	}*/
	public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,
	        String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
	    
	    // Validaciones de parámetros
	    if (nombre == null || nombre.trim().isEmpty()) {
	        throw new RuntimeException("El nombre de la sede no puede ser nulo o vacío");
	    }
	    
	    if (ListaDeSedes.containsKey(nombre)) {
	        throw new RuntimeException("Teatro ya registrado: " + nombre);
	    }
	    
	    if (direccion == null || direccion.trim().isEmpty()) {
	        throw new RuntimeException("La dirección no puede ser nula o vacía");
	    }
	    
	    if (capacidadMaxima <= 0) {
	        throw new RuntimeException("La capacidad máxima debe ser mayor a 0");
	    }
	    
	    if (asientosPorFila <= 0) {
	        throw new RuntimeException("Los asientos por fila deben ser mayores a 0");
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
	        throw new RuntimeException("Los arreglos de sectores no pueden ser nulos");
	    }
	    
	    if (sectores.length == 0 || capacidad.length == 0 || porcentajeAdicional.length == 0) {
	        throw new RuntimeException("Los arreglos de sectores no pueden estar vacíos");
	    }
	    
	    if (sectores.length != capacidad.length || sectores.length != porcentajeAdicional.length) {
	        throw new RuntimeException("Los arreglos de sectores deben tener la misma longitud");
	    }
	    
	    for (int i = 0; i < capacidad.length; i++) {
	        if (capacidad[i] <= 0) {
	            throw new RuntimeException("La capacidad del sector " + sectores[i] + " debe ser mayor a 0");
	        }
	        if (porcentajeAdicional[i] < 0) {
	            throw new RuntimeException("El porcentaje adicional del sector " + sectores[i] + " no puede ser negativo");
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
			
			if(ListaDeSedes.containsKey(nombre)) {
				throw new RuntimeException("miniestadio ya registrada");
				} 					
			 Miniestadio nuevoMiniestadio = new Miniestadio(
				        nombre,
				        direccion,
				        capacidadMaxima,
				        precioConsumicion,
				        asientosPorFila,
				        cantidadPuestos, 
				        sectores,
				        capacidad,
				        porcentajeAdicional
				    );
			 ListaDeSedes.put(nombre, nuevoMiniestadio);
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
		
		if(ListaDeSedes.containsKey(nombre)) {
			throw new RuntimeException("Sede ya registrada");
			}
		
			Estadio nuevoEstadio = new Estadio(nombre,direccion,capacidadMaxima);
			ListaDeSedes.put(nombre, nuevoEstadio);	
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
		ListaDeUsuarios.put(email, new Usuario(email,nombre,apellido,contraseña));
		} else {
			throw new RuntimeException("Email ya registrado");
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
	    	throw new RuntimeException("El nombre del espectáculo no puede ser nulo o vacío");
	    }
	    
	    // Validación de estado
	    if (ListaDeEspectaculos.containsKey(nombre)) {
	    	throw new RuntimeException("El espectáculo '" + nombre + "' ya está registrado");
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
	    	throw new RuntimeException("El nombre del espectáculo no puede ser nulo o vacío");
	    }
	    
	    if (fecha == null || !fecha.matches("\\d{2}/\\d{2}/\\d{2}")) {
	    	throw new RuntimeException("Formato de fecha inválido. Debe ser dd/mm/YY");
	    }
	    
	    if (sede == null || sede.trim().isEmpty()) {
	    	throw new RuntimeException("El nombre de la sede no puede ser nulo o vacío");
	    }
	    
	    if (precioBase <= 0) {
	    	throw new RuntimeException("El precio base debe ser mayor a cero");
	    }
	    
	    // Validación de estado del sistema
	    if (!ListaDeEspectaculos.containsKey(nombreEspectaculo)) {
	    	throw new RuntimeException("El espectáculo '" + nombreEspectaculo + "' no está registrado");
	    }
	    
	    if (!ListaDeSedes.containsKey(sede)) {
	    	throw new RuntimeException("La sede '" + sede + "' no está registrada");
	    }
	    
	    // Operación principal
	    try {
	        ListaDeEspectaculos.get(nombreEspectaculo)
	            .agregarFuncion(fecha, ListaDeSedes.get(sede), precioBase);
	    } catch (RuntimeException e) {
	    	throw new RuntimeException("Error al agregar la función: " + e.getMessage(), e);
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
	public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contraseña,int cantidadEntradas){
		if(email == null || contraseña == null || cantidadEntradas <= 0) {
			throw new RuntimeException("Email no ingresado");
			}
		if(!ListaDeUsuarios.containsKey(email)) {
			throw new RuntimeException("email no registrado");
		}
		if(!ListaDeEspectaculos.containsKey(nombreEspectaculo)) {
			throw new RuntimeException("espectaculo inexistente");
		}
		Usuario usuario = ListaDeUsuarios.get(email);
		Espectaculo espectaculo = ListaDeEspectaculos.get(nombreEspectaculo);
		Funcion funcion = espectaculo.obtenerFuncion(fecha);
		if(!usuario.comprobarContraseña(contraseña)) {
			throw new RuntimeException("Contraseña incorrecta");
		}
		
		if(funcion == null) {
			throw new RuntimeException("No hay funcion programada para esa fecha");
		}
		
		double precio = funcion.devolverPrecio();
		String nombreSede = funcion.devolverSede().devolverNombre();
		
		List<IEntrada> entradasVendidas = new ArrayList<>();
		
			for(int i = 0; i < cantidadEntradas;i++) {
			IEntrada nuevaEntrada = usuario.comprarEntrada(contraseña, nombreEspectaculo, fecha,precio,nombreSede);
			funcion.agregarEntradaVendida(nuevaEntrada);
			entradasVendidas.add(nuevaEntrada);
			}
		return entradasVendidas;
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
		if(email == null || contraseña == null || sector == null || asientos == null) {
			throw new RuntimeException("Los parametros son invalidos, revise el email, contraseña, sector y/o asientos");
			}
		if(!ListaDeUsuarios.containsKey(email)) {
			throw new RuntimeException("email no registrado");
			}
		if(!ListaDeEspectaculos.containsKey(nombreEspectaculo)) {
			throw new RuntimeException("espectaculo inexistente");
			}
		Usuario usuario = ListaDeUsuarios.get(email);
		Espectaculo espectaculo = ListaDeEspectaculos.get(nombreEspectaculo);
		Funcion funcion = espectaculo.obtenerFuncion(fecha);
		if(!usuario.comprobarContraseña(contraseña)) {
			throw new RuntimeException("Contraseña incorrecta");
		}
		double precio;
		try {
			precio = espectaculo.obtenerFuncion(fecha).devolverPrecio();
		} catch (Exception e) {
			throw new RuntimeException("No se encontró función para la fecha especificada");
		}
		
		List<IEntrada> entradasVendidas = new ArrayList<>();
		String nombreSede = funcion.devolverSede().devolverNombre();
				for(int asiento : asientos) {
			try {
				IEntrada nuevaEntrada = usuario.comprarEntrada(contraseña, sector, nombreEspectaculo,fecha,asiento,precio,nombreSede);
				funcion.agregarEntradaVendida(nuevaEntrada);
				entradasVendidas.add(nuevaEntrada);
				
			} catch (RuntimeException e) {
				System.out.println("Este asiento no está disponible");
			}
		}
		if(entradasVendidas.isEmpty()) {
			throw new RuntimeException("No se pudo comprar ningun asiento");
		}
		return entradasVendidas;
	}

	@Override
	public String listarFunciones(String nombreEspectaculo) {
		Espectaculo espectaculoSolicitado = ListaDeEspectaculos.get(nombreEspectaculo);
		if (espectaculoSolicitado == null) {
			throw new RuntimeException ("Espectáculo no encontrado");
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
			throw new RuntimeException("Usuario no encontrado");
		}
		else {
			Usuario usuario = ListaDeUsuarios.get(email);
			
			if (usuario.comprobarContraseña(contraseña)) {
				return usuario.devolverEntradasCompradas();
			} else {
				throw new RuntimeException("Contraseña incorrecta.");}
		}
	}

	@Override
	public boolean anularEntrada(IEntrada entrada, String contraseña) {
		if (contraseña == null) {
			throw new RuntimeException("Contraseña invalida");
		}
		if(entrada == null) {
			throw new RuntimeException("Entrada invalida");
		}
		boolean usuarioEncontrado = false;
		for(Usuario usuario : ListaDeUsuarios.values()) {
			if(usuario.comprobarContraseña(contraseña)) {
				 usuarioEncontrado = true;
			if(usuario.devolverEntradasCompradas().contains(entrada)) {
				usuario.anularEntrada(entrada.obtenerCodigo());
				return true;
				}
			} 
		}
		if (usuarioEncontrado){
			throw new RuntimeException("La entrada no existe para este usuario");
		} else {
			throw new RuntimeException("Contraseña incorrecta");
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
	public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha, String sector, int asiento) {
		if (contrasenia == null) {
			throw new RuntimeException("Contraseña invalida");
		}
		if (entrada == null) {
			throw new RuntimeException("Entrada invalida");
		}
		boolean usuarioEncontrado = false;
		for(Usuario usuario : ListaDeUsuarios.values()) {
			if(usuario.comprobarContraseña(contrasenia)) {
				usuarioEncontrado = true;
			if(usuario.devolverEntradasCompradas().contains(entrada)) {
				return usuario.cambiarEntradaTeatro(entrada, fecha,sector,asiento);
				}
			}
		}
		if (usuarioEncontrado) {
			throw new RuntimeException("La entrada no existe para este usuario");
		} else {
			throw new RuntimeException("Contraseña incorrecta");
		}
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
		if (contrasenia == null) {
			throw new RuntimeException("Contraseña invalida");
		}
		if (entrada == null) {
			throw new RuntimeException("Entrada invalida");
		}
		boolean usuarioEncontrado = false;
		for(Usuario usuario : ListaDeUsuarios.values()) {
			if(usuario.comprobarContraseña(contrasenia)) {
				usuarioEncontrado = true;
			if(usuario.devolverEntradasCompradas().contains(entrada)) {
				return usuario.cambiarEntradaEstadio(entrada, fecha);
				}
			}
		}
		if (usuarioEncontrado) {
			throw new RuntimeException("La entrada no existe para este usuario");
		} else {
			throw new RuntimeException("Contraseña incorrecta");
		}
	}

	@Override
	public double costoEntrada(String nombreEspectaculo, String fecha) {
		if(!ListaDeEspectaculos.containsKey(nombreEspectaculo)) 
		{
			throw new RuntimeException("espectaculo no registrado");
			}
		Espectaculo espectaculo = ListaDeEspectaculos.get(nombreEspectaculo);
		return espectaculo.consultarPrecio(fecha);
	}

	@Override
	public double costoEntrada(String nombreEspectaculo, String fecha, String sector) {
		if(!ListaDeEspectaculos.containsKey(nombreEspectaculo)) {
			throw new RuntimeException("espectaculo no registrado");
		}
		Espectaculo espectaculo = ListaDeEspectaculos.get(nombreEspectaculo);		
		Funcion funcion = espectaculo.devolverFunciones().get(fecha);
		if(funcion == null) {
			throw new RuntimeException("En esa fecha no está registrado el espectaculo");
		}
		switch(sector){
		case "Platea Baja":
            return funcion.devolverPrecioPlateaBaja();
        case "Platea Alta":
            return funcion.devolverPrecio();
        case "Platea VIP":
            return funcion.devolverPrecioVIP();
        case "Platea Común":
            return funcion.devolverPrecioPlateaComun();
        default:
            throw new RuntimeException("Sector no válido: " + sector);
			}
		}	

	@Override
	public double totalRecaudado(String nombreEspectaculo) {
	    Espectaculo espectaculo = ListaDeEspectaculos.get(nombreEspectaculo);
	    if (espectaculo == null) {
	        throw new RuntimeException("No se encontró el espectáculo");
	    }	    
	    double total = 0.0;
	    HashMap<String, Funcion> funciones = espectaculo.devolverFunciones();	 
	    if (funciones.isEmpty()) {
	        throw new RuntimeException("El espectáculo " + nombreEspectaculo + "no tiene funciones registradas");
	    }    
	    for (Funcion funcion : funciones.values()) {
	    	List<IEntrada> entradasVendidas = funcion.devolverEntradasVendidas();
	    	if (entradasVendidas != null && !entradasVendidas.isEmpty()) {
	    		for(IEntrada entrada : entradasVendidas) {
	    			if (entrada != null) {
	    				double precioEntrada = funcion.calcularConsumicionMiniestadio(entrada) + entrada.precio();
	    				total += precioEntrada;
	    			}
	    		}
	    	}
	    }
	    return total;
	}

	@Override
	public double totalRecaudadoPorSede(String nombreEspectaculo, String nombreSede) {
		Espectaculo espectaculo = ListaDeEspectaculos.get(nombreEspectaculo);
		if (espectaculo == null) {
			throw new RuntimeException("No se encontró el espectáculo");
		}
		double total = 0.0;
		HashMap<String, Funcion> funciones = espectaculo.devolverFunciones();
		if(funciones.isEmpty()) {
			throw new RuntimeException("El espectaculo " + nombreEspectaculo + "no tiene funciones registradas");
		}
		for(Funcion funcion : funciones.values()) {
			if(funcion.devolverSede().devolverNombre().equals(nombreSede)){
				List<IEntrada> entradasVendidas = funcion.devolverEntradasVendidas();
				if(entradasVendidas != null && !entradasVendidas.isEmpty()) {
					for(IEntrada entrada : entradasVendidas) {
						if(entrada !=null) {
							double precioEntrada = funcion.calcularConsumicionMiniestadio(entrada) + entrada.precio();
							total += precioEntrada;
						}
					}
				}
			}
		}
		return total;
	}

	




}
