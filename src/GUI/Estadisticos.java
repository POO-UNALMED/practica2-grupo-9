package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import GUI.Compras.UnicoHandlerClass;
import gestorAplicacion.finanzas.*;
public class Estadisticos extends FieldPanel {
	Label masVendido;
	Label cantidadCredito;
	Label ventasTotales;
	Label gananciasNetas;
	
	public void setMasVendido() {
		this.getChildren().clear();
		this.masVendido = new Label(Factura.masVendido().toString());
		this.masVendido.setLayoutX(50);
		this.masVendido.setLayoutY(0);
		this.masVendido.setWrapText(true);
		this.masVendido.setMaxWidth(200);
		this.getChildren().add(this.masVendido);
	}
	public void setCantidadCredito() {
		this.cantidadCredito = new Label("Productos vendidos con tarjeta" + " " + Integer.toString(Factura.cantProductVentDebCred()));
		this.cantidadCredito.setLayoutX(50);
		this.cantidadCredito.setLayoutY(55);
		this.getChildren().add(this.cantidadCredito);
	}
	public void setVentasTotales() {
		this.ventasTotales = new Label("Cantidad de ganancias por ventas" + " " +Integer.toString(Factura.ventasTotales()));
		this.ventasTotales.setLayoutX(50);
		this.ventasTotales.setLayoutY(80);
		this.getChildren().add(this.ventasTotales);
	}
	public void setGananciasNetas() {
		this.gananciasNetas = new Label("Cantidad de ganancias netas" + " " + Float.toString(Factura.gananciaNeta()));
		this.gananciasNetas.setLayoutX(50);
		this.gananciasNetas.setLayoutY(105);
		this.getChildren().add(this.gananciasNetas);
	}
	
	public Estadisticos() {
		super();
		
		//Texto
		this.masVendido = new Label(Factura.masVendido().toString());
		this.masVendido.setLayoutX(50);
		this.masVendido.setLayoutY(0);
		this.masVendido.setWrapText(true);
		this.masVendido.setMaxWidth(200);
		this.cantidadCredito = new Label("Productos vendidos con tarjeta" + " " + Integer.toString(Factura.cantProductVentDebCred()));
		this.cantidadCredito.setLayoutX(50);
		this.cantidadCredito.setLayoutY(55);
		this.ventasTotales = new Label("Cantidad de ganancias por ventas" + " " +Integer.toString(Factura.ventasTotales()));
		this.ventasTotales.setLayoutX(50);
		this.ventasTotales.setLayoutY(80);
		this.gananciasNetas = new Label("Cantidad de ganancias netas" + " " + Float.toString(Factura.gananciaNeta()));
		this.gananciasNetas.setLayoutX(50);
		this.gananciasNetas.setLayoutY(105);
		
		
		this.getChildren().add(this.masVendido);
		this.getChildren().add(this.cantidadCredito);
		this.getChildren().add(this.ventasTotales);
		this.getChildren().add(this.gananciasNetas);
	}
	
	
}
