package classes;

import java.awt.Button;
import java.awt.TextField;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SearchByStudent {
	static StackPane layout;
	static Button button;
	static TextField text;
	
	public static void display() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		layout = new StackPane();
		button = new Button("Найти");
		text = new TextField();
		Scene scene = new Scene(layout, 300, 300);
		window.setScene(scene);
		window.showAndWait();
	}
}
