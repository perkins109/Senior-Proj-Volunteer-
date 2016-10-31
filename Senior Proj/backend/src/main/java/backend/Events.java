package backend;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.JsonElement;

public class Events 
{
	
	private static DBConnector events;
	
	public Events(DBConnector events) 
	{
		super();
		this.events = events;
	}

	public static ResultSet nameSearch(String name) throws SQLException
	{
		ResultSet rs = events.results("SELECT * FROM events WHERE name LIKE '%" + name + "%'");
		
		
		return rs;

	}
	
	public static ResultSet dateSearch(String date) throws SQLException
	{
		ResultSet rs = events.results("SELECT * FROM events WHERE date LIKE '%" + date + "%'");
		
		return rs;

	}

	public boolean attend(String id) throws SQLException 
	{
		Boolean rs = events.input("UPDATE events SET attendanceCOUNT = attendanceCOUNT + 1 WHERE id = '" + id + "'");
		
		
		return rs;
	}

}
