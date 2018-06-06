package View;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Model.Data.TableInfo;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.cell.PropertyValueFactory;

public class Table {

	public VBox vbox;
	public HBox hbox;
	public TableView<TableInfo> table;
    public Label numOfPage;
    public Label numOfRec;
    public TextField inputNumOfRec;
    List<TableInfo> list;
    public int rec = 10;
    public  ObservableList<TableInfo> data;
    public int pageNumber = 1;
    
	public Table() {
	table = new TableView();
	table.setEditable(true);
	
	TableColumn studentFIO = new TableColumn("ФИО студента");
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
    
    table.getColumns().addAll(studentFIO, parentFIO, address, parentWork, workExperience);
    
    data = FXCollections.observableArrayList();
    
    vbox = new VBox(5);
    vbox.getChildren().add(table);
    
    numOfPage = new Label();
    numOfRec = new Label();
    
    inputNumOfRec = new TextField();
    
    
    
    hbox = new HBox();
    hbox.getChildren().addAll(numOfRec);
    vbox.getChildren().add(hbox);
	}

	
	
	
	
	 
}
