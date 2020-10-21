package uiMain;

import java.util.*;

import BaseDatos.Reader;
import BaseDatos.Writer;
import gestorAplicacion.finanzas.Factura;
import gestorAplicacion.productos.Abarrote;
import gestorAplicacion.productos.Aseo;
import gestorAplicacion.productos.Juguete;

public class UserInterface {

	public static void main(String[] args) {
		// Reader.Read();
		// Factura f2 = new Factura();
		// f2.finalizarCompra();
		// Writer.Write();

		Scanner scan = new Scanner(System.in);

		String name;
		int option;
		boolean exit = false;

		System.out.print(Mensajes.bienvenida());
		name = scan.next();

		while (!exit) {

			System.out.println(Mensajes.selInicio());
			System.out.print("Opcion: ");
			option = scan.nextInt();

			switch (option) {
			case 1:
				System.out.println(Mensajes.selUsuario());

				System.out.print("Opcion: ");

				option = scan.nextInt();

				switch (option) {
				case 1:
					System.out.println("Opcion 1.");
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
				System.out.println("Escogiste la opcion 2.");
				break;
			case 3:
				System.out.println("Menu Productos.");
				System.out.println(
						"1. Crear producto de Aseo. \n2. Crear producto de Abarrote. \n3. Crear producto de Juguete. \n4. Ver lista de productos. \nOtro valor para volver.");
				System.out.println("Opcion: ");
				option = scan.nextInt();

				switch (option) {
				case 1:
					int codigo;
					String nombre;
					int inventario;
					float precio;
					System.out.print("Codigo: ");
					codigo = scan.nextInt();
					System.out.print("Nombre: ");
					nombre = scan.next();
					System.out.print("inventario: ");
					inventario = scan.nextInt();
					System.out.print("Precio: ");
					precio = scan.nextFloat();

					// Aseo newProduct = new Aseo
					break;
				case 2:
					break;

				case 3:
					break;

				case 4:
					System.out.println("Lista de productos.");
					System.out.println("Codigo --- Nombre --- Inventario --- Precio");

					if (!Aseo.productosAseo.isEmpty()) {
						for (Aseo aseo : Aseo.productosAseo) {
							System.out.println(aseo.getCodigo() + " " + aseo.getNombre() + " " + aseo.getInventario()
									+ " " + aseo.getPrecio());
						}
					} else {System.out.println("No hay productos de Aseo :(");}
					if (!Abarrote.productosAbarrotes.isEmpty()) {
						for (Abarrote abarrote : Abarrote.productosAbarrotes) {
							System.out.println(abarrote.getCodigo() + " " + abarrote.getNombre() + " "
									+ abarrote.getInventario() + " " + abarrote.getPrecio());
						}
					} else {System.out.println("No hay Abarrotes :(");}
					if (!Juguete.productosJuguetes.isEmpty()) {
						for (Juguete juguete : Juguete.productosJuguetes) {
							System.out.println(juguete.getCodigo() + " " + juguete.getNombre() + " "
									+ juguete.getInventario() + " " + juguete.getPrecio());
						}
					} else {System.out.println("No hay Juguetes :(");}
					break;

				default:
					break;
				}

				break;

			case 4:
				System.out.println("Adios.");
				exit = true;
				break;
			default:
				System.out.println("Opcion incorrecta. ");
			}
		}

	}

	// Functions

	public void crearProducto(int opcion) {

		switch (opcion) {
		case 1:
			// Aseo
			// new Aseo();
		case 2:
			// Abarrote
			// new Abarrote();
		case 3:
			// Juguete
			// new Juguete();
		}

	}

}
