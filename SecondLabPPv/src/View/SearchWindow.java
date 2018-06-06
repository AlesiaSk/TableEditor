package View;

import Controller.Delete;
import Model.Search;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TableView;

public class SearchWindow {

	
	public static RadioButton radioButton1;
	public static RadioButton radioButton2;
	public static RadioButton radioButton3;
	public static RadioButton radioButton4;
	public static Button button;
	public static Button button1;
	public static TextField text;
	public static Table table1 = new Table();
	 
	public static void display(Boolean b) {
	Stage window = new Stage();
	Scene scene = new Scene(new Group());
	window.initModality(Modality.APPLICATION_MODAL);
	final ToggleGroup group = new ToggleGroup();
	StackPane layout = new StackPane();
	VBox vbox = new VBox();
	button = new Button("Выбрать");
	button1 = new Button("Ввести");
	text = new TextField();
	if (b == true) {
		button.setOnAction(e -> SearchWindow.kindOfSearch());
	}
	else if (b == false){
		button.setOnAction(e -> SearchWindow.kindOfDelete());
	}
	
	radioButton1 = new RadioButton("по ФИО студента");
	radioButton1.setToggleGroup(group);
	radioButton2 = new RadioButton("по ФИО родителя или месту работы");
	radioButton2.setToggleGroup(group);
	radioButton3 = new RadioButton("по стажу работы или месту работы");
	radioButton3.setToggleGroup(group);
	radioButton4 = new RadioButton("по ФИО студента или месту работы родителя");
	radioButton4.setToggleGroup(group);
	
	table1.table.setItems(MainWindow.listOfPages.get(MainWindow.numOfPage).data);
	layout.setMargin(radioButton1, new Insets(10,10,50,10));
	layout.setAlignment(radioButton1, Pos.TOP_LEFT);
	layout.setMargin(radioButton2, new Insets(30,10,50,10));
	layout.setAlignment(radioButton2, Pos.TOP_LEFT);
	layout.setMargin(radioButton3, new Insets(50,10,50,10));
	layout.setAlignment(radioButton3, Pos.TOP_LEFT);
	layout.setMargin(radioButton4, new Insets(70,10,50,10));
	layout.setAlignment(radioButton4, Pos.TOP_LEFT);
	layout.setMargin(button, new Insets(90,10,50,10));
	layout.setAlignment(button, Pos.TOP_LEFT);
	layout.setAlignment(text, Pos.BOTTOM_CENTER);
	layout.setMargin(text, new Insets(10,10,10,10));
	layout.getChildren().addAll(radioButton1, radioButton2, radioButton3, radioButton4, button, text, button1);
	vbox.setPadding(new Insets(10, 0, 0, 10));
	if (b == true) {
    vbox.getChildren().addAll(table1.vbox, layout);
	}
	else if ( b == false) {
	vbox.getChildren().addAll(table1.vbox, layout);
	}
    
    ((Group) scene.getRoot()).getChildren().addAll(vbox);
	window.setScene(scene);
	window.showAndWait();
	}
	
	public static void kindOfSearch() {
		if (radioButton1.isSelected()) {
			button1.setOnAction(e -> table1.table.setItems(Search.tableSearch(table1.table, "first")));
		}
		else if (radioButton2.isSelected()) {
			button1.setOnAction(e -> table1.table.setItems(Search.tableSearch(table1.table, "second")));
		}
		else if (radioButton3.isSelected()) {
			button1.setOnAction(e -> table1.table.setItems(Search.tableSearch(table1.table, "third")));
		}
		else if (radioButton4.isSelected()) {
			button1.setOnAction(e -> table1.table.setItems(Search.tableSearch(table1.table, "fourth")));
		}
	}
	
	public static void kindOfDelete() {
		if (radioButton1.isSelected()) {
			button1.setOnAction(e -> MainWindow.listOfPages.get(MainWindow.numOfPage).table.setItems(Delete.deleteFromTable("first", MainWindow.listOfPages.get(MainWindow.numOfPage).table)));
		}
		else if (radioButton2.isSelected()) {
			button1.setOnAction(e -> MainWindow.listOfPages.get(MainWindow.numOfPage).table.setItems(Delete.deleteFromTable("second", MainWindow.listOfPages.get(MainWindow.numOfPage).table)));
		}
		else if (radioButton3.isSelected()) {
			button1.setOnAction(e -> MainWindow.listOfPages.get(MainWindow.numOfPage).table.setItems(Delete.deleteFromTable("third", MainWindow.listOfPages.get(MainWindow.numOfPage).table)));
		}
		else if (radioButton4.isSelected()) {
			button1.setOnAction(e -> MainWindow.listOfPages.get(MainWindow.numOfPage).table.setItems(Delete.deleteFromTable("fourth", MainWindow.listOfPages.get(MainWindow.numOfPage).table)));
		}
	}
}
