public class authorship{
   //all the private fields that map to authorship table columns
	// database field facultyId (INT)
   private int facultyId;
   // database field paperId (INT)
   private int paperId;

   //getter for facultyId and paperId -> you shouldn't be able to set the ids as it is a primary key
   public int getFacultyId(){
      return this.facultyId;
   }
   
   public int getPaperId(){
      return this.paperId;
   }
}