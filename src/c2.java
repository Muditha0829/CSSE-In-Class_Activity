

import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.TransformerException;
import java.io.File;
import org.xml.sax.SAXException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import javax.xml.transform.TransformerConfigurationException;

public class c2 extends c1 {
	
	public static String Q(String id) throws Exception {
		NodeList nodeList;
		Element element = null;

		//initialize values which were obtained by the xml file to the Nodelist object
		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new File("src/e/EmployeeQuery.xml"))
				.getElementsByTagName("query");

		/*
		 * values of NodeList object are assigned to the element object one by one
		 * check the attribute id
		 */
		for (int x = 0; x < nodeList.getLength(); x++) {
			element = (Element) nodeList.item(x);
			if (element.getAttribute("id").equals(id))
				break;
		}
		assert element != null;
		return element.getTextContent().trim();
	}
}
