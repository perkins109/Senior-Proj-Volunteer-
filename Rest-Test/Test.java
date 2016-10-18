package test.test;
import static spark.Spark.*;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Test 
{
	public static void main(String[] args) throws SQLException, Exception 
	{
	
		DBConnector test = new DBConnector();
		JsonUtil json = new JsonUtil();
		System.out.println(json.convertToJSON(test.results()));

		get("/hello", "application/json", (request, response) -> 
		   json.convertToJSON(test.results()));
		
        
        
        
	}
}
