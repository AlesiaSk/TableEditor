package classes;

import java.util.ArrayList;
import java.util.List;

import classes.MainClass.TableInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DeleteByExpOrJob {
	static StackPane layout;
	static Button button;
	static TextField text;
	static TableView<TableInfo> table = new TableView<>();
	static VBox vbox;
	static SortedList<TableInfo> sortedData;
	static ObservableList<TableInfo> dataN =
	           FXCollections.observableArrayList();
	
	public static void display() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		layout = new StackPane();
		button = new Button("Удалить");
		text = new TextField();
		text.setPromptText("Введите стаж работы родителя или место его работы");
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
	    
	   table.setItems(MainClass.data);
	   FilteredList<TableInfo> filData = new FilteredList<>(MainClass.data, p -> true);
	    text.textProperty().addListener((observable, oldValue, newValue) -> {
	    	filData.setPredicate(tableInfo -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (tableInfo.getFifth().toString().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } else if (tableInfo.getThird().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                }
                return false;
           });
       });
	   sortedData = new SortedList<>(filData);

       sortedData.comparatorProperty().bind(table.comparatorProperty());
       table.setItems(sortedData);
	   button.setOnAction(e -> DeleteByExpOrJob.delExpOrJob());
	    table.getColumns().addAll(studentFIO, parentFIO, address, parentWork, workExperience);

		layout.setMargin(text, new Insets(170,10,50,10));
		layout.setAlignment(text, Pos.TOP_LEFT);
		layout.setMargin(button, new Insets(210,10,50,10));
		layout.setAlignment(button, Pos.TOP_CENTER);
		layout.getChildren().addAll(text, button);
		vbox = new VBox();
	       vbox.setSpacing(5);
	       vbox.setPadding(new Insets(10, 0, 0, 10));
	       vbox.getChildren().addAll(table, layout);
		Scene scene = new Scene(vbox, 770, 600);
		window.setScene(scene);
		window.showAndWait();
	}

	public static void delExpOrJob() {
		for (int i = 0; i < sortedData.size(); i++) {
			for (int k = 0; k < MainClass.data.size(); k++) {
				if(MainClass.data.get(k).equals(sortedData.get(i))) {
					MainClass.data.remove(k);
					k--;
				}
			}
		}
		table.setItems(MainClass.data);
	}
}


