import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class main {

	
	static RecordManager recordManager;
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException {

		recordManager = new RecordManager();
		
		// Welcome message
		System.out.println("Welcome to my music record.");
		
		// call method parseInput
		parseInput();
		
		}
	
		public static void parseInput () throws FileNotFoundException
		{
			String[] menu = {"1 - Create a record", "2 - View a record", "3 - Delete a record", "4 - Search for a record", "5 - Exit this program"}; 
			
			System.out.println("Do you want to: " );

			for (String i : menu ) {
				System.out.println(i);

			}
			
			
			String selection = input.nextLine();
			
			switch (selection)
			{
			case "1":
			createRecord();
			break;
			
			case "2":
			printRecord();
			break;
			
			case "3":
			System.out.println("The delete function has not yet been implemented. The view record needs to be implemented first");
			break;
			
			case "4":
//			System.out.println("The search function has not yet been implemented. The view record needs to be implemented first");
				searchList();
			break;
			
			case "5":
			exitRecord();
			break;
			}
						
		}

		public static void searchList() throws FileNotFoundException {
			String[] menu = {"1 - Search by Title", "2 - Search by Artist", "3 - Search by Genre", "4 - Return to the previous menu "};
//			Title,Artist,Genre, SongID

			System.out.println("Do you want to: " );

			for (String i : menu ) {
				System.out.println(i);

			}


			String selection = input.nextLine();

			switch (selection){
				case "1":
					System.out.println("Please enter the name of the Title");
					String searchVal = input.nextLine();
					recordManager.searchByTitle(searchVal);
					break;

				case "2":
					System.out.println("search by Artist");
					String searchVal2 = input.nextLine();
					recordManager.searchByArtist(searchVal2);
					break;

				case "3":
					System.out.println("search by Genre");
					String searchVal3 = input.nextLine();
					recordManager.searchByGenre(searchVal3);
					break;

				case "4":
					parseInput();
			}
			searchList();
		}

		
		public static void createRecord() throws FileNotFoundException
		{
			String answer;
			Scanner input = new Scanner(System.in);
			
			do {
			
			System.out.println("Please enter the artist");
			String artist = input.nextLine();
			
			System.out.println("Please enter the title");
			String title = input.nextLine();
			
			System.out.println("Please enter the genre of music this is");
			String genre = input.nextLine();
			
			
//			System.out.println(recordManager.createRecord(genre, artist, title));
			recordManager.createRecord(genre, artist, title);
			
			System.out.println("Do you want to enter another record? Y/N");
			answer = input.nextLine();
		
		}

		while
			
			// loop happens until anything other than Y / y is submitted
			(answer.equalsIgnoreCase("Y"));
			
//			input.close();
			parseInput();
			
		}
		

		public static void printRecord() throws FileNotFoundException
		{
			recordManager.printRecords(); 
			System.out.println("---------");
			parseInput();
			
		}

		public static void exitRecord() throws FileNotFoundException
		{
			String answer;
			Scanner input = new Scanner(System.in);
			
			
				System.out.println("Are you sure you want to exit? Y/N");
				answer = input.nextLine();
				
				if (answer.equalsIgnoreCase("Y")) {
					System.out.println("This is the end of the program. The program will now close");	
					recordManager.writeCSV();
					System.exit(0);
					
			} else if (answer.equalsIgnoreCase("N")) {
				parseInput();
			}
			
				
		input.close();
					
		}
		
	
 }
		

