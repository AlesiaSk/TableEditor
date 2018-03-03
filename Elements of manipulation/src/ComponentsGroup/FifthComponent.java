package ComponentsGroup;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FifthComponent extends Application implements EventHandler<ActionEvent>{
	Button button;
	TextField  textInput;
	Button button2;
	Button button3;
	TableColumn firstCol;
	TableColumn lastCol;
	public static void main (String[] args) {
		launch(args);
	}
	public void start(Stage primaryStage){
		primaryStage.setTitle("First elements");
		button = new Button("Button 1");
		StackPane layout = new StackPane();
		final ToggleGroup group = new ToggleGroup();
		TableView table = new TableView();
		firstCol = new TableColumn("The First");
        lastCol = new TableColumn("The Second");
        table.getColumns().addAll(firstCol, lastCol);
		button2 = new Button("Button2");
		button3 = new Button("Button3");
		button.setOnAction(this);
		textInput = new TextField();
		textInput.setPromptText("Enter something ");
		layout.setMargin(textInput, new Insets(50,10,10,10));
		layout.setMargin(table, new Insets(80,70,80,70));
		layout.setAlignment(textInput, Pos.TOP_CENTER);
		layout.setMargin(button, new Insets(10,10,50,10));
		layout.setAlignment(button, Pos.BOTTOM_LEFT);
		layout.setMargin(button2, new Insets(10,10,50,10));
		layout.setAlignment(button2, Pos.BOTTOM_CENTER);
		layout.setMargin(button3, new Insets(10,10,50,10));
		layout.setAlignment(button3, Pos.BOTTOM_RIGHT);
		layout.getChildren().addAll(button, textInput, button2, button3, table);
		Scene scene = new Scene(layout, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public void handle(ActionEvent event) {
		if (event.getSource() == button) {
			
	}

	}
}
