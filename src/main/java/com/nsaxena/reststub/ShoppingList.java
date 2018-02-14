package com.nsaxena.reststub;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingList 
{
	private int itemId;
	private String itemName;
	private double itemPrice;
	private int itemQuantity;
	public ShoppingList()
	{
	}
	public ShoppingList(int itemId, String itemName, double itemPrice, int itemQuantity) 
	{
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
	}
	@JsonProperty
	public int getItemId() {
		return itemId;
	}
	@JsonProperty
	public String getItemName() {
		return itemName;
	}
	@JsonProperty
	public double getItemPrice() {
		return itemPrice;
	}
	@JsonProperty
	public int getItemQuantity() {
		return itemQuantity;
	}
	
}
