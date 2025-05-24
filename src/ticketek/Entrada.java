package ticketek;

public class Entrada implements IEntrada  {
	protected String contraseña;
	protected String categoria;
	protected String codigo;
	protected String nombreEspectaculo;
	protected String fecha;
	protected String ubicacion;

	
	public Entrada (String contraseña,String categoria,String codigo, String nombreEspectaculo,String fecha,String ubicacion) {
		this.contraseña = contraseña;
		this.categoria = categoria;
		this.codigo = codigo;
		this.nombreEspectaculo = nombreEspectaculo;
		this.fecha = fecha;
		this.ubicacion = ubicacion;
	}
	
	public double precio() {
		
		return 0;
	}

	public String ubicacion() {
		
		return null;
	}

	@Override
	public String toString() {
		return "Entrada [contraseña=" + contraseña + ", categoria=" + categoria + ", codigo=" + codigo
				+ ", nombreEspectaculo=" + nombreEspectaculo + ", fecha=" + fecha + ", ubicacion=" + ubicacion + "]";
	}
	
	
	public String obtenerCodigo() {
		return codigo;
	}


}
