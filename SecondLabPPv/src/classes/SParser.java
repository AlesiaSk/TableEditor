package classes;

import org.xml.sax.helpers.DefaultHandler;

import classes.MainClass.TableInfo;

import org.xml.sax.*; 

public class SParser extends DefaultHandler{
	
	String thisElement = ""; 
	TableInfo tableinf; 
	
	public TableInfo getResult(){ 
		  return tableinf; 
		} 
		 
	 
	@Override 
	public void startDocument() throws SAXException { 
	  System.out.println("Start parse XML..."); 
	} 
	 
	@Override 
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException { 
	  thisElement = qName;  
	} 
	 
	@Override 
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException { 
	  thisElement = ""; 
	} 
	 
	@Override 
	public void characters(char[] ch, int start, int length) throws SAXException { 
	  if (thisElement.equals("first")) { 
	     tableinf.setFirst(new String(ch, start, length)); 
	  } 
	  if (thisElement.equals("second")) { 
	     tableinf.setSecond(new String(ch, start, length)); 
	  } 
	  if (thisElement.equals("third")) { 
	     tableinf.setThird(new String(ch, start, length)); 
	  } 
	  if (thisElement.equals("fourth")) { 
	     tableinf.setFourth(new String(ch, start, length)); 
	  } 
	  if (thisElement.equals("fifth")) { 
	     tableinf.setFifth(new Integer(new String(ch, start, length))); 
	  } 
	  
	} 
	 
	@Override 
	public void endDocument() { 
	  System.out.println("Stop parse XML..."); 
	} 
}
