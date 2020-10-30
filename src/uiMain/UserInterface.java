/*
 * Es la encargada de ejecutar la interfaz de usuario y de interactuar con las funcionalidades de proyecta
 * tambien de instanciar las clases 
 * 
 * se utilizo dos arreglos dianmicos con la finalidad de almacenar de manera temporal los productos y cantidades definidas por los clientes
 * y estos se pasan como parametros para crear las facturas al momento de pagar
 * 
 * El funcionamiento de todos los metodos usados en esta clase estan explicados en sus respectivas clases
 * */
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

		Reader.Read(); //llamada al metodo Read de la clase Reader encargada de cargar los objetos de los .txt a sus respectivas listas dinamicas en cada clase

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

		//Arreglos temporales utilizados con el fin explicado en la cabecera
		List<Producto> productos = new ArrayList<Producto>();
		List<Integer> cantidades = new ArrayList<Integer>();
		
		// seccion encargada de crear un cliente
		System.out.print(Mensajes.edad);
		edad = scan.nextInt();
		System.out.print(Mensajes.debCred);
		metodoPago = scan.nextInt();

		cliente = MenuUsuario.crearCliente(metodoPago, edad);

		System.out.print(Mensajes.bienvenida);
		System.out.println(Mensajes.seccionar);

		while (!exit) {
			
			//Seccion encargada del menu principal
			
			System.out.println(Mensajes.selInicio);
			System.out.println(Mensajes.seccionar);
			System.out.print(Mensajes.opcion);

			option = scan.nextInt();

			switch (option) {
			case 1:
				
				//Seccion encargada del menu de usuario, el cual permite ver nivel de afiliacion, aumentar/disminuir este y ver las facturas asociadas a dicho usuario
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
				
				//Seccion encargada del menu de tienda, el cual permite agregar/quitar un producto al carrito, ver la lista de productos en el carrito y pagar
				
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

				//Seccion encargada del menu de productos. el cual permite crear productos de tipo Aseo/Abarrote/Juguete, actualizar el inventario de estos y
				//ver la lista de todos los productos disponibles en la tienda
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

						System.out.println(Mensajes.agregarQuitar);
						System.out.print(Mensajes.opcion);
						option = scan.nextInt();
						System.out.print(Mensajes.selID);
						idProducto = scan.nextInt();
						System.out.print(Mensajes.agrQuitarInventario);
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
				
				//Seccion encargada de mostrar la lista de todas las facturas de la tienda
				
				System.out.println(Mensajes.seccionar);
				
				for(Factura f: Factura.facturas) {
					System.out.println(f);
				}
				
				System.out.println(Mensajes.seccionar);
				break;

			case 5:
				
				//Seccion encargada de mostrar el producto mas vendido en toda la tienda
				
				System.out.println(Mensajes.seccionar);
				if(Factura.masVendido() != null) {
					System.out.println(Factura.masVendido());
					if(Factura.masVendido() instanceof Aseo) {
						System.out.println(((Aseo) Factura.masVendido()).instrucciones());
					}
					else if (Factura.masVendido() instanceof Abarrote) {
						System.out.println(((Abarrote) Factura.masVendido()).instrucciones());
					}
					else if(Factura.masVendido() instanceof Juguete) {
						System.out.println(((Juguete) Factura.masVendido()).instrucciones());
					}
				}
				else {
					System.out.println(Mensajes.sinFacturas);
				}
				System.out.println(Mensajes.seccionar);

				break;

			case 6:
				
				//Seccion encargada de ver la cantidad total de productos vendidos con tarjeta de debito/credito
				
				System.out.println(Mensajes.seccionar);
				System.out.println(Mensajes.ventasDebCred + Factura.cantProductVentDebCred());
				System.out.println(Mensajes.seccionar);
				break;

			case 7:
				
				//Seccion encargada de mostrar la cantidad (monetaria) de ventas totales en toda la tienda
				
				System.out.println(Mensajes.seccionar);
				System.out.println(Mensajes.venTotales + Factura.ventasTotales());
				System.out.println(Mensajes.seccionar);
				break;

			case 8:
				
				//Seccion encargada de mostrar las ganancias netas de la tienda
				
				System.out.println(Mensajes.seccionar);
				System.out.println(Mensajes.ganNeta + Factura.gananciaNeta());
				System.out.println(Mensajes.seccionar);
				break;
			case 9:
				
				//Seccion encargada de finalizar el programa
				
				System.out.println(Mensajes.seccionar);
				System.out.println(Mensajes.despedida);
				Writer.Write();//llamada al metodo Write de la clase Writer encargada de sobreescribir los objetos de los .txt preservando el estado actual del programa
				exit = true;
				break;
			default:
				//Seccion encargada de notificar al usuario si no se ingreso correctamente un valor numerico definido por el menu
				System.out.println(Mensajes.opcIncorrecta);
			}
		}

	}



}
