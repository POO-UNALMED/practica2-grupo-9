package GUI;

import BaseDatos.Reader;
import BaseDatos.Writer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class VentanaInicio extends Stage{
	Label lbl = new Label();
	TextField txf = new TextField();
	TextArea txa = new TextArea();
	MenuItem salir = new MenuItem("Salir");
	MenuItem descr = new MenuItem("Descripcion");
	Button btn = new Button("Ir");
	
	

	VentanaInicio(){
		new Reader();
		//Paneles
		BorderPane root = new BorderPane();
		GridPane p0 = new GridPane();
		GridPane p1 = new GridPane();
		GridPane p2 = new GridPane();
		GridPane p3 = new GridPane();
		GridPane p4 = new GridPane();
		GridPane p5 = new GridPane();
		GridPane p6jp = new GridPane();
		GridPane p6df = new GridPane();
		GridPane p6wm = new GridPane();
		GridPane p6f = new GridPane();
		MenuBar bar = new MenuBar();
		Menu inicio = new Menu("Inicio");
		SeparatorMenuItem separator = new SeparatorMenuItem();
		Label lblJP = new Label();
		Label lblDF = new Label();
		Label lblWM = new Label();
		Label lblF = new Label();
		UnicoHandlerClass handler = new UnicoHandlerClass();
		
		ImageView jp1 = new ImageView("/img/jp1.JPG");
		ImageView jp2 = new ImageView("/img/jp2.JPG");
		ImageView jp3 = new ImageView("/img/jp3.JPG");
		ImageView jp4 = new ImageView("/img/jp4.JPG");
		ImageView df1 = new ImageView("/img/df1.JPG");
		ImageView df2 = new ImageView("/img/df2.JPG");
		ImageView df3 = new ImageView("/img/df3.JPG");
		ImageView df4 = new ImageView("/img/df4.JPG");
		ImageView wm1 = new ImageView("/img/wm1.JPG");
		ImageView wm2 = new ImageView("/img/wm2.JPG");
		ImageView wm3 = new ImageView("/img/wm3.JPG");
		ImageView wm4 = new ImageView("/img/wm4.JPG");
		ImageView f1 = new ImageView("/img/f1.JPG");
		ImageView f2 = new ImageView("/img/f2.JPG");
		ImageView f3 = new ImageView("/img/f3.JPG");
		ImageView f4 = new ImageView("/img/f4.JPG");
		
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
		p2.add(p6jp,0,1);
		p2.add(p6df,0,1);
		p2.add(p6wm,0,1);
		p2.add(p6f,0,1);
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
		lblJP.setText("JUAN PABLO OQUENDO HINCAPIE...\n"
				+ "Estudiante de ingenieria de sistemas e informatica\n"
				+ "en la Universidad Nacional de Colombia.\n"
				+ "EDAD: 22 .\n"
				+ "SEMESTRE: Octavo .");
		lblDF.setText("WILFER MAURICIO CHAVARRIA JARAMILLO\n"
				+ "Estudiante de ingenieria de sistemas e informatica\n"
				+ "en la Universidad Nacional de Colombia.\n"
				+ "EDAD: 24 .\n"
				+ "SEMESTRE: Octavo.");
		lblWM.setText("DANIEL FERNANDO ROBLEDO MESA...\n"
				+ "Estudiante de ingenieria de sistemas e informatica\n"
				+ "en la Universidad Nacional de Colombia.\n"
				+ "EDAD: 23 .\n"
				+ "SEMESTRE: Quinto");
		lblF.setText("FAIBER...\n"
				+ "Estudiante de ingenieria de sistemas e informatica\n"
				+ "en la Universidad Nacional de Colombia.\n"
				+ "EDAD: 26 .\n"
				+ "SEMESTRE: Septimo.");
		p5.add(lblJP, 0, 0);
		p5.add(lblDF, 0, 0);
		p5.add(lblWM, 0, 0);
		p5.add(lblF, 0, 0);
		lblF.setVisible(false);
		lblDF.setVisible(false);
		lblWM.setVisible(false);
		
		//GridPane p6
		p6jp.setStyle("-fx-border-color: black;");
		p6jp.setPadding(new Insets(10,10,10,10));
		p6df.setStyle("-fx-border-color: black;");
		p6df.setPadding(new Insets(10,10,10,10));
		p6wm.setStyle("-fx-border-color: black;");
		p6wm.setPadding(new Insets(10,10,10,10));
		p6f.setStyle("-fx-border-color: black;");
		p6f.setPadding(new Insets(10,10,10,10));
		//Image image = new Image("File:image/myfile.jpg")
		p6jp.add(jp1,0,0);
		p6jp.add(jp2,0,1);
		p6jp.add(jp3,1,0);
		p6jp.add(jp4,1,1);
		p6df.add(df1,0,0);
		p6df.add(df2,0,1);
		p6df.add(df3,1,0);
		p6df.add(df4,1,1);
		p6wm.add(wm1,0,0);
		p6wm.add(wm2,0,1);
		p6wm.add(wm3,1,0);
		p6wm.add(wm4,1,1);
		p6f.add(f1,0,0);
		p6f.add(f2,0,1);
		p6f.add(f3,1,0);
		p6f.add(f4,1,1);
		p6df.setVisible(false);
		p6wm.setVisible(false);
		p6f.setVisible(false);
		
		
		
		
		lblJP.setOnMouseClicked(new EventHandler<MouseEvent>() {
		       @Override
		       public void handle(MouseEvent event) {
		    	   lblJP.setVisible(false);
		    	   lblDF.setVisible(true);
		    	   p6jp.setVisible(false);
		    	   p6df.setVisible(true);
		       }
		});
		lblDF.setOnMouseClicked(new EventHandler<MouseEvent>() {
		       @Override
		       public void handle(MouseEvent event) {
		    	   lblDF.setVisible(false);
		    	   lblWM.setVisible(true);
		    	   p6df.setVisible(false);
		    	   p6wm.setVisible(true);
		       }
		});
		lblWM.setOnMouseClicked(new EventHandler<MouseEvent>() {
		       @Override
		       public void handle(MouseEvent event) {
		    	   lblWM.setVisible(false);
		    	   lblF.setVisible(true);
		    	   p6wm.setVisible(false);
		    	   p6f.setVisible(true);
		       }
		});
		lblF.setOnMouseClicked(new EventHandler<MouseEvent>() {
		       @Override
		       public void handle(MouseEvent event) {
		    	   lblF.setVisible(false);
		    	   lblJP.setVisible(true);
		    	   p6f.setVisible(false);
		    	   p6jp.setVisible(true);
		       }
		});
		
		btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
		       @Override
		       public void handle(MouseEvent event) {
		    	   new VentanaPrincipal();
		    	   VentanaInicio.this.close();
		       }
		});
		
		
		//Creando el scene
		Scene scene = new Scene(root, 480,300);
		this.setTitle("Tu pedido");
		this.setScene(scene);
		this.show();
	}
	
	//Un solo manejador de eventos
	class UnicoHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			Object control=e.getSource();
			if(control instanceof MenuItem){
				if(control.equals(salir)){
					new Writer();
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
			
		}
	}
}
