package GUI;
import java.util.List;

import gestorAplicacion.productos.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class MostrarListas extends Pane {
	Label Producto;
	Label Cantidad;
	
	public MostrarListas(List<Producto> productos, List<Integer> cantidades) {
		for(int i = 0; i < productos.size(); i ++) {
			Label l1 = new Label(productos.get(i).getNombre());
			l1.setLayoutX(50);
			l1.setLayoutY((i * 25) + 25);
			this.getChildren().add(l1);
			Label l2 = new Label(Integer.toString(cantidades.get(i)));
			l2.setLayoutX(50);
			l2.setLayoutY((i * 25) + 25);
			this.getChildren().add(l2);
		}
	}
}
