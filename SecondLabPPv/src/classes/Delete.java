package classes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Delete {
	static StackPane layout;
	static RadioButton radioButton1;
	static RadioButton radioButton2;
	static RadioButton radioButton3;
	static RadioButton radioButton4;
	static Button button;
	
	 
	public static void display() {
	Stage window = new Stage();
	window.initModality(Modality.APPLICATION_MODAL);
	final ToggleGroup group = new ToggleGroup();
	layout = new StackPane();
	button = new Button("Выбрать");
	button.setOnAction(e -> Delete.kindOfDelete());
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
	layout.getChildren().addAll(radioButton1, radioButton2, radioButton3, radioButton4, button);
	Scene scene = new Scene(layout, 300, 300);
	window.setScene(scene);
	window.showAndWait();
	}
	
	public static void kindOfDelete() {
		if (radioButton1.isSelected()) {
			DeleteByStudent.display();
		}
		else if (radioButton2.isSelected()) {
			DeleteByParentAndWork.display();
		}
		else if (radioButton3.isSelected()) {
			DeleteByExpOrJob.display();
		}
		else if (radioButton4.isSelected()) {
			DeleteByStudentOrJob.display();
		}
	}
}
