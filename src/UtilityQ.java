

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class UtilityQ extends UtilityL {

	//Initialize Variables
	public static final String EMPLOYEE_QUERY = "src/b/c/d/EmployeeQuery.xml";

	public static String Q(String id) throws Exception {
		NodeList nodeList;
		Element element = null;

		//initialize values which were obtained by the xml file to the Nodelist object
		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new File(EMPLOYEE_QUERY))
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
