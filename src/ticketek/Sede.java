package ticketek;
import java.util.*;
public class Sede {
	
	 int capacidad;	
	 public String direccion;	
	 public String nombre;	
	 int precioBase;
	 private HashMap<String ,Espectaculo> ListaDeEspectaculos=new HashMap<>();
	 
	 
	 public Sede(String nombre,String direccion, int capacidad){
		 
		 this.nombre=nombre;
		 this.direccion=direccion;
		 this.capacidad=capacidad;
		 
	 }
	 
	 /*
	  * @param nombre 
	 solo habrá una fecha por sede. Y, no pueden
	 haber dos espectáculos distintos el mismo día en la misma sede. Cada espectáculo tiene un
	 código que será único.*/
	 
	 void registrarEspectaculo(String nombreEspectaculo, String fecha, int precioBase){
		 
		 if(!ListaDeEspectaculos.containsKey(fecha)) {
				ListaDeEspectaculos.put(fecha, new Espectaculo(nombre));
				} else {
					System.out.println("Fecha ya registrada");}
		 
	 }
	
	public double calcularPrecio() {
    return precioBase;
    }
}
