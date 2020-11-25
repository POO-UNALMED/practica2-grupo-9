package GUI;

import java.util.ArrayList;
import java.util.List;

import gestorAplicacion.productos.Producto;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class VentanaPrincipal extends Stage{
		
	List<Producto> productos = new ArrayList<Producto>();
	List<Integer> cantidades = new ArrayList<Integer>();
	public int b = 0;
	//pane principal
	BorderPane root = new BorderPane();
	Label lblApp = new Label("Tu Pedido");
	
	//pane inicio
	GridPane inicio = new GridPane();
	
	//pane botones
	VBox menuBar;
	
	
	//pane botón 1 compras
	GridPane compra = new GridPane();
	
	//pane botón 2 carrito
	GridPane carrito = new GridPane();
	
	//pane botón 2 Estadistico
	GridPane estadistico = new GridPane();
	
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
	MenuItem m12 = new MenuItem("Carrito");
	MenuItem m13 = new MenuItem("Estadisticos");

	SeparatorMenuItem separator = new SeparatorMenuItem();
	
	//botones compraForm
	Button btnCompras1 = new Button("Añadir");
	Button btnCompras2 = new Button("Eliminar");
	
	//Alerta
	Alert a = new Alert(AlertType.NONE);
	
	VentanaPrincipal(){		
		//estilizamos pane botones
		//menuBar.setStyle("-fx-border-color: black;");
		
		//estilizamos pane inicio
		inicio.setStyle("-fx-border-color: black;");
		inicio.setVisible(true);
		
		//estilizar pane compra
		compra.setStyle("-fx-border-color: black;");
		compra.setVisible(false);
		
		//estilizar pane carrito
		carrito.setStyle("-fx-border-color: black;");
		carrito.setVisible(false);
		
		//estilizar pane carrito
		estadistico.setStyle("-fx-border-color: black;");
		estadistico.setVisible(false);
		//estilizar pane compraForm
		//compraForm.setStyle("-fx-border-color: black;");
		
		//estilizar pane compraForm
		//compraShow.setStyle("-fx-border-color: black;");
		
		//Texto del pane de compras
		Label titulo1 = new Label("Compras");
		titulo1.setStyle("-fx-border-color: black;");
		GridPane.setHalignment(titulo1, javafx.geometry.HPos.CENTER);
		Label texto1 = new Label("En esta pestaña puede añadir o eliminar productos al carrito.");
		texto1.setStyle("-fx-border-color: black;");
		GridPane.setHalignment(texto1, javafx.geometry.HPos.CENTER);
		
		//Texto del pane de carrito
		Label titulo2 = new Label("Carrito");
		titulo2.setStyle("-fx-border-color: black;");
		GridPane.setHalignment(titulo2, javafx.geometry.HPos.CENTER);
		Label texto2 = new Label("En esta pestaña pueden ver los productos \nen el carrito para luego proceder a pagarlos.");
		texto2.setStyle("-fx-border-color: black;");
		GridPane.setHalignment(texto2, javafx.geometry.HPos.CENTER);
		
		//Texto del pane de Estadisticos
		Label titulo3 = new Label("Datos estadísticos");
		titulo3.setStyle("-fx-border-color: black;");
		GridPane.setHalignment(titulo3, javafx.geometry.HPos.CENTER);
		Label texto3 = new Label("En esta pestaña pueden ver los datos estadísticos.");
		texto3.setStyle("-fx-border-color: black;");
		GridPane.setHalignment(texto3, javafx.geometry.HPos.CENTER);
		
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
		
		//margenes, espaciado y alineación del gridpane carrito
		carrito.setPadding(new Insets(10,10,10,10));
		carrito.setVgap(5);
		carrito.setHgap(5);
		carrito.setAlignment(Pos.TOP_CENTER);
		//compra.setMaxWidth(Region.USE_COMPUTED_SIZE);
		
		//margenes, espaciado y alineación del gridpane estadisticos
		estadistico.setPadding(new Insets(10,10,10,10));
		estadistico.setVgap(5);
		estadistico.setHgap(5);
		estadistico.setAlignment(Pos.TOP_CENTER);
				
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
		m1.getItems().addAll(m11,m12,m13);
		UnicoHandlerClass handler = new UnicoHandlerClass();
		m02.setOnAction(handler);
			
		m1.setOnAction(handler);
		m11.setOnAction(handler);
		m12.setOnAction(handler);
		m13.setOnAction(handler);
		Label menuLabel = new Label("Ayuda");
		menuLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
		       @Override
		       public void handle(MouseEvent event) {
		    	   	a.setAlertType(AlertType.INFORMATION);
					a.setTitle("Autores");
					a.setHeaderText(null);
					a.setContentText("Juan Pablo Oquendo \nDaniel Fernando Robledo \nWilfer Mauricio Chavarria \nFaiber Salazar");
					a.show();
		       }
		});
		Menu m2 = new Menu("",menuLabel);
		barraMenu.getMenus().addAll(m0,m1,m2);
		
		////Formulario de compras
		FieldPanel panelCompras = new Compras("Criterios", new String[]{"Código", "Cantidad"} , "Valores", new String[]{"Agregue código", "Agregue cantidad"}, new boolean[]{true, true}, productos, cantidades);
		//labels
		//Label lblCompras1 = new Label("Código del producto");
		//Label lblCompras2 = new Label("Cantidad");
		//Text fields
		//TextField t1 = new TextField();
		//t1.setPromptText("Agregue código");
		//t1.setPrefColumnCount(10);
		//TextField t2 = new TextField();
		//t2.setPromptText("Agregue cantidad");
		//t2.setPrefColumnCount(10);
		//Acción para el botón compra
		//btnCompras1.setOnAction(handler);
		
		////Menú carrito
		MostrarListas panelCarrito = new MostrarListas(productos, cantidades);
		
	    ////Menú estadisticos
		Estadisticos panelEstadistico = new Estadisticos();
		
			
		//Agregando flowpane botones al pane principal root
		root.setTop(menuBar);
		
		//agregando pane compras al borderpane principal root
		root.setCenter(inicio);
		
		
		//agregando titulo y texto al gridpane compras
		compra.add(titulo1, 0, 0);
		compra.add(texto1, 0, 1);
		
		//agregando titulo y texto al gridpane carrito
		carrito.add(titulo2, 0, 0);
		carrito.add(texto2, 0, 1);
		
		//agregando titulo y texto al gridpane estadisticos
		estadistico.add(titulo3, 0, 0);
		estadistico.add(texto3, 0, 1);
				
		//agregando gridpane de compraMenu al gridpane compras
		compra.add(panelCompras, 0, 2);
		
		//agregando gridpane de compraMenu al gridpane carrito
		carrito.add(panelCarrito, 0, 2);
		
		//agregando gridpane de compraMenu al gridpane carrito
		estadistico.add(panelEstadistico, 0, 2);
		
		//agregando gridpane de compraMenu al gridpane compras
		//compraPane.add(compraForm, 0, 0);
		//compraPane.add(compraShow, 1, 0);
		
		//agregando los elementos del gridpane compraform
		//compraForm.add(lblCompras1, 0, 0);
		//compraForm.add(t1, 1, 0);
		//compraForm.add(lblCompras2, 0, 1);
		//compraForm.add(t2, 1, 1);
		//compraForm.add(btnCompras1, 0, 4);
		//compraForm.add(btnCompras2, 1, 4);
		
		
		//Creando el scene
		Scene scene = new Scene(root, 480,300);
		this.setTitle("Tu pedido");
		this.setScene(scene);
		this.show();
		//
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
					estadistico.setVisible(false);
					carrito.setVisible(false);
					inicio.setVisible(false);
				}
				else if(control.equals(m12)){
					root.setCenter(carrito);
					carrito.setVisible(true);
					estadistico.setVisible(false);
					compra.setVisible(false);
					inicio.setVisible(false);
				}
				else if(control.equals(m13)){
					root.setCenter(estadistico);
					estadistico.setVisible(true);
					carrito.setVisible(false);
					compra.setVisible(false);
					inicio.setVisible(false);
				}
				else if(control.equals(m02)){
					new VentanaInicio();
					VentanaPrincipal.this.close();
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
}
