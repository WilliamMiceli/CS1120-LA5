package edu.wmich.cs1120.williambowen;

public class CartItem {
	public int id;
	public int quantity;
	public Item item;
	
	/**
	 * The item that is in the user's shopping cart.
	 * @param id The ID of the item.
	 * @param item The item object.
	 */
	public CartItem(int id, Item item) {
		this.id = id;
		this.item = item;
	}
	/**
	 * Sets the quantity of the item in the shopping cart.
	 * @param quantity The amount of the item in the shopping cart.
	 * @throws Exception if the user tries to request more
	 * than the quantity that is available in the store
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * The nicely formatted string of the item in the user's shopping cart.
	 */
	@Override
	public String toString() {
		return this.item.title + "(Quantity: " + quantity + "), Price: " + String.format("$%4.2f",this.item.price);
	}
}
