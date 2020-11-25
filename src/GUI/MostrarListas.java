package GUI;
import java.util.ArrayList;
import java.util.List;

import GUI.Compras.UnicoHandlerClass;
import gestorAplicacion.productos.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class MostrarListas extends Pane {
	Label Producto;
	Label Cantidad;
	Button btn1 = new Button("Ver factura");
	Button btn2 = new Button("Pagar");
	UnicoHandlerClass eventos = new UnicoHandlerClass();
	Alert a = new Alert(AlertType.NONE);
	
	public MostrarListas(List<Producto> productos, List<Integer> cantidades) {
		System.out.println(productos);
		System.out.println(cantidades);
		btn1.setLayoutX(80);
		btn2.setLayoutX(95);
		btn1.setLayoutY(50);
		btn2.setLayoutY(100);
		super.getChildren().addAll(btn1, btn2);
		
		btn1.setOnAction(eventos);
	}
	
	public String mensaje() {
		String a = "";
		for(int i = 0; i < Compras.getProductos().size(); i++) {
			a += Compras.getProductos().get(i).getNombre() + " " + Compras.getCantidades().get(i) + "\n";
		}
		System.out.println(a);
		return a;
	}
	class UnicoHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Object control=event.getSource();
			if(control instanceof Button){
				if(control.equals(btn1)){
					a.setAlertType(AlertType.INFORMATION);
					a.setTitle("Carrito");
					a.setHeaderText(null);
					a.setContentText(mensaje());
					a.show();
				}
				else if(control.equals(btn2)){
					
				}
			}
			
		}


	}
}
