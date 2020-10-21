package gestorAplicacion.productos;

import java.util.*;

import gestorAplicacion.finanzas.Factura;

public class Aseo extends Producto implements Instructivo{
	private String unidad;
	public static ArrayList<Aseo> productosAseo = new ArrayList<Aseo> ();
	
	public Aseo(int codigo,String nombre,int inventario,float precio,float inversion, String categoria,String tipo,String unidad) {
		super(codigo, nombre, inventario, precio, inversion, categoria, tipo);
		this.setUnidad(unidad);
		productosAseo.add(this);
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

	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

}
