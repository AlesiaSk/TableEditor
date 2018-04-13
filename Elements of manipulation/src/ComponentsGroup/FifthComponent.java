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
import ComponentsGroup.TableData;
import javafx.collections.*;
import javafx.scene.control.cell.*;;

public class FifthComponent extends Application implements EventHandler<ActionEvent>{
	Button button;
	TextField  textInput;
	Button button2;
	Button button3;
	TableColumn<TableData, String> firstCol;
	TableColumn lastCol; 
	TableView<TableData> table;
	TableData dataTab;
	public static void main (String[] args) {
		launch(args);
	}
	
	private ObservableList<TableData> data = FXCollections.observableArrayList();
	
	public void start(Stage primaryStage){
		primaryStage.setTitle("First elements");
		button = new Button("Button 1");
		StackPane layout = new StackPane();
		final ToggleGroup group = new ToggleGroup();
		table = new TableView<TableData>();
		dataTab = new TableData();
		firstCol = new TableColumn<TableData, String>("The First");
        lastCol = new TableColumn("The Second");
        table.getColumns().addAll(firstCol, lastCol);
		button2 = new Button("Button2");
		button3 = new Button("Button3");
		button.setOnAction(this);
		button2.setOnAction(this);
		button3.setOnAction(this);
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
		table.setItems(data);
		
	}
		
	public void handle(ActionEvent event) {
		if (event.getSource() == button) {
			
			data.add(new TableData(new String(textInput.getText())));
			firstCol.setCellValueFactory(new PropertyValueFactory<>(textInput.getText()));
			
		}
		if (event.getSource() == button2) {
			lastCol.setText(firstCol.getText());
			}
		if (event.getSource() == button3) {
			firstCol.setText(lastCol.getText());
			}

	}
}
