package edu.wmich.cs1120.williambowen;

public class User {
	public int id;
	public String userName;
	public String password;
	public CartItem[] cartItems = null;
	
	/**
	 * 
	 * @param id
	 * @param userName
	 * @param password
	 */
	public User(int id, String userName, String password) {
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
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
	 * @throws an appropriate exception if the user tries to add more than
	 * three items to the car list, and if there is a thrown exception from
	 * the {@link edu.wmich.cs1120.williambowen.CartItem#setQuantity(int)} method.
	 */
	public void addItemToTheCart(int id, Item item, int quantity) {
		CartItem[] newCartItems;
		
		if(this.cartItems == null) {
			newCartItems = new CartItem[1];
			newCartItems[0] = new CartItem(id, item);
			newCartItems[0].setQuantity(quantity);
			cartItems = newCartItems;
		}else if(cartItems.length > 2){
			System.out.println("EXCESS ITEMS CATCH THIS!!!!!!!!!!!!!!!!!!!!!!");
		}else {
			newCartItems = new CartItem[cartItems.length + 1];
			for(int i = 0; i < cartItems.length; ++i) {
				newCartItems[i] = cartItems[i];
			}
			newCartItems[cartItems.length] = new CartItem(id, item);
			newCartItems[cartItems.length].setQuantity(quantity);
			cartItems = newCartItems;
		}
	}
}
