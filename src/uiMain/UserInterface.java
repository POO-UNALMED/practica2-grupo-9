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
		 //Factura f3 = new Factura();
		 //f3.finalizarCompra();
		 Writer.Write();

		Scanner scan = new Scanner(System.in);

		String name;
		int option;
		boolean exit = false;
		
		List<Producto> productos = new ArrayList<Producto> ();
		List<Integer> cantidades = new ArrayList<Integer> ();

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
				
				Factura f;
				int cantidad = -1;
				int index = 0;
				
				
				System.out.println("Menu tienda.");
				
				System.out.println("1. Crear. \n2. Agregar producto. \n3. Quitar producto. \n4. Lista de productos. \n5. Pagar. \nPresiona cualquier tecla para salir.");
				
				System.out.print("Opcion: ");

				option = scan.nextInt();
				
				switch (option) {
				case 1:
					f = new Factura();
					break;
				
				case 2:
					mostrarProducto();
					
					System.out.print("Seleccione un producto: ");
					option = scan.nextInt();
					System.out.print("Cantidad: ");
					cantidad = scan.nextInt();
					
					if (option <= Aseo.productosAseo.size()) {
						index = option;
						if(agregarProducto(Aseo.productosAseo.get(--index), cantidad, productos, cantidades)) {
							System.out.println("Agregado exitosamente");
						} else {
							System.out.println("No se pudo agregar el producto");
						}
					} else if(option <= (Aseo.productosAseo.size() + Abarrote.productosAbarrotes.size()) && 
							(option - Aseo.productosAseo.size()) <= Abarrote.productosAbarrotes.size()) {
						index = option - Aseo.productosAseo.size();
						if(agregarProducto(Abarrote.productosAbarrotes.get(--index), cantidad, productos, cantidades)) {
							System.out.println("Agregado exitosamente");
						} else {
							System.out.println("No se pudo agregar el producto");
						}
						
					} else if(option <= (Aseo.productosAseo.size() + Abarrote.productosAbarrotes.size() + Juguete.productosJuguetes.size()) && 
							(option - (Aseo.productosAseo.size() + Juguete.productosJuguetes.size())) <= Juguete.productosJuguetes.size()) {
						index = option - (Aseo.productosAseo.size() + Juguete.productosJuguetes.size());
						if(agregarProducto(Juguete.productosJuguetes.get(--index), cantidad, productos, cantidades)) {
							System.out.println("Agregado exitosamente");
						} else {
							System.out.println("No se pudo agregar el producto");
						}
					} else {
						System.out.println("No existe el numero de producto.");
					}
					
					break;
					
				case 3:
					System.out.println(productos.size());
					break;
				}
				
				
				break;
			case 3:
				//System.out.println(Aseo.productosAseo.size());
				System.out.println("Menu Productos.");
				System.out.println(Mensajes.selProductos());
				System.out.println("Opcion: ");
				option = scan.nextInt();

				switch (option) {
				case 1:
					
					crearProducto(1, scan);
					break;
					
				case 2:
					
					crearProducto(2, scan);
					break;

				case 3:
					
					crearProducto(3, scan);
					break;

				case 4:
					
					mostrarProducto();
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

	public static boolean agregarProducto(Producto producto, int cantidad, List<Producto> productos, List<Integer> cantidades) {
		if (cantidad <= producto.getInventario()) {
			productos.add(producto);
			cantidades.add(cantidad);
			return true;
		} 
		else {
			return false;
		}
		
		
	}
	
	public static void mostrarProducto() {
		System.out.println("Lista de productos.");
		System.out.println("No. --- Codigo --- Nombre --- Inventario --- Precio");
		
		int index = 0;
		
		if (!Aseo.productosAseo.isEmpty()) {
			for (Aseo aseo : Aseo.productosAseo) {
				index++;
				System.out.println(index + "  |  " + aseo.getCodigo() + "  |  " + aseo.getNombre() + "  |  " + aseo.getInventario()
						+ "  |  " + aseo.getPrecio());
			}
		} else {System.out.println("No hay productos de Aseo :(");}
		
		if (!Abarrote.productosAbarrotes.isEmpty()) {
			for (Abarrote abarrote : Abarrote.productosAbarrotes) {
				index++;
				System.out.println(index + "  |  " + abarrote.getCodigo() + "  |  " + abarrote.getNombre() + "  |  "
						+ abarrote.getInventario() + "  |  " + abarrote.getPrecio());
			}
		} else {System.out.println("No hay Abarrotes :(");}
		
		if (!Juguete.productosJuguetes.isEmpty()) {
			for (Juguete juguete : Juguete.productosJuguetes) {
				index++;
				System.out.println(index + "  |  " + juguete.getCodigo() + "  |  " + juguete.getNombre() + "  |  "
						+ juguete.getInventario() + "  |  " + juguete.getPrecio());
			}
		} else {System.out.println("No hay Juguetes :(");}
		
	}
	
	public static void crearProducto(int opcion, Scanner scan) {
		
		int codigo;
		String nombre;
		int inventario;
		float precio;
		float inversion;
		String categoria;
		String tipo;
		String unidad;
		Boolean perecedero;
		String material;
		//Date fechaSalida;
		int garantia;
		
		System.out.print("Codigo: ");
		codigo = scan.nextInt();
		System.out.print("Nombre: ");
		nombre = scan.next();
		System.out.print("inventario: ");
		inventario = scan.nextInt();
		System.out.print("Precio: ");
		precio = scan.nextFloat();
		System.out.print("Inversion: ");
		inversion = scan.nextFloat();
		System.out.print("Categoria: ");
		categoria = scan.next();
		System.out.print("Tipo: ");
		tipo = scan.next();
		System.out.print("Unidad: ");
		unidad = scan.next();
		
		switch (opcion) {
		case 1:
			
			new Aseo(codigo, nombre, inventario, precio, inversion, categoria, tipo, unidad);
			break;
			
		case 2:
			
			System.out.print("Perecedero: ");
			perecedero = scan.nextBoolean();
			
			new Abarrote(codigo, nombre, inventario, precio, inversion, categoria, tipo, perecedero, unidad);
			break;
			
		case 3:
			
			System.out.print("Material: ");
			material = scan.next();
			System.out.print("Garantia: ");
			garantia = scan.nextInt();
			
			new Juguete(codigo, nombre, inventario, precio, inversion, categoria, tipo, material, new Date() , garantia);
			break;
			
		}

	}

}
