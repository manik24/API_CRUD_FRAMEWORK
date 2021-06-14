package org.testing.Utilities;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class XmlLoad {

	public static void XmlLoad(String path) throws ParserConfigurationException, SAXException, IOException
	{
		File f = new File(path);
		DocumentBuilderFactory db = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder d = db.newDocumentBuilder();
		Document doc = d.parse(f);
		System.out.println(doc);
		
		NodeList nodes = doc.getElementsByTagName("book");
		
		for(int i=1;i<nodes.getLength();i++)
		{
			Node node = nodes.item(i);
			Element element=(Element)node;
			System.out.println(element.getElementsByTagName("author").item(0).getTextContent());
		}
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		XmlLoad x = new XmlLoad();
		x.XmlLoad("../API_CRUD/layout.xml");
	}
}
