

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.Properties;


public class UtilityL {

	//Initialize variables
	public static final Properties property = new Properties();
	public static final Logger LOG = Logger.getLogger(EmployeeService.class.getName());

	static {
		try {
			property.load(UtilityQ.class.getResourceAsStream("../config/config.properties"));
		}
		catch (NullPointerException | IOException e) {
			UtilityL.LOG.log(Level.SEVERE, e.getMessage());
		}
	}
}
