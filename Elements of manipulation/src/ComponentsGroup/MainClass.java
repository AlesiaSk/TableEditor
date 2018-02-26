package ComponentsGroup;
import javax.swing.ComboBoxEditor;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control. ComboBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
public class MainClass extends Application implements EventHandler<ActionEvent> {
	Button button;
	public static void main (String[] args) {
		launch(args);
	}
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("First elements");
		button = new Button("Click here");
		ComboBox<String> comboBox = new ComboBox<>();
		StackPane layout = new StackPane();
		button.setOnAction(this);
		TextField textInput = new TextField();
		textInput.setPromptText("Enter something ");
		comboBox.setEditable(true);
		layout.setMargin(comboBox, new Insets (10,10,50,10));
		layout.setAlignment(comboBox, Pos.BOTTOM_CENTER);
		layout.setMargin(textInput, new Insets(50,10,10,10));
		layout.setAlignment(textInput, Pos.TOP_CENTER);
		layout.getChildren().addAll(button, comboBox, textInput);
		Scene scene = new Scene(layout, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public void handle(ActionEvent event) {
		if (event.getSource() == button) {
			
	}
	}
}
