package gestorAplicacion.finanzas;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.*;

import gestorAplicacion.productos.Abarrote;
import gestorAplicacion.productos.Aseo;
import gestorAplicacion.productos.Juguete;
import gestorAplicacion.productos.Producto;

public class Factura implements Serializable {
	private static int codigo;
	private Date fecha;
	private float descuento;
	private double total;
	private final double IVA = 1.19;
	private Cliente cliente;
	private List<Producto> productos = new ArrayList<Producto>();
	private List<Integer> cantidades = new ArrayList<Integer>();
	public static List<Factura> facturas = new ArrayList<Factura>();

	static {
		codigo = 0;
	}

	public Factura(List<Producto> productos, List<Integer> cantidades, float total, Cliente cliente) {
		++codigo;
		fecha = new Date();
		this.total = total * (1 - (descuento / 100)) * IVA;

		this.cliente = cliente;

		for (int i = 0; i < productos.size(); i++) {
			this.productos.add(productos.get(i));
			this.cantidades.add(cantidades.get(i));
			actualizarInventario(productos.get(i), cantidades.get(i));

		}

		facturas.add(this);
		cliente.agregarFactura(this);

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
		} else if (productosAbarrote.indexOf(producto) != -1) {
			index = productosAbarrote.indexOf(producto);
			nuevoInventario = productosAbarrote.get(index).getInventario() - cantidad;
			productosAbarrote.get(index).setInventario(nuevoInventario);
		} else if (productosJuguete.indexOf(producto) != -1) {
			index = productosJuguete.indexOf(producto);
			nuevoInventario = productosJuguete.get(index).getInventario() - cantidad;
			productosJuguete.get(index).setInventario(nuevoInventario);
		}

	}

	public String toString() {
		return "codigo: " + codigo + " Articulos: " + productos.get(0).getNombre();
	}

	public static int cantProductVentDebCred() {
		int cant = 0;
		for (Factura f : facturas) {
			if (f.getCliente().getMetodo_pago() == "Debito" || f.getCliente().getMetodo_pago() == "Credito") {
				cant += f.cantidades.stream().reduce(Integer::sum).get();
			}
		}
		return cant;
	}

	public static String masVendido() {
		HashMap<Producto, Integer> prodxcant = new HashMap<Producto, Integer>();
		for (Factura f : facturas) {
			for (int i = 0; i < f.productos.size(); i++) {
				Producto key = f.productos.get(i);
				int value = f.cantidades.get(i);
				if (prodxcant.containsKey(key)) {
					int oldValue = prodxcant.get(key);
					prodxcant.replace(key, oldValue + value);
				} else
					prodxcant.put(key, value);
			}
		}
		int temp = 0;
		String max = "No hay facturas aún";
		for (Producto p : prodxcant.keySet()) {
			if (prodxcant.get(p) > temp) {
				max = p.getNombre();
				temp = prodxcant.get(p);
			}
		}
		return max;
	}

	public static int ventasTotales() {
		int sum = 0;
		for (Factura f : facturas) {
			sum += f.total;
		}
		return sum;
	}

	public static float gananciaNeta() {
		int ganancia = 0;
		for (Factura f : facturas) {
			int parcial = 0;
			for (int i = 0; i < f.productos.size(); i++) {
				double inv = f.productos.get(i).getInversion() * f.getIVA();
				double inversion = inv * f.cantidades.get(i);
				parcial += inversion;
			}
			ganancia += f.total - parcial;
		}
		return ganancia;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
