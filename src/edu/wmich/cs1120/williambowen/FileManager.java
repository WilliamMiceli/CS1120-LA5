package edu.wmich.cs1120.williambowen;

import java.io.*;
import java.util.Scanner;

public class FileManager {
	public static String filename; // filename should be set as the userName.
	
	/**
	 * Used for creating an output file to save the user's bill
	 * when the user purchases the items in the cart list.
	 * 
	 * Will catch an appropriate type of exception if there is a problem
	 * while creating or writing to the file.
	 * @param total The total price of the order
	 */
	public static void createBillFile(double total, User sUser) {
		filename = sUser.userName + ".txt";
		FileWriter output;
		try {
			output = new FileWriter(filename);
			output.write(String.valueOf(total));
		} catch (IOException e) {
			System.out.println("Unable to create bill.");
		}
	}
	/**
	 * Reads and displays the user's bill file when the user
	 * wants to see his/her bill.
	 * 
	 * Based on the problem, appropriate exceptions will be caught
	 * for these specific cases:
	 * <ol>
	 * <li>If the user does not have a bill yet
	 * <li>If the problem happened while reading the file
	 * </ol>
	 */
	public static void readBill(User sUser) {
		filename = sUser.userName + ".txt";
		File file = new File(filename);
		Scanner input = null;
		
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("You don't have any bill currently.");
		} catch (Exception e) {
			System.out.println("Unable to read bill.");
		}
		System.out.println("Your bill balance is " + String.format("$%.2f",input.nextDouble()));
	}
}
