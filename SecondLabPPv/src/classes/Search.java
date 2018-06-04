package classes;


import javafx.scene.control.Button;
import classes.MainClass.TableInfo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
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
	window.initModality(Modality.APPLICATION_MODAL);
	final ToggleGroup group = new ToggleGroup();
	layout = new StackPane();
	button = new Button("�������");
	button.setOnAction(e -> Search.kindOfSearch());
	radioButton1 = new RadioButton("�� ��� ��������");
	radioButton1.setToggleGroup(group);
	radioButton2 = new RadioButton("�� ��� �������� ��� ����� ������");
	radioButton2.setToggleGroup(group);
	radioButton3 = new RadioButton("�� ����� ������ ��� ����� ������");
	radioButton3.setToggleGroup(group);
	radioButton4 = new RadioButton("�� ��� �������� ��� ����� ������ ��������");
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
	
	public static void kindOfSearch() {
		if (radioButton1.isSelected()) {
			SearchByStudent.display();
		}
		else if (radioButton2.isSelected()) {
			SearchByParentAndWork.display();
		}
		else if (radioButton3.isSelected()) {
			SearchByExpOrJob.display();
		}
		else if (radioButton4.isSelected()) {
			SearchByStudentOrJob.display();
		}
	}
}
