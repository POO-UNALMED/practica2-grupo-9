package gestorAplicacion.productos;

import java.io.*;

public abstract class Producto implements Serializable {
	private int codigo;
	private String nombre;
	private int inventario;
	private float precio;
	private float inversion;
	private float gananciaNeta;
	private String categoria;
	private String tipo;
	
	public Producto(int codigo,String nombre,int inventario,float precio,float inversion,
			String categoria,String tipo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.inventario = inventario;
		this.precio = precio;
		this.inversion = inversion;
		this.gananciaNeta = (precio - inversion);
		this.categoria = categoria;
		this.tipo = tipo;
	}
	
	public float ganancia() {
		return this.gananciaNeta * this.inventario;
	}
	public float inversion() {
		return this.inversion * this.inventario;
	}
	public abstract String toString();
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getInventario() {
		return inventario;
	}
	public void setInventario(int inventario) {
		this.inventario = inventario;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public float getInversion() {
		return inversion;
	}
	public void setInversion(float inversion) {
		this.inversion = inversion;
	}
	public float getGananciaNeta() {
		return gananciaNeta;
	}
	public void setGananciaNeta(float gananciaNeta) {
		this.gananciaNeta = gananciaNeta;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}

