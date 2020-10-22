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
	private final double IVA = 0.19;
	//private Cliente cliente;
	private List<Producto> productos = new ArrayList<Producto> ();
	private List<Integer> cantidades = new ArrayList<Integer> ();
	public static List<Factura> facturas = new ArrayList<Factura> ();
	
	
	static {
		codigo = 0;
	}
	
	public Factura() {
		++codigo;
	}
	
	public void finalizarCompra() {
		fecha = new Date();
		facturas.add(this);
	}
	
	public String toString() {
		return "codigo: " + codigo + "facturas: " + facturas.size();
		}
	
	
	
	public boolean agregarProducto(Producto producto, int cantidad) {
		if (cantidad <= producto.getInventario()) {
			productos.add(producto);
			cantidades.add(cantidad);
			return true;
		} 
		else {
			return false;
		}
		
		
	}
	
	public boolean eliminarProducto(String nombre, int cantidad) {
		int index = -1;
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).getNombre() == nombre) {
				index = i;
			}
		}
		
		if (cantidades.get(index) <= cantidad && cantidades.get(index) > 0 && index != -1) {
			if(cantidades.get(index) < cantidad) {
				cantidades.set(index, cantidades.get(index) - cantidad);
			}
			else {
				productos.remove(index);
				cantidades.remove(index);
			}
			return true;
		} else {
			return false;
		}
		
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
