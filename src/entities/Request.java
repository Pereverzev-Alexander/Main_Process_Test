package entities;

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
	
	
	// Дата регистрации заявки
	private long incomeDate;
	// ФИО клиента
	private String fullNameClient;
	// Адрес клиента
	private String address;
	// Планируемая дата выезда к клиенту
	private long serviceDate;
	// Дата закрытия заявки
	private long closedDate;
	// Комментарий к заявке
	private String comment;
	//ФИО оператора
	private String operatorName;
	//ФИО мастера
	private String masterName;
	//Типы услуг
	private List<Integer> services;
	
	

	public Request(){
		incomeDate = 0;
		fullNameClient = null;
		address = null;
		serviceDate = 0;
		closedDate = 0;
		comment = null;
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
	/**
	 * @return the operatorName
	 */
	public String getOperatorName() {
		return operatorName;
	}

	/**
	 * @param operatorName the operatorName to set
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	/**
	 * @return the masterName
	 */
	public String getMasterName() {
		return masterName;
	}

	/**
	 * @param masterName the masterName to set
	 */
	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}
		
}
