package Model;

import View.MainWindow;
import View.SearchWindow;
import View.Table;
import Model.Data.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;


public class Search {
	
	public static ObservableList<TableInfo> tableSearch(TableView table, String type) {
		
			   ObservableList<TableInfo>  sortedData = FXCollections.observableArrayList();
	    	   int size = MainWindow.listOfPages.get(MainWindow.numOfPage).data.size();
               String t = SearchWindow.text.getText();
               for (int ind = 0; ind < size; ind++) {
                if (type.equals("second")) {
                if (MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(ind).getSecond().contains(t)) {
                    sortedData.add(MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(ind)); 
                } else if (MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(ind).getThird().contains(t)) {
                	sortedData.add(MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(ind));
                }
                }
               }
               
               for (int ind = 0; ind < size; ind++) {
                   if (type.equals("third")) {
                   if (MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(ind).getFifth().contains(t)) {
                       sortedData.add(MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(ind)); 
                   } else if (MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(ind).getThird().contains(t)) {
                   	sortedData.add(MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(ind));
                   }
                   }
                  }
                
               for (int ind = 0; ind < size; ind++) {
                   if (type.equals("fourth")) {
                   if (MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(ind).getFifth().contains(t)) {
                       sortedData.add(MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(ind)); 
                   } else if (MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(ind).getFirst().contains(t)) {
                   	sortedData.add(MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(ind));
                   }
                   }
                  }
                
               for (int ind = 0; ind < size; ind++) {
                   if (type.equals("first")) {
                   if (MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(ind).getFirst().contains(t)) {
                       sortedData.add(MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(ind)); 
                   } 
                   }
                  }
	
	    
        System.out.println(sortedData.size());
        return (sortedData);
	}
	
	
}
