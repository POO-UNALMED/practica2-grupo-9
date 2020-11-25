package GUI;

import gestorAplicacion.finanzas.Factura;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

public class Facturas extends FieldPanel {
	ScrollPane factura;
	Label texto;
	
	public void setTodo() {
		this.getChildren().clear();
		Label texto = new Label(mensaje());
		this.factura = new ScrollPane();
		this.factura.setLayoutX(0);
		this.factura.setLayoutY(0);
		this.factura.setPrefSize(400, 180);
		this.factura.setContent(texto);
		
		this.getChildren().add(this.factura);
	}
	public Facturas() {
		super();
		//Texto
		Label texto = new Label(mensaje());
		this.factura = new ScrollPane();
		this.factura.setLayoutX(0);
		this.factura.setLayoutY(0);
		this.factura.setPrefSize(400, 180);
		this.factura.setContent(texto);
		
		this.getChildren().add(this.factura);
	}
	
	public String mensaje() {
		String a = "";
		for(int i = 0; i < Factura.facturas.size(); i++) {
			a += Factura.facturas.get(i) + "\n";
		}
		return a;
	}
}
