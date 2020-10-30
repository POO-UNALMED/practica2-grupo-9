/* esta clase tiene como finalidad mostrar el menu de la tienda, donde se llaman los metodos respectivos
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

	/* Este metodo mostrara por pantalla todos los productos almacenados en el carrito de compras del cliente
	 * Entrada:
	 * - productos es una lista que contiene todos los objetos de las subclases de productos almacenadas en carrito
	 * - cantidades es una lista que contiene las cantidades de cada producto que el cliente selecciono
	 */
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
	
	/* Encargado de agregar el producto y la cantidad seleccionada por el cliente al carrito de compras
	 * Entradas:
	 * -producto es el objeto de tipo producto seleccionado por el cliente
	 * -cantidad es la cantidad del producto seleccionado
	 * -productos es la lista que simula al carrito de compras y en la cual se almacena la instancia de producto
	 * -cantidades es lista que almacena las cantidades de los productos seleccionados por el cliente
	 * Salidas
	 * almacenar dichos datos en esas listas 
	 */
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

	/* Encargado de validar si el producto seleccionado por el usuario existe en la base de datos y almacenando este al carrito si es correcto
	 * Entradas:
	 * -idProducto entero que representa el id del producto seleccionado por el cliente
	 * -cantida entero que representa la cantidad de dicho producto que quiere el cliente
	 * -productos es la lista que simula al carrito de compras y en la cual se almacena la instancia de producto
	 * -cantidades es lista que almacena las cantidades de los productos seleccionados por el cliente
	 * Salida
	 * Llama al metodo agregarProducto o en su defecto envia un mensaje de error al cliente 
	 */
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
	
	/* Encargado de eliminar parte del producto o en su totalidad del carrito de compras
	 * Entradas:
	 * -productos es la lista que simula al carrito de compras y en la cual se almacena la instancia de producto
	 * -cantidades es lista que almacena las cantidades de los productos seleccionados por el cliente
	 * -id representa el id del producto dentro del carrito de compras
	 * -cantidad representa la cantidad a eliminar de dicho producto en el carrito de compras
	 * Salida:
	 * Actualiza el carrito de compras con la nueva cantidad o en su defecto elimina dicho producto del carrito
	 */
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
	
	/* con este metodo hacemos la accion de pagar despues de que el cliente ya haya seleccionado los productos que va a llevar
	 * Entradas
	 * -productos es la lista que simula al carrito de compras y en la cual se almacena la instancia de producto
	 * -cantidades es lista que almacena las cantidades de los productos seleccionados por el cliente
	 * -cliente representa al cliente al cual va asociado la factura
	 * Salida
	 * Construye con estos datos una nueva factura
	 */
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
