package ticketek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Funcion {
    
    private Sede sede;
    private String fecha;
    private double precioBase;
    private List<IEntrada> entradasDisponibles;
    private List<IEntrada> entradasVendidas;

    public Funcion(Sede sede, String fecha, double precioBase) {
        if(sede == null) {
        	throw new RuntimeException("Por favor ingresar una sede donde es la funcion");
        }
        if(fecha == null || fecha.isEmpty()) {
        	throw new RuntimeException("Por favor ingresar una fecha valida para la entrada");
        }
        if(precioBase < 0) {
        	throw new RuntimeException("Por favor ingresar un precio mayor a cero para la funcion");
        }
        this.sede = sede;
        this.fecha = fecha;
        this.precioBase = precioBase;
        this.entradasDisponibles = new ArrayList<>();
        this.entradasVendidas = new ArrayList<>();
    }

    public String getFecha() {
        return fecha;
    }
    
    public double devolverPrecio() {
    	return precioBase;
    }
    
    public double devolverPrecioPlateaBaja() {
    	return precioBase * 1.50;
    }
    
    public double devolverPrecioVIP() {
    	return precioBase * 1.70;
    }
    
    public double devolverPrecioPlateaComun() {
    	return precioBase * 1.40;
    }
    
    public double devolverPrecioSector(String sector) {
    	double costoEntrada = 0;
		switch(sector){
		case "Platea Baja":
		case "Baja":
			costoEntrada += precioBase * 1.50;
			break;
        case "Platea Alta":
        case "Alta":
        	costoEntrada += precioBase;
        	break;
        case "Platea VIP":
        case "VIP":
        	costoEntrada += precioBase * 1.70;
        	break;
        case "Platea Comun":
        case "Comun":
        case "Común":
        case "Platea Común":
        	costoEntrada += precioBase * 1.40;
        	break;
			}
		return costoEntrada;
    }
    
    public String toString() {
    	return "Sede: " + sede + ", Fecha: " + fecha + ", Precio base: $" + precioBase;
    }
    
    public void agregarEntradaDisponible(IEntrada entrada) {
    	entradasDisponibles.add(entrada);
    }
    
    public void agregarEntradaVendida(IEntrada entrada) {
    	entradasVendidas.add(entrada);
    }
    
    public double calcularConsumicionMiniestadio(IEntrada entrada) {
    	if(this.sede instanceof Miniestadio) {
    		String sectorEntrada = entrada.ubicacion();
    		  if(sectorEntrada.equals("VIP")) {
    			  return 20000.0;
    		  } else{
    			  return 15000.0;
    		  }
    		
    	}
    	else {
    		return 0.0;
    	}
    }
    
    public boolean venderEntrada(IEntrada entrada) {
    	if (entradasDisponibles.remove(entrada)) {
    		entradasVendidas.add(entrada);
    		return true;
    	}
    	return false;
    }
    
    public void eliminarEntradasVendidasDeDisponibles() {
    	HashMap<String, IEntrada> mapaDeEntradasDisponibles = new HashMap<>();
    	for (IEntrada entrada : entradasDisponibles) {
    		mapaDeEntradasDisponibles.put(entrada.obtenerCodigo(), entrada);
    	}
    	
    	Iterator<Map.Entry<String, IEntrada>> iterador = mapaDeEntradasDisponibles.entrySet().iterator();
    	while(iterador.hasNext()) {
    		Map.Entry<String, IEntrada> indice = iterador.next();
    		if (entradasVendidas.contains(indice.getValue()));{
    			iterador.remove();
    		}
    	}
    	
    	entradasDisponibles = new ArrayList<>(mapaDeEntradasDisponibles.values());
    }
    
    public List<IEntrada> devolverEntradasVendidas(){
    	return new ArrayList<>(entradasVendidas);
    }
    public List<IEntrada> devolverEntradasDisponibles(){
    	return new ArrayList<>(entradasDisponibles);
    }
    
   public int entradasVendidasPorSector(String nombreSector) {
	   int contador = 0;
	   for (IEntrada entrada : entradasVendidas) {
		   if (entrada instanceof Entrada entradaConcreta) {
			   String sector = entradaConcreta.ubicacion();
			   if (normalizarSector(nombreSector).equals(normalizarSector(sector))) {
				   contador++;
			   }
		   }
	   }
	   return contador;
   }

public Sede devolverSede() {
	return sede;
}


 public double costoTotalDeLasEntradasVendidasPorSede(Funcion funcion, String nombreSede) {
	 double total = 0;
	 if(funcion.devolverSede().devolverNombre().equals(nombreSede)) {
		 if(entradasVendidas != null && !entradasVendidas.isEmpty()) {
			 for(IEntrada entrada : entradasVendidas) {
				 if(entrada != null) {
					 double precioEntrada = funcion.calcularConsumicionMiniestadio(entrada) + entrada.precio();
					 total += precioEntrada;
				 }
			 }
		 }
	 }
	 return total;
 }
 
 public double costoTotalDeLasEntradasVendidasPorEspectaculo(Funcion funcion) {
	 double total = 0;
		 if(entradasVendidas != null && !entradasVendidas.isEmpty()) {
			 for(IEntrada entrada : entradasVendidas) {
				 if(entrada != null) {
					 double precioEntrada = funcion.calcularConsumicionMiniestadio(entrada) + entrada.precio();
					 total += precioEntrada;				 
			 }
		 }
	 }
	 return total;
 }
	public String normalizarSector(String sector) {
		if (sector == null) return "";
		sector = sector.trim().toLowerCase();
		switch (sector) {
		case "vip":
		case "platea vip":
			return "VIP";
		case "comun":
		case "común":
		case "platea comun":
		case "platea común":
			return "Comun";
		case "baja":
		case "platea baja":
			return "Baja";
		case "alta":
		case "platea alta":
			return "Alta";
		default:
			return sector;
		}
	}
}