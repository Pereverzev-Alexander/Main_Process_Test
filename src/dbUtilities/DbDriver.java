package dbUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import entities.Employee;
import entities.Request;
/*
 * Класс для взаимодействия с БД MySQL
 * 
 */
public class DbDriver {
	
	
	private static Connection connection = null;
	private static Statement statement;
    private static ResultSet result;
	private String url,user,pswd;
	private static java.sql.CallableStatement callGetRequestsBetween;
	private static java.sql.CallableStatement callAddRequest;
	
	private static List<Employee> employees_cache = null;
	
	
	public DbDriver	(String _url,String _user,String _pswd) {
		url = _url;
		user = _user;
		pswd = _pswd;
		
	}
	public void close () {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Connect to database
	 */
	public boolean connect() {
		try{
			System.out.println("Connecting to "+url);
			connection = DriverManager.getConnection(url, user, pswd);
			statement = connection.createStatement();
			
			//prepare statements
			callGetRequestsBetween = connection.prepareCall("{call requestsDate(?,?) }");
			callAddRequest = connection.prepareCall("{call addRequest(?,?,?,?,?,?,?,?,?,?,?) }");
			
			return true;
		}
		catch (SQLException e)		{
			System.out.println("Connection failed");
			//e.printStackTrace();			
			try {
				if (connection != null){
					connection.close();
					connection = null;
				}
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			return false;
		}
	}
	
	/*
	 * Get list of existing staff positions from DB 
	 */
	public List<String> getStaffPositionsList() throws SQLException{
		if (connection == null)
		{
			return null;
		}
		String query = "SELECT id,name from staff_positions";
		result = statement.executeQuery(query);
		List<String> res = new ArrayList<String>();
		while (result.next())
		{
			String name = result.getString(2);
			res.add(name);
		}
		return res;
	}
	
	/*
	 * Get list of all operators (surname and initials) from DB
	 */
	public List<String> getOperatorsInitialsList() throws SQLException{
		if (connection == null)
		{
			return null;
		}
		String query = "SELECT first_name,second_name,surname from staff where position_id = "+
					Integer.toString(Employee.operator_id)+";";
		result = statement.executeQuery(query);
		List<String> res = new ArrayList<String>();
		while (result.next())
		{
			String name = result.getString(3)+" ";
			name+=result.getString(1).substring(0,1).toUpperCase()+". ";
			name+=result.getString(2).substring(0,1).toUpperCase()+".";
			res.add(name);
		}
		return res;	
		
	}
	
	/*
	 * Get list of all masters (surname and initials) from DB
	 */
	public List<String> getMastersInitialsList() throws SQLException{
		if (connection == null)
			
		{
			return null;
		}
		String query = "SELECT first_name,second_name,surname from staff where position_id = "+
					Integer.toString(Employee.master_id)+";";
		result = statement.executeQuery(query);
		List<String> res = new ArrayList<String>();
		while (result.next())
		{
			String name = result.getString(3)+" ";
			name+=result.getString(1).substring(0,1).toUpperCase()+". ";
			name+=result.getString(2).substring(0,1).toUpperCase()+".";
			res.add(name);
		}
		return res;			
	}
	
	/*
	 * Get list of all employees
	 */
	public List<Employee> getEmployees() throws SQLException{
		if (connection == null)
		{
			return null;
		}
		String query = "select staff.id,first_name,second_name,surname,staff_positions.name "+
		 "from staff,staff_positions where staff.position_id = staff_positions.id;";
		result = statement.executeQuery(query);
		List<Employee> res = new ArrayList<Employee>();
		while (result.next())
		{
			Employee employee = new Employee();
			employee.setId(result.getInt(1));
			employee.setName(result.getString(2));
			employee.setSecondName(result.getString(3));
			employee.setSurname(result.getString(4));
			employee.setPosition(result.getString(5));
			res.add(employee);
			
		}		
		return res;				
	}
	/*
	 * Cache list of all employees in DB
	 * Checks if already cached
	 * This function is called every time any request is fetched from DB
	 */
	private void cacheEmployees(){
		if(employees_cache != null)
			return;
		employees_cache = null;
		try{
			employees_cache = getEmployees();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return;
		}	
		
	}
	
	/*
	 * Get employee object by it's id from local cache
	 */
	public Employee getEmployeeFromCache(int id){
		for(Employee e:employees_cache){
			if(e.getId() == id)
				return e;
		}
		return null;
	}
	
	/*
	 * Parse result of query returning some requests entries from DB
	 */
	private List<Request> parseRequestQueryResult(ResultSet result)	throws SQLException{
		List<Request> res = new ArrayList<Request>();
		while (result.next())
		{
			Request request = new Request();
			request.setId(result.getInt(1));
			request.setClientName(result.getString(2));
			request.setClientSecondName(result.getString(3));
			request.setClientSurname(result.getString(4));
			request.setAddress(result.getString(5));
			
			//setup required services
			int service_id = result.getInt(6);
			Integer []service_arr = Request.services_in_table[service_id-1];
			for(Integer i:service_arr) {
				request.addRequiredService(i);
			}
			
			request.setMaster(getEmployeeFromCache(result.getInt(7)));
			request.setOperator(getEmployeeFromCache(result.getInt(8)));
			
			request.setIncomeDateRaw(result.getLong(9));
			request.setClosedDateRaw(result.getLong(10));
			request.setServiceDateRaw(result.getLong(11));			
			
			res.add(request);
			
		}
		return res;
	}
	
	/*
	 * Get list of all requests in DB
	 */
	public List<Request> getAllRequests() throws SQLException{
		if (connection == null)
		{
			return null;
		}
		
		//first call of this function fills list of employees
		//after that, operator and master fields in request are filled with relevant Employee instances
		cacheEmployees();
		
		
		String query = "select id,first_name,second_name,surname,address,service_id,master_id,operator_id,"+
				"open_date,close_date,service_date from requests";
		result = statement.executeQuery(query);
		return parseRequestQueryResult(result);		
	}
	
	/*
	 * Get requests with date between raw1 and raw2
	 */
	public List<Request> getRequestsBetween(long start,long end) throws SQLException{
		if (connection == null)
		{
			return null;
		}
		
		//first call of this function fills list of employees
		//after that, operator and master fields in request are filled with relevant Employee instances
		cacheEmployees();
		
		callGetRequestsBetween.setLong(1, start);
		callGetRequestsBetween.setLong(2, end);
		result = callGetRequestsBetween.executeQuery();
		
		return parseRequestQueryResult(result);
	}
	
	/*
	 * Get employee id
	 */
	public int getEmployeeIdFromCache(Employee employee){
		for(Employee e:employees_cache){
			if(employee.getId() == e.getId())
				return e.getId();
		}
		System.out.println("Employee not found");
		return 0;
	}
	
	/*
	 * Add new request to DB
	 */
	public boolean addRequest(Request request) throws SQLException{
		if (connection == null)
		{
			return false;
		}
		
		//first call of this function fills list of employees
		cacheEmployees();
		
		callAddRequest.setString(1, request.getClientName());
		callAddRequest.setString(2, request.getClientSecondName());
		callAddRequest.setString(3, request.getClientSurname());
		callAddRequest.setString(4, request.getAddress());
		
		callAddRequest.setInt(5, request.getTableServicesId());
		callAddRequest.setInt(6, getEmployeeIdFromCache(request.getMaster()));
		callAddRequest.setInt(7, getEmployeeIdFromCache(request.getOperator()));
		callAddRequest.setLong(8, request.getIncomeDateRaw());
		callAddRequest.setLong(9, request.getClosedDateRaw());
		callAddRequest.setLong(10, request.getServiceDateRaw());
		callAddRequest.setString(11, request.getComment());
		
		callAddRequest.executeQuery();
		
		return true;
	}
	
	/*
	 * Add new request to DB
	 */
	public boolean addRequest (
			String clientName,
			String clientSecondName,
			String clientSurname,
			String address,
			List<Integer> required_services,
			Employee master,
			Employee operator,
			long open_time,
			long close_time,
			long service_time,
			String comment
			
			) throws SQLException{
		Request request = new Request();
		request.setClientName(clientName);
		request.setClientSecondName(clientSecondName);
		request.setClientSurname(clientSurname);
		request.setAddress(address);
		request.setServices(required_services);
		request.setOperator(operator);
		request.setMaster(master);
		request.setIncomeDateRaw(open_time);
		request.setClosedDateRaw(close_time);
		request.setServiceDateRaw(service_time);
		request.setComment(comment);
		return addRequest(request);
		
	}
	
	
}
