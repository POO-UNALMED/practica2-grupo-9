package gestorAplicacion.productos;
import java.util.*;

import gestorAplicacion.finanzas.Factura;

public class Juguete extends Producto implements Instructivo {
	private String material;
	private Date fechaSalida;
	private int garantia;
	public static ArrayList<Juguete> productosJuguetes = new ArrayList<Juguete> ();
	
	public Juguete(int codigo,String nombre,int inventario,float precio,
			float inversion,String categoria,
			String tipo,String material,Date fechaSalida, int garantia) {
		super(codigo, nombre, inventario, precio, inversion, categoria, tipo);
		this.setMaterial(material);
		this.setFechaSalida(fechaSalida);
		this.setGarantia(garantia);
		productosJuguetes.add(this);
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
