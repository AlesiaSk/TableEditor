package classes;

import javafx.beans.property.SimpleStringProperty;

public class Job {
	private final SimpleStringProperty forth;
	private Job(String foName) {
        this.forth = new SimpleStringProperty(foName);
    }
	 public String getForth() {
         return forth.get();
     }

     public void setForth(String foName) {
         forth.set(foName);
     }
}
