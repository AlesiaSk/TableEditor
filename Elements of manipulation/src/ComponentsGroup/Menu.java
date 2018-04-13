package ComponentsGroup;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Menu extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	  }
	 public void start(Stage primaryStage) {
		 primaryStage.setTitle("");
		    Group layout = new Group();
		    StackPane a = new StackPane();
		    MainClass first = new MainClass();
		    a.setMargin(first.comboBox, new Insets (150,10,50,10));
		    a.setAlignment(first.comboBox, Pos.BOTTOM_CENTER);
		    a.setAlignment(first.textInput, Pos.TOP_CENTER);
		    a.getChildren().addAll(first.button, first.textInput, first.comboBox);
		    layout.getChildren().addAll(a);
		    Scene scene = new Scene(layout, 300, 250);
		    primaryStage.setScene(scene);
		    primaryStage.show();
	 }
}
