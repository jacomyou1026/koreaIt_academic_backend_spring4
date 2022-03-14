package xmlParse;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Corona {
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

		StringBuilder urlBuilder = new StringBuilder("https://nip.kdca.go.kr/irgd/cov19stats.do?list=all");

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document doc = builder.parse(urlBuilder.toString());

		System.setProperty("https.protocols", "TLSv1.2");
		doc.normalize();

		NodeList dateTagList = doc.getElementsByTagName("dataTime");
		System.out.println("dataTime" + dateTagList.item(0).getTextContent());
		NodeList infoTagList = doc.getElementsByTagName("item");

		for (int i = 2; i < infoTagList.getLength(); i++) {
			NodeList childNodes = infoTagList.item(i).getChildNodes();
			for (int j = 0; j < childNodes.getLength(); j++) {
				String cnt = childNodes.item(j).getTextContent();
				switch (childNodes.item(j).getNodeName()) {
				case "firstCnt":
				case "secondCnt":
				case "thirdCnt":
					if(i==2){
                        float a = (Float.parseFloat(cnt)/51306264)*100;
                        float b =  (float) (Math.floor(a*10)/10);
                        System.out.println(b);
                    }
					if(i==3) {
						System.out.println("d :"+childNodes.item(j).getTextContent());
						
					}

				}
			}

		}

	}

}
