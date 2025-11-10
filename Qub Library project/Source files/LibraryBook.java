package part2;

public class LibraryBook extends Book implements Lendable {
	//Initialises LibraryBook attributes
	private int id;
	private static int nextId = 1;
	private BookStatus status;
	private String image;
	private int loanCount;
	
	//Constructor for LibraryBook
	public LibraryBook(String title, String author, String isbn, BookType type, int edition, String summary, double price, String coverImage) {
		super(title, author, isbn, type, edition, summary, price);
		this.id  = nextId ++;
		this.status = BookStatus.AVAILABLE;
		this.image = coverImage;
		this.loanCount = 0;
		
		
	
	
	}
	
	//Method to check out a book
	public boolean checkout() {
		if(status == BookStatus.AVAILABLE) {
			status = BookStatus.ON_LOAN;
			//Increments loan count so books can be ranked
			loanCount++;
			return true;
		}
		return false;
		
	}
	//Getter to return book image
	public String getImage() {
		return image;
	}
	
	//Method to check in a book
	public boolean checkin() {
		//Book can only be checked in if already on loan
		if(status == BookStatus.ON_LOAN) {
			status = BookStatus.AVAILABLE;
			return true;
		}
		return false;
		
	}
	//Getter to return book status
	public BookStatus getStatus() {
		return status;
	}
	//Sets the book status
	public void setStatus(BookStatus status) {
		this.status = status;
	}
	//Getter to return book id
	public int getId() {
		return id;
	}
	//Getter to return book loan count
	public int getLoanCount() {
		return loanCount;
	}
	

	//Method to return LibraryBook details - uses the constructor from class book
	public String toString() {
		return super.getDetails() + ", ID: " + id + ", Status: "+ status + ", Loan Count: "+ loanCount + " Image Path: " + image; 
	}
	
	

}
