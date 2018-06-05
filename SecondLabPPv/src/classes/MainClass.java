package classes;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javafx.beans.property.SimpleIntegerProperty;
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

public class MainClass extends Application{
	 
    static TableView<TableInfo> table = new TableView<>();
    static ObservableList<TableInfo> data =
           FXCollections.observableArrayList();
    HBox hb = new HBox();
    static ArrayList<String[]> list;
    Button addButton2 = new Button("Найти");
    Button addButton = new Button("Добавить");
    Button addButton3 = new Button("Удалить");
    Button addButton4 = new Button("Загрузить");
    Button addButton5 = new Button("Сохранить");
    VBox vbox;
    MenuBar menuBar;
    Label label1;
    Label label2;
    Label label3;
    Label label4;
    static Label label;
	static int allDeleted;
	static int del1;
	static int del2;
	static int del3;
	static int del4;
    Label label5;
    static TextField addStudent = new TextField();
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
       
       MenuItem addItm = new MenuItem("добавить данные");
       menu.getItems().add(addItm);
       addItm.setOnAction(e -> Add.display());
       MenuItem searchByStudItm = new MenuItem("поиск по ФИО студента");
       searchByStudItm.setOnAction(e -> SearchByStudent.display());
       MenuItem searchByExpItm = new MenuItem("поиск по cтажу или месту работы");
       searchByExpItm.setOnAction(e -> SearchByExpOrJob.display());
       MenuItem searchByParentItm = new MenuItem("поиск по ФИО родителя или метсу работы");
       searchByParentItm.setOnAction(e -> SearchByParentAndWork.display());
       MenuItem searchByJobItm = new MenuItem("поиск по ФИО студента или месту работы");
       searchByJobItm.setOnAction(e -> SearchByStudentOrJob.display());
       menu1.getItems().addAll(searchByStudItm, searchByExpItm, searchByParentItm, searchByJobItm);
       
       MenuItem deleteByStudItm = new MenuItem("удаление по ФИО студента");
       deleteByStudItm.setOnAction(e -> DeleteByStudent.display());
       MenuItem deleteByExpItm = new MenuItem("удаление по cтажу или месту работы");
       deleteByExpItm.setOnAction(e -> DeleteByExpOrJob.display());
       MenuItem deleteByParentItm = new MenuItem("удаление по ФИО родителя или метсу работы");
       deleteByParentItm.setOnAction(e -> DeleteByParentAndWork.display());
       MenuItem deleteByJobItm = new MenuItem("удаление по ФИО студента или месту работы");
       deleteByJobItm.setOnAction(e -> DeleteByStudentOrJob.display());
       menu2.getItems().addAll(deleteByStudItm, deleteByExpItm, deleteByParentItm, deleteByJobItm);
       
       allDeleted = del1 = del2 = del3  = del4 = 0;
       allDeleted = del1 + del2 + del3  + del4;
       label1 = new Label();
       label = new Label("Всего удалено - " + allDeleted + ", удалено по ФИО студента - " + del1 + ", удалено по ФИО родителя или месту его работы - " + del2);
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
               new PropertyValueFactory<>("fourth"));
       
       TableColumn workExperience = new TableColumn("Стаж работы родителя");
       workExperience.setMinWidth(150);
       workExperience.setCellValueFactory(
               new PropertyValueFactory<>("fifth"));
       
       table.setItems(data);
       table.getColumns().addAll(studentFIO, parentFIO, address, parentWork, workExperience);

       addStudent.setPromptText("Input text");
       addStudent.setMaxWidth(studentFIO.getPrefWidth());
       
       addButton.setOnAction(e -> Add.display());
       Add add = new Add();
       addButton2.setOnAction(e -> Search.display());
       addButton3.setOnAction(e -> Delete.display());
       addButton4.setOnAction(e -> ReadXMLFile.main(null));
       addButton5.setOnAction(e -> Save.main(null));
       hb.getChildren().addAll(addStudent,addButton, addButton2, addButton3, addButton4, addButton5, menuBar);
       hb.setSpacing(3);

       vbox = new VBox();
       vbox.setSpacing(5);
       vbox.setPadding(new Insets(10, 0, 0, 10));
       vbox.getChildren().addAll(table, hb);
       
       ((Group) scene.getRoot()).getChildren().addAll(vbox);

       stage.setScene(scene);
       stage.show();
   }
 
   public static class TableInfo {
	
	private final SimpleStringProperty first;
	private final SimpleStringProperty second;
	private final SimpleStringProperty third;
	private final SimpleStringProperty fourth;
	private final SimpleIntegerProperty fifth;
	
	 TableInfo(String fName, String sName, String tName, String foName, Integer fifName) {
         this.first = new SimpleStringProperty(fName);
         this.second = new SimpleStringProperty(sName);
         this.third = new SimpleStringProperty(tName);
         this.fourth = new SimpleStringProperty(foName);
         this.fifth = new SimpleIntegerProperty(fifName);
         
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

     public void setSecond(String fName) {
         second.set(fName);
     }
     
     public String getThird() {
         return third.get();
     }

     public void setThird(String tName) {
         third.set(tName);
     }
     
     public String getFourth() {
         return fourth.get();
     }

     public void setFourth(String foName) {
         fourth.set(foName);
     }
     
     public Integer getFifth() {
         return fifth.get();
     }

     public void setFifth(Integer fifName) {
         fifth.set(fifName);
     }
	   
   }
	   
   public static class Person {

       public String first;
       public String second;
       
       Person(String fName, String sName) {
           this.first = new String(fName);
           this.second = new String(sName);
           
       }
       
      
       }
   public static class Address {
		public String third;
		
		 Address(String tName) {
	           this.third = new String(tName);
	           
	       }
		
	}
   public static class Job {
		public  String fourth;
		Job(String foName) {
	           this.fourth = new String(foName);
	           
	       }
		
	}
   public static class WorkExperience {

		public Integer fifth;
		WorkExperience(Integer fifName) {
	           this.fifth = new Integer(fifName);
	           
	       }
		
	}

     
   }


