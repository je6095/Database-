import java.sql.SQLException;
import java.util.ArrayList;


public class BusinessLayer 
{
	//Faculty
	private int id;
	private String fname;
	private String lname;
	private String password;
	private String email;
	
	//Papers
	private String title;
	private String ab;
	private String citation;

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
		this.email = email;
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
	
	//Accessory
		public int getID()
		{
			return id;
		}
		
		public String getFname()
		{
			return fname;
		}
		
		public String getLname()
		{
			return lname;
		}
		
		public String getPassword()
		{
			return password;
		}
		
		public String getEmail()
		{
			return email;
		}
		
		public String getTitle()
		{
			return title;
		}
		
		public String getAb()
		{
			return ab;
		}
		
		public String getCitation()
		{
			return citation;
		}
		
		//Mutators
		public void setID(int id)
		{
			this.id = id;
		}
		
		public void setFname(String fname)
		{
			this.fname = fname;
		}
		
		public void setLname(String lname)
		{
			this.lname = lname;
		}
		
		public void setEmail(String email)
		{
			this.email = email;
		}
		public void setPass(String password)
		{
			this.password = password;
		}
	
	
	public ArrayList<ArrayList<String>> fetchFaculty() throws SQLException
	{
		String query = "SELECT * FROM faculty WHERE email = '" + email + "'";
		ArrayList<String> set = new ArrayList<String>();
		//set.add(Integer.toString(getID()));
		ArrayList<ArrayList<String>> rslt = database.getFacultyData(query);
		
		for(int i = 0; i < rslt.size() ; i++)
		{
			for(int x = 0 ; x < rslt.get(i).size(); x++)
			{
				System.out.println(rslt.get(i).get(x));
				
				switch(x)
				{
				case 0: setID(Integer.parseInt(rslt.get(i).get(x)));
				case 1: setFname(rslt.get(i).get(x));
				case 2: setLname(rslt.get(i).get(x));
				case 3: setEmail(rslt.get(i).get(x));
				case 4: setPass(rslt.get(i).get(x));
				}
			}	
		}
		return rslt;
	}
	
	public ArrayList<ArrayList<String>> fetchPapers()
	{
		String query = "SELECT * FROM faculty WHERE email = '" + email + "'";
		ArrayList<String> set = new ArrayList<String>();
		//set.add(Integer.toString(getID()));
		ArrayList<ArrayList<String>> rslt = database.getFacultyData(query);
		
		for(int i = 0; i < rslt.size() ; i++)
		{
			for(int x = 0 ; x < rslt.get(i).size(); x++)
			{
				System.out.println(rslt.get(i).get(x));
				
				switch(x)
				{
				case 0: setID(Integer.parseInt(rslt.get(i).get(x)));
				case 1: setFname(rslt.get(i).get(x));
				case 2: setLname(rslt.get(i).get(x));
				case 3: setEmail(rslt.get(i).get(x));
				case 4: setPass(rslt.get(i).get(x));
				}
			}	
		}
		return rslt;
		
	}
	
	public void insert( int id , String title, String ab, String citation ) throws SQLException
	{
		String query = "INSERT INTO papers (" + id + ",'" + title + "','" + ab + "'," + citation + ")" + " VALUES " + "(?,?,?,?)";
		ArrayList<String> set = new ArrayList<String>();
		set.add(Integer.toString(id));
		set.add(title);
		set.add(ab);
		set.add(citation);
		database.setData(query, set);
	}
	
	public void Update( int id , String title, String ab, String citation ) throws SQLException
	{
		String query = "UPDATE papers SET title = ?" + ",abstract = ?" + " ,citation = ?" + " WHERE id = ?;";
		ArrayList<String> set = new ArrayList<String>();
		set.add(Integer.toString(id));
		set.add(title);
		set.add(ab);
		set.add(citation);
		database.setData( query, set);
	}
	
	public void delete(int id) throws SQLException
	{
		String query = "DELETE FROM papers WHERE id = ?;";
		ArrayList<String> set = new ArrayList<String>();
		set.add(Integer.toString(id));
		database.setData(query, set);
	}
	
	
	public boolean login(String email, String password)
	{
		boolean credible = false;
		if(getEmail().equals(email) && getPassword().equals(password))
		{
			credible = true;
		}
		else
		{
			credible = false;
		}
		return credible;
	}
	
}
