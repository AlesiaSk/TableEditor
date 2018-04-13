package ComponentsGroup;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

 
public class TableViewSample extends Application implements EventHandler<ActionEvent>{
 
    private final TableView<Person> table = new TableView<>();
    private final ObservableList<Person> data =
            FXCollections.observableArrayList();
    final HBox hb = new HBox();
    final Button addButton2 = new Button("Button2");
    final Button addButton = new Button("Button1");
    final Button addButton3 = new Button("Button3");
    TableColumn firstNameCol = new TableColumn("The First");
    final TextField addFirstName = new TextField();
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage)  {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(600);
        stage.setHeight(600);
 
        final Label label = new Label("Table");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
        firstNameCol.setMinWidth(150);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));
       
 
        TableColumn lastNameCol = new TableColumn("The Second");
        lastNameCol.setMinWidth(150);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));
 
        
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol);

        addFirstName.setPromptText("Input text");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        
        addButton.setOnAction(this);
        addButton2.setOnAction(this);
        addButton3.setOnAction(this);
        
        hb.getChildren().addAll(addFirstName,addButton, addButton2, addButton3);
        hb.setSpacing(3);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
    public void handle(ActionEvent event) {
    	if (event.getSource() == addButton) {
    		data.add(new Person(
                    addFirstName.getText(), " "));
            
            addFirstName.clear();
    	}
    
		if (event.getSource() == addButton2) {
			String nameFirst = table.getSelectionModel().getSelectedItem().getFirstName();
        	table.getSelectionModel().getSelectedItem().setFirstName(null);
        	table.getSelectionModel().getSelectedItem().setLastName(nameFirst);
       
	}
		if (event.getSource() == addButton3) {
			String nameSecond = table.getSelectionModel().getSelectedItem().getLastName();
        	table.getSelectionModel().getSelectedItem().setFirstName(nameSecond);
        	table.getSelectionModel().getSelectedItem().setLastName(null);
        	
		}
    }
    public static class Person {
 
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
 
        private Person(String fName, String lName) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
        }
 
        public String getFirstName() {
            return firstName.get();
        }
 
        public void setFirstName(String fName) {
            firstName.set(fName);
        }
 
        public String getLastName() {
            return lastName.get();
        }
 
        public void setLastName(String fName) {
            lastName.set(fName);
        }
 
      
    }
} 