package uiMain;

import java.util.Date;
import java.util.Scanner;

import gestorAplicacion.productos.Abarrote;
import gestorAplicacion.productos.Aseo;
import gestorAplicacion.productos.Juguete;

public class MenuProducto {

	public static void mostrarProducto() {
		System.out.println("Lista de productos.");
		System.out.println("id --- Codigo --- Nombre --- Inventario --- Precio");

		int index = 0;

		if (!Aseo.productosAseo.isEmpty()) { // Cambiar cuando esten implementados los toString
			for (Aseo aseo : Aseo.productosAseo) {
				index++;
				System.out.println(index + "  |  " + aseo.getCodigo() + "  |  " + aseo.getNombre() + "  |  "
						+ aseo.getInventario() + "  |  " + aseo.getPrecio());
			}
		} else {
			System.out.println("No hay productos de Aseo :(");
		}

		if (!Abarrote.productosAbarrotes.isEmpty()) {
			for (Abarrote abarrote : Abarrote.productosAbarrotes) {
				index++;
				System.out.println(index + "  |  " + abarrote.getCodigo() + "  |  " + abarrote.getNombre() + "  |  "
						+ abarrote.getInventario() + "  |  " + abarrote.getPrecio());
			}
		} else {
			System.out.println("No hay Abarrotes :(");
		}

		if (!Juguete.productosJuguetes.isEmpty()) {
			for (Juguete juguete : Juguete.productosJuguetes) {
				index++;
				System.out.println(index + "  |  " + juguete.getCodigo() + "  |  " + juguete.getNombre() + "  |  "
						+ juguete.getInventario() + "  |  " + juguete.getPrecio());
			}
		} else {
			System.out.println("No hay Juguetes :(");
		}

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
		// Date fechaSalida;
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

		switch (opcion) {
		case 1:

			System.out.print("Unidad: ");
			unidad = scan.next();

			new Aseo(codigo, nombre, inventario, precio, inversion, categoria, tipo, unidad);
			break;

		case 2:

			System.out.print("Unidad: ");
			unidad = scan.next();
			System.out.print("Perecedero: ");
			perecedero = scan.nextBoolean();

			new Abarrote(codigo, nombre, inventario, precio, inversion, categoria, tipo, perecedero, unidad);
			break;

		case 3:

			System.out.print("Material: ");
			material = scan.next();
			System.out.print("Garantia: ");
			garantia = scan.nextInt();

			new Juguete(codigo, nombre, inventario, precio, inversion, categoria, tipo, material, new Date(), garantia);
			break;

		}

	}
	
	
	
}
