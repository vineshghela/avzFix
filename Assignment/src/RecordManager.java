package com.avatar.record_management;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class RecordManager {

    private ArrayList<Record> records = new ArrayList<>();

    private int songNum;

    private Scanner input = new Scanner(System.in);

    private String fileName = "src/com/avatar/record_management/Data/Record.csv";

    public void parseInput() throws FileNotFoundException {
        String[] menu = {"1 - Create a record", "2 - View a record", "3 - Delete a record", "4 - Search for a record", "5 - Exit this program"};

        System.out.println("Do you want to: ");

        for (String i : menu) {
            System.out.println(i);

        }


        String selection = input.nextLine();

        switch (selection) {
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

    private void searchList() throws FileNotFoundException {
        String[] menu = {"1 - Search by Title", "2 - Search by Artist", "3 - Search by Genre", "4 - Return to the previous menu "};
//			Title,Artist,Genre, SongID

        System.out.println("Do you want to: ");

        for (String i : menu) {
            System.out.println(i);

        }


        String selection = input.nextLine();

        switch (selection) {
            case "1":
                System.out.println("Please enter the name of the Title");
                String searchVal = input.nextLine();
                searchByTitle(searchVal);
                break;

            case "2":
                System.out.println("search by Artist");
                String searchVal2 = input.nextLine();
                searchByArtist(searchVal2);
                break;

            case "3":
                System.out.println("search by Genre");
                String searchVal3 = input.nextLine();
                searchByGenre(searchVal3);
                break;

            case "4":
                parseInput();
        }
        searchList();
    }


    private void createRecord() throws FileNotFoundException {
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
            createRecord(genre, artist, title);

            System.out.println("Do you want to enter another record? Y/N");
            answer = input.nextLine();

        }

        while

            // loop happens until anything other than Y / y is submitted
                (answer.equalsIgnoreCase("Y"));

//			input.close();
        parseInput();

    }


    private void printRecord() throws FileNotFoundException {
        printRecords();
        System.out.println("---------");
        parseInput();

    }

    private void exitRecord() throws FileNotFoundException {
        String answer;
        Scanner input = new Scanner(System.in);


        System.out.println("Are you sure you want to exit? Y/N");
        answer = input.nextLine();

        if (answer.equalsIgnoreCase("Y")) {
            System.out.println("This is the end of the program. The program will now close");
            writeCSV();
            System.exit(0);

        } else if (answer.equalsIgnoreCase("N")) {
            parseInput();
        }


        input.close();

    }

    public RecordManager() throws FileNotFoundException {

        readCSV();

    }

    private void createRecord(String genre, String artist, String title) {
        songNum++;

        records.add(new Record(genre, artist, title, songNum));

    }

    private void printRecords() {
        for (Record i : records) {
            System.out.println(i);
        }

    }

    private void searchByTitle(String value) {
        for (Record i : records) {
            if (i.getTitle().equalsIgnoreCase(value)) {

                System.out.println("The following record was found: \n" + i);
                return;
            }
        }
        System.out.println("Not found with value " + value);
    }

    private void searchByGenre(String value) {

        for (Record i : records) {
            if (i.getGenre().equalsIgnoreCase(value)) {
                System.out.println("The following record was found: \n" + i);
                return;
            }
        }
        System.out.println("Not found with value " + value);


    }

    private void searchByArtist(String value) {
        for (Record i : records) {
            if (i.getArtist().equalsIgnoreCase(value)) {
                System.out.println("The following record was found: \n" + i);
                return;
            }
        }
        System.out.println("Not found with value " + value);
    }

    private void readCSV() throws FileNotFoundException {
        Scanner input = new Scanner(new FileInputStream(fileName));

        try {
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Error "+ e);
        }

        while (input.hasNextLine()) {
            songNum++;
            String[] values = input.nextLine().split(",");
            records.add(new Record(values[0], values[1], values[2], Integer.parseInt(values[3])));
        }
        songNum--;
        input.close();

    }

    private void writeCSV() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileName);
        out.println("Title,Artist,Genre, SongID");

        for (Record i : records) {
            out.println(i);

        }
        out.close();
    }

}