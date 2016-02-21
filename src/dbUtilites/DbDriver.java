package dbUtilites;

import entites.GeneralEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.mysql.fabric.xmlrpc.base.Array;

public class DbDriver {
	private static Connection connection = null;
	private static Statement statement;
    private static ResultSet result;
	private String url,user,pswd;
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
	public boolean connect() {
		try{
			connection = DriverManager.getConnection(url, user, pswd);
			statement = connection.createStatement();
			
			return true;
		}
		catch (SQLException e)		{
			e.printStackTrace();
			try {
				connection.close();
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			return false;
		}
		finally {
			
		}
	}
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
}
