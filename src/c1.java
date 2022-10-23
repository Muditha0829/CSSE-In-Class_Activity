

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.Properties;


public class c1 {

	public static final Properties p = new Properties();

	public static final Logger LOG = Logger.getLogger(EmployeeService.class.getName());

	static {
		try {
			p.load(c2.class.getResourceAsStream("../config/config.properties"));
		}
		catch (NullPointerException e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
		catch (IOException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
	}
}
