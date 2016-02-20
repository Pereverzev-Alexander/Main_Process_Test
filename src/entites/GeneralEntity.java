package entites;

/**
 * @author Alexander
 * Общая сущность, включающая в себя все поля. Используется для экспорта в XLS документ и 
 * для запроса, возвращающего ВСЮ информацию о заявке 
 */
public class GeneralEntity {
	// Тип подключаемой услуги (Интернет/ТВ/Телефон)
	private String typeService;
	// Дата регистрации заявки
	private long incomeDate;
	// ФИО клиента
	private String fullNameClient;
	// Адрес клиента
	private String address;
	// Планируемая дата выезда клиента
	private long serviceDate;
	// Дата закрытия заявки
	private long closedDate;
	// Комментарий к заявке
	private String comment;
	// ФИО оператора, принявшего заявку
	private String fullNameOperator = null;
	// ФИО мастера
	private String fullNameMaster = null;
	
	
	public GeneralEntity(){
		typeService = null;
		incomeDate = 0;
		fullNameClient = null;
		address = null;
		serviceDate = 0;
		closedDate = 0;
		comment = null;
		fullNameOperator = null;
		fullNameMaster = null;
	}
	
	public GeneralEntity(
			String _typeService,
			long _incomeDate,
			String _fullNameClient,
			String _address,
			long _serviceDate,
			long _closedDate,
			String _comment,
			String _fullNameOperator,
			String _fullNameMaster){
		typeService = _typeService;
		incomeDate = _incomeDate;
		fullNameClient = _fullNameClient;
		address = _address;
		serviceDate = _serviceDate;
		closedDate = _closedDate;
		comment = _comment;
		fullNameOperator = _fullNameOperator;
		fullNameMaster = _fullNameMaster;
	}

	public String getTypeService() {
		return typeService;
	}

	public void setTypeService(String _typeService) {
		typeService = _typeService;
	}

	public long getIncomeDate() {
		return incomeDate;
	}

	public void setIncomeDate(long _incomeDate) {
		incomeDate = _incomeDate;
	}

	public String getFullNameClient() {
		return fullNameClient;
	}

	public void setFullNameClient(String _fullNameClient) {
		fullNameClient = _fullNameClient;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String _address) {
		address = _address;
	}

	public long getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(long _serviceDate) {
		serviceDate = _serviceDate;
	}

	public long getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(long _closedDate) {
		closedDate = _closedDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String _comment) {
		comment = _comment;
	}

	public String getEmployeePosition() {
		return fullNameOperator;
	}

	public void setEmployeePosition(String _fullNameOperator) {
		fullNameOperator = _fullNameOperator;
	}

	public String getFullNameEmployee() {
		return fullNameMaster;
	}

	public void setFullNameEmployee(String _fullNameMaster) {
		fullNameMaster = _fullNameMaster;
	}
	
	
}
