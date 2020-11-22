package exceptions;

import java.io.IOException;

public class ProblemaEscritura extends ExceptionsType2 {

	public ProblemaEscritura(String error) {
		super("\nOcurrio un error. Revisar el Path al cual se desea crear el siguiente txt: " + error);
		
	}

}
