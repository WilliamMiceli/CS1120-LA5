package edu.wmich.cs1120.williambowen;

public class User {
	public int id;
	public String username;
	public String password;
	public CartItem[] cartItems;
	
	/**
	 * When the user adds an item to the cart list, the following are checked:
	 * <ul>
	 * <li>The quantity of the item that is entered by the user should not be
	 * more than the available quantity in the store.
	 * <li>If the user adds the same item that he already has in his cart list,
	 * only the quantity for the item should be updated (added).
	 * <br>The same item is not listed multiple times in the cart list.
	 * <li>If the cart has less than three unique items, as that is the maximum.
	 * </ul>
	 * 
	 * @param item
	 * @param quantity
	 */
	public void addItemToTheCart(Item item, int quantity) {
		
	}
}
