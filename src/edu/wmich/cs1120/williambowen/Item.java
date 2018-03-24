package edu.wmich.cs1120.williambowen;

public class Item {
	public int id;
	public String title;
	public int availableQuantity;
	public double price;
	
	/**
	 * The constructor.
	 * @param id The ID of the item.
	 * @param title The title or name of the item.
	 * @param availableQuantity The quantity available for the user to purchase.
	 * @param price The price of the individual item.
	 */
	public Item(int id, String title, int availableQuantity, double price) {
		this.id = id;
		this.title = title;
		this.availableQuantity = availableQuantity;
		this.price = price;
	}
	/**
	 * Nicely formatted string for showing the available item in the storefront.
	 */
	@Override
	public String toString() {
		return id + " -  " + title + ",  Price:" + String.format("$%4.2f",price);
	}
}
