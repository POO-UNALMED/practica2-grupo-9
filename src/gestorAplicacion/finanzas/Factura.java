package gestorAplicacion.finanzas;

import java.time.LocalDate; 
import java.io.Serializable;
import java.util.*;

import gestorAplicacion.productos.Producto;

public class Factura implements Serializable{
	private static int codigo;
	private Date fecha;
	private float descuento;
	private double total;
	private final double IVA = 1.19;
	//private Cliente cliente;
	private List<Producto> productos = new ArrayList<Producto> ();
	private List<Integer> cantidades = new ArrayList<Integer> ();
	public static List<Factura> facturas = new ArrayList<Factura> ();
	
	
	static {
		codigo = 0;
	}
	
	public Factura(List<Producto> productos, List<Integer> cantidades, float total) {
		++codigo;
		fecha = new Date();
		this.total = total * IVA;
		
		for(int i = 0; i < productos.size(); i++) {
			this.productos.add(productos.get(i));
			this.cantidades.add(cantidades.get(i));
		}
		
		//this.productos.addAll(productos);
		//this.cantidades.addAll(cantidades);
		facturas.add(this);
		
	}
	
	
	public String toString() {
		return "codigo: " + codigo + "Articulos: " + productos.get(2).getNombre();
		}
	
	
	
	public int cantProductVentDebCred() {
		return 1;
		}
	
	public String masVendido() {
		return null;
		}
	
	public int ventasTotales() {
		return 1;
	}
	
	public int gananciaNeta() {
		return 1;
	}

	public static int getCodigo() {
		return codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public double getIVA() {
		return IVA;
	}
}
