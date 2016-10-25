package backend;
import java.sql.*; 

public class DBConnector 
{
	static Connection con;
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
	public static void close() throws SQLException 
	{
		con.close();
	}
	
}
