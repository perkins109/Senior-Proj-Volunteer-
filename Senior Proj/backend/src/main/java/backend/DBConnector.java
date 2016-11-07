package backend;
import java.sql.*; 

public class DBConnector 
{
	private static Connection con;
	public DBConnector(String dbName)
	{
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			
			con=DriverManager.getConnection( 
			"jdbc:mysql://localhost:3306/" + dbName,"root","staples");  
			
			}
		catch(Exception e)
		{ 
			System.out.println(e);
		}  
	}
	
	
	public ResultSet results(String select) throws SQLException 
	{
		ResultSet rs = null;
		Statement stmt=con.createStatement();
		try {
			rs=stmt.executeQuery(select);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public Boolean input(String select) throws SQLException 
	{
		ResultSet rs = null;
		Statement stmt=con.createStatement();
		
		
		try {
			if(!(stmt.executeUpdate(select) == 0))
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public static void close() throws SQLException 
	{
		con.close();
	}
	
	public Connection getCon()
	{
		return con;
	}
	
}
