package ComponentsGroup;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ThirdComponent extends Application implements EventHandler<ActionEvent>{
	Button button;
	TextField  textInput;
	RadioButton radioButton1;
	RadioButton radioButton2;
	RadioButton radioButton3;
	Alert alert;
	StackPane layout;
	public static void main (String[] args) {
		launch(args);
	}
	public void ThirdComponent(Button button, TextField textField, RadioButton radiobutton1, RadioButton radiobutton2, RadioButton radiobutton3, StackPane stackPane, Alert alert) {
		this.button = button;
		this.alert = alert;
		this.layout = stackPane;
		this.radioButton1 = radiobutton1;
		this.radioButton2 = radiobutton2;
		this.radioButton3 = radiobutton3;
		this.textInput = textField;
		
	}
	public void start(Stage primaryStage) {
		primaryStage.setTitle("First elements");
		button = new Button("Button 1");
		layout = new StackPane();
		alert = new Alert(AlertType.ERROR);
		final ToggleGroup group = new ToggleGroup();
		radioButton1 = new RadioButton("RadioButton1");
		radioButton1.setToggleGroup(group);
		radioButton2 = new RadioButton("RadioButton2");
		radioButton2.setToggleGroup(group);
		radioButton3 = new RadioButton("RadioButton3");
		radioButton3.setToggleGroup(group);
		button.setOnAction(this);
		textInput = new TextField();
		textInput.setPromptText("Enter something ");
		layout.setMargin(textInput, new Insets(50,10,10,10));
		layout.setAlignment(textInput, Pos.TOP_CENTER);
		layout.setMargin(radioButton1, new Insets(10,10,50,10));
		layout.setAlignment(radioButton1, Pos.BOTTOM_LEFT);
		layout.setMargin(radioButton2, new Insets(10,10,50,10));
		layout.setAlignment(radioButton2, Pos.BOTTOM_CENTER);
		layout.setMargin(radioButton3, new Insets(10,10,50,10));
		layout.setAlignment(radioButton3, Pos.BOTTOM_RIGHT);
		layout.getChildren().addAll(button, textInput, radioButton1, radioButton2, radioButton3);
		Scene scene = new Scene(layout, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public void handle(ActionEvent event) {
		if (event.getSource() == button) {
			if (textInput.getText().equals(radioButton1.getText())) {
				radioButton1.setSelected(true);
			}
			if (textInput.getText().equals(radioButton2.getText())) {
				radioButton2.setSelected(true);
			}
			if (textInput.getText().equals(radioButton3.getText())) {
				radioButton3.setSelected(true);
			}
			if (!(textInput.getText().equals((radioButton1.getText())) || textInput.getText().equals((radioButton2.getText())) || textInput.getText().equals((radioButton3.getText())) )){
				alert.setTitle("Error");
				alert.setContentText("This element doesn't exist!");

				alert.showAndWait();	
			}
	}
	}
}

