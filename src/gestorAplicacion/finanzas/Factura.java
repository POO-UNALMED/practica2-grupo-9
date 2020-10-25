package gestorAplicacion.finanzas;

import java.time.LocalDate; 
import java.io.Serializable;
import java.util.*;

import gestorAplicacion.productos.Abarrote;
import gestorAplicacion.productos.Aseo;
import gestorAplicacion.productos.Juguete;
import gestorAplicacion.productos.Producto;

public class Factura implements Serializable{
	private static int codigo;
	private Date fecha;
	private float descuento;
	private double total;
	private final double IVA = 1.19;
	private Cliente cliente;
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
			actualizarInventario(productos.get(i), cantidades.get(i));
			
		}
		
		
		
		facturas.add(this);
		
	}
	
	public void actualizarInventario(Producto producto, int cantidad) {
		List<Aseo> productosAseo = Aseo.productosAseo;
		List<Abarrote> productosAbarrote = Abarrote.productosAbarrotes;
		List<Juguete> productosJuguete = Juguete.productosJuguetes;
		
		int index = -1;
		int nuevoInventario = 0;
		if (productosAseo.indexOf(producto) != -1) {
			index = productosAseo.indexOf(producto);
			nuevoInventario = productosAseo.get(index).getInventario() - cantidad;
			productosAseo.get(index).setInventario(nuevoInventario);
		}
		else if (productosAbarrote.indexOf(producto) != -1) {
			index = productosAbarrote.indexOf(producto);
			nuevoInventario = productosAbarrote.get(index).getInventario() - cantidad;
			productosAbarrote.get(index).setInventario(nuevoInventario);
		}
		else if (productosJuguete.indexOf(producto) != -1) {
			index = productosJuguete.indexOf(producto);
			nuevoInventario = productosJuguete.get(index).getInventario() - cantidad;
			productosJuguete.get(index).setInventario(nuevoInventario);
		}
		
		
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
