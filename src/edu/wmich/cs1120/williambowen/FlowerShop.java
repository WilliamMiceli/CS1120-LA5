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
		User sUser = null;
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to our Flowers Shop!");
		
		mainMenu(input, sUser);
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
		
		String userName;
		String password1;
		String password2;
		
		boolean userNameUnique = true;
		boolean passwordsMatch = true;
		boolean passwordIsValid = true;
		
		do {
			do {
				System.out.println("Enter your UserName:");
				userName = input.nextLine();
				System.out.println("Enter your Password:");
				password1 = input.nextLine();
				System.out.println("Enter your Password again:");
				password2 = input.nextLine();
				
				userNameUnique = true;
				for(int i = 0; i < Lookup.userList.length; ++i) {
					if(Lookup.userList[i].userName.equals(userName)) {
						userNameUnique = false;
						System.out.println("UserName already exists.");
						break;
					}
				}
				
				passwordsMatch = true;
				if(password1.compareTo(password2) != 0) {
					passwordsMatch = false;
					System.out.println("Passwords do not match.");
				}
			}while(userNameUnique && passwordsMatch);
			
			passwordIsValid = true;
			if(Lookup.isValidPassword(password1).compareTo("error") == 0) {
				passwordIsValid = false;
			}
		}while(passwordIsValid);
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
	public static void mainMenu(Scanner input, User sUser) {
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
