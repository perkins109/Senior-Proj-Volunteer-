package backend;
import java.sql.*; 

public class DBConnector 
{
	//Declaes connection variable
	private static Connection con;
	public DBConnector(String dbName)
	{
		//Attempts to connect to Voluntold database on localhost
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			
			con=DriverManager.getConnection( 
			"jdbc:mysql://localhost:3306/" + dbName,"root","staples");  
			
			}
		//Error catch
		catch(Exception e)
		{ 
			System.out.println(e);
		}  
	}
	
	//Gets a ResultSet from the database, using a "select" String.
	public ResultSet results(String select) throws SQLException 
	{
		//Initializes ResultSet as null
		ResultSet rs = null;
		Statement stmt=con.createStatement();
		//Attempts to set ResultSet to the results of the specified query
		try {
			rs=stmt.executeQuery(select);
		//Error catch
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	//Checks to see if an input will update the database
	public Boolean input(String select) throws SQLException 
	{
		ResultSet rs = null;
		Statement stmt=con.createStatement();
		
		//If an update happens, return true
		try {
			if(!(stmt.executeUpdate(select) == 0))
				return true;
		//Error catch
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Else, return false
		return false;
		
	}
	
	//Closes the connection
	public static void close() throws SQLException 
	{
		con.close();
	}
	
	//Returns the connection
	public Connection getCon()
	{
		return con;
	}
	
}
