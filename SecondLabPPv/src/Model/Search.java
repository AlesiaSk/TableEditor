package Model;

import View.MainWindow;
import View.SearchWindow;
import Model.Data.*;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;


public class Search {
	
	public static SortedList<TableInfo> tableSearch(TableView table, String type) {
	    FilteredList<TableInfo> filData = new FilteredList<>(Data.data, p -> true);
	    SearchWindow.text.textProperty().addListener((observable, oldValue, newValue) -> {
            filData.setPredicate(tableInfo -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                if (type.equals("second")) {
                if (tableInfo.getSecond().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } else if (tableInfo.getThird().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                }
                }
                else if (type.equals("third")) {
                    if (tableInfo.getFifth().toLowerCase().contains(lowerCaseFilter)) {
                        return true; 
                    } else if (tableInfo.getThird().toLowerCase().contains(lowerCaseFilter)) {
                        return true; 
                    }
                }   
                else if (type.equals("fourth")) {
                    if (tableInfo.getFifth().toLowerCase().contains(lowerCaseFilter)) {
                        return true; 
                    } else if (tableInfo.getFirst().toLowerCase().contains(lowerCaseFilter)) {
                        return true; 
                    }
                }
                else if (type.equals("first")) {
                     if (tableInfo.getFirst().toLowerCase().contains(lowerCaseFilter)) {
                        return true; 
                    }
                }
                    return false; 
                    
            });
        });
	    SortedList<TableInfo> sortedData = new SortedList<>(filData);

        sortedData.comparatorProperty().bind(table.comparatorProperty());

        return (sortedData);
	}
	
	
}
