package entites;

public class Active_services {
	// Тип подключаемой услуги (интернет/ТВ/Телефон)
	private String TypeService;
	
	
	public Active_services() {
		TypeService = null;
	}
	
	public Active_services(String typeService){
		TypeService = typeService;
	}
	
	public String getTypeService() {
		return TypeService;
	}

	public void setTypeService(String typeService) {
		TypeService = typeService;
	}
}
