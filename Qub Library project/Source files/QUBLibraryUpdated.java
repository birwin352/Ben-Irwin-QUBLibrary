package part2;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import console.Console;

public class QUBLibraryUpdated {
	
	 //Creates a Library instance
	 static Library qubLibrary = new Library();
		
	 //Array of menu options
	 static final String options[] = {"List all books", "List Books by Status", "Add a book",
			 "Remove a Book", "Borrow a book", "Return a book", "Display ranked List", "Exit"};
	
	 //Max number of books
	 static final int MAX = 10;
	 
	 static final int QUIT = options.length;
		
	 //Title of the menu
	 static String title = "Library Menu";
	 
	 //Creates the different console instances
	 private static Console conMenu;
	 private static Console conDetails;
	 private static Console conTitle;
	 

	 //Method to initialise some default books
	 private static Library initialise() {
		 
		 //Creates some default books
		 LibraryBook book1 = new LibraryBook("The Fellowship of the ring", "JRR Tolkien", "2234567832", BookType.FICTION , 1,  "Rings and all that", 15.78, "lotr.jpg" );
		 LibraryBook book2 = new LibraryBook("The Lion the Witch and the Wardrobe", "CS Lewis", "1234567891", BookType.FICTION, 2, "Siblings go into a magical wardrobe", 6.99, "lion witch.jpg");
		 LibraryBook book3 = new LibraryBook("To Kill a Mockingbird", "Harper Lee", "1234567892", BookType.FICTION, 3, "A story of racial injustice and childhood innocence", 8.99, "to kill bird.jpg");
		 LibraryBook book4 = new LibraryBook("19884", "George Orwell", "1234567893", BookType.FICTION, 4, "A dystopian novel about totalitarianism and surveillance", 7.99, "1984.jpg");
		 LibraryBook book5 = new LibraryBook("A Brief History of Time", "Stephen Hawking", "1234567894", BookType.NON_FICTION, 5, "An exploration of cosmology and black holes", 10.99, "a brief history.jpg");
		 
		 //Adds the books to the library
		 qubLibrary.add(book1);
		 qubLibrary.add(book2);
		 qubLibrary.add(book3);
		 qubLibrary.add(book4);
		 qubLibrary.add(book5);
		 
		 return qubLibrary;
	 }
	 //Method to initialise the console windows
	 private static void startConsoles(){
		 

		//Initialises the title console
		conTitle = new Console(true);
		conTitle.setSize(500, 120);
		conTitle.setLocation(100,100);
		conTitle.setVisible(true);
		conTitle.setBgColour(Color.BLACK);
		conTitle.setColour(Color.GREEN);
		conTitle.setFont(new Font ("Consolas", Font.BOLD, 50) );
		conTitle.setTitle("QUB Library");
		
		//Initialises the menu console
		conMenu = new Console(true);
		conMenu.setSize(500, 400);
		conMenu.setLocation(100, 200);
		conMenu.setVisible(true);
		conMenu.setBgColour(Color.BLACK);
		conMenu.setColour(Color.GREEN);
		conMenu.setFont(new Font ("Consolas", Font.BOLD, 20) );
		conMenu.setTitle("");
		
		//Initialises the details console
		conDetails = new Console(true);
		conDetails.setSize(500, 500);
		conDetails.setLocation(600, 100);
		conDetails.setVisible(true);
		conDetails.setBgColour(Color.BLACK);
		conDetails.setColour(Color.WHITE);
		conDetails.setFont(new Font("Consolas", Font.ITALIC, 20) );
		conDetails.setTitle("QUB Library");
	 }
	 
	 //Main method
	 public static void main(String[] args) {
		 
		//Calls the startConsoles method
		startConsoles();
		//Calls the initialise method
		initialise();
		
		//Creates a menu 
	    Menu myMenu = new Menu(title, options, conMenu);
	    
	    //Displays the title in the title console
	    conTitle.println("Qub Library");
		
	    
	    
		int choice;
		do {
			try {
			//Gets the user choice
			choice = myMenu.getUserChoice();
			if(choice != QUIT) {
				processChoice(choice);
			}
			}catch (NumberFormatException e) {
				//Handles invalid inputs
				conDetails.println("PLease enter a number" );
				choice = -1;
			}
		}
		while (choice != QUIT); // Continues until user wants to quit
		
		//Displays goodbye message
		conMenu.println("Goodbye");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		//Closes consoles
		conMenu.setVisible(false);
		conDetails.setVisible(false);
		
	 }
		
	 

	 
	 	
	 	//Method to process user input
		private static void processChoice(int choice) {
		conMenu.println("Processing choice: " + choice + "\nPlease go to other window") ;
		
		 //Switch statement handles the menu options
		 switch(choice) {
		 
		 case 1:
			 listAllBooks();
			 break;
		 case 2:
			 listBooksByStatus();
			 break;
		 case 3:
			 addBook();
			 break;
		 case 4:
			 removeBook();
			 break;
		 case 5:
			 borrowBook();
			 break;
		 case 6:
			 returnBook();
			 break;
		 case 7:
			 displayRankedList();
			 break;
		 case 8:
			 System.exit(0);
			 break;
		
		 default:
			 //Handles invalid choices
			 conMenu.print("Please enter a valid choice.");
		 }

		 
		 conMenu.println();

	}

	//Method to list all books
	private static void listAllBooks() {
		conDetails.clear();
		conDetails.println("List all Books");
		//Gets books from the library
		LibraryBook[] titles = qubLibrary.list();
		for(int i = 0; i < titles.length; i++) {
			LibraryBook book = titles[i];
			if(book == null) {
				continue; //skips null entries
			}
			//Displays book details
			conDetails.println(titles[i]+ "\n");

			//Displays the books image
			if (book.getImage() != null) {
			ImageIcon img = new ImageIcon("Images\\" +book.getImage());
			conDetails.println(img);
			}
		}
		//Waits for user to hit enter before returning to the menu
		conDetails.println("\nHit enter to return to the menu. ");
	    conDetails.readLn();

			
		}
		
		
	 //Method to list all books of the provided status
	 private static void listBooksByStatus() {
		 conDetails.clear();
		 conDetails.println("List books by status");
		 conDetails.print("Enter the status of the books you want to view (available, on_loan or withdrawn) : ");
		 String constatus = conDetails.readLn();
		 //Converts input to uppercase and then to BookStaus enum
		 String strstatus = constatus.toUpperCase();
	 try {
		 BookStatus status = BookStatus.valueOf(strstatus);
		//Gets books from the library
		 LibraryBook[] titles = qubLibrary.list(status);
	 if(titles.length == 0) {
		 conDetails.println("No books found with this status");
	 }else {
		for(int i = 0; i < titles.length; i++) {
			LibraryBook book = titles[i];
			if(book == null) {
				continue; //skips null entries
			}
			//Displays book details
			conDetails.println(titles[i]+ "\n");

			//Displays the books image	
			if (book.getImage() != null) {
			ImageIcon img = new ImageIcon("Images\\" +book.getImage());
			conDetails.println(img);
			}
		 
		}
	 }
	 //Handles invalid status
	 }catch(IllegalArgumentException e) {
		 conDetails.println("Invalid status entered.");
	 }
	 //Waits for user to hit enter before returning to the menu
	 conDetails.println("\nHit enter to return to the menu. ");
	 conDetails.readLn();
			
	
		 
	 }
	 //Method to add new book to the library
	 private static void addBook() {
		 conDetails.clear();
		 conDetails.println("Add new Book.");
		 String title;
		 String author;
		 
		 //Validate and get the book title
		 do {
		 conDetails.println("Enter the title (must be between 5 and 40 characters) : ");
		 title = conDetails.readLn();
		 
		 if(title.length() < 5 || title.length() > 40) {
			 conDetails.println("Inavlid title go again");
			 title = "No title";
		 }
		 }while(title.equals("No title"));
		 
		 do {
		 conDetails.println("Enter the author (must be between 5 and 40 characters) : ");
		 author = conDetails.readLn();
		 
		 //Validate and get the book author
		 if(author.length() < 5 || author.length() > 40) {
			 conDetails.println("Inavlid author go again");
			 author = "No author";
		 }
		 }while(author.equals("No author"));
		 
		//Validate and get the book Isbn
		 String isbn = "";
		 boolean validIsbn = false;
		 
		 while(validIsbn == false) {
		
		 
		 conDetails.println("Enter the isbn (must be a 10 digit number) : ");
		 isbn = conDetails.readLn();
		 if(isbn.length() == 10 ) {
			 validIsbn = true;
			 
			 for(char ch: isbn.toCharArray()) {
				 if(!Character.isDigit(ch)) {
					 conDetails.println("Only enter digits");
					 validIsbn = false;
					 break;
				 }
			 }
		 }else {
			 conDetails.println("Isbn must be 10 digits long");
		 }
		 
		 }
		 //Validate and get the book type
		 BookType bookType = null;
	     boolean validType = false;
	     while (!validType) {
	        conDetails.println("Enter the type (FICTION, NON_FICTION, REFERENCE): ");
		    String typeInput = conDetails.readLn().toUpperCase().trim();
		        
		        
		    try {
		        bookType = BookType.valueOf(typeInput);  
		        validType = true; 
		    } catch (IllegalArgumentException e) {
		        conDetails.println("Invalid type entered. Please enter a valid type.");
		    }
		 }
		 
	     //Validate and get the book edition
	     int edition = -1;
	     while(edition < 0 ) {
		 
		 conDetails.println("Enter the edition: ");
		 String strEdition = conDetails.readLn();
		 try {
			 edition = Integer.parseInt(strEdition);
			 if (edition < 0 ) {
				 conDetails.println("Invalid input, please enter a positive number.");
			 }
		 }catch(NumberFormatException e) {
			 conDetails.println("Invalid input, please enter a positive number");
		 }
	     }
	     //Validate and get the book summary
	     String summary = "";
	     while(summary.isEmpty() || summary.length() < 20 || summary.length() > 150) {
		 conDetails.println("Enter the summary (must be between 20 and 150 characters) : ");
		 summary = conDetails.readLn();
		 if(summary.isEmpty() || summary.length() < 20 || summary.length() > 150) {
			 conDetails.println("Please enter a valid summary");
		 }
	     }
	     
	     //Validate and get the book price
	     double price = -1;
	     while(price < 0 ) {
		 
		 conDetails.println("Enter the price: ");
		 String strPrice = conDetails.readLn();
		 try {
			 price = Double.parseDouble(strPrice);
			 if (price < 0 ) {
				 conDetails.println("Invalid input, please enter a positive number.");
			 }
		 }catch(NumberFormatException e) {
			 conDetails.println("Invalid input, please enter a positive number");
		 }
	     }
		 
	     //Get the books cover image
		 conDetails.println("Enter the cover image: "); //obviously only works for book.jpg
		 String image = conDetails.readLn();
		 
		

		 //Creates a new book with the given details
		 LibraryBook newbook = new LibraryBook(title, author, isbn, bookType, edition, summary, price, image);
		 
		 //Adds this book to the library
		 qubLibrary.add(newbook);
		 
		 //Waits for user to hit enter before returning to the menu
		 conDetails.println("\nHit enter to return to the menu. ");
		 conDetails.readLn();
		 
		 
	 }
	 //Method to remove a book
	 private static void removeBook() {
		 conDetails.clear();
		 conDetails.println("Remove Book");
		 conDetails.println("Enter the id of the book you wish to remove: ");
		 String strId = conDetails.readLn();
		 //Converts input to integer
		 int id = Integer.parseInt(strId);
		 //Removes the book
		 boolean result = qubLibrary.remove(id);
		 if (result) {
			 conDetails.println("Book with id: " +id+ " removed");
		 }
		 else {
			 conDetails.println("Book with id: " +id+ " does not exist");
		 }
		 //Waits for the user to hit enter before returning to the menu
		 conDetails.println("\nHit enter to return to the menu. ");
		 conDetails.readLn();
	
		 
	 }
	 //Method to borrow a book
	 private static void borrowBook() {
		 conDetails.clear();
		 conDetails.println("Borrow Book");
		 conDetails.println("Enter the id of the book you wish to borrow: ");
		 try { 
		 String strId = conDetails.readLn();
		 //Converts input to an integer
		 int id = Integer.parseInt(strId);
		 //Borrows the book
		 boolean result = qubLibrary.borrowBook(id);
		 if (result) {
			 conDetails.println("Book with id: " +id+ " borrowed");
		 }
		 else {
			 conDetails.println("Book with id: " +id+ " does not exist or is on loan");
		 }
		 //Handles invalid id's
		 }catch (NumberFormatException e) {
			 conDetails.println("Invalid input. Please enter a number");
		 }
		 //Waits for the user to hit enter before returning to the menu
		 conDetails.println("\nHit enter to return to the menu. ");
		 conDetails.readLn();
	 }
	 //Method to return a book
	 private static void returnBook() {
		 conDetails.clear();
		 conDetails.println("Return Book");
		 conDetails.println("Enter the id of the book you wish to return: ");
		 try {
		 String strId = conDetails.readLn();
		 //Converts input to an integer
		 int id = Integer.parseInt(strId);
		 //Returns the book
		 boolean result = qubLibrary.returnBook(id);
		 if (result) {
			 conDetails.println("Book with id: " +id+ " returned");
		 }
		 else {
			 conDetails.println("Book with id: " +id+ " does not exist or isn't out on loan");
		 }
		 //Handles invalid id's
		 }catch (NumberFormatException e) {
			 conDetails.println("Invalid input. Please enter a number");
		 }
		 //Waits for the user to hit enter before returning to the menu
		 conDetails.println("\nHit enter to return to the menu. ");
		 conDetails.readLn();
	 }
	 //Method to display the books ranked by popularity
	 private static void displayRankedList() {
		 conDetails.clear();
		 conDetails.println("Display ranked list");
		 //Gets the ranked list of books
		 LibraryBook[] rankedBooks = qubLibrary.mostPopular();
		 //Displays the books in order of most loaned out
		 for(int i = 0; i < rankedBooks.length; i++) {
			 conDetails.println((i+1) + "." + rankedBooks[i].getTitle() + " by " +rankedBooks[i].getAuthor()
					 +" ---> Loans: "+ rankedBooks[i].getLoanCount());
		 }
		 //Waits for the user to hit enter before returning to the menu
		 conDetails.println("\nHit enter to return to the menu. ");
		 conDetails.readLn();
		 
		 
	 }

	
}

