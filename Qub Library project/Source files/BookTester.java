package part2;

public class BookTester {

	public static void main(String[] args) {
		//Initialises some book instances
		Book book1 = new Book("The Fellowship of the ring", "1234567899", "JRR Tolkien", BookType.FICTION , 1,  "Rings and all that", 15.78 );
		System.out.println(book1);
		Book book2 = new Book("Short", "9876543210", "J.K.", BookType.NON_FICTION, 2, "A very short book", -5.00);
	    Book book3 = new Book("A Really Long Book Title That Is More Than Forty Characters", "1112223334", "Author Name",BookType.REFERENCE, 0, "", 10.99);
	    Book book4 = new Book("r", "abc1234567", "", BookType.FICTION, 5, "A summary that is way too long and exceeds the character limit imposed by the class", 15.75);

	    //Prints the book instances
	    System.out.println(book2);
	    System.out.println(book3);
	    System.out.println(book4);

	}

}
