package ComponentsGroup;

import java.util.Collection;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
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

public class Fifth extends Application{
	
	private final TableView<TableData> table = new TableView<>();
    private final ObservableList<TableData> data =
        FXCollections.observableArrayList(
            new TableData("Jacob")
        );
    final HBox hb = new HBox();
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(450);
        stage.setHeight(550);
 
        final Label label = new Label("Add information");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
 
        TableColumn firstCol = new TableColumn("The First");
        firstCol.setMinWidth(100);
        firstCol.setCellValueFactory(
                new PropertyValueFactory<>("firstColData"));
 
        TableColumn lastCol = new TableColumn("The Second");
        lastCol.setMinWidth(100);
        lastCol.setCellValueFactory(
                new PropertyValueFactory<>("secondColData"));
 
 
        table.setItems(data);
        table.getColumns().addAll(firstCol, lastCol);
 
        final TextField addFirst = new TextField();
        addFirst.setPromptText("First");
        addFirst.setMaxWidth(firstCol.getPrefWidth());
        final TextField addLast = new TextField();
        addLast.setMaxWidth(lastCol.getPrefWidth());
        addLast.setPromptText("Last");
        
        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            data.addAll((Collection<? extends TableData>) new TabData(
                    addFirst.getText(),
                    addLast.getText()));
            addFirst.clear();
            addLast.clear();
        });
 
        hb.getChildren().addAll(addFirst, addLast, addButton);
        hb.setSpacing(3);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
 
    public static class TabData {
 
        private final SimpleStringProperty first;
        private final SimpleStringProperty last;
 
        private TabData(String fCol, String lCol) {
            this.first = new SimpleStringProperty(fCol);
            this.last = new SimpleStringProperty(lCol);
        }
 
        public String getFirst() {
            return first.get();
        }
 
        public void setFirst(String fCol) {
            first.set(fCol);
        }
 
        public String getLast() {
            return last.get();
        }
 
        public void setLast(String lCol) {
            last.set(lCol);
        }
 
}     
    

}
