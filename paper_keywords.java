
public class paper_keywords extends papers {
	//database fields for paper_keywords table
	
	/***
	 * paper_keywords is the child table of "papers" table. The paper id associated with papers table and paper_keywords table
	 * will be the same. Inheritance of the "id" field is being depicted here. When you make the object of paper_keyword class, you will
	 * be able to access all the fields of paper class. There is a parent-child relation between the tables. So, id of "papers" table and
	 *  id of "paper_keywords" table are linked to each other. You can easily create a paper_keywords object and can find out the details related to
	 *  the paper along with the keywords by linking the two classes with "id" field. 
	 */
	
	//database field keyword VARCHAR(45)
	private String keyword;
	//getter and setter for keyword VARCHAR(45)
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
