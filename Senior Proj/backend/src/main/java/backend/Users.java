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
		ResultSet retVal = users.results("SELECT * FROM events, eventsCreated WHERE eeventsCreated.user_id = '"+ id +"' AND eventsCreated.eventsCreated = events.id");
		System.out.println("nick");

		
		return retVal;

	}
	
	public Boolean attend(String eventID, String un) throws SQLException 
	{
		
		Boolean rs = users.input("INSERT INTO eventsAttended (user_id, eventsAttended) VALUES"
				+ "((SELECT user_id FROM users WHERE userName = '"+ un +"'), '"+ eventID + "')");
				
		
		return rs;

	}

}
