package part2;

public class Book {
	//Initialise all the book attributes
	private String title; 
	private String author;
	private String isbn;
	private BookType type;
	private int edition;
	private String summary;
	private double price;
	
	//Constructor for Book
	public Book(String title, String author, String isbn, BookType type, int edition, String summary, double price) {
		setTitle(title);
		setIsbn(isbn);
		setAuthor(author);
		setedition(edition);
		setSummary(summary);
		setPrice(price);
		setType(type);
		
	}
	//Sets the book type
	public void setType(BookType type) {
		if (type == null) {
			this.type = null;
		}else {
			this.type = type;
		}
	
	}
	//Getter to return book type
	public BookType getType() {
		return type;
	}
	//Sets the title
	public void setTitle(String title) {
		if(title.length() >= 5 && title.length() <= 40) {
		this.title = title;}
		else {
			this.title = "No title";
		}
			
	}
	//Getter to return title
	public String getTitle() {
		return title;
	}
	//Sets ISBN
	public void setIsbn(String isbn) {
		if(isbn.length() == 10) {
		    boolean valid = true;

		    for (char ch : isbn.toCharArray()) {
		        if (!Character.isDigit(ch)) { 
		            valid = false;
		            break; 
		        }
		    }

		    if (valid) {
		        this.isbn = isbn; 
		    } else {
		        this.isbn = "No ISBN"; 
		    }
		} else {
		    this.isbn = "No ISBN"; 
		}

	}
		
	//Getter to return ISBN
	public String getIsbn() {
		return isbn;
	}
	//Sets the author
	public void setAuthor(String author) {
		if(author.length()>=5 && author.length()<= 40) {
		this.author = author;}
		else {
		this.author = "No Author";}
		
	}
	//Getter to return author
	public String getAuthor() {
		return author;
	}
	//Sets the edition
	public void setedition(int edition) {
		this.edition = (edition > 0)? edition:1;
		
	}
	//Getter to return edition
	public int getedition() {
		return edition;
	}
	//Sets the summary
	public void setSummary(String summary) {
		if(summary.length()>19 && summary.length()<151) {
		this.summary = summary;}
		else {
		this.summary = "No Summary";}
		
	}
	//Getter to return summary
	public String getSummary() {
		return summary;
	}
	//Sets the price
	public void setPrice(double price) {
		this.price = (price>0.0)? price:0.0;
		
	}
	//Getter to return price
	public double getPrice() {
		return price;
	}
	//Returns a string of book details
	public String getDetails() {
		String details = "Title: "+getTitle()+ "  Author: "+getAuthor()+ "  Isbn: "+getIsbn()+"  Type: "+getType()+  "  Edition: "+getedition()+"  Summary: "+getSummary()+"  Price: "+getPrice();
		return details;
	}
	//Returns a string of book details
	public String toString() {
		return getDetails();}
	}


