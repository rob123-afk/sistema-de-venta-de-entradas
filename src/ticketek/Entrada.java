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

	//constructor de entrada con categoria
	public Entrada (String contraseña,String categoria,String codigo, String nombreEspectaculo,String fecha,int ubicacion, double precio) {
		this.contraseña = contraseña;
		this.categoria = categoria;
		this.codigo = codigo;
		this.nombreEspectaculo = nombreEspectaculo;
		this.fecha = fecha;
		this.asiento = ubicacion;
		this.precio = precio;
	}
	
	//constructor de campo
	public Entrada (String contraseña,String codigo, String nombreEspectaculo,String fecha, double precio) {
		this.contraseña = contraseña;
		this.categoria = null;
		this.codigo = codigo;
		this.nombreEspectaculo = nombreEspectaculo;
		this.fecha = fecha;
		this.asiento = null;
		this.precio = precio;
	}
	
	

	
	@Override
	public double precio() {
		
		return precio;
	}

	public String ubicacion() {
		
		return categoria;
	}

	
	public String toString() {
		return "Entrada [contraseña=" + contraseña + ", categoria=" + categoria + ", codigo=" + codigo
				+ ", nombreEspectaculo=" + nombreEspectaculo + ", fecha=" + fecha + ", ubicacion=" + asiento + "]";
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
		return new Entrada(this.contraseña,this.codigo,this.nombreEspectaculo, nuevaFecha,this.precio);
	}
	
	public Entrada entradaConNuevaFechaTeatro(String nuevaFecha, String sector, int asiento) {
		return new Entrada(this.contraseña,sector,this.codigo, this.nombreEspectaculo,nuevaFecha,asiento,this.precio);
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
