package Controller;

import java.util.ArrayList;

import Model.Data;
import Model.Data.*;
import View.AddWindow;
import View.MainWindow;

public class Add {

	public static void addInfo() {
		ArrayList<String[]> list = new ArrayList<String[]>();
   		Person A = new Person(AddWindow.addStudent.getText(), AddWindow.addParent.getText());
   		Address adr = new Address(AddWindow.addAddress.getText());
   		Job job = new Job(AddWindow.addJob.getText());
   		WorkExperience exp = new WorkExperience(AddWindow.addExp.getText());
   		MainWindow.listOfPages.get(MainWindow.numOfPage).data.add(new TableInfo(A.first, A.second, adr.third , job.fourth, exp.fifth));
   		AddWindow.addStudent.clear();
   		AddWindow.addParent.clear();
   		AddWindow.addAddress.clear();
   		AddWindow.addJob.clear();
   		AddWindow.addExp.clear();
	}
}
