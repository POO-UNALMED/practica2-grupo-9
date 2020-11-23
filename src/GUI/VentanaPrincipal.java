package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class VentanaPrincipal extends Application{

	@Override
	public void start(Stage primaryStage){
		//pane principal
		GridPane root = new GridPane();
		//pane botones
		FlowPane botones = new FlowPane();
		//pane botón 1 compras
		GridPane compra = new GridPane();
		compra.setStyle("-fx-border-color: black;");
		//pane compras interno
		GridPane compraMenu = new GridPane();
		compraMenu.setStyle("-fx-border-color: black;");
		//Texto del panel de compras
		Label titulo1 = new Label("Compras");
		titulo1.setStyle("-fx-border-color: black;");
		GridPane.setHalignment(titulo1, javafx.geometry.HPos.CENTER);
		Label texto1 = new Label("En esta pestaña puede añadir productos al carrito para luego proceder a pagarlos.");
		texto1.setStyle("-fx-border-color: black;");
		GridPane.setHalignment(texto1, javafx.geometry.HPos.CENTER);
		//dimensiones del pane
		root.setPadding(new Insets(10,10,10,10));
		root.setVgap(5);
		root.setHgap(5);
		root.setAlignment(Pos.TOP_LEFT);
		//dimensiones del flowpane
		botones.setPadding(new Insets(10,10,10,10));
		botones.setVgap(2);
		botones.setHgap(4);
		//dimensiones del pane de compras
		compra.setPadding(new Insets(10,10,10,10));
		compra.setVgap(5);
		compra.setHgap(5);
		compra.setAlignment(Pos.TOP_CENTER);
		//dimensiones del pane de compraMenu
		compra.setPadding(new Insets(10,10,10,10));
		compra.setVgap(5);
		compra.setHgap(5);
		compra.setAlignment(Pos.BOTTOM_CENTER);
		//Botones del flowpane
		Button boton1 = new Button("Archivo");
		Button boton2 = new Button("Archivo2");
		Button boton3 = new Button("Archivo3");
		botones.getChildren().add(boton1);
		botones.getChildren().add(boton2);
		botones.getChildren().add(boton3);
		
		
		//Agregando flowpane al pane principal
		root.add(botones, 0, 0);
		//agregando pane compras
		root.add(compra, 0, 1);
		//agregando pane de texto compras
		compra.add(titulo1, 0, 0);
		compra.add(texto1, 0, 1);
		//agregando pane de compraMenu
		compra.add(compraMenu, 0, 2);
		
		
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
	
}
