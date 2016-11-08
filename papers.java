
public class papers {
	//all the private fields that map to papers table columns
	// database field id (INT)
	private int id;
	// database field title VARCHAR(45)
	private String title;
	//database field abstract TEXT
	private String text;
	//database field citation VARCHAR(45)
	private String citation;
	
	//getter and setter for id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//getter and setter for title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	//getter and setter for text
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	//getter and setter for citation
	public String getCitation() {
		return citation;
	}
	public void setCitation(String citation) {
		this.citation = citation;
	}
}
