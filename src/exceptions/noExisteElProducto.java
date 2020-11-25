package exceptions;

public class noExisteElProducto extends ExceptionsType1 {
	
	public noExisteElProducto(int id) {
		super("\nEl id de producto " + id + " no existe, por favor verifique el id ingresado.");

	}
}
