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
		input.close();
	}
	/**
	 * Catch an appropriate type of exception
	 */
	public static User login(Scanner input, User sUser, Lookup store) {
		String userName;
		String password;
		
		do {
			System.out.println("Enter your UserName:");
			userName = input.next();
			System.out.println("Enter your Password:");
			password = input.next();
			
			sUser = store.checkLoginAuth(userName, password);
		}while(sUser == null);
		return sUser;
	}
	/**
	 * 
	 */
	public static User signUp(Scanner input, User sUser, Lookup store) {
		
		String userName;
		String password1;
		String password2;
		
		do {
			System.out.println("Enter your UserName:");
			userName = input.next();
			System.out.println("Enter your Password:");
			password1 = input.next();
			System.out.println("Enter your Password again:");
			password2 = input.next();
			
			sUser = checkSignUp(userName, password1, password2, store, sUser);
		}while(sUser == null);
		System.out.println("Login Successfully!\n");
		return sUser;
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
		boolean loopMenu = true;
		do {
			System.out.println("");
			System.out.println("1- SignUp");
			System.out.println("2- Login");
			System.out.println("3- Exit");
			System.out.println("Select one of these options:");
			
			switch(input.nextInt()) {
			case 1: // SignUp
				sUser = signUp(input, sUser, store);
				storeMenu(input, sUser, store);
				break;
			case 2: // Login
				sUser = login(input, sUser, store);
				storeMenu(input, sUser, store);
				break;
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
	public static void myCart(Scanner input, User sUser) {
		double total = 0.00;
		if(sUser.cartItems == null) {
			System.out.println("Your Shopping Cart is empty.");
		}else {
			for(int i = 0; i < sUser.cartItems.length; ++i) {
				total += sUser.cartItems[i].item.price * sUser.cartItems[i].quantity;
				System.out.println(sUser.cartItems[i]);
			}
			System.out.println("\nTotal Price: " + String.format("$%.2f",total));
			System.out.println("\nDo you want to purchase these items(Y,N)");
			if(input.next().charAt(0) == 'Y') {
				FileManager.createBillFile(total, sUser);
			}
		}
	}
	/**
	 * 
	 */
	public static void storeMenu(Scanner input, User sUser, Lookup store) {
		
		boolean loopMenu = true;
		do {
			System.out.println("");
			System.out.println("1- Flowers List!");
			System.out.println("2- My Cart");
			System.out.println("3- Bill");
			System.out.println("4- Exit");
			
			switch(input.nextInt()) {
			case 1: // Flowers List
				printFlowersList(store);
				flowerMenu(input, sUser, store);
				break;
			case 2: // My Cart
				myCart(input, sUser);
				break;
			case 3: // Bill
				FileManager.readBill(sUser);
				break;
			case 4: // Exit
				loopMenu = false;
				break;
			default:
				System.out.println("Invalid choice. Integers from 1-4 only.");
			}
		}while(loopMenu);
	}
	/**
	 * 
	 * @param input
	 * @param sUser
	 * @param store
	 */
	public static void flowerMenu(Scanner input, User sUser, Lookup store) {
		
		int id = -1;
		Item flower = null;
		int quantity = 0;
		
		boolean loopMenu = true;
		do {
			System.out.println("\nDo you want to purchase an item(Y,N)?");
			
			if(input.next().charAt(0) == ('Y')){
				System.out.println("Enter flower id:");
				id = input.nextInt();
				flower = store.getItemById(id);
				
				if(flower != null) {
					System.out.println("Enter the quantity:");
					quantity = input.nextInt();
					
					if(quantity > flower.availableQuantity) {
						System.out.println("This quantity is not available.");
						System.out.println("The available quantity in the store is " + flower.availableQuantity + " flowers, " +
								"and your ordered quantity is " + quantity + " flowers.");
						quantity = 0;
					}else {
						sUser.addItemToTheCart(id, flower, quantity);
					}
				}
			}else {
				loopMenu = false;
			}
		}while(loopMenu);
	}
}
