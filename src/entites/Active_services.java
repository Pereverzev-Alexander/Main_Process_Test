package entites;

public class Active_services {
	// ��� ������������ ������ (��������/��/�������)
	private String typeService;
	
	
	public Active_services() {
		typeService = null;
	}
	
	public Active_services(String _typeService){
		typeService = _typeService;
	}
	
	public String getTypeService() {
		return typeService;
	}

	public void setTypeService(String _typeService) {
		typeService = _typeService;
	}
}
