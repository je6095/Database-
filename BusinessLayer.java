import java.sql.SQLException;
import java.util.ArrayList;


public class BusinessLayer 
{
	private int id;
	private String fname;
	private String lname;
	private String password;
	private String email;
	private ConnectDB database;
	
	public BusinessLayer()
	{
		database = new ConnectDB();
		id = 0;
		fname = "";
		lname = "";
		password = "";
		email = "";
	}
	
	public BusinessLayer( String email , ConnectDB database)
	{
		this.id = id;
		this.database = database;
		
	}
	
	public BusinessLayer(int id, String fname, String lname, String password, String email, ConnectDB database )
	{
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.email = email;
		this.database = database;
	}
	
	public boolean login(String email)
	   {
		   try{
	         String sqlString = "SELECT password FROM faculty WHERE email =" +email;
	         ArrayList<ArrayList<String>> sqlData = database.getFacultyData(sqlString);
	         for(ArrayList<String> row : sqlData){
	            for (String info : row){
	               if(this.password = info){
	                  return true;
	               }else{
	                  return false;
	               }
	            }
	         }
	      }catch(SQLException e){
	         e.printStackTrace();
	      }
	   }
	
	public void statements( String query)
	{
		database.setData(query);
	}
	
}