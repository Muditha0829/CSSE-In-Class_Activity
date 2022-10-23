

public class b {

	public String employeeId;
	public String fullName;
	public String address;
	public String facultyName;
	public String department;
	public String designation;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeID) {
		employeeId = employeeID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		address = address;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		facultyName = facultyName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		designation = designation;
	}

	@Override
	public String toString() {
		
		return "Employee ID = " + employeeId + "\n" + "FullName = " + fullName + "\n" + "Address = " + address + "\n"
				+ "Faculty Name = " + facultyName + "\n" + "Department = " + department + "\n" + "Designation = "
				+ designation;
	}
}
