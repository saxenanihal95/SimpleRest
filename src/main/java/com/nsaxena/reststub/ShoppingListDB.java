package com.nsaxena.reststub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ShoppingListDB {
	private static Map<Integer,ShoppingList> shoppingList=new HashMap<Integer,ShoppingList>();
	
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
	
	public static void remove() {
        if (!shoppingList.keySet().isEmpty()) {
        	shoppingList.remove(shoppingList.keySet().toArray()[0]);
        }
    }
	
	public static String save(ShoppingList list) {
        String result = "";
        if (shoppingList.get(list.getItemId()) != null) {
            result = "Updated List with id=" + list.getItemId();
        } else {
            result = "Added List with id=" + list.getItemId();
        }
        shoppingList.put(list.getItemId(), list);
        return result;
    }
}
