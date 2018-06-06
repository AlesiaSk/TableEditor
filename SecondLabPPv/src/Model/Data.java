package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Data {

	public static ObservableList<TableInfo> data =
	           FXCollections.observableArrayList();
	public static class TableInfo {
		
		private final SimpleStringProperty first;
		private final SimpleStringProperty second;
		private final SimpleStringProperty third;
		private final SimpleStringProperty fourth;
		private final SimpleStringProperty fifth;
		
		 public TableInfo(String fName, String sName, String tName, String foName, String fifName) {
	         this.first = new SimpleStringProperty(fName);
	         this.second = new SimpleStringProperty(sName);
	         this.third = new SimpleStringProperty(tName);
	         this.fourth = new SimpleStringProperty(foName);
	         this.fifth = new SimpleStringProperty(fifName);
	         
	     }

	     public String getFirst() {
	         return first.get();
	     }

	     public void setFirst(String fName) {
	         first.set(fName);
	     }
	     
	     public String getSecond() {
	         return second.get();
	     }

	     public void setSecond(String fName) {
	         second.set(fName);
	     }
	     
	     public String getThird() {
	         return third.get();
	     }

	     public void setThird(String tName) {
	         third.set(tName);
	     }
	     
	     public String getFourth() {
	         return fourth.get();
	     }

	     public void setFourth(String foName) {
	         fourth.set(foName);
	     }
	     
	     public String getFifth() {
	         return fifth.get();
	     }

	     public void setFifth(String fifName) {
	         fifth.set(fifName);
	     }
		   
	   }
	public static class Person {

	    public String first;
	    public String second;
	    
	    public Person(String fName, String sName) {
	        this.first = new String(fName);
	        this.second = new String(sName);
	        
	    }
	    
	   
	    }
	public static class Address {
			public String third;
			
			public Address(String tName) {
		           this.third = new String(tName);
		           
		       }
			
		}
	public static class Job {
			public  String fourth;
			public Job(String foName) {
		           this.fourth = new String(foName);
		           
		       }
			
		}
	public static class WorkExperience {

			public String fifth;
			public WorkExperience(String fifName) {
		           this.fifth = new String(fifName);
		           
		       }
			
		}
}

