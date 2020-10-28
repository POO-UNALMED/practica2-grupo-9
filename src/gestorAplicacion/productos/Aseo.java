package gestorAplicacion.productos;


import java.io.*;
import java.util.*;


public class Aseo extends Producto implements Instructivo, Serializable{
	private String unidad;
	public static List<Aseo> productosAseo = new ArrayList<Aseo> ();
	
	public Aseo(int codigo,String nombre,int inventario,float precio,float inversion, String categoria,String tipo,String unidad) {
		super(codigo, nombre, inventario, precio, inversion, categoria, tipo);
		this.unidad = unidad;
		productosAseo.add(this);
	}
		
	@Override
	public String toString() {
		return "El nombre del producto es " + this.nombre + ", su precio unitario es " + this.precio + " y tenemos " + this.inventario + " en existencias.";
	}
	@Override
	public String instrucciones() {
		return "\nInstrucciones para el uso de implementos de aseo:  \n-Mantener en un lugar fresco y seco."
				+ " \n-Mantener fuera del alcance de los niños. \n-En caso de contacto de detergente con los ojos, lavar con abundante agua, si la molestia persiste, favor comunicarse con su médico.";
	}

	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

}
