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
	 * @throws SQLException
	 *         -An exception that provides information on a database access error or other errors
	 *
	 * @throws NumberFormatException
	 *         -Thrown to indicate that the application has attempted to convert a string to one of the numeric types,
	 *          but that the string does not have the appropriate format
	 *
	 * @throws SAXException
	 *         -Encapsulate a general SAX error or warning
	 *
	 * @throws XPathExpressionException
	 *         - represents an error in an XPath expression.
	 *
	 * @throws IOException
	 *        -Signals that an I/O exception of some sort has occurred.
	 *         This class is the general class of exceptions produced by failed or interrupted I/O operations
	 *
	 * @throws TransformerException
	 *         -This class specifies an exceptional condition that occurred during the transformation process
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

		} catch (NullPointerException | SQLException e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		} catch (NumberFormatException e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
		catch (SAXException e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
		catch (XPathExpressionException e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
		catch (IOException e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
		catch (TransformerException e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
		catch (TransformerFactoryConfigurationError e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
		catch (Exception e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}

	}

}
