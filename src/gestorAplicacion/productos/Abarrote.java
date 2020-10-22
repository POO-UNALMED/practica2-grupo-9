package gestorAplicacion.productos;
import java.io.*;
import java.util.*;


public class Abarrote extends Producto implements Instructivo, Serializable {
	private Boolean perecedero;
	private String unidad;
	public static List<Abarrote> productosAbarrotes = new ArrayList<Abarrote> ();
	
	public Abarrote(int codigo,String nombre,int inventario,float precio,float inversion,
			String categoria,String tipo,Boolean perecedero,String unidad) {
		super(codigo, nombre, inventario, precio, inversion, categoria, tipo);
		this.perecedero = perecedero;
		this.unidad = unidad;
		productosAbarrotes.add(this);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String instrucciones() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Boolean getPerecedero() {
		return perecedero;
	}
	public void setPerecedero(Boolean perecedero) {
		this.perecedero = perecedero;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

}
