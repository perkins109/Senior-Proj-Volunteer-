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

	public static boolean userValidate(String un, String pw) throws SQLException
	{
		ResultSet rs = users.results("SELECT * FROM users WHERE userName = '"+ un +"' AND password = '"+pw+"'");
		
		if(rs.next())
			return true;
		return false;

	}
	
	public static Boolean addUser(String un, String pw, String em, String loc, String ph, String sex) throws SQLException
	{
		Boolean rs = users.input("INSERT INTO users (userName, password, email, homeLocation, phone, sex) VALUES"
				+ "( '"+un+"', '"+ pw +"', '" + em + "', '"+ loc + "', '" + ph + "', '" + sex + "' )");
		
		
		return rs;

	}
	
	public static ResultSet getUser(String un) throws SQLException
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

}
