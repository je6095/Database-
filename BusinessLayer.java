
public class BusinessLayer 
{
	private int id;
	private String fname;
	private String lname;
	private String password;
	private String email;
	private Connect database;
	
	public BusinessLayer()
	{
		database = new Connect();
		id = 0;
		fname = "";
		lname = "";
		password = "";
		email = "";
	}
	
	public BusinessLayer( int id , Connect database)
	{
		this.id = id;
		this.database = database;
		
	}
	
	public BusinessLayer(int id, String fname, String lname, String password, String email, Connect database )
	{
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.email = email;
		this.database = database;
		
	}
}
