package entites;

public class Personnel {
	// ��������� ���������� (��������/������)
	private String employeePosition = null;
	// ��� ����������
	private String fullNameEmployee = null;
	
		
	public Personnel(){
		employeePosition = null;
		fullNameEmployee = null;
	}
	
	public Personnel(
			String _employeePosition,
			String _fullNameEmployee){
		employeePosition = _employeePosition;
		fullNameEmployee = _fullNameEmployee;
		
	}
	
	public String getEmployeePosition() {
		return employeePosition;
	}
	public void setEmployeePosition(String _employeePosition) {
		employeePosition = _employeePosition;
	}
	public String getFullNameEmployee() {
		return fullNameEmployee;
	}
	public void setFullNameEmployee(String _fullNameEmployee) {
		fullNameEmployee = _fullNameEmployee;
	}
}
