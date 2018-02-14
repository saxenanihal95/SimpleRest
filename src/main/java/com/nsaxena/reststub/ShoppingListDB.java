package com.nsaxena.reststub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ShoppingListDB {
	private static Map<Integer,ShoppingList> shoppingList=new HashMap<Integer,ShoppingList>();
	
	final static String ERROR_EMPTY_BODY="Please add item details !!";
	final static String ERROR_EMPTY_NAME="Please provide the item name !!";
	final static String ERROR_EMPTY_PRICE="Please provide the item price !!";
	final static String ERROR_EMPTY_QUANTIY="Please provide the item quantity !!";
	final static String SUCCESS_DELETED="Item Deleted Succesfully";
	final static String SUCCESS_CREATED="Item Created Succesfully";
	final static String SUCCESS_UPDATED="Item Updated Succesfully";
	final static String ERROR_ALREADY_EXISTS="Item Already Exists";
	final static String ERROR_DOES_NOT_EXISTS="Item Does Not Exists";
	
	static {
		shoppingList.put(1, new ShoppingList(1, "item1", 100.0, 2));
		shoppingList.put(2, new ShoppingList(2, "item2", 56.6, 3));
		shoppingList.put(3, new ShoppingList(3, "item3", 66.6, 4));
		shoppingList.put(4, new ShoppingList(4, "item4", 77.7, 1));
    }
	
	public static ShoppingList getbyId(int id)
	{
		return shoppingList.get(id);
	}
	
	public static List<ShoppingList> getAll() {
        List<ShoppingList> result = new ArrayList<ShoppingList>();
        for (Integer key : shoppingList.keySet()) {
            result.add(shoppingList.get(key));
        }
        return result;
    }
	
	public static int getCount() {
        return shoppingList.size();
    }
	
	public static boolean remove(int id) {
		if (shoppingList.get(id) != null) {
			shoppingList.remove(id);
			return true;
		}
        return false;
    }
	
	public static boolean create(ShoppingList list) {
		if (shoppingList.get(list.getItemId()) == null) {
			shoppingList.put(list.getItemId(), list);
			return true;
		}
		
        return false;
    }
	
	public static boolean update(ShoppingList list) {
		if (shoppingList.get(list.getItemId()) != null) {
			shoppingList.put(list.getItemId(), list);
			return true;
		}
        
        return false;
    }
}
