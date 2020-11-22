package exceptions;

public class ProblemaLectura extends ExceptionsType2 {

	public ProblemaLectura(String error) {
		super("\nNo se pudo leer o no existe el siguiente archivo: " + error);
		
	}

}
