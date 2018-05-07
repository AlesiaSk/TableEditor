package ComponentsGroup;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;

public class SecondComponent extends Application implements EventHandler<ActionEvent>{
	Button button;
	Button button2;
	TextField  textInput;
	StackPane layout;
	public static void main (String[] args) {
		launch(args);
	}
	public void SecondComponent(Button button1, Button button2, TextField textField, StackPane stackPane) {
		this.button = button1;
		this.button2 = button2;
		this.textInput = textField;
		this.layout = stackPane;
	}
	public void start(Stage primaryStage)  {
		primaryStage.setTitle("First elements");
		button = new Button("Button 1");
		button2 = new Button ("Button 2");
		layout = new StackPane();
		button.setOnAction(this);
		button2.setOnAction(this);
		textInput = new TextField();
		textInput.setPromptText("Enter something ");
		layout.setMargin(textInput, new Insets(50,10,10,10));
		layout.setAlignment(textInput, Pos.TOP_CENTER);
		layout.setMargin(button2, new Insets(10,10,50,10));
		layout.setAlignment(button2, Pos.BOTTOM_CENTER);
		layout.getChildren().addAll(button, button2, textInput);
		Scene scene = new Scene(layout, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public void handle(ActionEvent event) {
		if (event.getSource() == button) {
			button2.setText(textInput.getText());
	}
		if (event.getSource() == button2) {
			String textfrombutton1 = button.getText();
			String textfrombutton2 = button2.getText();
			button.setText(textfrombutton2);
			button2.setText(textfrombutton1);
		}
	}
}
