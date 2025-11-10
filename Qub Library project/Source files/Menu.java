package part2;


import console.Console;

public class Menu {
	//Array to store the menu items
	private String items[];
	//Title of the menu
	private String title;
	//Console instance for displaying the menu
	private static Console conMenu;
	
	//Constructor to initialise the menu
	public Menu(String title, String data[], Console console) {
		this.title = title;
		this.items = data;
		Menu.conMenu = console;
		}
	
	//Method to display the menu
	private void display() {
		//Prints the title and a line of + characters
		conMenu.println(title);
		for(int count=0;count<title.length();count++) {
				conMenu.print("+");
		}
		//Prints each numbered menu item
		conMenu.println();
		for(int option=1; option<=items.length; option++) {
				conMenu.println(option + ". " + items[option-1] );
		}
		//Adds a blank line
		conMenu.println();
	}
	//Method to get user's choice
	public int getUserChoice() {
		conMenu.clear();
		//Adds a delay for the craic
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		//Displays the menu
		display();
		conMenu.print("Enter Selection: ");
		//Reads the user's input
		int value = Integer.parseInt(conMenu.readLn().trim());
		return value;
	}
}


