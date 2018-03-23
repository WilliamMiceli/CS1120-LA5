package edu.wmich.cs1120.williambowen;

public class Item {
	public int id;
	public String title;
	public int availableQuantity;
	public double price;
	
	/**
	 * 
	 * @param id
	 * @param title
	 * @param availableQuantity
	 * @param price
	 */
	public Item(int id, String title, int availableQuantity, double price) {
		this.id = id;
		this.title = title;
		this.availableQuantity = availableQuantity;
		this.price = price;
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "";
	}
}
