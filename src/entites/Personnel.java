package entites;

public class Personnel {
	// ��������� ���������� (��������/������)
	private String EmployeePosition = null;
	// ��� ����������
	private String FullNameEmployee = null;
	
		
	public Personnel(){
		EmployeePosition = null;
		FullNameEmployee = null;
	}
	
	public Personnel(
			String employeePosition,
			String fullNameEmployee){
		EmployeePosition = employeePosition;
		FullNameEmployee = fullNameEmployee;
		
	}
	
	public String getEmployeePosition() {
		return EmployeePosition;
	}
	public void setEmployeePosition(String employeePosition) {
		EmployeePosition = employeePosition;
	}
	public String getFullNameEmployee() {
		return FullNameEmployee;
	}
	public void setFullNameEmployee(String fullNameEmployee) {
		FullNameEmployee = fullNameEmployee;
	}
}
