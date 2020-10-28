/*
 * Clase encargada de albergar la logica como crear un cliente o modificar su afiliacion, de la seccion menu usuario del la UI
 * esta clase existe con la unica finalidad de no sobrecargar a la clase UIMain de funciones manteniendo un estilo mas limpio
 * No utiliza ninguna estructura de datos
 * */

package uiMain;

import gestorAplicacion.finanzas.Cliente;
import gestorAplicacion.finanzas.Factura;

public class MenuUsuario {

	
	/*
	 * metodo encargado de crear una nueva instancia de cliente
	 * 
	 * Entrada:
	 * -metodo es un entero de 1 a 3 que se encarga de definir si el cliente desea pagar con tarjeta debito, credito o en efectivo
	 * -edad es un entero que recibe la edad del cliente la cual es utilizada para descuentos 
	 * 
	 * Salida: construye una instancia de cliente
	 * */
	public static Cliente crearCliente(int metodo, int edad) {
		Cliente cliente;
		String debCred = "";

		if (metodo == 1) {
			debCred = "Efectivo";
		} else if (metodo == 2) {
			debCred = "Debito";
		} else if (metodo == 3) {
			debCred = "Credito";
		}
		cliente = new Cliente(edad, debCred);
		return cliente;

	}
	/*
	 * Modifica el nivel de afiliacion del cliente
	 * 
	 * Entradas: 
	 * -opcion es un entero de 1 a 2 que define si se quiere aumentar o disminuir el nivel de afiliacion
	 * -cliente recibe el objeto cliente al cual se le quiere modificar su nivel de afiliacion, el cliente es el de la seccion actual
	 * 
	 * -salida: modifica el atributo afiliacion del objeto cliente al cual apunta
	 * */
	public static void modifAfiliacion(int opcion, Cliente cliente) {
		if (opcion == 1 && cliente.getNivel_afiliacion() < 2) {
			cliente.aumentarAfiliacion();
		} else if (opcion == 2 && cliente.getNivel_afiliacion() > 0) {
			cliente.disminuirAfiliacion();
		}
	}
	/*
	 * Muestra un listado de las facturas asociadas a ese cliente
	 * 
	 * Entrada: cliente recibe el objeto cliente de la sesion actual
	 * Salida: Muestra un listado de las facturas asociadas al cliente, utiliza el toString de factura
	 * */
	public static void facturasCliente(Cliente cliente) {
		if (cliente.getFacturas().size() == 0) {
			System.out.println(Mensajes.sinFacturas);
		} else if (cliente.getFacturas().size() > 0) {
			for (Factura f : cliente.getFacturas()) {
				System.out.println(f);
			}

		}
		
	}

}
