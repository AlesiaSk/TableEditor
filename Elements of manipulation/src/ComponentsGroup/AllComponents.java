package ComponentsGroup;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.layout.StackPane;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ComponentsGroup.MainClass;


public class AllComponents extends Application{
		
		public static void main (String[] args) {
			launch(args);
		}
		public void start(Stage primaryStage)  {
			primaryStage.setTitle("First elements");
			MainClass first = new MainClass();
			first.start(primaryStage);
			TabPane layout = new TabPane();
			Tab tab = new Tab("1");
			layout.getTabs().add(tab);
			
			StackPane layout1 = new StackPane();
			Scene scene = new Scene(layout, 300, 300);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
}
