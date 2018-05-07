package classes;

import classes.MainClass.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Table extends Application{
	TableView<Person> table;
	public static void main (String[] args) {
		launch(args);
	}
	public void start(Stage primaryStage)  {
	StackPane layout = new StackPane();
	table = new TableView<>();
    ObservableList<Person> data =
           FXCollections.observableArrayList();
    TableColumn studentFIO = new TableColumn("ФИО студента");
    table.setEditable(true);
    studentFIO.setMinWidth(150);
    studentFIO.setCellValueFactory(
            new PropertyValueFactory<>("firstName"));
   
    TableColumn parentFIO = new TableColumn("ФИО родителя");
    parentFIO.setMinWidth(150);
    parentFIO.setCellValueFactory(
            new PropertyValueFactory<>("lastName"));
    
    TableColumn address = new TableColumn("Адрес работы родителя");
    address.setMinWidth(150);
    address.setCellValueFactory(
            new PropertyValueFactory<>("lastName"));
    
    TableColumn parentWork = new TableColumn("Должность родителя");
    parentWork.setMinWidth(150);
    parentWork.setCellValueFactory(
            new PropertyValueFactory<>("lastName"));
    
    TableColumn workExperience = new TableColumn("Стаж работы родителя");
    workExperience.setMinWidth(150);
    workExperience.setCellValueFactory(
            new PropertyValueFactory<>("lastName"));
    
    table.setItems(data);
    table.getColumns().addAll(studentFIO, parentFIO, address, parentWork, workExperience);
   
    layout.getChildren().addAll(table);
    Scene scene = new Scene(layout, 750, 300);
	primaryStage.setScene(scene);
	primaryStage.show();
	}
    
}
