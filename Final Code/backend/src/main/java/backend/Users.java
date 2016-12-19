package backend;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Users 
{
	private static  DBConnector users;
	
	
	public Users(DBConnector users) 
	{
		super();
		this.users = users;
	}

	//Compares specified username and password against user database for exact match
	public boolean userValidate(String un, String pw) throws SQLException
	{
		ResultSet rs = users.results("SELECT * FROM users WHERE userName = '"+ un +"' AND password = '"+pw+"'");
		
		if(rs.next())
			return true;
		return false;

	}
	
	//Creates an entry in user database with specified username, password, email address, location, phone number, and sex 
	public Boolean addUser(String un, String pw, String em, String loc, String ph, String sex) throws SQLException
	{
		Boolean rs = users.input("INSERT INTO users (userName, password, email, homeLocation, phone, sex) VALUES"
				+ "( '"+un+"', '"+ pw +"', '" + em + "', '"+ loc + "', '" + ph + "', '" + sex + "' )");
		
		
		return rs;

	}
	
	//Getter for username
	public ResultSet getUser(String un) throws SQLException
	{
		ResultSet rs = users.results("SELECT * FROM users WHERE userName = '"+ un +"'");
		
		
		return rs;

	}

	//Updates specified username entry's corresponding password, assuming matching old password is supplied
	public Boolean changePw(String un, String currentPW, String newPW) throws SQLException 
	{
		
		Boolean rs = users.input("UPDATE users SET password = '"+newPW +"' WHERE userName = '" + un + "' AND "
				+ "password = '"+currentPW +"'");
		
		
		return rs;

	}
	
	//Getter for events attended for a specified username
	public  ResultSet getEventsAtt(String un) throws SQLException
	{
		String id = null;
		ResultSet rs = users.results("SELECT * FROM users WHERE userName = '"+ un +"'");
		
		if(rs.next())
			id = rs.getString("user_id");
		ResultSet retVal = users.results("SELECT * FROM events, eventsAttended WHERE eventsAttended.user_id = '"+ id +"' AND eventsAttended.eventsAttended = events.id");
		
		//error checking
		System.out.println("nick");

		
		return retVal;

	}
	
	//Getter for events created for a specified username
	public  ResultSet getEventsCreated(String un) throws SQLException
	{
		String id = null;
		ResultSet rs = users.results("SELECT * FROM users WHERE userName = '"+ un +"'");
		
		if(rs.next())
			id = rs.getString("user_id");
		ResultSet retVal = users.results("SELECT * FROM events, eventsCreated WHERE eventsCreated.user_id = '"+ id +"' AND eventsCreated.eventsCreated = events.id");
		System.out.println("nick");

		
		return retVal;

	}
	
	//Adds an event by ID to a specified username's corresponding eventsAttended field
	public Boolean attend(String eventID, String un) throws SQLException 
	{
		
		Boolean rs = users.input("INSERT INTO eventsAttended (user_id, eventsAttended) VALUES"
				+ "((SELECT user_id FROM users WHERE userName = '"+ un +"'), '"+ eventID + "')");
				
		
		return rs;

	}

	//Adds a fully specified user into the users database from a corresponding user POJO
	public String add(UserPOJO userpojo) 
	{
		try
		{
		 String query = "INSERT INTO users ( userName, password, phone, email, sex, homelocation)"
			        + " values (?, ?, ?, ?, ?, ?)";

			      // create the mysql insert preparedstatement
		 		java.sql.PreparedStatement preparedStmt = users.getCon().prepareStatement(query);
			      preparedStmt.setString (1, userpojo.getUsername() );
			      preparedStmt.setString (2, userpojo.getPassword());
			      preparedStmt.setString (3, userpojo.getPhone());
			      preparedStmt.setString (4, userpojo.getEmail());
			      preparedStmt.setString (5, userpojo.getSex());
			      preparedStmt.setString (6, userpojo.getHomelocation());
			   
		
			      
			      preparedStmt.execute();
			      return "true";
			      
		}
		catch(Exception e)
		{
			return e.toString();
		}
		
	}

	//Uses a user POJO and specified username to update an entry in the users database
	public String edit(UserPOJO user, String un) 
	{
		try
		{
		 String query = "UPDATE users SET  phone = ?, email = ?, sex = ?, "
		 		+ "homelocation = ? where userName = '" + un + "'";

			      // create the mysql insert preparedstatement
		 		java.sql.PreparedStatement preparedStmt = users.getCon().prepareStatement(query);
			      preparedStmt.setString (1, user.getPhone());
			      preparedStmt.setString (2, user.getEmail());
			      preparedStmt.setString (3, user.getSex());
			      preparedStmt.setString (4, user.getHomelocation());
			  
		
			      
			      preparedStmt.execute();
			      
			      return "true";
			     
			      
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			return e.toString();
		}
		
	}
	
	

}
