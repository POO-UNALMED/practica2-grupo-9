package gestorAplicacion.productos;

public abstract class Producto {
	private int codigo;
	private String nombre;
	private int inventario;
	private float precio;
	private float inversion;
	private float gananciaNeta;
	private String categoria;
	private String tipo;
	
	public abstract int ganancia();
	public abstract int inversion();
	
}

