package GUI;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class FieldPanel extends Pane {
	Label tituloCriterios;
	Label tituloValores;
	String[] criterios;
	String[] valores;
	List<TextField> elementos = new ArrayList<TextField>();
	
	public FieldPanel() {
		
	}
	public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores, boolean[] habilitado) {
			this.tituloCriterios = new Label(tituloCriterios);
			this.tituloCriterios.setLayoutX(50);
			this.tituloCriterios.setLayoutY(0);
			this.tituloValores = new Label(tituloValores);
			this.tituloValores.setLayoutX(150);
			this.tituloValores.setLayoutY(0);
			
			
			this.getChildren().add(this.tituloCriterios);
			this.getChildren().add(this.tituloValores);
			for(int i = 0; i < criterios.length; i ++) {
				Label l1 = new Label(criterios[i]);
				l1.setLayoutX(50);
				l1.setLayoutY((i * 25) + 25);
				this.getChildren().add(l1);
				l1.setStyle("-fx-border-color: black;");
				TextField t1 = new TextField();
				elementos.add(t1);
				t1.setPromptText(valores[i]);
				t1.setPrefColumnCount(10);
				t1.setLayoutX(150);
				t1.setLayoutY((i*25) + 25);
				this.getChildren().add(t1);
			}
	}
}
