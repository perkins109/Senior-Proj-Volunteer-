package backend;
import java.sql.*; 

public class DBConnector 
{
	static Connection con;
	public DBConnector()
	{
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			
			con=DriverManager.getConnection( 
			"jdbc:mysql://localhost:3306/names","root","staples");  
			
			}
		catch(Exception e)
		{ 
			System.out.println(e);
		}  
	}
	
	
	public ResultSet results() throws SQLException 
	{
		ResultSet rs = null;
		Statement stmt=con.createStatement();
		try {
			rs=stmt.executeQuery("select * from names");
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
