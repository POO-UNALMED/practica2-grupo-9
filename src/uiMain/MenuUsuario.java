package uiMain;

import gestorAplicacion.finanzas.Cliente;
import gestorAplicacion.finanzas.Factura;

public class MenuUsuario {

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

	public static void modifAfiliacion(int opcion, Cliente cliente) {
		if (opcion == 1 && cliente.getNivel_afiliacion() < 2) {
			cliente.aumentarAfiliacion();
		} else if (opcion == 2 && cliente.getNivel_afiliacion() > 0) {
			cliente.disminuirAfiliacion();
		}
	}

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
