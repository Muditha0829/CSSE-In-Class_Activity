

import javax.xml.xpath.XPathFactory;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import org.w3c.dom.Document;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.TransformerFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

public class c3 extends c1 {

	//Declaring employee array list
	private static final ArrayList<Map<String, String>> employeeList = new ArrayList<Map<String, String>>();

	//Declaring map for employee
	private static Map<String, String> employeeMap = null;

	//Initialize employee paths
	public static final String EMPLOYEE_REQUEST_PATH = "src/b/c/d/EmployeeRequest.xml";
	public static final String EMPLOYEE_MODIFIED_PATH = "src/b/c/d/Employee-modified.xsl";
	public static final String EMPLOYEE_RESPONSE_PATH = "src/b/c/d/EmployeeResponse.xml";

	public static void requestTransform() throws Exception {

		Source requestSource = new StreamSource(new File(EMPLOYEE_REQUEST_PATH));
		Source modifiedSource = new StreamSource(new File(EMPLOYEE_MODIFIED_PATH));
		Result resultResponse = new StreamResult(new File(EMPLOYEE_RESPONSE_PATH));
		TransformerFactory.newInstance().newTransformer(modifiedSource).transform(requestSource, resultResponse);
	}

	public static ArrayList<Map<String, String>> xmlPaths() throws Exception {

		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(EMPLOYEE_REQUEST_PATH);
		XPath x = XPathFactory.newInstance().newXPath();
		int n = Integer.parseInt((String) x.compile("count(//Employees/Employee)").evaluate(document, XPathConstants.STRING));
		for (int i = 1; i <= n; i++) {
			employeeMap = new HashMap<String, String>();
			employeeMap.put("XpathEmployeeIDKey", (String) x.compile("//Employees/Employee[" + i + "]/EmployeeID/text()")
					.evaluate(document, XPathConstants.STRING));
			employeeMap.put("XpathEmployeeNameKey", (String) x.compile("//Employees/Employee[" + i + "]/EmployeeFullName/text()")
					.evaluate(document, XPathConstants.STRING));
			employeeMap.put("XpathEmployeeAddressKey",
					(String) x.compile("//Employees/Employee[" + i + "]/EmployeeFullAddress/text()").evaluate(document,
							XPathConstants.STRING));
			employeeMap.put("XpathFacultyNameKey", (String) x.compile("//Employees/Employee[" + i + "]/FacultyName/text()")
					.evaluate(document, XPathConstants.STRING));
			employeeMap.put("XpathDepartmentKey", (String) x.compile("//Employees/Employee[" + i + "]/Department/text()")
					.evaluate(document, XPathConstants.STRING));
			employeeMap.put("XpathDesignationKey", (String) x.compile("//Employees/Employee[" + i + "]/Designation/text()")
					.evaluate(document, XPathConstants.STRING));
			employeeList.add(employeeMap);
		}
		return employeeList;
	}
}
