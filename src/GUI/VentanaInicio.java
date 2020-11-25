package GUI;

import com.sun.prism.Image;

import BaseDatos.Reader;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
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


public class VentanaInicio extends Application{
	Label lbl = new Label();
	TextField txf = new TextField();
	TextArea txa = new TextArea();
	MenuItem salir = new MenuItem("Salir");
	MenuItem descr = new MenuItem("Descripcion");
	Button btn = new Button("Ir");
	
	
	@Override
	public void start(Stage initialStage){
		//Paneles
		BorderPane root = new BorderPane();
		GridPane p0 = new GridPane();
		GridPane p1 = new GridPane();
		GridPane p2 = new GridPane();
		GridPane p3 = new GridPane();
		GridPane p4 = new GridPane();
		GridPane p5 = new GridPane();
		GridPane p6 = new GridPane();
		MenuBar bar = new MenuBar();
		Menu inicio = new Menu("Inicio");
		SeparatorMenuItem separator = new SeparatorMenuItem();
		Label lblJP = new Label();
		Label lblDF = new Label();
		Label lblWM = new Label();
		Label lblF = new Label();
		UnicoHandlerClass handler = new UnicoHandlerClass();
		
		//Root
		root.setTop(bar);
		root.setCenter(p0);
		bar.getMenus().add(inicio);
		inicio.getItems().addAll(descr,separator,salir);
		descr.setOnAction(handler);
		salir.setOnAction(handler);
		
		
		//BorderPane p0
		p0.add(p1,0,1);
		p0.add(p2,1,1);
		p0.setPadding(new Insets(10,10,10,10));
		p0.setAlignment(Pos.TOP_CENTER);
		p0.setVgap(5);
		p0.setHgap(5);
		
		
		//BorderPane p1
		p1.add(p3,0,0);
		p1.add(p4,0,1);
		p1.setStyle("-fx-border-color: black;");
		p1.setPadding(new Insets(10,10,10,10));
		p1.setVgap(5);
		
		//BorderPane p2
		p2.add(p5,0,0);
		p2.add(p6,0,1);
		p2.setStyle("-fx-border-color: black;");
		p2.setPadding(new Insets(10,10,10,10));
		p2.setVgap(5);
		
		//GridPane p3
		p3.setStyle("-fx-border-color: black;");
		p3.setPadding(new Insets(10,10,10,10));
		lbl.setText("Bienvenido");
		p3.add(lbl, 0, 0);
		
		//GridPane p4
		p4.setStyle("-fx-border-color: black;");
		p4.setPadding(new Insets(10,10,10,10));
		p4.setAlignment(Pos.CENTER);
		p4.add(btn, 1, 0);
		btn.setOnAction(handler);
		
		
		//GridPane p5
		p5.setStyle("-fx-border-color: black;");
		p5.setPadding(new Insets(10,10,10,10));
		lblJP.setText("JUAN PABLO...\n"
					+ "Estudiante de ingeniria de sistemas e informatica\n"
					+ "en la Universidad Nacional de Colombia.\n"
					+ "EDAD: ... .\n"
					+ "SEMESTRE: ... .");
		lblDF.setText("WILFER MAURICIO CHAVARRIA JARAMILLO\n"
					+ "Estudiante de ingeniria de sistemas e informatica\n"
					+ "en la Universidad Nacional de Colombia.\n"
					+ "EDAD: 24 años.\n"
					+ "SEMESTRE: Octavo.");
		lblWM.setText("DANIEL FERNANDO...\n"
					+ "Estudiante de ingeniria de sistemas e informatica\n"
					+ "en la Universidad Nacional de Colombia.\n"
					+ "EDAD: ... .\n"
					+ "SEMESTRE: ... .");
		lblF.setText("FAIBER...\n"
					+ "Estudiante de ingeniria de sistemas e informatica\n"
					+ "en la Universidad Nacional de Colombia.\n"
					+ "EDAD: ... .\n"
					+ "SEMESTRE: ... .");
		p5.add(lblJP, 0, 0);
		p5.add(lblDF, 0, 0);
		p5.add(lblWM, 0, 0);
		p5.add(lblF, 0, 0);
		lblF.setVisible(false);
		lblDF.setVisible(false);
		lblWM.setVisible(false);
		lblJP.setOnMouseClicked(new EventHandler<MouseEvent>() {
		       @Override
		       public void handle(MouseEvent event) {
		    	   lblJP.setVisible(false);
		    	   lblDF.setVisible(true);
		    	   
		    	   
		       }
		});
		lblDF.setOnMouseClicked(new EventHandler<MouseEvent>() {
		       @Override
		       public void handle(MouseEvent event) {
		    	   lblDF.setVisible(false);
		    	   lblWM.setVisible(true);
		       }
		});
		lblWM.setOnMouseClicked(new EventHandler<MouseEvent>() {
		       @Override
		       public void handle(MouseEvent event) {
		    	   lblWM.setVisible(false);
		    	   lblF.setVisible(true);
		       }
		});
		lblF.setOnMouseClicked(new EventHandler<MouseEvent>() {
		       @Override
		       public void handle(MouseEvent event) {
		    	   lblF.setVisible(false);
		    	   lblJP.setVisible(true);
		       }
		});
		
		
		//GridPane p6
		p6.setStyle("-fx-border-color: black;");
		p6.setPadding(new Insets(10,10,10,10));
		
		
		
		//Creando el scene
		Scene scene = new Scene(root, 480,300);
		initialStage.setTitle("Tu pedido");
		initialStage.setScene(scene);
		initialStage.show();
	}
	
	public static void main(String args[]) {
		new Reader();
		launch(args);
	}
	
	//Un solo manejador de eventos
	class UnicoHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			Object control=e.getSource();
			if(control instanceof MenuItem){
				if(control.equals(salir)){
					Platform.exit();
				}
				else if(control.equals(descr)){
					lbl.setText("DESCRIPCION.\n"
							+ 	"Con nosotros podras realizar todas las compras\n"
							+	"necesarias para tu hogar, es un tienda 100%\n"
							+ 	"virtal.\n"
							+ 	"Si le das click al boton inferiri 'Ir' podras\n"
							+ 	"encontrar todos nustros productos.\n"
							+ 	"Es una pagina muy intuitiva y facil de manejar.\n");
				}
			}
			else if(control instanceof Button){
				if(control.equals(btn)){
					Platform.exit();
					Application.launch(new String[] {});
				}
			}
			
		}
	}
}
