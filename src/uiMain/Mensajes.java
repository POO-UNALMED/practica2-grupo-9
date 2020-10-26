package uiMain;

public class Mensajes {
	
	public static String bienvenida() {
		return "**************************************************\n***********          TU PEDIDO        ************\n**************************************************\n";
	}
	
	public static String seccionar() {
		return "==================================================";
	}
	
	public static String opcion() {
		return "Opcion: ";
	}
	
	public static String edad() {
		return "Ingrese su edad: ";
	}
	
	public static String debCred() {
		return "Ingrese su metodo de pago (1. Debito / 2. Credito): ";
	}
	
	public static String selInicio() {
		return "1. Menu usuario. \n2. Menu tienda. \n3. Menu productos. \n4. Ver lista de facturas. \n5. salir.";
	}
	
	public static String selUsuario() {
		return "1. Ver nivel afiliacion. \n2. Modificar Afiliacion \n3. Ver tu lista de facturas. \nOtro valor para volver.";
	}
	
	public static String afiliacion() {
		return "1. Aumentar afiliacion. \n2. Disminuir afiliacion.";
	}
	
	public static String selTienda() {
		return "1. Agregar producto. \n2. Quitar producto. \n3. Lista de productos. \n4. Pagar. \nPresiona cualquier tecla para salir.";
	}
	
	public static String selProductos() {
		return "1. Crear producto de Aseo. \n2. Crear producto de Abarrote. \n3. Crear producto de Juguete. \n4. Actualizar inventario.  \n5. Ver lista de productos. \nOtro valor para volver.";
	}
	
}
