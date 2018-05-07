package ComponentsGroup;
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
public class MainClass extends Application implements EventHandler<ActionEvent>  {

	Button button;
	ComboBox<String> comboBox;
	TextField  textInput;
	StackPane layout;
	
	public static void main (String[] args) {
		launch(args);
	}
	public void MainClass(Button button, TextField textField, StackPane stackPane, ComboBox<String> comboBox) {
		this.button = button;
		this.layout = stackPane;
		this.textInput = textField;
		this.comboBox = comboBox;
	}
	public void start(Stage primaryStage)  {
		primaryStage.setTitle("First elements");
		button = new Button("Click here");
		comboBox = new ComboBox<>();
		layout = new StackPane();
		button.setOnAction(this);
		textInput = new TextField();
		textInput.setPromptText("Enter something ");
		comboBox.setEditable(true);
		comboBox.setPromptText(textInput.getText());
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
			comboBox.getItems().add(textInput.getText());
	}
	}
	
}
