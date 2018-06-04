package classes;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import classes.MainClass.TableInfo;


public class ReadXMLFile {
	 static List<String> lFirst = new Vector<String>();
	 static List<String> lSecond = new Vector<String>();
	 static List<String> lThird = new Vector<String>();
	 static List<String> lFourth = new Vector<String>();
	 static List<String> lFifth= new Vector<String>();
	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = null;
		try {
			saxParser = factory.newSAXParser();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultHandler handler = new DefaultHandler() {
			boolean bfirst = false;
			boolean bsecond = false;
			boolean bthird = false;
			boolean bfourth = false;
			boolean bfifth = false;
			
			public void startElement(String uri, String localName, String a, Attributes attrib) throws SAXException{
				if(a.equals("first")) {
					bfirst = true;
				}
				if(a.equals("second")) {
					bsecond = true;
				}
				if(a.equals("third")) {
					bthird = true;
				}
				if(a.equals("fourth")) {
					bfourth = true;
				}
				if(a.equals("fifth")) {
					bfifth = true;
				}
			}
			
			public void endElement (String uri, String localName, String a) throws SAXException{
			}
				public void characters(char ch[], int start, int length) throws SAXException{
					if(bfirst) {
						lFirst.add(new String(ch, start, length));
						bfirst = false;
					}
					if(bsecond) {
						lSecond.add(new String(ch, start, length));
						bsecond = false;
					}
					if(bthird) {
						lThird.add(new String(ch, start, length));
						bthird = false;
					}
					if(bfourth) {
						lFourth.add(new String(ch, start, length));
						bfourth = false;
					}
					if(bfifth) {
						lFifth.add(new String(ch, start, length));
						bfifth = false;
					}
					
				}
		};
		try {
			saxParser.parse(MainClass.addStudent.getText(), handler);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (int i = 0; i < lFirst.size(); i++) {
			MainClass.data.add(new TableInfo(lFirst.get(i), lSecond.get(i), lThird.get(i), lFourth.get(i), Integer.parseInt(lFifth.get(i))));
		}
		
	}

}
