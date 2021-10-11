package dad;

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

public class AdivinaApp extends Application {
	
	private Label adivinaLabel;
	private TextField adivinaTexto;
	private Button comprobarBoton;
	int random = (int) (Math.random()*100 +1), intentos=0;

	public void start(Stage primaryStage) throws Exception {
		
		adivinaLabel = new Label("Introduce un número del 1 al 100.");
		adivinaLabel.setWrapText(true);
		
		adivinaTexto = new TextField();
		adivinaTexto.setPromptText("Esperando número...");
		adivinaTexto.setMaxWidth(150);
		
		comprobarBoton = new Button("Comprobar");
		comprobarBoton.setDefaultButton(true);
		comprobarBoton.setOnAction(e -> onVerificarButtonAction(e));
		
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setFillWidth(false);
		root.getChildren().addAll(adivinaLabel, adivinaTexto, comprobarBoton);
		
		Scene scene = new Scene(root, 320, 200);
		primaryStage.setTitle("AdivinaApp");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
private void onVerificarButtonAction(ActionEvent e) {
		
		String numeroText = adivinaTexto.getText();
		
		try {
			int numero = Integer.parseInt(numeroText);
			if(numero==random) {
				intentos++;
				Alert ganarAlert = new Alert(AlertType.INFORMATION);
				ganarAlert.setTitle("AdivinApp");
				ganarAlert.setHeaderText("¡Has ganado!");
				ganarAlert.setContentText("Sólo has necesitado "+intentos+" intentos\nVuelve a jugar y hazlo mejor.");

				ganarAlert.showAndWait();
				
			}else if(numero<random) {
				intentos++;
				Alert fallarAlert = new Alert(AlertType.WARNING);
				fallarAlert.setTitle("AdivinApp");
				fallarAlert.setHeaderText("¡Has fallado!");
				fallarAlert.setContentText("El número a adivinar es mayor que "+numero);
				
				fallarAlert.showAndWait();
			}else if (numero>random){
				intentos++;
				Alert fallarAlert = new Alert(AlertType.WARNING);
				fallarAlert.setTitle("AdivinApp");
				fallarAlert.setHeaderText("¡Has fallado!");
				fallarAlert.setContentText("El número a adivinar es menor que "+numero);
				
				fallarAlert.showAndWait();
			}else{
				Alert invalido = new Alert(AlertType.ERROR);
				invalido.setTitle("AdivinApp");
				invalido.setHeaderText("Algo ha fallado");
				invalido.setContentText("El número introducido no es válido, verifica los rangos.");

				invalido.showAndWait();
			}
				
		} catch (NumberFormatException error){
			Alert noNumber = new Alert(AlertType.ERROR);
			noNumber.setTitle("AdivinApp");
			noNumber.setHeaderText("Error");
			noNumber.setContentText("No has introducido un número.");

			noNumber.showAndWait();
		}
	
	}

	public static void main(String[] args) {
		launch(args);

	}

}
