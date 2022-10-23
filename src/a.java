

import org.xml.sax.SAXException;
import java.sql.Connection;
import java.util.logging.Logger;
import java.sql.DriverManager;
import javax.xml.parsers.ParserConfigurationException;
import java.sql.PreparedStatement;
import javax.xml.xpath.XPathExpressionException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.sql.Statement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class a extends c1 {

	private final ArrayList<b> el = new ArrayList<b>();

	private static Connection c;

	private PreparedStatement ps;

	public a() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"),
					p.getProperty("password"));
		} catch (Exception e) {
		} 
	}

	public void a2() {

		try {
			int s = c3.XMLXPATHS().size();
			for (int i = 0; i < s; i++) {
				Map<String, String> l = c3.XMLXPATHS().get(i);
				b EMPLOYEE = new b();
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
		}
	}

	public void a3() {
		try {
			Statement s = c.createStatement();
			s.executeUpdate(c2.Q("q2"));
			s.executeUpdate(c2.Q("q1"));
		} catch (Exception e) {
		}
	}

	public void a4() {
		try {
			ps = c.prepareStatement(c2.Q("q3"));
			c.setAutoCommit(false);
			for (b e : el) {
				ps.setString(1, e.getEmployeeId());
				ps.setString(2, e.getFullName());
				ps.setString(3, e.getAddress());
				ps.setString(4, e.getFacultyName());
				ps.setString(5, e.getDepartment());
				ps.setString(6, e.getDesignation());
				ps.addBatch();
			}
			ps.executeBatch();
			c.commit();
		} catch (Exception e) {
		}
	}

	public void eMPLOYEEGETBYID(String eid) {

		b e = new b();
		try {
			ps = c.prepareStatement(c2.Q("q4"));
			ps.setString(1, eid);
			ResultSet R = ps.executeQuery();
			while (R.next()) {
				e.setEmployeeId(R.getString(1));
				e.setFullName(R.getString(2));
				e.setAddress(R.getString(3));
				e.setFacultyName(R.getString(4));
				e.setDepartment(R.getString(5));
				e.setDesignation(R.getString(6));
			}
			ArrayList<b> l = new ArrayList<b>();
			l.add(e);
			eMPLOYEEoUTPUT(l);
		} catch (Exception ex) {
		}
	}

	public void EMPLOYEEDELETE(String eid) {

		try {
			ps = c.prepareStatement(c2.Q("q6"));
			ps.setString(1, eid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void a5() {

		ArrayList<b> l = new ArrayList<b>();
		try {
			ps = c.prepareStatement(c2.Q("q5"));
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				b e = new b();
				e.setEmployeeId(r.getString(1));
				e.setFullName(r.getString(2));
				e.setAddress(r.getString(3));
				e.setFacultyName(r.getString(4));
				e.setDepartment(r.getString(5));
				e.setDesignation(r.getString(6));
				l.add(e);
			}
		} catch (Exception e) {
		}
		eMPLOYEEoUTPUT(l);
	}
	
	public void eMPLOYEEoUTPUT(ArrayList<b> l){
		
		System.out.println("Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		System.out.println("================================================================================================================");
		for (b e : l) {
			System.out.println(e.getEmployeeId() + "\t" + e.getFullName() + "\t\t"
					+ e.getAddress() + "\t" + e.getFacultyName() + "\t" + e.getDepartment() + "\t"
					+ e.getDesignation() + "\n");
			System.out.println("----------------------------------------------------------------------------------------------------------------");
		}
		
	}
}
