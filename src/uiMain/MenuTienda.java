package uiMain;

import java.util.List;

import gestorAplicacion.productos.Abarrote;
import gestorAplicacion.productos.Aseo;
import gestorAplicacion.productos.Juguete;
import gestorAplicacion.productos.Producto;

public class MenuTienda {

	public static void mostrarListaProductos(List<Producto> productos, List<Integer> cantidades) {
		int index;
		if (!productos.isEmpty()) {
			System.out.println("id --- Codigo --- Nombre --- Cantidad --- Precio Unidad");
			for (int i = 0; i < productos.size(); i++) {
				index = i + 1;
				System.out.println(index + "  |  "+ productos.get(i).getCodigo() + "  |  " + productos.get(i).getNombre() + "  |  "
						+ cantidades.get(i) + "  |  " + productos.get(i).getPrecio());
			}
		} else {
			System.out.println("No hay productos agregados.");
		}

	}
	
	public static void agregarProducto(Producto producto, int cantidad, List<Producto> productos, List<Integer> cantidades) {
		int index;
		int aumento;
		if (productos.indexOf(producto) == -1) {

			if (cantidad <= producto.getInventario()) {
				productos.add(producto);
				cantidades.add(cantidad);
				System.out.println("Agregado exitosamente");
			} else {
				System.out.println("No se pudo agregar el producto");
			}
		} else {
			index = productos.indexOf(producto);
			aumento = cantidades.get(index) + cantidad;

			if (cantidad <= producto.getInventario()) {
				cantidades.set(index, aumento);
				System.out.println("Agregado exitosamente");
			} else {
				System.out.println("No se pudo agregar el producto");
			}

		}
	}
	
	public static void validarProducto(int idProducto, int index, int cantidad, List<Producto> productos, List<Integer> cantidades) {
		if (idProducto <= Aseo.productosAseo.size()) {
			
			index = idProducto;
			agregarProducto(Aseo.productosAseo.get(--index), cantidad, productos, cantidades);
			
		} else if (idProducto <= (Aseo.productosAseo.size() + Abarrote.productosAbarrotes.size()) && 
				(idProducto - Aseo.productosAseo.size()) <= Abarrote.productosAbarrotes.size()) {

			index = idProducto - Aseo.productosAseo.size();
			agregarProducto(Abarrote.productosAbarrotes.get(--index), cantidad, productos, cantidades);

		} else if (idProducto <= (Aseo.productosAseo.size() + Abarrote.productosAbarrotes.size() + Juguete.productosJuguetes.size()) && 
				  (idProducto - (Aseo.productosAseo.size() + Juguete.productosJuguetes.size())) <= Juguete.productosJuguetes.size()) {

			index = idProducto - (Aseo.productosAseo.size() + Juguete.productosJuguetes.size());
			agregarProducto(Juguete.productosJuguetes.get(--index), cantidad, productos, cantidades);
			
		} else {
			System.out.println("No existe el numero de producto.");
		}
	}
	
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
			System.out.println("Se ha borrado exitosamente");
		} else {
			System.out.println("Ingresa correctamente los datos.");
		}

	}

	
}
