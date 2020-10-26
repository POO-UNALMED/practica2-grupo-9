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
		// Factura f3 = new Factura();
		// f3.finalizarCompra();
		//Writer.Write();
		
		
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
		
		System.out.print("Ingrese su edad: ");
		edad = scan.nextInt();
		System.out.print("Ingrese su metodo de pago (1. Debito / 2. Credito): ");
		metodoPago = scan.nextInt();
		
		if(metodoPago == 1) { debCred = "Debito"; }
		else if(metodoPago == 2) { debCred = "Credito"; }
		
		cliente = new Cliente(edad, debCred);
		// System.out.print(Mensajes.bienvenida());
		// name = scan.next();

		while (!exit) {

			System.out.println(Mensajes.selInicio());
			System.out.print(Mensajes.opcion());
			option = scan.nextInt();

			switch (option) {
			case 1:
				
				boolean menuUsuario = false;
				while (!menuUsuario) {
				
				System.out.println(Mensajes.selUsuario());

				System.out.print(Mensajes.opcion());

				option = scan.nextInt();
//1. Ver nivel afiliacion. \n2. Modificar Afiliacion \n3. Ver tu lista de facturas. \nOtro valor para volver.
				switch (option) {
				case 1:
					
					
					System.out.println(cliente.getNivel_afiliacion());
					
					//System.out.println("Opcion 1.");

					// System.out.println(Factura.facturas.get(1));

					// for(Factura f: Factura.facturas) {
					// System.out.println(f);
					// }

					//System.out.println(Factura.facturas.size());

					break;

				case 2:
					
					System.out.println("1. Aumentar afiliacion. \n2. Disminuir afiliacion.");
					option = scan.nextInt();
					
					if (option == 1) { cliente.aumentarAfiliacion(); }
					else if(option == 2) { cliente.disminuirAfiliacion(); }
					break;

				case 3:
					
					if (cliente.getFacturas().size() == 0) { System.out.println("No tienes facturas para mostrar."); }
					else if(cliente.getFacturas().size() > 0) { System.out.println(cliente.getFacturas().size()); } //Mostrar con el metodo toString
					
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

					System.out.println("Menu tienda.");

					System.out.println(Mensajes.selTienda());

					System.out.print(Mensajes.opcion());

					option = scan.nextInt();

					switch (option) {


					case 1:

						MenuProducto.mostrarProducto();

						System.out.print("Seleccione un id de producto: ");
						option = scan.nextInt();
						System.out.print("Cantidad: ");
						cantidad = scan.nextInt();

						MenuTienda.validarProducto(option, cantidad, productos, cantidades);

						break;

					case 2:
						MenuTienda.mostrarListaProductos(productos, cantidades);

						System.out.print("ingrese el id del producto: ");
						idProducto = scan.nextInt();
						System.out.print("Cantidad a eliminar: ");
						cantidadProducto = scan.nextInt();

						MenuTienda.eliminarProducto(productos, cantidades, idProducto, cantidadProducto);
						break;

					case 3:
						MenuTienda.mostrarListaProductos(productos, cantidades);
						break;

					case 4:
						totalVenta = 0;
						for (int i = 0; i < productos.size(); i++) {
							totalVenta += productos.get(i).getPrecio() * cantidades.get(i);
						}

						new Factura(productos, cantidades, totalVenta, cliente);
						productos.clear();
						cantidades.clear();
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

					System.out.println("Menu Productos.");
					System.out.println(Mensajes.selProductos());
					System.out.print(Mensajes.opcion());
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
						System.out.println("1. Agregar. \n2. Eliminar");
						option = scan.nextInt();
						System.out.print("Ingrese el id del producto: ");
						idProducto = scan.nextInt();
						System.out.print("Cantidad de invenatiro a agregar: ");
						cantidadProducto = scan.nextInt();
						
						MenuProducto.actualizarInventario(option, idProducto, cantidadProducto);
						
						break;

					case 5:

						MenuProducto.mostrarProducto();
						break;

					default:
						menuProductos = true;
						break;
					}
				}
				break;
				
			case 4:
				System.out.println(Factura.facturas.size()); //metodo toString
				break;
				
			case 5:
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
