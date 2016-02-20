package entites;

public class Info_request {
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
	
	
	public Info_request(){
		incomeDate = 0;
		fullNameClient = null;
		address = null;
		serviceDate = 0;
		closedDate = 0;
		comment = null;
	}
		
	public Info_request(
			long _incomeDate,
			String _fullNameClient,
			String _address,
			long _serviceDate,
			long _closedDate,
			String _comment){
		incomeDate = _incomeDate;
		fullNameClient = _fullNameClient;
		address = _address;
		serviceDate = _serviceDate;
		closedDate = _closedDate;
		comment = _comment;
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
		
}
