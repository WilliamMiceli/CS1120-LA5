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
		
	}
	/**
	 * 
	 * @param quantity
	 * @throws Exception if the user tries to request more
	 * than the quantity that is available in the store
	 */
	public void setQuantity(int quantity) {
		
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "";
	}
}
