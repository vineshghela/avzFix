import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class RecordManager {

	static ArrayList<Record> records = new ArrayList<Record>();

	static int songNum;

	public RecordManager() throws FileNotFoundException {

		readCSV();
		
	}
	
	public void createRecord(String genre, String artist, String title)
	{
		songNum++; 
		
		records.add(new Record(genre,artist, title,  songNum));
		
	}

	public void printRecords()
	{
		for ( Record i : records) {
			System.out.println(i);
		}

	}

	public void searchByTitle(String value)
	{
		for ( Record i : records) {
			if(i.getTitle().equalsIgnoreCase(value)){

				System.out.println("The following record was found: \n"+i);
				return;
			}
		}
		System.out.println("Not found with value " + value);
	}
	public void searchByGenre(String value)
	{

		for ( Record i : records) {
			if(i.getGenre().equalsIgnoreCase(value)){
				System.out.println("The following record was found: \n"+i);
				return;
			}
		}
		System.out.println("Not found with value " + value);


	}
	public void searchByArtist( String value)
	{
		for ( Record i : records) {
			if(i.getArtist().equalsIgnoreCase(value)){
				System.out.println("The following record was found: \n"+i);
				return;
			}
		}
		System.out.println("Not found with value " + value);
	}
	
	public static void readCSV() throws FileNotFoundException 
{
		Scanner input = new Scanner(new FileInputStream("/home/vinesh/Downloads/JavaAssignmentYear1-main/avzFix/Assignment/Data/Record.csv"));
		
		try { 
			input.nextLine();
		} catch(Exception e) {
			
		}
		
	while(input.hasNextLine()) {
		songNum++;
		String[] values = input.nextLine().split(",");
		records.add(new Record(values[0], values [1], values [2], Integer.parseInt(values[3])));
	}
	songNum--;
	input.close();
	
}

public void writeCSV() throws FileNotFoundException
{
	PrintWriter out = new PrintWriter("/home/vinesh/Downloads/JavaAssignmentYear1-main/avzFix/Assignment/Data/Record.csv");
	out.println("Title,Artist,Genre, SongID");
	
	for ( Record i : records) {
		out.println(i);
		
	}
	out.close();
}

}