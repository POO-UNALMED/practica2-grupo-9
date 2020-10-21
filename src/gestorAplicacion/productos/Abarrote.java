package gestorAplicacion.productos;
import java.util.*;

import gestorAplicacion.finanzas.Factura;

public class Abarrote extends Producto implements Instructivo {
	private Boolean perecedero;
	private String unidad;
	public static ArrayList<Abarrote> productosAbarrotes = new ArrayList<Abarrote> ();
	
	public Abarrote(int codigo,String nombre,int inventario,float precio,float inversion,
			String categoria,String tipo,Boolean perecedero,String unidad) {
		super(codigo, nombre, inventario, precio, inversion, categoria, tipo);
		this.setPerecedero(perecedero);
		this.setUnidad(unidad);
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
