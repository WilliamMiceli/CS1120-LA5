package edu.wmich.cs1120.williambowen;

public class CartItem {
	public int id;
	public int quantity;
	public Item item;
	
	/**
	 * 
	 * @param id
	 * @param item
	 */
	public CartItem(int id, Item item) {
		this.id = id;
		this.item = item;
	}
	/**
	 * 
	 * @param quantity
	 * @throws Exception if the user tries to request more
	 * than the quantity that is available in the store
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		return this.item.title + "(Quantity: " + quantity + "), Price: " + String.format("$%4.2f",this.item.price);
	}
}
