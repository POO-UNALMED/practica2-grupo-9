//Modulo gestorAplicacion finanzas cuyas funcionalidades van destinadas al manejo de facturas de clientes e inventarios de productos
//Clase Factura que se encarga de registrar la venta para cada cliente y actualizar los inventarios con cada compra
package gestorAplicacion.finanzas;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.*;

import gestorAplicacion.productos.Abarrote;
import gestorAplicacion.productos.Aseo;
import gestorAplicacion.productos.Juguete;
import gestorAplicacion.productos.Producto;

public class Factura implements Serializable {
	private int codigo;
	private Date fecha;
	private float descuento;
	private double total;
	private final double IVA = 1.19;
	private Cliente cliente;
	private List<Producto> productos = new ArrayList<Producto>();
	private List<Integer> cantidades = new ArrayList<Integer>();
	public static List<Factura> facturas = new ArrayList<Factura>();

	

	public Factura(List<Producto> productos, List<Integer> cantidades, float total, Cliente cliente) {
		codigo = facturas.size() + 1;
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
	//Metodo actualizarInventario
	//Encargado de actualizar el inventario de los productos cuando se instancia una factua
	//Entradas:
	//-productos recibe un Producto con el proposito de verificar a cual lista de productos pertenece
	//-cantidad es un entero que almacena la cantidad a restar de inventario de dicho producto
	//Salida
	//Actualiza el inventario de un producto
	
	
	
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
	//Metodo actualizarInventario
	//Encargado de actualizar el inventario de los productos cuando se instancia una factua
	//Entradas:
	//-productos recibe un Producto con el proposito de verificar a cual lista de productos pertenece
	//Salida:
	//-Actualiza el inventario de dicho producto restandole 1 unidad
	public void actualizarInventario(Producto producto) {
		List<Aseo> productosAseo = Aseo.productosAseo;
		List<Abarrote> productosAbarrote = Abarrote.productosAbarrotes;
		List<Juguete> productosJuguete = Juguete.productosJuguetes;

		int index = -1;
		int nuevoInventario = 0;
		if (productosAseo.indexOf(producto) != -1) {
			index = productosAseo.indexOf(producto);
			nuevoInventario = productosAseo.get(index).getInventario() - 1;
			productosAseo.get(index).setInventario(nuevoInventario);
		} else if (productosAbarrote.indexOf(producto) != -1) {
			index = productosAbarrote.indexOf(producto);
			nuevoInventario = productosAbarrote.get(index).getInventario() - 1;
			productosAbarrote.get(index).setInventario(nuevoInventario);
		} else if (productosJuguete.indexOf(producto) != -1) {
			index = productosJuguete.indexOf(producto);
			nuevoInventario = productosJuguete.get(index).getInventario() - 1;
			productosJuguete.get(index).setInventario(nuevoInventario);
		}

	}
	
	//Metodo toString que retorna una descripcion de la factura y todos los productos asociados a ella
	public String toString() {
		String impress = "Esta factura se identifica con el codigo: " + codigo + "\nFue expedida en la fecha: " + fecha + "\nFue pagada con: " + cliente.getMetodo_pago() +
				"\nEl cliente tiene un nivel de afiliación de: " + cliente.getNivel_afiliacion() + "\nTotal pagado: " + total +"\nLos productos adquiridos son: ";
		for(int i = 0; i < productos.size(); i ++) {
			impress = impress + "\n" + productos.get(i).getNombre() + " cantidad " + cantidades.get(i);
		}
		return impress;
	}
	//Metodo cantProductVentDebCred que devuelve un entero con la cantidad de productos que se pagaron con Debito o Credito
	
	public static int cantProductVentDebCred() {
		int cant = 0;
		
		
		for (Factura f : facturas) {
			
			if(f.getCliente().getMetodo_pago().compareTo("Debito") == 0 || f.getCliente().getMetodo_pago().compareTo("Credito") == 0) {
				
				cant += f.cantidades.stream().reduce(Integer::sum).get();
			}
			
		}
		
		return cant;
	}
	//Metodo masVendido retorna el objeto producto mas vendido en la tienda
	public static Producto masVendido() {
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
		Producto produc = null;
		for (Producto p : prodxcant.keySet()) {
			if (prodxcant.get(p) > temp) {
				produc = p;
				temp = prodxcant.get(p);
				
			}
		}
		return produc;
		
		//return max;
	}
	//Metodo ventasTotales devuelve la sumatoria del total de todas las ventas hechas.
	public static int ventasTotales() {
		int sum = 0;
		for (Factura f : facturas) {
			sum += f.total;
		}
		return sum;
	}
	//Metodo gananciaNeta que se encarga de recorrer todas las fácturas generadas 
	//y devolver la sumatoria de toda la ganancia (precio de venta - inversion) hasta el momento 
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
	
	//Setter y Getter
	public int getCodigo() {
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
