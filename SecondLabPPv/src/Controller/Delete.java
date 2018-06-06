package Controller;

import Model.Data.TableInfo;
import Model.Search;
import View.MainWindow;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

public class Delete {
	
	public static ObservableList<TableInfo> deleteFromTable(String type, TableView table) {
	ObservableList<TableInfo> sortedData = Search.tableSearch(table, type);
	int size = MainWindow.listOfPages.get(MainWindow.numOfPage).data.size();
	int sortSize = sortedData.size();
	System.out.println(sortSize);
	System.out.println(size);
	for (int i = 0; i < sortSize; i++) {
		for (int k = 0; k < MainWindow.listOfPages.get(MainWindow.numOfPage).data.size(); k++) {
			if(MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(k).equals(sortedData.get(i))) {
				MainWindow.listOfPages.get(MainWindow.numOfPage).data.remove(k);
				if (k == 0) {
					k = -1;
				}
				else{
				k--;
				}
			}
		}
	}
	return MainWindow.listOfPages.get(MainWindow.numOfPage).data;
	}
}
