import java.sql.SQLException;
import java.util.*;

public class faculty{
   //all the private fields that map to faculty table columns
	// database field id (INT)
   private int id;
   // database field fname VARCHAR(45)
   private String fname;
   // database field lname VARCHAR(45)
   private String lname;
   // database field password VARCHAR(45)
   private String password;
   // database field email VARCHAR(45)
   private String email;
   
   protected ConnectDB database;
   
   public faculty( String fname , ConnectDB database )
   {
	   this.database = database;
	   this.fname = fname;
   }
   
   
   //getter for id -> you shouldn't be able to set the id as it is a primary key
   public int getId(){
      return this.id;
   }
   
   //getters and setters for fname
   public String getFname(){
      return this.fname;
   }
   
   public void setFname(String temp){
      this.fname = temp;
   }
   
   //getters and setters for lname
   public String getLname(){
      return this.lname;
   }
   
   public void setLname(String temp){
      this.lname = temp;
   }
   
   //getters and setters for password
   public String getPassword(){
      return this.password;
   }
   
   public void setPassword(String temp){
      this.password = temp;
   }
   
   //getters and setters for email
   public String getEmail(){
      return this.email;
   }
   
   public void setEmail(String temp){
      this.email = temp;
   }
   
   public boolean login(String email)
   {
	   try{
         String sqlString = "SELECT password FROM faculty WHERE email =" +email;
         ArrayList<ArrayList<String>> sqlData = database.getData(sqlString);
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
   
}