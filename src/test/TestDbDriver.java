package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dbUtilities.DbDriver;
import entities.Employee;

/*
 * Test class for DbDriver
 */
public class TestDbDriver {
	
	/*
	 * Test method for DB interaction
	 */
	@Test
	public void test() {
		DbDriver driver = new DbDriver("jdbc:mysql://localhost:3306/mp?autoReconnect=true&useSSL=false", "admin", "vae51");
		boolean connectionEstablished = driver.connect();
		assertTrue("Connection error",connectionEstablished);
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
			
			

			driver.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			fail("SQL exception happened");
		}
	}

}
