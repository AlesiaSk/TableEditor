package ComponentsGroup;

import java.util.logging.Level;
import ComponentsGroup.Six.MyDataType;
import java.util.Timer;
import java.util.TimerTask;
import ComponentsGroup.TableViewSample.Person;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import java.util.*;
import javafx.scene.shape.*;

public class Six extends Application implements EventHandler<ActionEvent>{
	Button button;
	TextField  textInput;
	TextField textInput2;
	StackPane layout;
	TableView<MyDataType> table;
	Button button2;
	Button button3;
	Timer mTimer;
	MTimerTask task;
	
	private final ObservableList<MyDataType> data =
            FXCollections.observableArrayList();
	public static void main (String[] args) {
		launch(args);
	}
	public void Six(Button button, TextField textField1, TextField textField2, StackPane stackPane, TableView<MyDataType> table, Button button2, Button button3, Timer mTimer, MTimerTask task) {
		this.button = button;
		this.button2 = button2;
		this.button3 = button3;
		this.layout = stackPane;
		this.mTimer = mTimer;
		this.task = task;
		this.table = table;
		this.textInput = textField1;
		this.textInput2 = textField2;
	}
	public void start(Stage primaryStage)  {
		primaryStage.setTitle("Sixth component");
		button = new Button("Click");
		mTimer = new Timer();
		textInput = new TextField();
		textInput.setPromptText("Input number of columns");
		textInput2 = new TextField();
		textInput2.setPromptText("Input number of rows");
		button.setOnAction(this);
		layout = new StackPane();
		layout.setMargin(textInput, new Insets(50,10,10,10));
		layout.setAlignment(textInput, Pos.CENTER);
		layout.setMargin(textInput2, new Insets(10,10,50,10));
		layout.setAlignment(textInput2, Pos.CENTER);
		layout.setMargin(button, new Insets(10,10,50,10));
		layout.setAlignment(button, Pos.BOTTOM_CENTER);
		table = new TableView<>();
		table.setMinSize(150, 150);
		button2 = new Button("Start");
		button3 = new Button("Stop");
		button2.setOnAction(this);
		button3.setOnAction(this);
		layout.getChildren().addAll(button, textInput, textInput2);
		Scene scene = new Scene(layout, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void handle(ActionEvent event) {
		if (event.getSource() == button) {
			String strNumbOfColumns = textInput.getText();
			String strNumbOfRows= textInput2.getText();
			layout.setMargin(button3, new Insets(10,10,50,10));
			layout.setAlignment(button3, Pos.BOTTOM_CENTER);
			layout.getChildren().addAll(table, button2, button3);
			List<String> intValues = new ArrayList();
			 for (int i = 0; i < Integer.parseInt(strNumbOfColumns); i++) {
				 TableColumn<MyDataType, String> firstNameCol = new TableColumn<>(Integer.toString(i+1));
				 firstNameCol.setMinWidth(150/Integer.parseInt(strNumbOfColumns));
			     firstNameCol.setCellValueFactory(new PropertyValueFactory<MyDataType, String>("intValue"));
			     table.setItems(data);
			     table.setEditable(true);
			     table.getColumns().addAll(firstNameCol);
		}
			 for (int j = 0; j < Integer.parseInt(strNumbOfRows); j++) {
		    	 intValues.add(Integer.toString(j+1));
		     }
		     for (int k = 0; k < Integer.parseInt(strNumbOfRows); k++) {
		    	 data.add(new MyDataType(intValues.get(k)));
		    	 
		     }
		     
	}
		if (event.getSource() == button2) {
			task = new MTimerTask(table.getItems().size());
			mTimer.schedule(task, 100, 1000);
			
		}
		if (event.getSource() == button3) {
			task.cancel();
			mTimer.cancel();
			mTimer.purge();
			mTimer = null;
		}
		
	}
	public class MyDataType {
		private final SimpleStringProperty intValue ;
	    public MyDataType(String intValue) {
	        this.intValue = new SimpleStringProperty(intValue);
	    }
	    public String getIntValue() {
	        return intValue.get();
	    }
	    
	    public void setIntValue(String a) {
	    	intValue.set(a);
        }
	    
	}
	class MTimerTask extends TimerTask {

	    
	    private int size;


	    MTimerTask ( int size)
	    {
	      this.size = size;
	    }

	    public void run() {
	    	MyDataType firstRow =  (MyDataType)table.getItems().get(0);
	    	for (int i = 0; i <= (size -1); i++) {
	    		if (i == (size - 1)) {
	    			table.getItems().set(i, firstRow);
	    		}
	    		else {
	    			table.getItems().set(i, (MyDataType)table.getItems().get(i+1));
	    			}
	    }
	    	
	}
	
	
}

}