package edu.wmich.cs1120.williambowen;

public class Lookup {
	public static User[] userList;
	public static Item[] storeItemList;
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @return Return the user object if it exists
	 * An appropriate exception will be thrown for the following scenarios:
	 * <ol>
	 * <li>If userName doesn't exist, throw the message "Username doesn't exist."
	 * <li>If the user enters the wrong password, throw the message "Wrong password."
	 * </ol>
	 */
	public static User checkLoginAuth(String userName, String password) {
		userList = createUsers();
		storeItemList = loadItems();
		
		return null;
	}
	/**
	 * 
	 * @param userName
	 * @param password1
	 * @param password2
	 * @return
	 * An appropriate exception will be thrown for the following scenarios:
	 * <ol>
	 * <li>A user is trying to signup using a userName that already exists.
	 * <li>When a user enters password a second time, it doesn't match the first password.
	 * <li>If the password length is less than 6 characters.
	 * <li>If the password is not valid for requirements in the {@link #isValidPassword(String)} method
	 * </ol>
	 */
	public static User checkSignUpAuth(String userName, String password1, String password2) {
		return null;
	}
	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * This method adds new users to the user array
	 */
	public static User addUserToTheList(String userName, String password) {
		return null;
	}
	/**
	 * This method adds two users to the user list.
	 * The initial two users should not be changed, but more
	 * can be added.
	 * @return
	 */
	public static User[] createUsers() {
		User[] list = new User[2];
		
		list[0] = new User(1, "sara", "123");
		list[1] = new User(2, "adam", "321");
		
		return list;
	}
	/**
	 * This method loads data into the item list.
	 * This list has all of the items in the application.
	 * The initial items should not be changed, but more
	 * can be added.
	 * @return
	 */
	public static Item[] loadItems() {
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
	/**
	 * This method searches for the item by its key and then
	 * returns the item object if it exists, else null.
	 * @param key
	 * @return
	 */
	public static Item getItemById(int key) {
		return null;
	}
	/**
	 * This method checks if the password is valid.
	 * Passwords should contain:
	 * <ol>
	 * <li>At least one special character
	 * <br>(digit and number are the same thing, and with "specific" not being specified, I assumed "special" was intended)
	 * <li>At least one lower-case letter
	 * <li>At least one upper-case letter
	 * <li>At least one number
	 * @param password
	 * @return Message of "error" if the password is not valid, and null if the password is valid
	 */
	public static String isValidPassword(String password) {
		return null;
	}
}
