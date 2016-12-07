
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
	
	public BusinessLayer( int id , ConnectDB database)
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
	
	public void statements( String query)
	{
		database.setData(query);
	}
	
}
