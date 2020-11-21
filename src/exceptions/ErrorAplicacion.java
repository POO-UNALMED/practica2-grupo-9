package exceptions;

public class ErrorAplicacion extends Exception {
	
	public ErrorAplicacion(String error) {
		super("Manejo de errores de la Aplicacion: " + error);
	}
	

}

class ExceptionClass1 {
	
	
}


class ExceptionClass2 {
	public void metodo1() throws ErrorAplicacion {
		
	}
	
}