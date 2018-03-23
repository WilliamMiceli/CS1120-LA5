package edu.wmich.cs1120.williambowen;

import java.util.Scanner;

public class FlowerShop {
	/**
	 * Use a try-catch block in the main method instead of the "default" case,
	 * you should have relevant catch clauses:
	 * <ol>
	 * <li>Use an appropriate type of exception if the input is not an integer.
	 * <li>Use a custom Exception (InvalidInputException) when the input is not
	 * one of the options on the menu.
	 * </ol>
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to our Flowers Shop!");
		
		mainMenu(input);
	}
	/**
	 * Catch an appropriate type of exception
	 */
	public static void login(Scanner input) {
		
	}
	/**
	 * 
	 */
	public static void signUp(Scanner input) {
		
	}
	/**
	 * Catch an appropriate type of exception
	 * @param userName
	 * @param password1
	 * @param password2
	 * @return
	 */
	public static User checkSignUp(String userName, String password1, String password2) {
		return null;
	}
	/**
	 * 
	 */
	public static void mainMenu(Scanner input) {
		System.out.println("1- SignUp");
		System.out.println("2- Login");
		System.out.println("3- Exit");
		System.out.println("Select one of these options:");
		
		boolean quit = false;
		do {
			switch(input.nextInt()) {
			case 1: // SignUp
				signUp(input);
			case 2: // Login
				login(input);
			case 3: // Exit
				quit = true;
				break;
			default:
				
			}
		}while(quit);
	}
	/**
	 * 
	 */
	public static void printFlowersList() {
		
	}
	/**
	 * 
	 */
	public static void myCart() {
		
	}
}
