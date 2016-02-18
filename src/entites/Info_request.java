package entites;

public class Info_request {
	// Дата заявки
	private long IncomeDate;
	// ФИО клиента
	private String FullNameClient;
	// Адрес клиента
	private String Address;
	// Планируемая дата выезда мастера
	private long ServiceDate;
	// Дата закрытия заявки
	private long ClosedDate;
	// Коментарий к заявке
	private String Comment;
	
	
	public Info_request(){
		IncomeDate = 0;
		FullNameClient = null;
		Address = null;
		ServiceDate = 0;
		ClosedDate = 0;
		Comment = null;
	}
		
	public Info_request(
			long incomeDate,
			String fullNameClient,
			String address,
			long serviceDate,
			long closedDate,
			String comment){
		IncomeDate = incomeDate;
		FullNameClient = fullNameClient;
		Address = address;
		ServiceDate = serviceDate;
		ClosedDate = closedDate;
		Comment = comment;
	}
	
	public long getIncomeDate() {
		return IncomeDate;
	}
	public void setIncomeDate(long incomeDate) {
		IncomeDate = incomeDate;
	}
	public String getFullNameClient() {
		return FullNameClient;
	}
	public void setFullNameClient(String fullNameClient) {
		FullNameClient = fullNameClient;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public long getServiceDate() {
		return ServiceDate;
	}
	public void setServiceDate(long serviceDate) {
		ServiceDate = serviceDate;
	}
	public long getClosedDate() {
		return ClosedDate;
	}
	public void setClosedDate(long closedDate) {
		ClosedDate = closedDate;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
		
}
