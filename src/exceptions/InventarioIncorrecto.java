package exceptions;

public class InventarioIncorrecto extends ExceptionsType1 {
	
	private int modificar;
	private int inventario;
	
	public InventarioIncorrecto(int modificar, int inventario) {
		super("\nValor de inventario incorrecto,");
		
		this.modificar = modificar;
		this.inventario = inventario;
		
	}
	
	public String diferenciaInventario() {
		if (modificar > 0) {
			return "fue excedido por una diferencia de " + Math.abs(inventario - modificar) + " unidad/es.";
		}
		else {
			return "fue ingresado un numero negativo";
		}
	}
}
