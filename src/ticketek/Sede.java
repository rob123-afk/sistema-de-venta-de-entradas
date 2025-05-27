package ticketek;

public abstract class Sede {
	
	 protected int capacidad;	
	 protected String direccion;	
	 protected String nombre;	
	 protected int precioBase;
	 //private HashMap<String ,Espectaculo> ListaDeEspectaculos=new HashMap<>();
	 
	 
	 public Sede(String nombre,String direccion, int capacidad){
		 
		 this.nombre=nombre;
		 this.direccion=direccion;
		 this.capacidad=capacidad;
		 
	 }
	 
	 /*
	  * @param nombre 
	 solo habrá una fecha por sede. Y, no pueden
	 haber dos espectáculos distintos el mismo día en la misma sede. Cada espectáculo tiene un
	 código que será único.
	 !se cambió esa definición en el segundo enunciado. 
	 dándole mas peso a la fecha que a la sede.
	entonces quedó que un espectáculo tiene una única funcion por fecha y 
	esta puede ser en cualquier sede, incluso repetir sede en distintos días¡.*/
	 
	 /*void registrarEspectaculo(String nombreEspectaculo, String fecha, int precioBase){
		 
		 if(!ListaDeEspectaculos.containsKey(fecha)) {
				ListaDeEspectaculos.put(nombre, new Espectaculo(nombre));
				} else {
					System.out.println("Espectaculo ya registrado");}
		 
	 }
	 */
	
	public void calcularPrecio() {
    
    }

	public String devolverNombre() {
		return nombre;
	}
	
	public  abstract int devolverCapacidadTotal();
	public abstract int capacidadPorSector(String nombreSector);
	
	
}
