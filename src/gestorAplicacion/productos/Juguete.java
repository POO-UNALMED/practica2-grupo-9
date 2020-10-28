package gestorAplicacion.productos;
import java.io.*;
import java.util.*;


public class Juguete extends Producto implements Instructivo, Serializable {
	private String material;
	private Date fechaSalida;
	private int garantia;
	public static List<Juguete> productosJuguetes = new ArrayList<Juguete> ();
	
	public Juguete(int codigo,String nombre,int inventario,float precio,
			float inversion,String categoria,
			String tipo,String material,Date fechaSalida, int garantia) {
		super(codigo, nombre, inventario, precio, inversion, categoria, tipo);
		this.material = material;
		this.fechaSalida = fechaSalida;
		this.garantia = garantia;
		productosJuguetes.add(this);
	}
	
	@Override
	public String toString() {
		return "El nombre del producto es " + this.nombre + ", su precio unitario es " + this.precio + " y tenemos " + this.inventario + " en existencias.";
	}
	@Override
	public String instrucciones() {
		return "\nInstrucciones para el uso de juguetes  \n-Apto para personas de 3 a 98 años. \n-Las baterías no vienen incluidas con el producto. "
				+ "\n-Tratar bien a los juguetes para evitar una escena de Toy Story.";
	}

	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public int getGarantia() {
		return garantia;
	}
	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}

}
