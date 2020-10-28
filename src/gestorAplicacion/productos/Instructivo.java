//Interface instructivo se usa para que todas las clases hijas implementen un instructivo para sus productos.
package gestorAplicacion.productos;

public interface Instructivo {
	//Método instrucciones para que las clases hijas implementen dicho instructivo.
	public abstract String instrucciones();
}
