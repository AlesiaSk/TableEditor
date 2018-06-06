package View;

import Model.*;
import Model.Data.TableInfo;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application{
	
		Button addButton2 = new Button("�����");
	    Button addButton = new Button("��������");
	    Button addButton3 = new Button("�������");
	    Button addButton4 = new Button("���������");
	    Button addButton5 = new Button("���������");
	    HBox hb = new HBox();
	    VBox vbox;
	    MenuBar menuBar;
	    public static TextField addStudent;
	    static Label label;
	    public static void main(String[] args) {
	        launch(args);
	    }
	    public void start(Stage stage)  {
	    	
		   Scene scene = new Scene(new Group());
	       stage.setTitle("");
	       stage.setWidth(800);
	       stage.setHeight(600);
	       
	       Menu menu = new Menu("����");
	       
	       menuBar = new MenuBar();
	       menuBar.getMenus().addAll(menu);
	       
	       addStudent = new TextField();
	       
	       MenuItem addItm = new MenuItem("�������� ������");
	       addItm.setOnAction(e -> AddWindow.display());
	       
	       MenuItem searchByStudItm = new MenuItem("�����");
	       searchByStudItm.setOnAction(e -> SearchWindow.display(true));
	       
	       MenuItem deleteByStudItm = new MenuItem("��������");
	       deleteByStudItm.setOnAction(e -> SearchWindow.display(false));
	       
	       menu.getItems().addAll(addItm, searchByStudItm, deleteByStudItm);
	       
	       addStudent.setPromptText("Input text");
	       
	       addButton.setOnAction(e -> AddWindow.display());
	       addButton2.setOnAction(e -> SearchWindow.display(true));
	       addButton3.setOnAction(e -> SearchWindow.display(false));
	       addButton4.setOnAction(e -> ReadXMLFile.main(null));
	       addButton5.setOnAction(e -> Save.main(null));
	       hb.getChildren().addAll(addStudent,addButton, addButton2, addButton3, addButton4, addButton5, menuBar);
	       hb.setSpacing(3);

	       vbox = new VBox();
	       vbox.setSpacing(5);
	       vbox.setPadding(new Insets(10, 0, 0, 10));
	       vbox.getChildren().addAll(Controller.Controller.table, hb);
	       
	       ((Group) scene.getRoot()).getChildren().addAll(vbox);

	       stage.setScene(scene);
	       stage.show();
	    }
	    
	    public static TableView createTable(ObservableList<TableInfo> data) {
	    	TableView table = new TableView();
	    	table.setEditable(true);
	    	
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
	        
	        table.setItems(data);
	        table.getColumns().addAll(studentFIO, parentFIO, address, parentWork, workExperience);
	        return table;
	    }
}
