package classes;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control. ComboBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class Add extends Application implements EventHandler<ActionEvent>{
	
	Button button;
	StackPane layout;
	TextField addStudent;
	
	public static void main (String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage)  {
		button = new Button("Add");
		button.setOnAction(this);
		addStudent = new TextField();
		layout = new StackPane();
		layout.getChildren().addAll(button, addStudent);
		Scene scene = new Scene(layout, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
}
	public void handle(ActionEvent event) {
		
	}
}