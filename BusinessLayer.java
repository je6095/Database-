import java.sql.*;
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
	
	//Constructor for Login
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
	
	//Constructor for Update
		public BusinessLayer( int id, ConnectDB database )
		{
			this.id = id;
			this.database = database;
		}
		
	//Constructor for Insert
	public BusinessLayer( ConnectDB database )
	{
		this.database = database;
		id = 0;
		title = "";
		ab = "";
		citation = "";
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
	
	/**
	 To INSERT the gui will make a new BusinessLayer object and call the constructor used for Insert *SEE ABOVE*
	 from there the gui should prompt the user to enter in values into text fields for title, abstract, and citation
	 the gui will call the insert() method with the entered in values as parameters
	 INSERT uses a prepared statement and an arraylist filled with the parameter values. 
	 INSERT then calls setData which should execute the query and a New entry will be created.  
	**/
	public void insert( int id , String title, String ab, String citation, int facId ) throws SQLException
	{
		String query = "INSERT INTO papers VALUES (?,?,?,?)";
		ArrayList<String> set = new ArrayList<String>();
		set.add(Integer.toString(id));
		set.add(title);
		set.add(ab);
		set.add(citation);
		database.setData(query, set);
      /**
      query = "INSERT INTO authorship VALUES(?,?)";
      ArrayList<String> set_author = new ArrayList<String>();
      set_author.add(Integer.toString(facId));
      set_author.add(Integer.toString(id));
      database.setData( query, set);
      */
	}
	
	/**
	 To UPDATE the gui will make a new BusinessLayer object and call the constructor used for Insert *SEE ABOVE*
	 the gui should then call the fetchPapers() method to get the info for the row that is to be updated
	 from there the gui should prompt the user to enter in values into text fields for title, abstract, and citation that are to be updated
	 the gui will call the update() method with the entered in values as parameters
	 UPDATE uses a prepared statement and an arraylist filled with the parameter values. 
	 UPDATE then calls setData which should execute the query and a New entry will be created.  
	**/
	public void update( int id , String title, String ab, String citation) throws SQLException
	{
		String query = "UPDATE papers SET title = ?" + ",abstract = ?" + " ,citation = ?" + " WHERE id = ?;";
      //System.out.println(query);
		ArrayList<String> set = new ArrayList<String>();
		set.add(title);
		set.add(ab);
		set.add(citation);
      set.add(Integer.toString(id));
      //System.out.println(set.toString());
		database.setData( query, set);
  	}
	
	/**
	 To DELETE the gui will prompt the user to select which paper to delete
	 the gui will get that papers id and call the DELETE method with the id as a parameter
	 DELETE uses a prepared statement and an arraylist filled with the parameter values. 
	 DELETE then calls setData which should execute the query and the entry will be deleted.  
	**/
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
   
   public Object[] keywordSearch(String keyword){
      //System.out.println("in keywordSearch - keyword = " +keyword);
      Object[] paperInfo = null;
      try {
        ArrayList<String> keys = new ArrayList<String>();
        keys.add(keyword);
        String sql = "SELECT papers.title, papers.abstract, papers.citation FROM papers, paper_keywords WHERE papers.id = paper_keywords.id AND paper_keywords.keyword = ?";
        
        PreparedStatement stmt = database.prepare(sql,keys);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            String title = rs.getString(1);
            String abstracts = rs.getString(2);
            String citation = rs.getString(3);
            
            //((DefaultTableModel) resultsTable.getModel()).addRow(new Object[]{title,abstracts,citation});
            paperInfo = new Object[]{title,abstracts,citation};
        }
       } catch (Exception ex) {
           ex.printStackTrace(System.out);
       }
       return paperInfo;
   }
   
   public ArrayList<Object[]> getAllPapers(){
      ArrayList<Object[]> papers = new ArrayList<Object[]>();
      
      try {
         
        String sql = "SELECT papers.title, papers.abstract, papers.citation FROM papers";
        
        PreparedStatement stmt = database.prepare(sql,new ArrayList<String>());
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            String title = rs.getString(1);
            String abstracts = rs.getString(2);
            String citation = rs.getString(3);

            Object[] temp = new Object[]{title,abstracts,citation};
            papers.add(temp);
        }
       } catch (Exception ex) {
           ex.printStackTrace(System.out);
       }
      
      return papers;
   }
   
   public ArrayList<Object[]> getFacultyPapers(int id){ //these papers are specific to each faculty
      ArrayList<Object[]> papers = new ArrayList<Object[]>();
      
      try {
         System.out.println();
        String sql = "SELECT papers.title, papers.abstract, papers.citation, papers.id FROM papers INNER JOIN authorship ON papers.id = authorship.paperId INNER JOIN faculty ON authorship.facultyId = faculty.id WHERE faculty.id="+id;
        
        PreparedStatement stmt = database.prepare(sql,new ArrayList<String>());
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            String title = rs.getString(1);
            String abstracts = rs.getString(2);
            String citation = rs.getString(3);
            int papers_id = rs.getInt(4);

            Object[] temp = new Object[]{title,abstracts,citation,papers_id};
            papers.add(temp);
        }
       } catch (Exception ex) {
           ex.printStackTrace(System.out);
       }
      
      return papers;
   }
	
}
