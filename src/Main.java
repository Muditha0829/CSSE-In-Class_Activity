import org.xml.sax.SAXException;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;

public class Main {

	/**
	 * @param args
	 *
	 * @throws NullPointerException
	 * 			-Thrown when an application attempts to use null in a case where an object is required
	 *
	 * @throws NumberFormatException
	 *         -Thrown to indicate that the application has attempted to convert a string to one of the numeric types,
	 *          but that the string does not have the appropriate format
	 *
	 * @throws TransformerFactoryConfigurationError
	 *         -Thrown when a problem with configuration with the Transformer Factories exists
	 */

	public static void main(String[] args) {

		EmployeeService employeeService = new EmployeeService();

		try {
			c3.requestTransform();

			employeeService.a2();
			employeeService.a3();
			employeeService.a4();
			employeeService.getEmployeeID("EMP10004");
			employeeService.deleteEmployee("EMP10001");
			employeeService.a5();

		} catch (TransformerFactoryConfigurationError | Exception e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}

	}

}
