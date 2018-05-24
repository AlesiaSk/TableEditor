package classes;

import java.awt.Button;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Search {
	static StackPane layout;
	static RadioButton radioButton1;
	static RadioButton radioButton2;
	static RadioButton radioButton3;
	static RadioButton radioButton4;
	static Button button;
	
	public static void display() {
	Stage window = new Stage();
	final ToggleGroup group = new ToggleGroup();
	window.initModality(Modality.APPLICATION_MODAL);
	layout = new StackPane();
	radioButton1 = new RadioButton("по ФИО студента");
	radioButton1.setToggleGroup(group);
	radioButton2 = new RadioButton("по ФИО родителя или месту работы");
	radioButton2.setToggleGroup(group);
	radioButton3 = new RadioButton("по стажу работы или месту работы");
	radioButton3.setToggleGroup(group);
	radioButton4 = new RadioButton("по ФИО студента или месту работы родителя");
	radioButton4.setToggleGroup(group);
	layout.setMargin(radioButton1, new Insets(10,10,50,10));
	layout.setAlignment(radioButton1, Pos.TOP_LEFT);
	layout.setMargin(radioButton2, new Insets(30,10,50,10));
	layout.setAlignment(radioButton2, Pos.TOP_LEFT);
	layout.setMargin(radioButton3, new Insets(50,10,50,10));
	layout.setAlignment(radioButton3, Pos.TOP_LEFT);
	layout.setMargin(radioButton4, new Insets(70,10,50,10));
	layout.setAlignment(radioButton4, Pos.TOP_LEFT);
	layout.getChildren().addAll(radioButton1, radioButton2, radioButton3, radioButton4);
	Scene scene = new Scene(layout, 300, 300);
	window.setScene(scene);
	window.showAndWait();
	}
	
}
