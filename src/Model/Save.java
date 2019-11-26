package Model;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import View.MainWindow;
public class Save {
	public static void main(String argv[]) {

		  try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("tableInfos");
			doc.appendChild(rootElement);
			for (int i = 0; i < MainWindow.listOfPages.get(MainWindow.numOfPage).data.size(); i ++) {
			
			Element staff = doc.createElement("tableInfo");
			rootElement.appendChild(staff);

			
			Element first = doc.createElement("first");
			first.appendChild(doc.createTextNode(MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(i).getFirst()));
			staff.appendChild(first);

			
			Element firstname = doc.createElement("second");
			firstname.appendChild(doc.createTextNode(MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(i).getSecond()));
			staff.appendChild(firstname);

			
			Element lastname = doc.createElement("third");
			lastname.appendChild(doc.createTextNode(MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(i).getThird()));
			staff.appendChild(lastname);

			
			Element nickname = doc.createElement("fourth");
			nickname.appendChild(doc.createTextNode(MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(i).getFourth()));
			staff.appendChild(nickname);

			
			Element salary = doc.createElement("fifth");
			salary.appendChild(doc.createTextNode(MainWindow.listOfPages.get(MainWindow.numOfPage).data.get(i).getFifth().toString()));
			staff.appendChild(salary);

			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\Users\\Алеся\\eclipse-workspace\\SecondLabPpv\\" + MainWindow.addStudent));

			

			transformer.transform(source, result);

			
			}
			System.out.println("File saved!");
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
		  
		}
	
}
