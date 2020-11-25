package GUI;

import java.util.ArrayList;
import java.util.List;

import exceptions.IngreseEntero;
import exceptions.InventarioIncorrecto;
import exceptions.noExisteElProducto;
import gestorAplicacion.productos.Producto;
import uiMain.MenuTienda;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Compras extends FieldPanel {
	
	Button btn1 = new Button("Añadir");
	Button btn2 = new Button("Eliminar");
	public static List<Producto> productos = new ArrayList<Producto>();
	public static List<Integer> cantidades = new ArrayList<Integer>();
	List<TextField> elements = super.elementos;
	UnicoHandlerClass eventos = new UnicoHandlerClass();
	Alert a = new Alert(AlertType.NONE);
	
	public static List<Producto> getProductos(){
		return productos;
	}
	public static List<Integer> getCantidades(){
		return cantidades;
	}
	
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
		btn2.setOnAction(eventos);
		
	}
	
	
	
	public void agregar(List<Producto> productos, List<Integer> cantidades, List<TextField> elem) throws noExisteElProducto, IndexOutOfBoundsException, InventarioIncorrecto{
		MenuTienda.validarProducto(Integer.parseInt(elem.get(0).getText()), Integer.parseInt(elem.get(1).getText()), productos, cantidades);
		System.out.println(productos);
		System.out.println(cantidades);
	}
	
	public void elimina(List<Producto> productos, List<Integer> cantidades, List<TextField> elem) throws noExisteElProducto, InventarioIncorrecto, NumberFormatException, IndexOutOfBoundsException {
		MenuTienda.eliminarProducto(productos, cantidades, Integer.parseInt(elem.get(0).getText()), Integer.parseInt(elem.get(1).getText()));
		System.out.println(productos);
		System.out.println(cantidades);
	}

	class UnicoHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Object control=event.getSource();
			if(control instanceof Button){
				if(control.equals(btn1)){
					try {
						agregar(productos, cantidades, elements);
					} catch (NumberFormatException error) {
						a.setAlertType(AlertType.WARNING);
						a.setTitle("Error");
						a.setHeaderText(null);
						a.setContentText(new IngreseEntero().toString());
						a.show();
						
					} catch (IndexOutOfBoundsException error) {
						a.setAlertType(AlertType.WARNING);
						a.setTitle("Error");
						a.setHeaderText(null);
						a.setContentText(error.toString());
						a.show();
						//System.out.println();
					} catch (noExisteElProducto error) {
						a.setAlertType(AlertType.WARNING);
						a.setTitle("Error");
						a.setHeaderText(null);
						a.setContentText(error.toString());
						a.show();
						//System.out.println();
					} catch (InventarioIncorrecto error) {
						a.setAlertType(AlertType.WARNING);
						a.setTitle("Error");
						a.setHeaderText(null);
						a.setContentText(error.toString() + " " + error.diferenciaInventario());
						a.show();
						//System.out.println();
					} 
					
					
					elements.get(0).setText("");
					elements.get(1).setText("");
				}
				else if(control.equals(btn2)){
					try {
						elimina(productos, cantidades, elements);
					} 
					 catch (ArrayIndexOutOfBoundsException error) {
							a.setAlertType(AlertType.WARNING);
							a.setTitle("Error");
							a.setHeaderText(null);
							a.setContentText(error.toString());
							a.show();
							//System.out.println();
						} 
					catch (NumberFormatException error) {
						a.setAlertType(AlertType.WARNING);
						a.setTitle("Error");
						a.setHeaderText(null);
						a.setContentText(new IngreseEntero().toString());
						a.show();
						
					} catch (IndexOutOfBoundsException error) {
						a.setAlertType(AlertType.WARNING);
						a.setTitle("Error");
						a.setHeaderText(null);
						a.setContentText(error.toString());
						a.show();
						//System.out.println();
					} catch (noExisteElProducto error) {
						a.setAlertType(AlertType.WARNING);
						a.setTitle("Error");
						a.setHeaderText(null);
						a.setContentText(error.toString());
						a.show();
						//System.out.println();
					} catch (InventarioIncorrecto error) {
						a.setAlertType(AlertType.WARNING);
						a.setTitle("Error");
						a.setHeaderText(null);
						a.setContentText(error.toString() + " " + error.diferenciaInventario());
						a.show();
						//System.out.println();
					} 
				}
			}
			
		}


	}
	
}


