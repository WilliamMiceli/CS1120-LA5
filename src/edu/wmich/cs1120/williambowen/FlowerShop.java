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
		Lookup store = new Lookup();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to our Flowers Shop!");
		
		mainMenu(input, sUser, store);
	}
	/**
	 * Catch an appropriate type of exception
	 */
	public static void login(Scanner input, User sUser, Lookup store) {
		String userName;
		String password;
		
		do {
			System.out.println("Enter your UserName:");
			userName = input.nextLine();
			System.out.println("Enter your Password:");
			password = input.nextLine();
			
			sUser = store.checkLoginAuth(userName, password);
		}while(sUser == null);
	}
	/**
	 * 
	 */
	public static void signUp(Scanner input, User sUser, Lookup store) {
		
		String userName;
		String password1;
		String password2;
		
		do {
			System.out.println("Enter your UserName:");
			userName = input.nextLine();
			System.out.println("Enter your Password:");
			password1 = input.nextLine();
			System.out.println("Enter your Password again:");
			password2 = input.nextLine();
			
			sUser = checkSignUp(userName, password1, password2, store, sUser);
		}while(sUser == null);
		
		System.out.println("Login Successfully!");
	}
	/**
	 * Catch an appropriate type of exception
	 * @param userName
	 * @param password1
	 * @param password2
	 * @return
	 */
	public static User checkSignUp(String userName, String password1, String password2, Lookup store, User sUser) {
		
		sUser = store.checkSignUpAuth(userName, password1, password2);
		
		return sUser;
	}
	/**
	 * 
	 */
	public static void mainMenu(Scanner input, User sUser, Lookup store) {
		System.out.println("1- SignUp");
		System.out.println("2- Login");
		System.out.println("3- Exit");
		System.out.println("Select one of these options:");
		
		boolean loopMenu = true;
		do {
			switch(input.nextInt()) {
			case 1: // SignUp
				signUp(input, sUser, store);
			case 2: // Login
				login(input, sUser, store);
			case 3: // Exit
				loopMenu = false;
				break;
			default:
				System.out.println("Invalid choice. Integers from 1 - 3 only.");
			}
		}while(loopMenu);
	}
	/**
	 * 
	 */
	public static void printFlowersList(Lookup store) {
		for(int i = 0; i < store.storeItemList.length; ++i) {
			System.out.println(store.storeItemList[i]);
		}
	}
	/**
	 * 
	 */
	public static void myCart() {
		
	}
	/**
	 * 
	 */
	public static void storeMenu(Scanner input, User sUser, Lookup store) {
		
		boolean loopMenu = true;
		do {
			System.out.println("1- Flowers List!");
			System.out.println("2- My Cart");
			System.out.println("3 - Bill");
			System.out.println("4- Exit");
			
			switch(input.nextInt()) {
			case 1: // Flowers List
				printFlowersList(store);
				break;
			case 2: // My Cart
				myCart();
				break;
			case 3: // Bill
				FileManager.readBill();
				break;
			case 4: // Exit
				loopMenu = false;
				break;
			default:
				System.out.println("Invalid choice. Integers from 1-4 only.");
			}
		}while(loopMenu);
		
		
		
	}
}
