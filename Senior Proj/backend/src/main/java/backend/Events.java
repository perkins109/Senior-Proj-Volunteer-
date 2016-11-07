package backend;

import java.sql.*;


import com.google.gson.JsonElement;
import com.mysql.jdbc.PreparedStatement;

public class Events 
{
	
	private static DBConnector events;
	EventPOJO event;
	
	public Events(DBConnector events) 
	{
		super();
		this.events = events;
	}

	public ResultSet nameSearch(String name) throws SQLException
	{
		ResultSet rs = events.results("SELECT * FROM events WHERE name LIKE '%" + name + "%'");
		
		
		return rs;

	}
	
	public ResultSet dateSearch(String date) throws SQLException
	{
		ResultSet rs = events.results("SELECT * FROM events WHERE date LIKE '%" + date + "%'");
		
		return rs;

	}

	public boolean attend(String id) throws SQLException 
	{
		Boolean rs = events.input("UPDATE events SET attendanceCOUNT = attendanceCOUNT + 1 WHERE id = '" + id + "'");
		
		
		return rs;
	}
	
	public static void add(EventPOJO event) throws SQLException 
	{
		try
		{
		 String query = "INSERT INTO events ( name, status, description, location, date, time, owner, contactEmail)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?)";

			      // create the mysql insert preparedstatement
		 		java.sql.PreparedStatement preparedStmt = events.getCon().prepareStatement(query);
			      preparedStmt.setString (1, event.getName());
			      preparedStmt.setString (2, event.getStatus());
			      preparedStmt.setString (3, event.getDescription());
			      preparedStmt.setString (4, event.getLocation());
			      preparedStmt.setString (5, event.getDate());
			      preparedStmt.setString (6, event.getTime());
			      preparedStmt.setString (7, event.getOwner());
			      preparedStmt.setString (8, event.getContactEmail());
		
			      
			      preparedStmt.execute();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
			     
		
		
	}

}
