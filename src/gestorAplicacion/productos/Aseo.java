package gestorAplicacion.productos;

import java.util.*;

public class Aseo extends Producto implements Instructivo{
	private String unidad;
	private static ArrayList<Aseo> productosAseo;
	
	public Aseo(int codigo,String nombre,int inventario,float precio,float inversion,
			String categoria,String tipo,String unidad) {
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
