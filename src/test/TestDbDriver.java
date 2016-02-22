package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dbUtilities.DbDriver;
import entities.Employee;
import entities.Request;

/*
 * Test class for DbDriver
 */
public class TestDbDriver {
	
	/*
	 * Test method for DB interaction
	 */
	@Test
	public void test() {
		//DbDriver driver = new DbDriver("jdbc:mysql://localhost:3306/mp?autoReconnect=true&useSSL=false", "admin", "vae51");
		
		DbDriver driver = new DbDriver("jdbc:mysql://85.10.205.173:3306/zayavki?autoReconnect=true&useSSL=false", "mainprocess", "mainprocess");
		
		boolean connectionEstablished = driver.connect();
		assertTrue("Connection error",connectionEstablished);
		if(!connectionEstablished)
			return;
		try{

			//check staff positions table	
			List<String> staff = driver.getStaffPositionsList();
			assertTrue("There must be 2 staff positions",staff != null && staff.size() == 2);
			System.out.println("Checked staff positions table");

			//check employees
			staff = driver.getOperatorsInitialsList();
			int op_size = staff.size();
			System.out.println("Operators number: "+Integer.toString(op_size));
			for(String name :staff){
				System.out.println("Operator: "+name);
			}
			staff = driver.getMastersInitialsList();
			int masters_size = staff.size();
			System.out.println("Masters number: "+Integer.toString(masters_size));
			for(String name :staff){
				System.out.println("Master: "+name);
			}
			List<Employee> employees = driver.getEmployees();
			assertEquals(masters_size+op_size, employees.size());
			System.out.println("Checked employees");
			
			/*System.out.println("Print all requests");
			List<Request> requests = driver.getAllRequests();
			for(Request req: requests){
				System.out.println(req.toString());
			}*/
			
			//check all requests
			List<Request> requests = driver.getAllRequests();
			assertTrue(requests.size()>0);
			
			//check stored procedures
			System.out.println("Requests between two dates:");
			requests = driver.getRequestsBetween(1448409600, 1449273600);
			for(Request req: requests){
				System.out.println(req.toString());
			}

			driver.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			fail("SQL exception happened");
		}
	}

}
