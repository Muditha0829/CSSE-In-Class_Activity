

import java.sql.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;

public class EmployeeService extends c1 {

	//Declaring ArrayList for Employees
	private final ArrayList<Employee> employeeArray = new ArrayList<Employee>();

	//Declaring variables for database connection
	private static Connection connection;
	private PreparedStatement preparedStatement;

	//Creating connection for employee
	public EmployeeService() {
		try {
			//Check for existing connection using singleton
			if(connection==null){
				//Establishing connection with the database
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(property.getProperty("url"), property.getProperty("username"),
						property.getProperty("password"));
			}else {

				c1.LOG.info("Connection already exists");
			}
		} catch (SQLException | ClassNotFoundException e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
	}

	//Get data from xml
	public void getEmployeesFromXML() {

		try {
			int s = c3.XMLXPATHS().size();
			for (int i = 0; i < s; i++) {
				Map<String, String> l = c3.XMLXPATHS().get(i);
				Employee employee = new Employee();
				employee.setEmployeeId(l.get("XpathEmployeeIDKey"));
				employee.setFullName(l.get("XpathEmployeeNameKey"));
				employee.setAddress(l.get("XpathEmployeeAddressKey"));
				employee.setFacultyName(l.get("XpathFacultyNameKey"));
				employee.setDepartment(l.get("XpathDepartmentKey"));
				employee.setDesignation(l.get("XpathDesignationKey"));
				employeeArray.add(employee);
				System.out.println(employee.toString() + "\n");
			}
		} catch (Exception e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
	}

	//Connect with the table in the database
	public void employeeCreateTable() {
		//
		try {
			Statement s = connection.createStatement();
			s.executeUpdate(c2.Q("q2"));
			s.executeUpdate(c2.Q("q1"));
		} catch (Exception e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
	}

	//Adding employees to the database
	public void addEmployee() {
		//add employee
		try {
			preparedStatement = connection.prepareStatement(c2.Q("q3"));
			connection.setAutoCommit(false);
			for (Employee e : employeeArray) {
				preparedStatement.setString(1, e.getEmployeeId());
				preparedStatement.setString(2, e.getFullName());
				preparedStatement.setString(3, e.getAddress());
				preparedStatement.setString(4, e.getFacultyName());
				preparedStatement.setString(5, e.getDepartment());
				preparedStatement.setString(6, e.getDesignation());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			connection.commit();
		} catch (Exception e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
	}

	//Get employee data from the database by employeeId
	public void getEmployeeID(String eid) {

		Employee employee = new Employee();
		try {
			preparedStatement = connection.prepareStatement(c2.Q("q4"));
			preparedStatement.setString(1, eid);
			ResultSet R = preparedStatement.executeQuery();
			while (R.next()) {
				employee.setEmployeeId(R.getString(1));
				employee.setFullName(R.getString(2));
				employee.setAddress(R.getString(3));
				employee.setFacultyName(R.getString(4));
				employee.setDepartment(R.getString(5));
				employee.setDesignation(R.getString(6));
			}
			ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();
			employeeArrayList.add(employee);
			employeeOutput(employeeArrayList);
		} catch (Exception e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
	}

	//Delete employee data by employeeId
	public void deleteEmployee(String eid) {

		try {
			preparedStatement = connection.prepareStatement(c2.Q("q6"));
			preparedStatement.setString(1, eid);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
	}

	//Get all employee data from the database
	public void getEmployees() {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		try {
			preparedStatement = connection.prepareStatement(c2.Q("q5"));
			ResultSet r = preparedStatement.executeQuery();
			while (r.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(r.getString(1));
				employee.setFullName(r.getString(2));
				employee.setAddress(r.getString(3));
				employee.setFacultyName(r.getString(4));
				employee.setDepartment(r.getString(5));
				employee.setDesignation(r.getString(6));
				employeeList.add(employee);
			}
		} catch (Exception e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
		employeeOutput(employeeList);
	}

	//Display employees data fetched from the database
	public void employeeOutput(ArrayList<Employee> l){
		
		System.out.println( "Employee ID" + "\t\t" +
							"Full Name" + "\t\t" +
							"Address" + "\t\t" +
							"Faculty Name" + "\t\t" +
							"Department" + "\t\t" +
							"Designation" + "\n");

		System.out.println("================================================================================================================");

		for (Employee employee : l) {
			System.out.println( employee.getEmployeeId() + "\t" +
								employee.getFullName() + "\t\t" +
								employee.getAddress() + "\t" +
								employee.getFacultyName() + "\t" +
								employee.getDepartment() + "\t" +
								employee.getDesignation() + "\n");

			System.out.println("----------------------------------------------------------------------------------------------------------------");
		}
		
	}
}
