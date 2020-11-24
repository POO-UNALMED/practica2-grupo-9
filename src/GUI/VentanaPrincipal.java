package GUI;

import javafx.application.Application;
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


public class VentanaPrincipal extends Application{
	//pane principal
	BorderPane root = new BorderPane();
	Label lblApp = new Label("Tu Pedido");
	
	//pane inicio
	GridPane inicio = new GridPane();
	
	//pane botones
	VBox menuBar;
	
	
	//pane botón 1 compras
	GridPane compra = new GridPane();
	
	//pane compras interno
	GridPane compraPane = new GridPane();
	GridPane compraForm = new GridPane();
	GridPane compraShow = new GridPane();
	
	////Menu
	MenuBar barraMenu = new MenuBar();
	Menu m0 = new Menu("Archivo");
	MenuItem m01 = new MenuItem("Tu Pedido");
	MenuItem m02 = new MenuItem("Salir");
	Menu m1 = new Menu("Procesos y Consultas");
	MenuItem m11 = new MenuItem("Compras");
	MenuItem m12 = new MenuItem("Productos");

	SeparatorMenuItem separator = new SeparatorMenuItem();
	
	//botones compraForm
	Button btnCompras1 = new Button("Añadir");
	Button btnCompras2 = new Button("Eliminar");
	
	//Alerta
	Alert a = new Alert(AlertType.NONE);
	
	@Override
	public void start(Stage primaryStage){		
		//estilizamos pane botones
		//menuBar.setStyle("-fx-border-color: black;");
		
		//estilizamos pane inicio
		inicio.setStyle("-fx-border-color: black;");
		inicio.setVisible(true);
		
		//estilizar pane compra
		compra.setStyle("-fx-border-color: black;");
		compra.setVisible(false);
		
		//estilizar pane compraForm
		compraForm.setStyle("-fx-border-color: black;");
		
		//estilizar pane compraForm
		compraShow.setStyle("-fx-border-color: black;");
		
		//Texto del pane de compras
		Label titulo1 = new Label("Compras");
		titulo1.setStyle("-fx-border-color: black;");
		GridPane.setHalignment(titulo1, javafx.geometry.HPos.CENTER);
		Label texto1 = new Label("En esta pestaña puede añadir productos al carrito para luego proceder a pagarlos.");
		texto1.setStyle("-fx-border-color: black;");
		GridPane.setHalignment(texto1, javafx.geometry.HPos.CENTER);
		
		//margenes del borderpane root
		root.setPadding(new Insets(10,10,10,10));
		
		//margenes del flowpane botones
		//menuBar.setPadding(new Insets(0,10,0,10));
		//menuBar.setAlignment(Pos.CENTER);
		
		//margenes, espaciado y alineación del gridpane compras
		compra.setPadding(new Insets(10,10,10,10));
		compra.setVgap(5);
		compra.setHgap(5);
		compra.setAlignment(Pos.TOP_CENTER);
		//compra.setMaxWidth(Region.USE_COMPUTED_SIZE);
		
		//margenes, espaciado y alineación del gridpane compraForm
		compraPane.setPadding(new Insets(10,10,10,10));
		compraPane.setVgap(5);
		//compraPane.setHgap(5);
		compraPane.setAlignment(Pos.CENTER);
		
		//margenes, espaciado y alineación del gridpane compraForm
		compraForm.setPadding(new Insets(10,10,10,10));
		compraForm.setVgap(5);
		compraForm.setHgap(5);
		compraForm.setAlignment(Pos.CENTER_LEFT);
		
		//margenes, espaciado y alineación del gridpane compraForm
		compraShow.setPadding(new Insets(10,10,10,10));
		compraShow.setVgap(5);
		compraShow.setHgap(5);
		compraShow.setAlignment(Pos.CENTER_RIGHT);		
		
		
		//Botones del vbox menuBar
		menuBar = new VBox(barraMenu);
		m0.getItems().addAll(m01,m02);
		m1.getItems().addAll(m11,m12);
		UnicoHandlerClass handler = new UnicoHandlerClass();
		m0.setOnAction(handler);
		m1.setOnAction(handler);
		m11.setOnAction(handler);
		m12.setOnAction(handler);
		Label menuLabel = new Label("Ayuda");
		menuLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
		       @Override
		       public void handle(MouseEvent event) {
		    	   	a.setAlertType(AlertType.INFORMATION);
					a.setTitle("Autores");
					a.setHeaderText("Los autores de éste hermoso proyecto :')");
					a.setContentText("Juan Pablo Oquendo \nDaniel Fernando Robledo \nWilfer Mauricio Chavarria \nFaiber Salazar");
					a.show();
		       }
		});
		Menu m2 = new Menu("",menuLabel);
		barraMenu.getMenus().addAll(m0,m1,m2);
		
		////Formulario de compras
		//labels
		Label lblCompras1 = new Label("Producto 1");
		Label lblCompras2 = new Label("Producto 2");
		Label lblCompras3 = new Label("Producto 3");
		Label lblCompras4 = new Label("Producto 4");
		//Acción para el botón compra
		btnCompras1.setOnAction(handler);
		
		//Menú desplegable de productos
		String productos[] = {"Pollo","Leche","Arracacha","Yuca"};
		ComboBox productosCB1 = new ComboBox(FXCollections.observableArrayList(productos));
		productosCB1.setPromptText("Productos");
		ComboBox productosCB2 = new ComboBox(FXCollections.observableArrayList(productos));
		productosCB2.setPromptText("Productos");
		ComboBox productosCB3 = new ComboBox(FXCollections.observableArrayList(productos));
		productosCB3.setPromptText("Productos");
		ComboBox productosCB4 = new ComboBox(FXCollections.observableArrayList(productos));
		productosCB4.setPromptText("Productos");
		
		
		
		//Agregando flowpane botones al pane principal root
		root.setTop(menuBar);
		
		//agregando pane compras al borderpane principal root
		root.setCenter(inicio);
		
		//agregando pane compras al borderpane principal root
		
		
		//agregando titulo y texto al gridpane compras
		compra.add(titulo1, 0, 0);
		compra.add(texto1, 0, 1);
		
		//agregando gridpane de compraMenu al gridpane compras
		compra.add(compraPane, 0, 2);
		
		//agregando gridpane de compraMenu al gridpane compras
		compraPane.add(compraForm, 0, 0);
		compraPane.add(compraShow, 1, 0);
		
		//agregando los elementos del gridpane compraform
		compraForm.add(lblCompras1, 0, 0);
		compraForm.add(productosCB1, 1, 0);
		compraForm.add(lblCompras2, 0, 1);
		compraForm.add(productosCB2, 1, 1);
		compraForm.add(lblCompras3, 0, 2);
		compraForm.add(productosCB3, 1, 2);
		compraForm.add(lblCompras4, 0, 3);
		compraForm.add(productosCB4, 1, 3);
		compraForm.add(btnCompras1, 0, 4);
		compraForm.add(btnCompras2, 1, 4);
		
		
		//Creando el scene
		Scene scene = new Scene(root, 480,300);
		primaryStage.setTitle("Tu pedido");
		primaryStage.setScene(scene);
		primaryStage.show();
		//
	}
	public static void main(String args[]) {
		launch(args);
	}
	//Un solo manejador de eventos
	class UnicoHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			Object control=e.getSource();
			if(control instanceof MenuItem){
				if(control.equals(m11)){
					root.setCenter(compra);
					compra.setVisible(true);
					inicio.setVisible(false);
				}
				else if(control.equals(m12)){
					//root.setCenter(productos);
					//productos.setVisible(true);
					compra.setVisible(false);
					inicio.setVisible(false);
				}
			}
			else if (control instanceof Button){
				if(control.equals(btnCompras1)){
					a.setAlertType(AlertType.CONFIRMATION);
					a.setTitle("Confirmación Compra");
					a.setContentText("¿Está seguro que desea proceder con el pago?");
					a.show();
				}
			}			
		}
	}
	
	public class FieldPanel extends Pane{
		//FieldPanel fp = new FieldPanel();
		String tittuloCriterios;
		String[] criterios;
		String tituloValores;
		String[] valores;
		boolean[] habilitado;
		public FieldPanel(String tittuloCriterios, String[] criterios, String tituloValores, String[] valores, boolean[] habilitado) {
			
		}
	}
}
