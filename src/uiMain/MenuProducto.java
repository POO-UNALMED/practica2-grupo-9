/*
 * MenuProducto
 * 
 * Alberga los metodos del menu productos, encargados de validar datos de las clases
 * e implementar restricciones sobre los datos ingresados por el usuario y los arreglos definidos.
 * En esta se utilizan los arreglos dinamicos definidos como estaticos en cada subclase de productos
 * cada arreglo dinamico(ArrayList) es del tipo de clase a la cual esta asociado(Aseo, Abarrote, Juguete).
 * */
package uiMain;

import java.util.Date;
import java.util.Scanner;

import gestorAplicacion.productos.Abarrote;
import gestorAplicacion.productos.Aseo;
import gestorAplicacion.productos.Juguete;

public class MenuProducto {

	/* 
	 * Muestra en un formato definido y estilizado los elementos por medio del toString de cada subclase
	 * de productos y en el siguiente orden, Productos de Aseo, Productos de Abarrotes y Productos de Juguete 
	 * 
	 * Entradas: Ningun Parametro. Utiliza arreglos dinamicos definidos como estaticos de cada subclase
	 * Salidad: Un listado de los productos definidos hasta el momento.
	 * */
	
	public static void mostrarProducto() {
		System.out.println(Mensajes.listaDeProductos);
		System.out.println(Mensajes.cabeceras);

		int index = 0;

		if (!Aseo.productosAseo.isEmpty()) {
			for (Aseo aseo : Aseo.productosAseo) {
				index++;
				System.out.println("| " + index + "  |  " + aseo.getCodigo() + "  |  " + aseo.getNombre() + "  |  "
						+ aseo.getInventario() + "  |  " + aseo.getPrecio());
			}
		} else {
			System.out.println(Mensajes.noProductosAseo);
		}

		if (!Abarrote.productosAbarrotes.isEmpty()) {
			for (Abarrote abarrote : Abarrote.productosAbarrotes) {
				index++;
				System.out.println("| " + index + "  |  " + abarrote.getCodigo() + "  |  " + abarrote.getNombre()
						+ "  |  " + abarrote.getInventario() + "  |  " + abarrote.getPrecio());
			}
		} else {
			System.out.println(Mensajes.noProductosAbarrote);
		}

		if (!Juguete.productosJuguetes.isEmpty()) {
			for (Juguete juguete : Juguete.productosJuguetes) {
				index++;
				System.out.println("| " + index + "  |  " + juguete.getCodigo() + "  |  " + juguete.getNombre()
						+ "  |  " + juguete.getInventario() + "  |  " + juguete.getPrecio());
			}
		} else {
			System.out.println(Mensajes.noProductosJuguete);
		}

	}
	
	/*
	 * Se encarga de validar si el id ingresado por el usuario es acorde con los elementos definidos en cada lista dinamica
	 * de las subclases de productos
	 * 
	 * Entradas: 
	 * - validador es un entero de 1 a 3 con la unica funcionalidad de verificar en alguna de las listas de las subclases de productos 
	 * (1 = productosAseo, 2 = productosAbarrote, 3 = productosJuguetes).
	 * 
	 * - idProducto es un entero que representa el id del producto seleccionado por el usuario
	 * 
	 * Salidas: Retorna un booleano dependiendo si el idProducto se encuentra en la lista especifica seleccionada por el validador
	 *
	 * */
	
	public static boolean validarListas(int validador, int idProducto) {

		if (validador == 1 && idProducto <= Aseo.productosAseo.size()) {
			return true;
		} else if (validador == 2 && idProducto <= (Aseo.productosAseo.size() + Abarrote.productosAbarrotes.size())
				&& (idProducto - Aseo.productosAseo.size()) <= Abarrote.productosAbarrotes.size()) {
			return true;
		} else if (validador == 3
				&& idProducto <= (Aseo.productosAseo.size() + Abarrote.productosAbarrotes.size()
						+ Juguete.productosJuguetes.size())
				&& (idProducto
						- (Aseo.productosAseo.size() + Abarrote.productosAbarrotes.size())) <= Juguete.productosJuguetes
								.size()) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * Se encarga de Aumentar o disminuir el inventario de un producto, ademas, valida que al disminuir el inventario
	 * no sobrepase el 0
	 * 
	 * Entradas: 
	 * - validador es un entero de 1 a 3 con la unica funcionalidad de verificar en alguna de las listas de las subclases de productos 
	 * (1 = productosAseo, 2 = productosAbarrote, 3 = productosJuguetes).
	 * 
	 * - idProducto es un entero que representa el id del producto seleccionado por el usuario
	 * 
	 * - cantidad es un entero que representa la cantidad de inventario a aumentar o disminuir
	 * 
	 * Salidas: Modifica el inventario del producto seleccionado o en su defecto le comunica al usuario que los datos ingresados son incorrectos 
	 * 
	 * */

	/*
	 * IMPORTANTE: El codigo basa los id de productos de manera dinamica, reservando los primeros id a los productos de Aseo y siguiendo ese orden con Abarrote y Juguete
	 * Como un producto de abarrote puede tener un id y este puede ser acaparado por un producto de aseo en algun momento de la ejecucion
	 * Cualquier tipo de exception que tenga que ver con dichos ids esta controlada
	 * 
	 * */
	
	public static void actualizarInventario(int opcion, int idProducto, int cantidad) {

		int index = -1;
		int nuevoInventario = -1;

		if (validarListas(1, idProducto)) {

			index = idProducto - 1;
			if (opcion == 1) {
				nuevoInventario = Aseo.productosAseo.get(index).getInventario() + cantidad;
			} else if (opcion == 2 && Aseo.productosAseo.get(index).getInventario() >= cantidad) {
				nuevoInventario = Aseo.productosAseo.get(index).getInventario() - cantidad;
			} else {
				System.out.println(Mensajes.accionNoRealizada);
			}

			if (nuevoInventario >= 0) {
				Aseo.productosAseo.get(index).setInventario(nuevoInventario);
			}

		} else if (validarListas(2, idProducto)) {

			index = idProducto - Aseo.productosAseo.size() - 1;
			if (opcion == 1) {
				nuevoInventario = Abarrote.productosAbarrotes.get(index).getInventario() + cantidad;
			} else if (opcion == 2 && Abarrote.productosAbarrotes.get(index).getInventario() >= cantidad) {
				nuevoInventario = Abarrote.productosAbarrotes.get(index).getInventario() - cantidad;
			} else {
				System.out.println(Mensajes.accionNoRealizada);
			}

			if (nuevoInventario >= 0) {
				Abarrote.productosAbarrotes.get(index).setInventario(nuevoInventario);
			}

		} else if (validarListas(3, idProducto)) {

			index = idProducto - (Aseo.productosAseo.size() + Abarrote.productosAbarrotes.size()) - 1;
			if (opcion == 1) {
				nuevoInventario = Juguete.productosJuguetes.get(index).getInventario() + cantidad;
			} else if (opcion == 2 && Juguete.productosJuguetes.get(index).getInventario() >= cantidad) {
				nuevoInventario = Juguete.productosJuguetes.get(index).getInventario() - cantidad;
			} else {
				System.out.println(Mensajes.accionNoRealizada);
			}

			if (nuevoInventario >= 0) {
				Juguete.productosJuguetes.get(index).setInventario(nuevoInventario);
			}

		} else {
			System.out.println(Mensajes.noExisteID);
		}
	}

	/*
	 * Crea un producto de tipo Aseo, Abarrote o Juguete y lo almacena en su respectiva lista dinamica
	 * 
	 * Entradas: 
	 * -Opcion: Un entero de 1 a 3 que representa el producto a instanciar (a = Aseo, 2 = Abarrote, 3 = Juguete)
	 * -Scan es un scanner que recibe los datos ingresados por el usuario
	 * 
	 * Salida: Crea el respectivo objeto con los datos ingresador por el usuario y los almacena en sus respectivas listas dinamicas
	 * */
	public static void crearProducto(int opcion, Scanner scan) {
		System.out.println(Mensajes.seccionar);
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

		System.out.print(Mensajes.codigo);
		codigo = scan.nextInt();
		System.out.print(Mensajes.nombre);
		nombre = scan.next();
		System.out.print(Mensajes.inventario);
		inventario = scan.nextInt();
		System.out.print(Mensajes.precio);
		precio = scan.nextFloat();
		System.out.print(Mensajes.inversion);
		inversion = scan.nextFloat();
		System.out.print(Mensajes.categoria);
		categoria = scan.next();
		System.out.print(Mensajes.tipo);
		tipo = scan.next();

		switch (opcion) {
		case 1:

			System.out.print(Mensajes.unidad);
			unidad = scan.next();

			new Aseo(codigo, nombre, inventario, precio, inversion, categoria, tipo, unidad);
			break;

		case 2:

			System.out.print(Mensajes.unidad);
			unidad = scan.next();
			System.out.print(Mensajes.perecedero);
			perecedero = scan.nextBoolean();

			new Abarrote(codigo, nombre, inventario, precio, inversion, categoria, tipo, perecedero, unidad);
			break;

		case 3:

			System.out.print(Mensajes.material);
			material = scan.next();
			System.out.print(Mensajes.garantia);
			garantia = scan.nextInt();

			new Juguete(codigo, nombre, inventario, precio, inversion, categoria, tipo, material, new Date(), garantia);
			break;

		}

	}

}
