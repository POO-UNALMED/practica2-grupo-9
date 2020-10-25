package uiMain;

import java.util.*;

import BaseDatos.Reader;
import BaseDatos.Writer;
import gestorAplicacion.finanzas.Factura;
import gestorAplicacion.productos.Abarrote;
import gestorAplicacion.productos.Aseo;
import gestorAplicacion.productos.Juguete;
import gestorAplicacion.productos.Producto;

public class UserInterface {

	public static void main(String[] args) {

		Reader.Read();
		// Factura f3 = new Factura();
		// f3.finalizarCompra();
		Writer.Write();

		Scanner scan = new Scanner(System.in);

		// String name;
		int option;
		int cantidadProducto;
		int idProducto;
		float totalVenta;
		boolean exit = false;

		List<Producto> productos = new ArrayList<Producto>();
		List<Integer> cantidades = new ArrayList<Integer>();

		// System.out.print(Mensajes.bienvenida());
		// name = scan.next();

		while (!exit) {

			System.out.println(Mensajes.selInicio());
			System.out.print(Mensajes.opcion());
			option = scan.nextInt();

			switch (option) {
			case 1:
				System.out.println(Mensajes.selUsuario());

				System.out.print(Mensajes.opcion());

				option = scan.nextInt();

				switch (option) {
				case 1:
					System.out.println("Opcion 1.");
					
					//System.out.println(Factura.facturas.get(1));
					
					//for(Factura f: Factura.facturas) {
					//	System.out.println(f);
					//}
					
					System.out.println(Factura.facturas.size());

					break;

				case 2:
					System.out.println("Opcion 2");
					break;

				case 3:
					System.out.println("Opcion 3");
					break;

				default:
					break;
				}

				break;
			case 2:

				Factura f;
				int cantidad = -1;
				int index = 0;

				System.out.println("Menu tienda.");

				System.out.println(
						"1. Crear. \n2. Agregar producto. \n3. Quitar producto. \n4. Lista de productos. \n5. Pagar. \nPresiona cualquier tecla para salir.");

				System.out.print(Mensajes.opcion());

				option = scan.nextInt();

				switch (option) {
				case 1:
					
					break;

				case 2:
					MenuProducto.mostrarProducto();

					System.out.print("Seleccione un id de producto: ");
					option = scan.nextInt();
					System.out.print("Cantidad: ");
					cantidad = scan.nextInt();
					
					MenuTienda.validarProducto(option, index, cantidad, productos, cantidades);
					
					break;

				case 3:
					MenuTienda.mostrarListaProductos(productos, cantidades);
					
					System.out.print("ingrese el id del producto: ");
					idProducto = scan.nextInt();
					System.out.print("Cantidad a eliminar: ");
					cantidadProducto = scan.nextInt();

					MenuTienda.eliminarProducto(productos, cantidades, idProducto, cantidadProducto);
					break;

				case 4:
					MenuTienda.mostrarListaProductos(productos, cantidades);
					break;

				case 5:
					totalVenta = 0;
					for(int i = 0; i < productos.size(); i++) {
						totalVenta += productos.get(i).getPrecio() * cantidades.get(i);
					}
					
					new Factura(productos, cantidades, totalVenta);
					productos.clear();
					cantidades.clear();
					break;

				}

				break;
			case 3:

				System.out.println("Menu Productos.");
				System.out.println(Mensajes.selProductos());
				System.out.println(Mensajes.opcion());
				option = scan.nextInt();

				switch (option) {
				case 1:

					MenuProducto.crearProducto(1, scan);
					break;

				case 2:

					MenuProducto.crearProducto(2, scan);
					break;

				case 3:

					MenuProducto.crearProducto(3, scan);
					break;

				case 4:

					MenuProducto.mostrarProducto();
					break;

				default:
					break;
				}

				break;

			case 4:
				System.out.println("Adios.");
				Writer.Write();
				exit = true;
				break;
			default:
				System.out.println("Opcion incorrecta. ");
			}
		}

	}

	// Functions

	

	

	

	

	

}
