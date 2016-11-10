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
	
	public String add(EventPOJO event) throws SQLException 
	{
		try
		{
		 String query = "INSERT INTO events ( name, status, description, date, time, owner, contactEmail, lat, lng)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			      // create the mysql insert preparedstatement
		 		java.sql.PreparedStatement preparedStmt = events.getCon().prepareStatement(query);
			      preparedStmt.setString (1, event.getName());
			      preparedStmt.setString (2, event.getStatus());
			      preparedStmt.setString (3, event.getDescription());
			      preparedStmt.setString (4, event.getDate());
			      preparedStmt.setString (5, event.getTime());
			      preparedStmt.setString (6, event.getOwner());
			      preparedStmt.setString (7, event.getContactEmail());
			      preparedStmt.setString (8, event.getLat());
			      preparedStmt.setString (9, event.getLng());
		
			      
			      preparedStmt.execute();
			      Boolean rs = events.input("INSERT INTO eventsCreated (user_id, eventsCreated)"
			      		+ "values((SELECT user_id FROM users WHERE userName = '"+ event.getOwner() +"'),LAST_INSERT_ID())");   
			      
			      return "true";
			      
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			 return e.toString();
		}
	}
			     
		
		public String edit(EventPOJO event, String id) throws SQLException 
		{
			try
			{
			 String query = "UPDATE events SET name = ?, description = ?, date = ?, time = ?, "
			 		+ "contactEmail = ?, lat = ?, lng = ? where id = '" + id + "'";

				      // create the mysql insert preparedstatement
			 		java.sql.PreparedStatement preparedStmt = events.getCon().prepareStatement(query);
				      preparedStmt.setString (1, event.getName());
				      preparedStmt.setString (2, event.getDescription());
				      preparedStmt.setString (3, event.getDate());
				      preparedStmt.setString (4, event.getTime());
				      preparedStmt.setString (5, event.getContactEmail());
				      preparedStmt.setString (6, event.getLat());
				      preparedStmt.setString (7, event.getLng());
			
				      
				      preparedStmt.execute();
				     
				      return "true";
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
				return e.toString();
			}
		
	}

		
		public ResultSet locationSearch(String lat, String lng, String radius) throws SQLException 
		{
			ResultSet rs = null;
			try
			{
			 String query = "SELECT *, ( 3959 * acos( cos( radians(?) ) * "
			 		+ "cos( radians( lat ) ) * cos( radians( lng ) - radians(?) ) + sin( radians(?) ) *"
			 		+ " sin( radians( lat ) ) ) ) AS distance FROM events having distance < ? ORDER BY distance LIMIT 0 , 20;";

				      // create the mysql insert preparedstatement
			 		java.sql.PreparedStatement preparedStmt = events.getCon().prepareStatement(query);
				      preparedStmt.setString (1, lat);
				      preparedStmt.setString (2, lng);
				      preparedStmt.setString (3, lat);
				      preparedStmt.setString (4, radius);
				      
			
				      
				    rs = preparedStmt.executeQuery();
				    
				    return rs;
				     
				      
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
			return rs;
		}
}
