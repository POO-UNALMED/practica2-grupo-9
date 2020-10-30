/*esta clase tiene como finalidad mostrar el menu de la tienda, donde se llaman los metodos respectivos
 * para cumplir con todas las funcionalidades de este menu.
 */
package uiMain;

import java.util.List;

import gestorAplicacion.finanzas.Cliente;
import gestorAplicacion.finanzas.Factura;
import gestorAplicacion.productos.Abarrote;
import gestorAplicacion.productos.Aseo;
import gestorAplicacion.productos.Juguete;
import gestorAplicacion.productos.Producto;

public class MenuTienda {

	//este metodo mostrara por pantalla todos los productos que hay en existencia en la base de datos
	public static void mostrarListaProductos(List<Producto> productos, List<Integer> cantidades) {
		int index;
		if (!productos.isEmpty()) {
			System.out.println(Mensajes.carritoCompras);
			System.out.println(Mensajes.cabeceras);
			for (int i = 0; i < productos.size(); i++) {
				index = i + 1;
				System.out.println("| " + index + "  |  "+ productos.get(i).getCodigo() + "  |  " + productos.get(i).getNombre() + "  |  "
						+ cantidades.get(i) + "  |  " + productos.get(i).getPrecio());
			}
		} else {
			System.out.println(Mensajes.sinProductos);
		}

	}
	
	//con este metodo se pede agregar un nuevo producto a la base de datos
	public static void agregarProducto(Producto producto, int cantidad, List<Producto> productos, List<Integer> cantidades) {
		int index;
		int aumento;
		if (productos.indexOf(producto) == -1) {

			if (cantidad <= producto.getInventario()) {
				productos.add(producto);
				cantidades.add(cantidad);
				System.out.println(Mensajes.exitoAgregar);
			} else {
				System.out.println(Mensajes.productoNoAgregado);
			}
		} else {
			
			index = productos.indexOf(producto);
			aumento = cantidades.get(index) + cantidad;
			
			if (cantidad <= producto.getInventario() && aumento <= producto.getInventario()) {
				cantidades.set(index, aumento);
				System.out.println(Mensajes.exitoAgregar);
			} else {
				System.out.println(Mensajes.productoNoAgregado);
			}

		}
	}

	//este metodo actualiza los productos existentes y de esta manera no tener productos repetidos
	public static void validarProducto(int idProducto, int cantidad, List<Producto> productos, List<Integer> cantidades) {
		
		int index = -1; 
		
		if (MenuProducto.validarListas(1, idProducto)) {
			
			index = idProducto - 1;
			agregarProducto(Aseo.productosAseo.get(index), cantidad, productos, cantidades);
			
		} else if (MenuProducto.validarListas(2, idProducto)) {

			index = idProducto - Aseo.productosAseo.size() - 1;
			agregarProducto(Abarrote.productosAbarrotes.get(index), cantidad, productos, cantidades);

		} else if (MenuProducto.validarListas(3, idProducto)) {

			index = idProducto - (Aseo.productosAseo.size() + Abarrote.productosAbarrotes.size()) - 1;
			agregarProducto(Juguete.productosJuguetes.get(index), cantidad, productos, cantidades);
			
		} else {
			System.out.println(Mensajes.noExisteID);
		}
	}
	
	//este metodo nos sirve para eliminar un producto de la base de datos
	public static void eliminarProducto(List<Producto> producto, List<Integer> cantidades, int id, int cantidad) {
		int index = id - 1;
		int eliminar;

		if (cantidades.get(index) >= cantidad && cantidad > 0) {

			if (cantidades.get(index) > cantidad) {
				eliminar = cantidades.get(index) - cantidad;
				cantidades.set(index, eliminar);
			} else {
				producto.remove(index);
				cantidades.remove(index);
			}
			System.out.println(Mensajes.borradoExitoso);
		} else {
			System.out.println(Mensajes.datosIncorrectos);
		}

	}
	
	//con este metodo hacemos la accion de pagar despues de que el cliente ya haya seleccionado los productos que va a llevar
	public static void pagar(List<Producto> productos, List<Integer> cantidades, Cliente cliente) {
		int totalVenta = 0;
		for (int i = 0; i < productos.size(); i++) {
				totalVenta += productos.get(i).getPrecio() * cantidades.get(i);
			}
		new Factura(productos, cantidades, totalVenta, cliente);
		productos.clear();
		cantidades.clear();
		
		System.out.println(Mensajes.compraExitosa);
	}

	
}
