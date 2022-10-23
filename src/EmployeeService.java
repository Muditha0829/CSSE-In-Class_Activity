

import java.sql.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;

public class EmployeeService extends c1 {

	private final ArrayList<Employee> el = new ArrayList<Employee>();

	private static Connection conn;

	private PreparedStatement ps;

	public EmployeeService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"),
					p.getProperty("password"));
		} catch (SQLException | ClassNotFoundException e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
	}

	public void a2() {
	//getfromxml
		try {
			int s = c3.XMLXPATHS().size();
			for (int i = 0; i < s; i++) {
				Map<String, String> l = c3.XMLXPATHS().get(i);
				Employee EMPLOYEE = new Employee();
				EMPLOYEE.setEmployeeId(l.get("XpathEmployeeIDKey"));
				EMPLOYEE.setFullName(l.get("XpathEmployeeNameKey"));
				EMPLOYEE.setAddress(l.get("XpathEmployeeAddressKey"));
				EMPLOYEE.setFacultyName(l.get("XpathFacultyNameKey"));
				EMPLOYEE.setDepartment(l.get("XpathDepartmentKey"));
				EMPLOYEE.setDesignation(l.get("XpathDesignationKey"));
				el.add(EMPLOYEE);
				System.out.println(EMPLOYEE.toString() + "\n");
			}
		} catch (Exception e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
	}

	public void a3() {
		//
		try {
			Statement s = conn.createStatement();
			s.executeUpdate(c2.Q("q2"));
			s.executeUpdate(c2.Q("q1"));
		} catch (Exception e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
	}

	public void addEmployee() {
		//add employee
		try {
			ps = conn.prepareStatement(c2.Q("q3"));
			conn.setAutoCommit(false);
			for (Employee e : el) {
				ps.setString(1, e.getEmployeeId());
				ps.setString(2, e.getFullName());
				ps.setString(3, e.getAddress());
				ps.setString(4, e.getFacultyName());
				ps.setString(5, e.getDepartment());
				ps.setString(6, e.getDesignation());
				ps.addBatch();
			}
			ps.executeBatch();
			conn.commit();
		} catch (Exception e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
	}

	public void getEmployeeID(String eid) {

		Employee employee = new Employee();
		try {
			ps = conn.prepareStatement(c2.Q("q4"));
			ps.setString(1, eid);
			ResultSet R = ps.executeQuery();
			while (R.next()) {
				employee.setEmployeeId(R.getString(1));
				employee.setFullName(R.getString(2));
				employee.setAddress(R.getString(3));
				employee.setFacultyName(R.getString(4));
				employee.setDepartment(R.getString(5));
				employee.setDesignation(R.getString(6));
			}
			ArrayList<Employee> l = new ArrayList<Employee>();
			l.add(employee);
			employeeOutput(l);
		} catch (Exception e) {
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
	}

	public void deleteEmployee(String eid) {

		try {
			ps = conn.prepareStatement(c2.Q("q6"));
			ps.setString(1, eid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			c1.LOG.log(Level.SEVERE, e.getMessage());
		}
	}

	public void getEmployees() {
	//get employees
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		try {
			ps = conn.prepareStatement(c2.Q("q5"));
			ResultSet r = ps.executeQuery();
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
	
	public void employeeOutput(ArrayList<Employee> l){
		
		System.out.println("Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		System.out.println("================================================================================================================");
		for (Employee employee : l) {
			System.out.println(employee.getEmployeeId() + "\t" + employee.getFullName() + "\t\t"
					+ employee.getAddress() + "\t" + employee.getFacultyName() + "\t" + employee.getDepartment() + "\t"
					+ employee.getDesignation() + "\n");
			System.out.println("----------------------------------------------------------------------------------------------------------------");
		}
		
	}
}
