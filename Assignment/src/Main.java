package com.avatar.record_management;

import java.io.FileNotFoundException;

public class Main {

	


	public static void main(String[] args) throws FileNotFoundException {

		RecordManager rm = new RecordManager();
		
		// Welcome message
		System.out.println("Welcome to my music record.");
		// call method parseInput
		rm.parseInput();
		
		}
	
 }
		

