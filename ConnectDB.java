import java.sql.*;
import java.util.*;

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
	
	public ArrayList<ArrayList<String>> getData(String sqlString) {
      Statement stmt = null;
      ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
      try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sqlString);
        ResultSetMetaData rsmd = rs.getMetaData();
        while (rs.next()) {
            ArrayList<String> tempArray = new ArrayList<String>();
            tempArray.add(String.valueOf(rs.getInt("EquipID")));
            tempArray.add(rs.getString("EquipmentName"));
            tempArray.add(rs.getString("EquipmentDescription"));
            tempArray.add(String.valueOf(rs.getInt("EquipmentCapacity")));
            data.add(tempArray);
        }
        return data;
      } catch (SQLException sqle) {
         sqle.printStackTrace();
      }
      return data;
   }//end of getData;

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