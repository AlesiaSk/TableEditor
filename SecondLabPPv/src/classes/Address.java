package classes;

import javafx.beans.property.SimpleStringProperty;

public class Address {
	private final SimpleStringProperty third;
	private Address(String tName) {
        this.third = new SimpleStringProperty(tName);
    }
	 public String getThird() {
         return third.get();
     }

     public void setThird(String tName) {
         third.set(tName);
     }

}
