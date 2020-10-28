package uiMain;

import java.util.*;

import BaseDatos.Reader;
import BaseDatos.Writer;
import gestorAplicacion.finanzas.Cliente;
import gestorAplicacion.finanzas.Factura;
import gestorAplicacion.productos.Abarrote;
import gestorAplicacion.productos.Aseo;
import gestorAplicacion.productos.Juguete;
import gestorAplicacion.productos.Producto;

public class UserInterface {

	public static void main(String[] args) {

		Reader.Read();

		Scanner scan = new Scanner(System.in);

		int metodoPago;
		int edad;
		String debCred = "";
		int option;
		int cantidadProducto;
		int idProducto;
		float totalVenta;
		boolean exit = false;
		Cliente cliente;

		List<Producto> productos = new ArrayList<Producto>();
		List<Integer> cantidades = new ArrayList<Integer>();

		System.out.print(Mensajes.edad);
		edad = scan.nextInt();
		System.out.print(Mensajes.debCred);
		metodoPago = scan.nextInt();

		cliente = MenuUsuario.crearCliente(metodoPago, edad);

		System.out.print(Mensajes.bienvenida);
		System.out.println(Mensajes.seccionar);

		while (!exit) {

			System.out.println(Mensajes.selInicio);
			System.out.println(Mensajes.seccionar);
			System.out.print(Mensajes.opcion);

			option = scan.nextInt();

			switch (option) {
			case 1:

				boolean menuUsuario = false;
				while (!menuUsuario) {

					System.out.println(Mensajes.seccionar);
					System.out.println(Mensajes.menuCliente);
					System.out.println(Mensajes.selUsuario);
					System.out.println(Mensajes.seccionar);
					System.out.print(Mensajes.opcion);

					option = scan.nextInt();

					switch (option) {
					case 1:

						System.out.println(Mensajes.mensajeNivelAfiliacion + cliente.getNivel_afiliacion());

						break;

					case 2:

						System.out.println(Mensajes.afiliacion);
						System.out.print(Mensajes.opcion);
						option = scan.nextInt();

						MenuUsuario.modifAfiliacion(option, cliente);
						break;

					case 3:

						MenuUsuario.facturasCliente(cliente);

						break;

					default:
						menuUsuario = true;
						break;
					}
				}
				break;

			case 2:

				boolean menuTienda = false;
				while (!menuTienda) {

					int cantidad = -1;
					int index = 0;

					System.out.println(Mensajes.seccionar);
					System.out.println(Mensajes.menuTienda);

					System.out.println(Mensajes.selTienda);
					System.out.println(Mensajes.seccionar);
					System.out.print(Mensajes.opcion);

					option = scan.nextInt();

					switch (option) {

					case 1:

						System.out.println(Mensajes.seccionar);
						MenuProducto.mostrarProducto();
						System.out.println(Mensajes.seccionar);

						System.out.print(Mensajes.selID);
						option = scan.nextInt();
						System.out.print(Mensajes.cantidad);
						cantidad = scan.nextInt();

						MenuTienda.validarProducto(option, cantidad, productos, cantidades);

						break;

					case 2:

						System.out.println(Mensajes.seccionar);
						MenuTienda.mostrarListaProductos(productos, cantidades);
						System.out.println(Mensajes.seccionar);
						if (productos.size() > 0) {
							System.out.print(Mensajes.selID);
							idProducto = scan.nextInt();
							System.out.print(Mensajes.cantidad);
							cantidadProducto = scan.nextInt();

							MenuTienda.eliminarProducto(productos, cantidades, idProducto, cantidadProducto);
						}

						break;

					case 3:
						System.out.println(Mensajes.seccionar);
						MenuTienda.mostrarListaProductos(productos, cantidades);

						break;

					case 4:
						System.out.println(Mensajes.seccionar);
						MenuTienda.pagar(productos, cantidades, cliente);

						break;

					default:
						menuTienda = true;
						break;

					}
				}

				break;

			case 3:

				boolean menuProductos = false;
				while (!menuProductos) {

					System.out.println(Mensajes.seccionar);
					System.out.println(Mensajes.menuProducto);
					System.out.println(Mensajes.selProductos);
					System.out.println(Mensajes.seccionar);
					System.out.print(Mensajes.opcion);
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
						System.out.println(Mensajes.seccionar);
						MenuProducto.mostrarProducto();
						System.out.println(Mensajes.seccionar);

						System.out.println("1. Agregar. / 2. Eliminar");
						System.out.print(Mensajes.opcion);
						option = scan.nextInt();
						System.out.print(Mensajes.selID);
						idProducto = scan.nextInt();
						System.out.print("Cantidad de inventario a Agregar/Quitar: ");
						cantidadProducto = scan.nextInt();

						MenuProducto.actualizarInventario(option, idProducto, cantidadProducto);

						break;

					case 5:
						System.out.println(Mensajes.seccionar);
						MenuProducto.mostrarProducto();
						break;

					default:
						menuProductos = true;
						break;
					}
				}
				break;

			case 4:
				System.out.println(Mensajes.seccionar);
				
				for(Factura f: Factura.facturas) {
					System.out.println(f);
				}
				
				System.out.println(Mensajes.seccionar);
				break;

			case 5:
				System.out.println(Mensajes.seccionar);
				Factura.masVendido();
				System.out.println(Mensajes.seccionar);

				break;

			case 6:
				System.out.println(Mensajes.seccionar);
				System.out.println("La cantidad de productos vendidos con tarjetas de debito o credito es de: " + Factura.cantProductVentDebCred());
				System.out.println(Mensajes.seccionar);
				break;

			case 7:
				System.out.println(Mensajes.seccionar);
				System.out.println("Las ventas totales son de: " + Factura.ventasTotales());
				System.out.println(Mensajes.seccionar);
				break;

			case 8:
				System.out.println(Mensajes.seccionar);
				System.out.println("La ganacia neta es de: " + Factura.gananciaNeta());
				System.out.println(Mensajes.seccionar);
				break;
			case 9:
				System.out.println(Mensajes.seccionar);
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

	// totalVenta = 0;
	// for (int i = 0; i < productos.size(); i++) {
	// totalVenta += productos.get(i).getPrecio() * cantidades.get(i);
	// }

	// new Factura(productos, cantidades, totalVenta, cliente);
	// productos.clear();
	// cantidades.clear();

}
