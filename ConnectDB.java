import java.sql.*;

public class ConnectDB 
{
	public Connection con;
	public Statement st;
	public ResultSet rs;
	
	String uri = "jdbc:mysql://localhost:3306/Research";
    String driver = "com.mysql.jdbc.Driver";
    String user = "root";
    String password = "";//student
	
//	  String uri = "jdbc:sqlserver://theodore.ist.rit.edu;databaseName=Jobs";
//    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    String user = "330User";
//    String password = "330Password";
	
	public ConnectDB()
	{}
	
	public boolean connect() throws SQLException, ClassNotFoundException
	{
		boolean isConnected = false;
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection( uri, user, password );
			if(con.isValid(0))
			{
				isConnected = true;
			}
		}
		catch(SQLException e)
		{
			isConnected = false;
			System.out.println(e.getMessage());
		}
		return isConnected;
	}
	
	public boolean close() throws SQLException
	{
		boolean isClosed = false;
		try
		{
	        con.close();
	        if(con.isClosed())
	        {
	       	 isClosed = true;
	        } 
	     }
	     catch(SQLException e)
	     {
	         isClosed = false;
	         System.out.println(e.getMessage());
	     }
		 return isClosed;
	}
	
	/**
	public void getLogin(String query) throws SQLException 
	{
		st = con.createStatement();
		try
		{
			rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int col = rsmd.getColumnCount();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	**/
	
	public boolean setData( String query )
	{
		boolean updated = false;
		try
		{
			Statement st = con.createStatement();
			st.executeUpdate(query);
			updated = true;
			System.out.println("Query Successful");
		}
		catch(SQLException e)
		{
			System.out.println("Error");
			updated = false;
		}
		return updated;
	}
	
}	