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

	public boolean userValidate(String un, String pw) throws SQLException
	{
		ResultSet rs = users.results("SELECT * FROM users WHERE userName = '"+ un +"' AND password = '"+pw+"'");
		
		if(rs.next())
			return true;
		return false;

	}
	
	public Boolean addUser(String un, String pw, String em, String loc, String ph, String sex) throws SQLException
	{
		Boolean rs = users.input("INSERT INTO users (userName, password, email, homeLocation, phone, sex) VALUES"
				+ "( '"+un+"', '"+ pw +"', '" + em + "', '"+ loc + "', '" + ph + "', '" + sex + "' )");
		
		
		return rs;

	}
	
	public ResultSet getUser(String un) throws SQLException
	{
		ResultSet rs = users.results("SELECT * FROM users WHERE userName = '"+ un +"'");
		
		
		return rs;

	}

	public Boolean changePw(String un, String currentPW, String newPW) throws SQLException 
	{
		
		Boolean rs = users.input("UPDATE users SET password = '"+newPW +"' WHERE userName = '" + un + "' AND "
				+ "password = '"+currentPW +"'");
		
		
		return rs;

	}
	
	public  ResultSet getEventsAtt(String un) throws SQLException
	{
		String id = null;
		ResultSet rs = users.results("SELECT * FROM users WHERE userName = '"+ un +"'");
		
		if(rs.next())
			id = rs.getString("user_id");
		ResultSet retVal = users.results("SELECT * FROM events, eventsAttended WHERE eventsAttended.user_id = '"+ id +"' AND eventsAttended.eventsAttended = events.id");
		System.out.println("nick");

		
		return retVal;

	}
	
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
	
	public Boolean attend(String eventID, String un) throws SQLException 
	{
		
		Boolean rs = users.input("INSERT INTO eventsAttended (user_id, eventsAttended) VALUES"
				+ "((SELECT user_id FROM users WHERE userName = '"+ un +"'), '"+ eventID + "')");
				
		
		return rs;

	}

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
