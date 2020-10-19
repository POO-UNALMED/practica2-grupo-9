package gestorAplicacion.finanzas;

import java.time.LocalDate;
import java.util.*;

public class Factura {
	private static int codigo;
	private LocalDate fecha;
	private float descuento;
	private double total;
	private final double IVA = 0.19;
	//private Cliente cliente;
	//private List<Producto> productos = new ArrayList<Producto> ();
	//private List<Int> cantidades = new ArrayList<Int> ();
	private static List<Factura> DBRecibos = new ArrayList<Factura> ();
	
	
	static {
		codigo = 0;
	}
	
	public Factura() {
		++codigo;
	}
	
	public void finalizarCompra() {
		fecha = LocalDate.now();
		DBRecibos.add(this);
	}
	
	public String toString() {
		return null;
		}
	
	
	
	/*public boolean agregarProducto(Producto producto, int cantidad) {
		if (cantidad <= producto.getInventario()) {
			productos.add(producto);
			cantidades.add(cantidades);
			return true;
		} 
		else {
			return false;
		}
		
		
	}
	
	public boolean eliminarProducto(String nombre, int cantidad) {
		int index = -1;
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).getName() == nombre) {
				index = i;
			}
		}
		
		if (cantidades.get(index) <= cantidad && cantidades.get(index) > 0 && index != -1) {
			if(cantidades.get(index) < cantidad) {
				cantidades.get(i) -= cantidad;
			}
			else {
				productos.remove(index);
				cantidades.remove(index);
			}
			return true;
		} else {
			return false;
		}
		
	}*/
	
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
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
