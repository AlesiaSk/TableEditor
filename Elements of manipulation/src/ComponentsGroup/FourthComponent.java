package ComponentsGroup;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class FourthComponent extends Application implements EventHandler<ActionEvent>{
		Button button;
		TextField  textInput;
		CheckBox checkBox1;
		CheckBox checkBox2;
		CheckBox checkBox3;
		Alert alert;
		public static void main (String[] args) {
			launch(args);
		}
		public void start(Stage primaryStage)  {
			primaryStage.setTitle("First elements");
			button = new Button("Button 1");
			StackPane layout = new StackPane();
			checkBox1 = new CheckBox("CheckBox1");
			checkBox2 = new CheckBox("CheckBox2");
			checkBox3 = new CheckBox("CheckBox3");
			button.setOnAction(this);
			textInput = new TextField();
			textInput.setPromptText("Enter something ");
			alert = new Alert(AlertType.ERROR);
			layout.setMargin(textInput, new Insets(50,10,10,10));
			layout.setAlignment(textInput, Pos.TOP_CENTER);
			layout.setMargin(checkBox1, new Insets(10,10,50,10));
			layout.setAlignment(checkBox1, Pos.BOTTOM_LEFT);
			layout.setMargin(checkBox2, new Insets(10,10,50,10));
			layout.setAlignment(checkBox2, Pos.BOTTOM_CENTER);
			layout.setMargin(checkBox3, new Insets(10,10,50,10));
			layout.setAlignment(checkBox3, Pos.BOTTOM_RIGHT);
			layout.getChildren().addAll(button, textInput, checkBox1, checkBox2, checkBox3);
			Scene scene = new Scene(layout, 300, 300);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}
		public void handle(ActionEvent event) {
			if (event.getSource() == button) {
				if (textInput.getText().equals(checkBox1.getText())) {
					if (checkBox1.isSelected()) {
						checkBox1.setSelected(false);
					}
					else{
						checkBox1.setSelected(true);
					}
				}
				if (textInput.getText().equals(checkBox2.getText())) {
					if (checkBox2.isSelected()) {
						checkBox2.setSelected(false);
					}
					else{
						checkBox2.setSelected(true);
					}
				}
				if (textInput.getText().equals(checkBox3.getText())) {
					if (checkBox3.isSelected()) {
						checkBox3.setSelected(false);
					}
					else{
						checkBox3.setSelected(true);
					}
				}
				if (!(textInput.getText().equals((checkBox1.getText())) || textInput.getText().equals((checkBox2.getText())) || textInput.getText().equals((checkBox3.getText())) )){
					alert.setTitle("Error");
					alert.setContentText("This element doesn't exist!");

					alert.showAndWait();	
				}
		}
	}
	
}
