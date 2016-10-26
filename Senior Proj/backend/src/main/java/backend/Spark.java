package backend;
import static spark.Spark.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.Gson;

import spark.Route;




public class Spark 
{
	private static DBConnector users = new DBConnector("USERS");
	private JsonUtil json = new JsonUtil();
	 
	public static void main(String[] args) throws SQLException, Exception 
	{
	
		DBConnector users = new DBConnector("USERS");
		JsonUtil json = new JsonUtil();
		Gson gson = new Gson();

		get("/user/:userName/:password",  (request, response) -> {
			return gson.toJson(userValidate(request.params(":userName"), request.params(":password")));
			
		});  
		
		get("/makeuser/:userName/:password",  (request, response) -> {
			return gson.toJson(addUser(request.params(":userName"), request.params(":password")));
			
		});  
        
	}
	
	private static boolean userValidate(String un, String pw) throws SQLException
	{
		ResultSet rs = users.results("SELECT * FROM users WHERE userName = '"+ pw +"' AND password = '"+pw+"'");
		
		if(rs.next())
			return true;
		return false;

	}
	
	private static Boolean addUser(String un, String pw) throws SQLException
	{
		Boolean rs = users.input("INSERT INTO users (userName, password) VALUES( '"+un+"', '"+ pw +"' )");
		
		
		return rs;

	}

	
		
	
}
