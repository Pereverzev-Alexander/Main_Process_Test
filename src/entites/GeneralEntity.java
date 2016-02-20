package entites;

public class GeneralEntity {
	// Тип подключаемой услуги (интернет/ТВ/Телефон)
	private String typeService;
	// Дата заявки
	private long incomeDate;
	// ФИО клиента
	private String fullNameClient;
	// Адрес клиента
	private String address;
	// Планируемая дата выезда мастера
	private long serviceDate;
	// Дата закрытия заявки
	private long closedDate;
	// Коментарий к заявке
	private String comment;
	// Должность сотрудника (Оператор/Мастер)
	private String employeePosition = null;
	// ФИО сотрудника
	private String fullNameEmployee = null;
	
	
	public GeneralEntity(){
		typeService = null;
		incomeDate = 0;
		fullNameClient = null;
		address = null;
		serviceDate = 0;
		closedDate = 0;
		comment = null;
		employeePosition = null;
		fullNameEmployee = null;
	}
	
	public GeneralEntity(
			String _typeService,
			long _incomeDate,
			String _fullNameClient,
			String _address,
			long _serviceDate,
			long _closedDate,
			String _comment,
			String _employeePosition,
			String _fullNameEmployee){
		typeService = _typeService;
		incomeDate = _incomeDate;
		fullNameClient = _fullNameClient;
		address = _address;
		serviceDate = _serviceDate;
		closedDate = _closedDate;
		comment = _comment;
		employeePosition = _employeePosition;
		fullNameEmployee = _fullNameEmployee;
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
