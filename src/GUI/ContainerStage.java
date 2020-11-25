package GUI;

import javafx.application.Application;
import javafx.stage.Stage;

public class ContainerStage extends Application {
   
	@Override
	public void start(Stage primaryStage) {
		new VentanaInicio();
		
	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
