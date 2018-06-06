package View;

import java.util.ArrayList;
import java.util.List;

import Model.*;
import Model.Data.TableInfo;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.ToolBar;
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
	
		Button addButton2 = new Button("Найти");
	    Button addButton = new Button("Добавить");
	    Button addButton3 = new Button("Удалить");
	    Button addButton4 = new Button("Загрузить");
	    Button addButton5 = new Button("Сохранить");
	    Table table;
	    Table table1;
	    Table table2;
	    public static List<Table> listOfPages;
	    HBox hb = new HBox(10);
	    HBox hb2 = new HBox(10);
	    VBox vbox;
	    MenuBar menuBar;
	    public static TextField addStudent;
	    public static TextField  numOfRec;
	    static Label label;
	    public static int numOfPage = 0;
	    Label lNumPage;
	    public void main(String[] args) {
	        launch(args);
	    }
	    public void start(Stage stage)  {
	    	
		   Scene scene = new Scene(new Group());
	       stage.setTitle("");
	       stage.setWidth(800);
	       stage.setHeight(600);
	 
	       
	       Menu menu = new Menu("Меню");
	       
	       Button but1 = new Button("Найти");
		   Button but = new Button("Добавить");
		   Button but2 = new Button("Удалить");
		   Button but3 = new Button("Загрузить");
		   Button but4 = new Button("Сохранить");
	       
	       numOfRec = new TextField();
	       
	       menuBar = new MenuBar();
	       menuBar.getMenus().addAll(menu);
	       
	       addStudent = new TextField();
	       
	       MenuItem addItm = new MenuItem("добавить данные");
	       addItm.setOnAction(e -> AddWindow.display());
	       
	       MenuItem searchByStudItm = new MenuItem("поиск");
	       searchByStudItm.setOnAction(e -> SearchWindow.display(true));
	       
	       MenuItem deleteByStudItm = new MenuItem("удаление");
	       deleteByStudItm.setOnAction(e -> SearchWindow.display(false));
	       
	       MenuItem save = new MenuItem("сохранение");
	       searchByStudItm.setOnAction(e -> Save.main(null));
	       
	       MenuItem download = new MenuItem("загрузка");
	       deleteByStudItm.setOnAction(e -> ReadXMLFile.main(null));
	       
	       menu.getItems().addAll(addItm, searchByStudItm, deleteByStudItm, save, download);
	       
	       addStudent.setPromptText("Input text");
	       
	       
	       
	       addButton.setOnAction(e -> AddWindow.display());
	       addButton2.setOnAction(e -> SearchWindow.display(true));
	       addButton3.setOnAction(e -> SearchWindow.display(false));
	       addButton4.setOnAction(e -> ReadXMLFile.main(null));
	       addButton5.setOnAction(e -> Save.main(null));
	       
	       lNumPage = new Label();
	       lNumPage.setText("Номер страницы  - 1");
	       
	       Button button1 = new Button("1");
	       Button button2 = new Button ("<-");
	       Button button3 = new Button ("->");
	       Button button4 = new Button ("3");
	       Button button5 = new Button ("Изменить");
	       
	       table = new Table();
	       table.table.setItems(table.data);
	       table1 = new Table();
	       table1.table.setItems(table1.data);
	       table2 = new Table();
	       table2.table.setItems(table2.data);
	       
	       listOfPages = new ArrayList();
	       listOfPages.add(table);
	       listOfPages.add(table1);
	       listOfPages.add(table2);
	       
	       listOfPages.add(table);
	       hb.getChildren().addAll(addStudent,addButton, addButton2, addButton3, addButton4, addButton5, menuBar, button1, button2, button3, button4);
	       hb.setSpacing(3);
	       
	       Label records = new Label();
	       records.setText("Количество записей "); 
	       ToolBar toolBar = new ToolBar(but, but1, but2, but3, but4);
	       
	       but.setOnAction(e -> AddWindow.display());
	       but1.setOnAction(e -> SearchWindow.display(true));
	       but2.setOnAction(e -> SearchWindow.display(false));
	       but3.setOnAction(e -> ReadXMLFile.main(null));
	       but4.setOnAction(e -> Save.main(null));
	       
	       hb2.getChildren().addAll(lNumPage, records, numOfRec, toolBar);
	       
	      
	       vbox = new VBox();
	       vbox.setSpacing(5);
	       vbox.setPadding(new Insets(10, 0, 0, 10));
	       vbox.getChildren().addAll(listOfPages.get(numOfPage).vbox, hb, hb2);
	       
	      
	       button1.setOnAction(e -> {numOfPage = 1; vbox.getChildren().clear(); vbox.getChildren().addAll(listOfPages.get(numOfPage).vbox, hb, hb2); lNumPage.setText("Номер страницы  - 1");});
	       button2.setOnAction(e -> {numOfPage -=1; vbox.getChildren().clear(); vbox.getChildren().addAll(listOfPages.get(numOfPage).vbox, hb, hb2); lNumPage.setText("Номер страницы  - " + String.valueOf(numOfPage));});
	       button3.setOnAction(e -> {numOfPage +=1; vbox.getChildren().clear(); vbox.getChildren().addAll(listOfPages.get(numOfPage).vbox, hb, hb2); lNumPage.setText("Номер страницы  - " + String.valueOf(numOfPage));});
	       button4.setOnAction(e -> {numOfPage = 3; vbox.getChildren().clear(); vbox.getChildren().addAll(listOfPages.get(numOfPage).vbox, hb, hb2); lNumPage.setText("3");});
	       button5.setOnAction(e -> numOfRec.getText());
	       
	       ((Group) scene.getRoot()).getChildren().addAll(vbox);

	       stage.setScene(scene);
	       stage.show();
	    }
	    
}
