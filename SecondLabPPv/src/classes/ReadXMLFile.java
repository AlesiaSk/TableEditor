package classes;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ReadXMLFile {
	
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
						System.out.println(new String(ch, start, length));
						bfirst = false;
					}
					if(bsecond) {
						System.out.println(new String(ch, start, length));
						bsecond = false;
					}
					if(bthird) {
						System.out.println(new String(ch, start, length));
						bthird = false;
					}
					if(bfourth) {
						System.out.println(new String(ch, start, length));
						bfourth = false;
					}
					if(bfifth) {
						System.out.println(new String(ch, start, length)); 
						bfifth = false;
					}
					
				}
		};
		try {
			saxParser.parse("File.xml", handler);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
