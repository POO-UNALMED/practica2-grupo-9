package GUI;

import gestorAplicacion.finanzas.Factura;
import gestorAplicacion.productos.Abarrote;
import gestorAplicacion.productos.Aseo;
import gestorAplicacion.productos.Juguete;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import uiMain.MenuProducto;

public class Productos extends FieldPanel {
	ScrollPane producto;
	Label texto;
	
	public void setTodo() {
		this.getChildren().clear();
		Label texto = new Label(mensaje());
		this.producto = new ScrollPane();
		this.producto.setLayoutX(0);
		this.producto.setLayoutY(0);
		this.producto.setPrefSize(400, 180);
		this.producto.setContent(texto);
		
		this.getChildren().add(this.producto);
	}
	
	public Productos() {
		super();
		//Texto
		Label texto = new Label(mensaje());
		this.producto = new ScrollPane();
		this.producto.setLayoutX(0);
		this.producto.setLayoutY(0);
		this.producto.setPrefSize(400, 180);
		this.producto.setContent(texto);
		
		this.getChildren().add(this.producto);
	}
	
	public String mensaje() {
		
		int total = Aseo.productosAseo.size() + Abarrote.productosAbarrotes.size() + Juguete.productosJuguetes.size();
		String a = "";
		
		for(int i = 0; i < Aseo.productosAseo.size(); i++) {
			a += "ID: " + (i+1) + " Nombre: " + Aseo.productosAseo.get(i).getNombre() + " Cantidad: " + Aseo.productosAseo.get(i).getInventario() + "\n";
		}
		for(int i = 0; i < Abarrote.productosAbarrotes.size(); i++) {
			a += "ID: " + (i+1+Aseo.productosAseo.size()) + " Nombre: " + Abarrote.productosAbarrotes.get(i).getNombre() + " Cantidad: " + Abarrote.productosAbarrotes.get(i).getInventario() + "\n";
			
		}
		for(int i = 0; i < Juguete.productosJuguetes.size(); i++) {
			a += "ID: " + (i+2+Aseo.productosAseo.size()+Juguete.productosJuguetes.size()) + " Nombre: " + Juguete.productosJuguetes.get(i).getNombre() + " Cantidad: " + Juguete.productosJuguetes.get(i).getInventario() + "\n";
		}
		return a;
		 
	}
}
