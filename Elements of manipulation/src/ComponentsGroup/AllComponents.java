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
			SecondComponent second = new SecondComponent();
			ThirdComponent third = new ThirdComponent();
			FourthComponent fourth = new FourthComponent();
			TableViewSample fifth = new TableViewSample();
			Six sixth = new Six();
			fourth.start(primaryStage);
			first.start(primaryStage);
			second.start(primaryStage);
			third.start(primaryStage);
			fifth.start(primaryStage);
			sixth.start(primaryStage);
			TabPane layout = new TabPane();
			Tab tab1 = new Tab("1");
			Tab tab2 = new Tab("2");
			Tab tab3 = new Tab("3");
			Tab tab4 = new Tab("4");
			Tab tab5 = new Tab("5");
			Tab tab6 = new Tab("6");
			tab1.setContent(first.layout);
			tab2.setContent(second.layout);
			tab3.setContent(third.layout);
			tab4.setContent(fourth.layout);
			tab5.setContent(fifth.vbox);
			tab6.setContent(sixth.layout);
			layout.getTabs().addAll(tab1, tab2, tab3, tab4, tab5, tab6);
			
			StackPane layout1 = new StackPane();
			Scene scene = new Scene(layout, 300, 300);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
}
