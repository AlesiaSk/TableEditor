package classes;

import classes.MainClass.TableInfo;
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

public class SearchByStudentOrJob {
	static StackPane layout;
	static Button button;
	static TextField text;
	static TableView<TableInfo> table = new TableView<>();
	static VBox vbox;
	
	public static void display() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		layout = new StackPane();
		button = new Button("�����");
		button.setOnAction(e -> Search.kindOfSearch());
		text = new TextField();
		text.setPromptText("������� ��� �������� ��� ����� ������ ��������");
		TableColumn studentFIO = new TableColumn("��� ��������");
		studentFIO.setMinWidth(150);
	    studentFIO.setCellValueFactory(
	            new PropertyValueFactory<>("first"));
	   
	    TableColumn parentFIO = new TableColumn("��� ��������");
	    parentFIO.setMinWidth(150);
	    parentFIO.setCellValueFactory(
	            new PropertyValueFactory<>("second"));
	    
	    TableColumn address = new TableColumn("����� ������ ��������");
	    address.setMinWidth(150);
	    address.setCellValueFactory(
	            new PropertyValueFactory<>("third"));
	    
	    TableColumn parentWork = new TableColumn("��������� ��������");
	    parentWork.setMinWidth(150);
	    parentWork.setCellValueFactory(
	            new PropertyValueFactory<>("fourth"));
	    
	    TableColumn workExperience = new TableColumn("���� ������ ��������");
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

                if (tableInfo.getFirst().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } else if (tableInfo.getThird().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                }
                return false; 
            });
        });
	    SortedList<TableInfo> sortedData = new SortedList<>(filData);

        sortedData.comparatorProperty().bind(table.comparatorProperty());

        table.setItems(sortedData);
            
	    table.getColumns().addAll(studentFIO, parentFIO, address, parentWork, workExperience);

		layout.setMargin(text, new Insets(170,10,50,10));
		layout.setAlignment(text, Pos.TOP_LEFT);
		layout.setMargin(button, new Insets(210,10,50,10));
		layout.setAlignment(button, Pos.TOP_CENTER);
		layout.getChildren().addAll(text);
		vbox = new VBox();
	       vbox.setSpacing(5);
	       vbox.setPadding(new Insets(10, 0, 0, 10));
	       vbox.getChildren().addAll(table, layout);
		Scene scene = new Scene(vbox, 770, 600);
		window.setScene(scene);
		window.showAndWait();
	}
}
