public class Main {

	/**
	 * @param args
	 * description must
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

		} catch (Exception e) {
		}

	}

}
