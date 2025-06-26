package ticketek;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Entrada implements IEntrada  {
	protected String contraseña;
	protected String categoria;
	protected String codigo;
	protected String nombreEspectaculo;
	protected String fecha;
	protected Integer asiento;
	protected double precio;
	protected String nombreSede;

	//constructor de entrada con categoria
	public Entrada (String contraseña,String categoria,String codigo, String nombreEspectaculo,String fecha,int ubicacion, double precio,
			String nombreSede) {
		this.contraseña = contraseña;
		this.categoria = categoria;
		this.codigo = codigo;
		this.nombreEspectaculo = nombreEspectaculo;
		this.fecha = fecha;
		this.asiento = ubicacion;
		this.precio = precio;
		this.nombreSede = nombreSede;
	}
	
	//constructor de campo
	public Entrada (String contraseña,String codigo, String nombreEspectaculo,String fecha, double precio, String nombreSede) {
		this.contraseña = contraseña;
		this.categoria = "CAMPO";
		this.codigo = codigo;
		this.nombreEspectaculo = nombreEspectaculo;
		this.fecha = fecha;
		this.asiento = null;
		this.precio = precio;
		this.nombreSede = nombreSede;
	}
	
	

	
	@Override
	public double precio() {
		double precioFinal = this.precio;
		if(this.categoria.equals("VIP")) {
			precioFinal += this.precio * 0.7;
		}
		if(this.categoria.equals("Comun")) {
			precioFinal += this.precio * 0.4;
		}
		
		if(this.categoria.equals("Baja")) {
			precioFinal += this.precio * 0.5;
		}
		System.out.println(precioFinal);
		return precioFinal;
	}

	public String ubicacion() {		
		return categoria;
	}

	
	public String toString() {
		String fechaFormateada = formatearFechaConPasado(fecha);
		return String.format(" - " + nombreEspectaculo + " - "+ fechaFormateada +" - " + nombreSede +" - "+ categoria.toUpperCase());
	}
	
	
	private String formatearFechaConPasado(String fecha) {
		try {
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
			LocalDate fechaEntrada = LocalDate.parse(fecha,formato);
			LocalDate hoy = LocalDate.now();
			
			if(fechaEntrada.isBefore(hoy)) {
				return " P - " + fecha;
			} else {
				return fecha;
			}
		} catch (Exception e) {
			return fecha;
		}
	}

	public String obtenerCodigo() {
		return codigo;
	}


	@Override
	public boolean esFuturo() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		LocalDate hoy= LocalDate.now();
		LocalDate fecha= LocalDate.parse(this.fecha,formatter);
		
		
        if (fecha.isAfter(hoy)) {
            return true;
        }
    
        return false;}

	public String obtenerSector() {
		return categoria;
	}

	public Entrada entradaConNuevaFechaEstadio(String nuevaFecha) {
		return new Entrada(this.contraseña,this.codigo,this.nombreEspectaculo, nuevaFecha,this.precio,this.nombreSede);
	}
	
	public Entrada entradaConNuevaFechaTeatro(String nuevaFecha, String sector, int asiento) {
		return new Entrada(this.contraseña,sector,this.codigo, this.nombreEspectaculo,nuevaFecha,asiento,this.precio,this.nombreSede);
	}
	
	public boolean esMismaEntrada (IEntrada otra) {
		if (!(otra instanceof Entrada)) return false;
		Entrada entradaBuscada = (Entrada) otra;
		return this.codigo.equals(entradaBuscada.codigo);
	}
	public boolean esDelSector(String sector) {
		return this.categoria.equals(sector);
	}
	
}
