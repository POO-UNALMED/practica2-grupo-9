package GUI;

import java.util.ArrayList;
import java.util.List;
import gestorAplicacion.productos.Producto;
import uiMain.MenuTienda;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Compras extends FieldPanel {
	
	Button btn1 = new Button("Añadir");
	Button btn2 = new Button("Eliminar");
	List<Producto> productos = new ArrayList<Producto>();
	List<Integer> cantidades = new ArrayList<Integer>();
	List<TextField> elements = super.elementos;
	UnicoHandlerClass eventos = new UnicoHandlerClass();
	
	public Compras(String tituloCriterios, String[] criterios, String tituloValores, String[] valores,
			boolean[] habilitado, List<Producto> productos, List<Integer> cantidades) {
		super(tituloCriterios, criterios, tituloValores, valores, habilitado);
		
		this.productos.addAll(productos);
		this.cantidades.addAll(cantidades);
		
		
		btn1.setLayoutX(50);
		btn2.setLayoutX(150);
		btn1.setLayoutY(criterios.length*25 + 40);
		btn2.setLayoutY(criterios.length*25 + 40);
		super.getChildren().addAll(btn1, btn2);
		
		btn1.setOnAction(eventos);
		
	}
	
	
	
	public void agregar(List<Producto> productos, List<Integer> cantidades, List<TextField> elem) {
		MenuTienda.validarProducto(Integer.parseInt(elem.get(0).getText()), Integer.parseInt(elem.get(1).getText()), productos, cantidades);
		System.out.println(productos);
		System.out.println(cantidades);
	}


	class UnicoHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Object control=event.getSource();
			if(control instanceof Button){
				if(control.equals(btn1)){
					agregar(productos, cantidades, elements);
					elements.get(0).setText("");
					elements.get(1).setText("");
				}
				else if(control.equals(btn2)){
					
				}
			}
			
		}


	}
	
}


