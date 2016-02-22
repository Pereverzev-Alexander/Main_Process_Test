package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander
 * Информация о заявке
 */
public class Request {
	
	//Service types id's
	public final static Integer service_internet_id = 1;
	public final static Integer service_tv_id = 2;
	public final static Integer service_telephone_id = 3;
	
	//Расшифровка таблицы services
	public static final Integer[][] services_in_table = {
			{service_internet_id}, //services.id 1
			{service_tv_id}	,     //services.id 2
			{service_telephone_id},  //services.id 3
			{service_telephone_id,service_tv_id}, //services.id 4
			{service_internet_id,service_telephone_id}, //services.id 5
			{service_tv_id,service_internet_id}, //services.id 6
			{service_internet_id,service_tv_id,service_telephone_id} //services.id 7
	};
	
	// Дата регистрации заявки
	private long incomeDate;
	// ФИО клиента
	private String clientName,clientSecondName,clientSurname;
	// Адрес клиента
	private String address;
	// Планируемая дата выезда к клиенту
	private long serviceDate;
	// Дата закрытия заявки
	private long closedDate;
	// Комментарий к заявке
	private String comment;
	//ФИО оператора
	private Employee operator;
	//ФИО мастера
	private Employee master;
	//Типы услуг
	private List<Integer> services;
	//Идентификатор заявки
	private int id;
	
	

	public Request(){
		incomeDate = 0;
		clientName = null;
		clientSecondName = null;
		clientSurname = null;
		address = null;
		serviceDate = 0;
		closedDate = 0;
		comment = null;
		master = null;
		operator = null;
		id = 0;
		services = new ArrayList<Integer>();
	}
	
	//consider deprecated
	/*public Request(
			long _incomeDate,
			String _fullNameClient,
			String _address,
			long _serviceDate,
			long _closedDate,
			String _operator,
			String _master,
			String _comment){
		incomeDate = _incomeDate;
		fullNameClient = _fullNameClient;
		address = _address;
		serviceDate = _serviceDate;
		closedDate = _closedDate;
		comment = _comment;
		operatorName = _operator;
		masterName = _master;
	}*/
	
	/*
	 * Check if Internet connection is requested
	 */
	public boolean isInternetRequested() {
		return services.contains(service_internet_id);
	}
	
	/*
	 * Check if telephone connection is requested
	 */
	public boolean isTelephoneRequested() {
		return services.contains(service_telephone_id);
	}
	
	/*
	 * Check if TV connection is requested
	 */
	public boolean isTvRequested() {
		return services.contains(service_tv_id);
	}
	
	/*
	 * Get all the connected services
	 */
	public String getTypeServices(){
		String temp = null;
		if(isInternetRequested())
			temp = "Интернет";
		else 
			temp = "";
		if(isTelephoneRequested() && temp.equals(null))
			temp = "Телефон";
		else
			if(isTelephoneRequested())
				temp = temp + ", Телефон";
		if(isTvRequested() && temp.equals(null))
			temp = "ТВ";
		else
			if(isTvRequested())
				temp = temp + ", ТВ";
		return temp;
	}
	
	/*
	 * Add Internet connection to the requested services
	 */
	public void addRequestInternet(){
		if (!services.contains(service_internet_id)){
			services.add(service_internet_id);
		}
	}
	
	/*
	 * Add phone connection to the requested services
	 */
	public void addRequestTelephone(){
		if (!services.contains(service_telephone_id)) {
			services.add(service_telephone_id);
		}
	}
	
	/*
	 * Add TV connection to the requested services
	 */
	public void addRequestTv(){
		if (!services.contains(service_tv_id)) {
			services.add(service_tv_id);
		}
	}
	
	public long getIncomeDateRaw() {
		return incomeDate;
	}
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(Employee operator) {
		this.operator = operator;
	}

	/**
	 * @param master the master to set
	 */
	public void setMaster(Employee master) {
		this.master = master;
	}

	public void setIncomeDateRaw(long _incomeDate) {
		incomeDate = _incomeDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String _address) {
		address = _address;
	}
	public long getServiceDateRaw() {
		return serviceDate;
	}
	public void setServiceDateRaw(long _serviceDate) {
		serviceDate = _serviceDate;
	}
	public long getClosedDateRaw() {
		return closedDate;
	}
	public void setClosedDateRaw(long _closedDate) {
		closedDate = _closedDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String _comment) {
		comment = _comment;
	}
	/**
	 * @return the operatorName
	 */
	public String getOperatorInitials() {
		if(operator != null){
			return operator.getInitials();
		}
		else return null;
	}
	
	public String getMasterInitials() {
		if(master != null){
			return master.getInitials();
		}
		else return null;
	}

	public void setOperatorName(String operatorName) {
		if(operator == null){
			operator = new Employee();
		}
		operator.setName(operatorName);
	}
	
	public void setOperatorSecondName(String sec_name) {
		if(operator == null){
			operator = new Employee();
		}
		operator.setSecondName(sec_name);
	}
	
	public void setOperatorSurname(String surname) {
		if(operator == null){
			operator = new Employee();
		}
		operator.setSurname(surname);
	}
	
	public void setMasterName(String masterName) {
		if(master == null){
			master = new Employee();
		}
		master.setName(masterName);
	}
	
	public void setMasterSecondName(String sec_name) {
		if(master == null){
			master = new Employee();
		}
		master.setSecondName(sec_name);
	}
	
	public void setMasterSurname(String surname) {
		if(master == null){
			master = new Employee();
		}
		master.setSurname(surname);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the clientSecondName
	 */
	public String getClientSecondName() {
		return clientSecondName;
	}

	/**
	 * @param clientSecondName the clientSecondName to set
	 */
	public void setClientSecondName(String clientSecondName) {
		this.clientSecondName = clientSecondName;
	}

	/**
	 * @return the clientSurname
	 */
	public String getClientSurname() {
		return clientSurname;
	}

	/**
	 * @param clientSurname the clientSurname to set
	 */
	public void setClientSurname(String clientSurname) {
		this.clientSurname = clientSurname;
	}

	/*
	 * Get client full name as Ivanov Akakiy Akakievich
	 */
	public String getClientFullName(){
		return clientName+" "+clientSecondName+" "+clientSurname;
	}
	
	/*
	 * Add service by it's id
	 */
	public void addRequiredService(int serv_id){
		services.add(serv_id);
	}
	
	public String toString(){
		return Integer.toString(id)+" "+clientName+" "+clientSecondName+" "+clientSurname+
				" ;Оператор: "+operator.getInitials()+" Мастер: "+master.getInitials();
	}

	
		
}
