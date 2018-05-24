package classes;

import java.util.ArrayList;
import java.util.List;

import classes.MainClass.Address;
import classes.MainClass.Job;
import classes.MainClass.Person;
import classes.MainClass.TableInfo;
import classes.MainClass.WorkExperience;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control. ComboBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class Add  {
	static Button button;
	static StackPane layout;
	static TextField addStudent;
	static TextField addParent;
	static TextField addAddress;
	static TextField addJob;
	static TextField addExp;
	public static void display() {
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		button = new Button("Добавить");
		button.setOnAction(e -> Add.addInfo());
		addStudent = new TextField();
		addStudent.setPromptText("Введите ФИО студента");
		addParent = new TextField();
		addParent.setPromptText("Введите ФИО родителя");
		addAddress = new TextField();
		addAddress.setPromptText("Введите адрес работы родителя");
		addJob = new TextField();
		addJob.setPromptText("Введите должность родителя");
		addExp = new TextField();
		addExp.setPromptText("Введите стаж работы родителя");
		layout = new StackPane();
		layout.setMargin(addStudent, new Insets(10,10,50,10));
		layout.setAlignment(addStudent, Pos.TOP_LEFT);
		layout.setMargin(addParent, new Insets(50,10,50,10));
		layout.setAlignment(addParent, Pos.TOP_LEFT);
		layout.setMargin(addAddress, new Insets(90,10,50,10));
		layout.setAlignment(addAddress, Pos.TOP_LEFT);
		layout.setMargin(addJob, new Insets(130,10,50,10));
		layout.setAlignment(addJob, Pos.TOP_LEFT);
		layout.setMargin(addExp, new Insets(170,10,50,10));
		layout.setAlignment(addExp, Pos.TOP_LEFT);
		layout.setMargin(button, new Insets(210,10,50,10));
		layout.setAlignment(button, Pos.TOP_CENTER);
		layout.getChildren().addAll(button, addStudent, addParent, addJob, addExp, addAddress);
		Scene scene = new Scene(layout, 300, 300);
		window.setScene(scene);
		window.showAndWait();
	
}
	public static void addInfo() {
		ArrayList<String[]> list = new ArrayList<String[]>();
   		Person A = new Person(addStudent.getText(), addParent.getText());
   		Address adr = new Address(addAddress.getText());
   		Job job = new Job(addJob.getText());
   		WorkExperience exp = new WorkExperience(Integer.parseInt(addExp.getText()));
   		MainClass.data.add(new TableInfo(A.first, A.second, adr.third , job.fourth, exp.fifth));
   		addStudent.clear();
   		addParent.clear();
   		addAddress.clear();
   		addJob.clear();
   		addExp.clear();
	}
}