package gestorAplicacion.productos;

import java.util.*;

import gestorAplicacion.finanzas.Factura;

public class Aseo extends Producto implements Instructivo{
	private String unidad;
	public static ArrayList<Aseo> productosAseo = new ArrayList<Aseo> ();
	
	public Aseo(int codigo,String nombre,int inventario,float precio,float inversion, String categoria,String tipo,String unidad) {
		this.setCodigo(codigo);
		this.setNombre(nombre);
		this.setInventario(inventario);
		this.setPrecio(precio);
		this.setInversion(inversion);
		this.setGananciaNeta(precio - inversion);
		this.setCategoria(categoria);
		this.setTipo(tipo);
		this.setUnidad(unidad);
		productosAseo.add(this);
	}
	
	@Override
	public float ganancia() {
		return this.getGananciaNeta();
	}
	@Override
	public float inversion() {
		return this.getInversion();
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
