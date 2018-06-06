package Model;

import Model.Data.TableInfo;
import View.MainWindow;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

public class Delete {
	
	public static  ObservableList<TableInfo> deleteFromTable(String type, TableView table) {
	SortedList<TableInfo> sortedData = Search.tableSearch(table, type);
	
	for (int i = 0; i < sortedData.size(); i++) {
		for (int k = 0; k < Data.data.size(); k++) {
			if(Data.data.get(k).equals(sortedData.get(i))) {
				Data.data.remove(k);
				if (k == 0) {
					k = -1;
				}
				else{
				k--;
				}
			}
		}
	}
	return Data.data;
	}
}
