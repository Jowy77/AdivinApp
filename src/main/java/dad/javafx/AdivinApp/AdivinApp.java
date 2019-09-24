package dad.javafx.AdivinApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {
	
	private TextField nombreText;
	private Button comprobarButton;
	private Label resultadoLabel;
	private int numero = (int) (Math.random() * (100 - 1) + 1);
	private int numIntentos = 1;
	public void start(Stage primaryStage) throws Exception {
	nombreText = new TextField();
	nombreText.setPromptText("0");
	nombreText.setMaxWidth(150);

	resultadoLabel = new Label("Introduce un numero del uno al 100");

	comprobarButton = new Button("Comprobar");
	comprobarButton.setDefaultButton(true);
	comprobarButton.setOnAction(e -> onAdivinarButtonAction(e));

	VBox root = new VBox();
	root.setSpacing(5);
	root.setAlignment(Pos.CENTER);
	root.getChildren().addAll(resultadoLabel,nombreText, comprobarButton);

	Scene scene = new Scene(root, 320, 200);

	primaryStage.setTitle("AdivinApp");
	primaryStage.setScene(scene);
	primaryStage.show();
	
	}
	
	private void onAdivinarButtonAction(ActionEvent e) {
		try {
			
		int numeroAdivinado = Integer.parseInt(nombreText.getText());
		
		if (numeroAdivinado==numero) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("Has ganado");
			alert.setContentText("Solo has necesitado: "+ numIntentos + " intentos."
					+"\n Vuelve a jugar y hazla mejor");

			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("Has fallado");
			alert.setContentText("El numero a adivinar es " + esMayor(numeroAdivinado)+ " que "+numeroAdivinado);

			alert.showAndWait();
			numIntentos++;
		}
		
		}catch(NumberFormatException b) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("Error");
			alert.setContentText("El numero introducido no es valido");

			alert.showAndWait();
		}
		
	
		
	}
	
	public static void main (String [] args) {
		launch(args);
	}
	
	public String esMayor(int num) {
		String a = " mayor";
		if(num>numero)
			 a = " menor";
		return a;
	}
	
}
