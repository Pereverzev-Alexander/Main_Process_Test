package entities;

/**
 * @author Alexander
 * Сущность для таблицы "Услуги"
 */
public class Active_services {
	// Тип подключаемой услуги (Интернет/ТВ/Телефон)
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
