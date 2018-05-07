package classes;

import javafx.beans.property.SimpleIntegerProperty;

public class WorkExperience {

	private final SimpleIntegerProperty fifth;
	private WorkExperience(Integer fifName) {
        this.fifth = new SimpleIntegerProperty(fifName);
    }
	 public Integer getFifth() {
         return fifth.get();
     }

     public void setFifth(Integer fifName) {
         fifth.set(fifName);
     }
}
