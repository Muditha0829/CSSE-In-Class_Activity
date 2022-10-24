
import javax.xml.transform.TransformerFactoryConfigurationError;
import java.util.logging.Level;

public class Main {

	/**
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

		//Declaring object from EmployeeService
		EmployeeService employeeService = new EmployeeService();

		//Handling Exceptions
		try {
			c3.requestTransform();

			employeeService.getEmployeesFromXML();
			employeeService.employeeCreateTable();
			employeeService.addEmployee();
			employeeService.getEmployeeID("EMP10004");
			employeeService.deleteEmployee("EMP10001");
			employeeService.getEmployees();

		} catch (TransformerFactoryConfigurationError | Exception e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}

	}

}
