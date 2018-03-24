package edu.wmich.cs1120.williambowen;

public class Lookup {
	public User[] userList;
	public Item[] storeItemList;
	
	public Lookup() {
		userList = createUsers();
		storeItemList = loadItems();
	}
	/**
	 * An appropriate exception will be thrown for the following scenarios:
	 * <ol>
	 * <li>If userName doesn't exist, throw the message "Username doesn't exist."
	 * <li>If the user enters the wrong password, throw the message "Wrong password."
	 * </ol>
	 * @param userName The username to be checked to log in.
	 * @param password The password of the user to be checked for log in.
	 * @return Return the user object if it exists
	 */
	public User checkLoginAuth(String userName, String password) {
		for(int i = 0; i < userList.length; ++i) {
			if(userList[i].userName.compareToIgnoreCase(userName) == 0) {
				if(userList[i].password.compareTo(password) == 0) {
					return userList[i];
				}else {
					System.out.println("Password is incorrect.");
					return null;
				}
			}
		}
		System.out.println("Username does not exist.");
		return null;
	}
	/**
	 * An appropriate exception will be thrown for the following scenarios:
	 * <ol>
	 * <li>A user is trying to signup using a userName that already exists.
	 * <li>When a user enters password a second time, it doesn't match the first password.
	 * <li>If the password length is less than 6 characters.
	 * <li>If the password is not valid for requirements in the {@link #isValidPassword(String)} method
	 * </ol>
	 * @param userName The username of the user trying to make an account with.
	 * @param password1 Password entry 1
	 * @param password2 Password entry 2
	 * @return User The user that is currently now logged in.
	 */
	public User checkSignUpAuth(String userName, String password1, String password2) {
		
		for(int i = 0; i < userList.length; ++i) {
			if(userList[i].userName.equals(userName)) {
				System.out.println("UserName already exists.");
				return null;
			}
		}
		if(password1.compareTo(password2) != 0) {
			System.out.println("Passwords do not match.");
			return null;
		}
		if(isValidPassword(password1) != null) {
			return null;
		}
		return addUserToTheList(userName, password1);
	}
	/**
	 * Adds users to the user list.
	 * @param userName The username of the user to be added.
	 * @param password The password of the user to be added.
	 * @return User The user that has been successfully added to the list.
	 * This method adds new users to the user array
	 */
	public User addUserToTheList(String userName, String password) {
		User[] newUserList = new User[userList.length + 1];
		for(int i = 0; i < userList.length; ++i) {
			newUserList[i] = userList[i];
		}
		newUserList[userList.length] = new User(userList.length + 1, userName, password);
		userList = newUserList;
		return userList[userList.length - 1];
	}
	/** This method adds two users to the user list.
	 * The initial two users should not be changed, but more
	 * can be added.
	 * @return User[] The list of users that have just been created.
	 */
	public User[] createUsers() {
		User[] list = new User[2];
		
		list[0] = new User(1, "sara", "123");
		list[1] = new User(2, "adam", "321");
		
		return list;
	}
	/** This method loads data into the item list.
	 * This list has all of the items in the application.
	 * The initial items should not be changed, but more
	 * can be added.
	 * @return Item[] The items that are available to purchase.
	 */
	public Item[] loadItems() {
		Item[] itemList = new Item[10];
		
		itemList[0] = new Item(1, "Tulip", 10, 3.00);
		itemList[1] = new Item(2, "Calla", 15, 3.00);
		itemList[2] = new Item(3, "Gerbera", 15, 2.00);
		itemList[3] = new Item(4, "Rose", 30, 2.00);
		itemList[4] = new Item(5, "Purple Mallow", 12, 2.00);
		itemList[5] = new Item(6, "Bergenia", 8, 1.80);
		itemList[6] = new Item(7, "Baneberry", 20, 1.95);
		itemList[7] = new Item(8, "Aster", 25, 1.50);
		itemList[8] = new Item(9, "Sunflower", 8, 1.00);
		itemList[9] = new Item(10, "Gladiolus", 10, 0.75);
		
		return itemList;
	}
	/** This method searches for the item by its key and then
	 * returns the item object if it exists, else null.
	 * @param key The requested ID of the item.
	 * @return Item The item that has been found from the key;
	 */
	public Item getItemById(int key) {
		for(int i = 0; i < storeItemList.length; ++i) {
			if(storeItemList[i].id == key) {
				return storeItemList[i];
			}
		}
		System.out.println("This flower's id is not existing!");
		return null;
	}
	/** This method checks if the password is valid.
	 * Passwords should contain:
	 * <ol>
	 * <li>At least one special character
	 * <br>(digit and number are the same thing, and with "specific" not being specified, I assumed "special" was intended)
	 * <li>At least one lower-case letter
	 * <li>At least one upper-case letter
	 * <li>At least one number
	 * </ol>
	 * @param password The password to check against set requirements.
	 * @return Message of "error" if the password is not valid, and null if the password is valid.
	 */
	public String isValidPassword(String password) {
		boolean special = false;
		boolean lower = false;
		boolean upper = false;
		boolean number = false;
		
		String specialCharList = "`~!@%#$^&*()-_=+|,.<>?;:[]{}";
		String lowerCharList = "abcdefghijklmnopqrstuvwxyz";
		String upperCharList = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numberCharList = "0123456789";
		
		if(password.length() < 6) {
			System.out.println("The password length should be at least 6 characters.");
			return "error";
		}
		
		for(int i = 0; i < password.length(); ++i) {
			if(specialCharList.contains(Character.toString(password.charAt(i)))) {
				special = true;
			}else if(lowerCharList.contains(Character.toString(password.charAt(i)))) {
				lower = true;
			}else if(upperCharList.contains(Character.toString(password.charAt(i)))) {
				upper = true;
			}else if(numberCharList.contains(Character.toString(password.charAt(i)))) {
				number = true;
			}
		}
		
		if(special && lower && upper && number) {
			return null;
		}else {
			System.out.println("Password should contain:");
			if(!special) {
				System.out.println("At least one special character.");
			}
			if(!lower) {
				System.out.println("At least one lower-case character.");
			}
			if(!upper) {
				System.out.println("At least one upper-case character.");
			}
			if(!number) {
				System.out.println("At least one number.");
			}
			return "error";
		}
	}
}
