package part2;

import java.util.ArrayList;

public class Library {
	//Initialises an array list called books
	private ArrayList<LibraryBook>books;
	
	//Constructor to initialise library
	public Library() {
		books = new ArrayList<>();
		
	}
	//Method to borrow a book based on its id
	public boolean borrowBook(int id) {
		//Iterates through books
		for (int i = 0; i < books.size(); i++) {
			//Check if book matches given id
			LibraryBook book = books.get(i);
			if(id == book.getId()) {
				//Checks out the book
				return book.checkout();
			}
				
			}
		//returns false if book can't be found
		return false;
	
		
	}
	//Method to return a book
	public boolean returnBook(int id) {
		//Iterates through books
		for (int i = 0; i < books.size(); i++) {
			//Check if book matches given id
			LibraryBook book = books.get(i);
			if(id == book.getId()) {
				//Checks in the book
				return book.checkin();
			
			}
			
		}
		//Returns false if book can't be found
		return false;

	}
	//Method to list all books
	public LibraryBook[] list() {
		//Creates array to store books
		LibraryBook[] result = new LibraryBook[books.size()];
		for(int i = 0; i<result.length; i++) {
			result[i] = books.get(i);
					
			
		}
		//Returns the array of books
		return result;
		
	}
	//Method to list books by their status
	public LibraryBook[] list(BookStatus status) {
		int count = 0;
		//Counts the number of books of the given status
		for(int i = 0; i < books.size(); i++) {
			LibraryBook book = books.get(i);
			if(status == book.getStatus()) {
				count++;
			}	
		}
		//Creates an array to store books of the specified status
		LibraryBook[] result = new LibraryBook[count];
		int index = 0;
		//Add the books with the specified status to the array
		for(int i = 0; i < books.size(); i++) {
			LibraryBook book = books.get(i);
			if(status == book.getStatus()) {
				result[index] = book;
				
				index++;
			}
		}
		//Returns the array of books of the specified status
		return result;
		
	}
	//Method to get a ranked list of books in order of their loan count
	public LibraryBook[] mostPopular () {
		//Creates an array to store the books
		LibraryBook[] result = new LibraryBook[books.size()];
		//Copies the books from the arrayList to the array
		for(int i = 0; i < books.size(); i++) {
			result[i] = books.get(i);
		}
		//Sorts the array using insertion sort
		for(int i = 1; i < result.length; i++) {
			LibraryBook key = result[i];
			int j = i-1;
			
			while(j >= 0 && result[j].getLoanCount() < key.getLoanCount()) {
				result[j+1] = result[j];
				j--;
			}
			result[j+1] = key;
		}
        
        
		//Returns the sorted array of books
        return result;
			
		
	}
	
	//Method to search for a book by its ID
	public LibraryBook search(int id) {
		LibraryBook target = null;
		//Iterates through the books
		for (int i = 0; i < books.size(); i++) {
			LibraryBook book = books.get(i);
			//Check if book matches given id
			if(book.getId() == id) {
				//Stores the matching book
				target = book;
				break;
				
			}
		}
		//Returns the found book
		return target;
		
	}
	//Method to add a new book to the library
	public boolean add(LibraryBook book) {
		if (book != null) {
			//Search for a book with the same ID
			LibraryBook temp = search(book.getId());
			//If no book exists with the same id then add the book
			if(temp == null) {
				books.add(book);
				//Return true if successful
				return true;
			}

		}
		//return false if no book or duplicate book
		return false;
		
		
	}
	
	//Method to remove a book by its ID
	public boolean remove(int id) {
		//Iterates through the books
	    for (int i = 0; i < books.size(); i++) {
	    	//Check if book matches given id
	        if (books.get(i).getId() == id) {  
	        	//Removes book
	            books.remove(i); 
	            //Returns true if book is removed
	            return true;
	        }
	    }
	    //Returns false if unsuccessful
	    return false;
	}
}
	

