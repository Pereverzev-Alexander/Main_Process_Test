package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dbUtilites.DbDriver;

public class TestDbDriver {
	
	@Test
	public void test() {
		DbDriver driver = new DbDriver("jdbc:mysql://localhost:3306/mp?autoReconnect=true&useSSL=false", "admin", "vae51");
		boolean connectionEstablished = driver.connect();
		assertTrue("Connection error",connectionEstablished);
		try{
		List<String> staff = driver.getStaffPositionsList();
		assertTrue("There must be 2 staff positions",staff != null && staff.size() == 2);
		System.out.println("Checked staff positions table");
		driver.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			fail("SQL exception happened");
		}
	}

}
