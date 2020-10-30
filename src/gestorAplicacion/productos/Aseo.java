//Clase Aseo hereda atributos de Producto y metodo de Instructivo, y agrupa los productos de tipo Aseo

package gestorAplicacion.productos;

import java.io.*;
import java.util.*;

public class Aseo extends Producto implements Instructivo, Serializable{
	private String unidad;
	public static List<Aseo> productosAseo = new ArrayList<Aseo> ();
	
	
	public Aseo() {
		this(1, "NaN", 0, 0, 0, "NaN", "NaN","NaN");
		
	}
	
	public Aseo(int codigo,String nombre,int inventario,float precio,float inversion, String categoria,String tipo,String unidad) {
		super(codigo, nombre, inventario, precio, inversion, categoria, tipo);
		this.unidad = unidad;
		productosAseo.add(this);
	}
	
	//Metodo toString que sobreescribe el de la clase padre Producto y retorna una descripcion del producto con nombre, precio e inventario
	@Override
	public String toString() {
		return "El nombre del producto es " + this.nombre + ", su precio unitario es " + this.precio + " y tenemos " + this.inventario + " en existencias.";
	}
	//Metodo instrucciones que sobreescribe el de la clase padre Instructivo y retorna unas instrucciones a considerar del producto
	@Override
	public String instrucciones() {
		return "\nInstrucciones para el uso de implementos de aseo:  \n-Mantener en un lugar fresco y seco."
				+ " \n-Mantener fuera del alcance de los niños. \n-En caso de contacto de detergente con los ojos, lavar con abundante agua, si la molestia persiste, favor comunicarse con su médico.";
	}
	
	//Setter y Getter
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

}
