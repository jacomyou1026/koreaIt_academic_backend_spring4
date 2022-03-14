package xmlParse;

import java.io.File;
import java.io.IOException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CarXmlParse {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File xmlFile = new File("car.xml");

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(xmlFile);

		document.getDocumentElement().normalize();

		NodeList personTagList = document.getElementsByTagName("record");

		for (int i = 0; i < personTagList.getLength(); i++) {
			// person이 가지고 있는 하위 태그(노드)들을 가져옴
			NodeList childNodes = personTagList.item(i).getChildNodes();
			for (int j = 0; j < childNodes.getLength(); j++) {
				switch (childNodes.item(j).getNodeName()) {
				case "mno":
				case "model":
				case "year":
				case "maker":
				case "price":
					System.out.println(childNodes.item(j).getNodeName() + " - " + childNodes.item(j).getTextContent());
				}

			}

		}
	}
}
