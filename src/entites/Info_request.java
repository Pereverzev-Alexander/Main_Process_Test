package entites;

public class Info_request {
	// ���� ������
	private long IncomeDate;
	// ��� �������
	private String FullNameClient;
	// ����� �������
	private String Address;
	// ����������� ���� ������ �������
	private long ServiceDate;
	// ���� �������� ������
	private long ClosedDate;
	// ���������� � ������
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
