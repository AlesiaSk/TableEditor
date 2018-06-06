package Controller;

import Model.Data;
import View.MainWindow;
import javafx.scene.control.TableView;

public class Controller {
	public static TableView table = MainWindow.createTable(Data.data);
}
