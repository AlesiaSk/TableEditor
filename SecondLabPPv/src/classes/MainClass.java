package classes;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import javafx.scene.control.MenuBar;

public class MainClass extends Application implements EventHandler<ActionEvent>{
	 
    TableView<Person> table = new TableView<>();
    ObservableList<Person> data =
           FXCollections.observableArrayList();
    HBox hb = new HBox();
    ArrayList<String[]> list;
    Button addButton2 = new Button("Найти");
    Button addButton = new Button("Добавить");
    Button addButton3 = new Button("Удалить");
    VBox vbox;
    MenuBar menuBar;
    Label label1;
    Label label2;
    Label label3;
    Label label4;
    Label label5;
    TextField addStudent = new TextField();
    TableColumn studentFIO = new TableColumn("ФИО студента");
   public static void main(String[] args) {
       launch(args);
   }
   
   @Override
   public void start(Stage stage)  {
       Scene scene = new Scene(new Group());
       stage.setTitle("");
       stage.setWidth(800);
       stage.setHeight(600);
       Menu menu = new Menu("Добавить");
       Menu menu1 = new Menu("Найти");
       Menu menu2 = new Menu("Удалить");
       menuBar = new MenuBar();
       list = new ArrayList<String[]>();
       menuBar.getMenus().addAll(menu, menu1, menu2);
       label1 = new Label();
       label2 = new Label();
       label3 = new Label();
       label4 = new Label();
       label5 = new Label();
       table.setEditable(true);
       studentFIO.setMinWidth(150);
       studentFIO.setCellValueFactory(
               new PropertyValueFactory<>("first"));
      
       TableColumn parentFIO = new TableColumn("ФИО родителя");
       parentFIO.setMinWidth(150);
       parentFIO.setCellValueFactory(
               new PropertyValueFactory<>("second"));
       
       TableColumn address = new TableColumn("Адрес работы родителя");
       address.setMinWidth(150);
       address.setCellValueFactory(
               new PropertyValueFactory<>("third"));
       
       TableColumn parentWork = new TableColumn("Должность родителя");
       parentWork.setMinWidth(150);
       parentWork.setCellValueFactory(
               new PropertyValueFactory<>("forth"));
       
       TableColumn workExperience = new TableColumn("Стаж работы родителя");
       workExperience.setMinWidth(150);
       workExperience.setCellValueFactory(
               new PropertyValueFactory<>("fifth"));
       
       table.setItems(data);
       table.getColumns().addAll(studentFIO, parentFIO, address, parentWork, workExperience);

       addStudent.setPromptText("Input text");
       addStudent.setMaxWidth(studentFIO.getPrefWidth());
       
       addButton.setOnAction(this);
       addButton2.setOnAction(this);
       addButton3.setOnAction(this);
       hb.getChildren().addAll(addStudent,addButton, addButton2, addButton3, menuBar);
       hb.setSpacing(3);

       vbox = new VBox();
       vbox.setSpacing(5);
       vbox.setPadding(new Insets(10, 0, 0, 10));
       vbox.getChildren().addAll(table, hb);
       
       ((Group) scene.getRoot()).getChildren().addAll(vbox);

       stage.setScene(scene);
       stage.show();
   }
   public void handle(ActionEvent event) {
   	if (event.getSource() == addButton) {
   		String s =  addStudent.getText();
   		String[] parts = s.split(" ");
   		list.add(parts);
   		data.add(new Person(parts[0], parts[1], parts[2], parts[3], parts[4]));
   		addStudent.clear();
   	}
   	if (event.getSource() == addButton2) {
	   		for (int i = 0; i < list.size(); i++) {
	   			String[] word = list.get(i);
	   			for (int k = 0; k < word.length; k++) {
		   			if (word[k].equals(addStudent.getText())) {
		   				label1.setText(table.getItems().get(i).getFirst() + " " + table.getItems().get(i).getSecond() + " " + table.getItems().get(i).getThird() + " " + table.getItems().get(i).getForth() + " " + table.getItems().get(i).getFifth());
		   				Alert alert = new Alert(AlertType.INFORMATION);
		   				alert.setTitle("Информация");
		   				alert.setHeaderText("Было найдено");
		   				alert.setContentText(label1.getText());
		   				alert.showAndWait();
		   			}
	   			}
	   		}
   		
   		
   		addStudent.clear();
   	}
   
		
   }
   public static class Person {

       private final SimpleStringProperty first;
       private final SimpleStringProperty second;
       private final SimpleStringProperty third;
       private final SimpleStringProperty forth;
       private final SimpleStringProperty fifth;
       
       private Person(String fName, String lName,  String tName, String foName, String fifName) {
           this.first = new SimpleStringProperty(fName);
           this.second = new SimpleStringProperty(lName);
           this.third = new SimpleStringProperty(tName);
           this.forth = new SimpleStringProperty(foName);
           this.fifth= new SimpleStringProperty(fifName);
       }

       public String getFirst() {
           return first.get();
       }

       public void setFirst(String fName) {
           first.set(fName);
       }

       public String getSecond() {
           return second.get();
       }

       public void setSecond(String lName) {
           second.set(lName);
       }
       
       public String getThird() {
           return third.get();
       }

       public void setThird(String tName) {
           third.set(tName);
       }

       public String getForth() {
           return forth.get();
       }

       public void setForth(String foName) {
           forth.set(foName);
       }
       
       public String getFifth() {
           return fifth.get();
       }

       public void setFifth(String fifName) {
           fifth.set(fifName);
       }

     
   }

}
