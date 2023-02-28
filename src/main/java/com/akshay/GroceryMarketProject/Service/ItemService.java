package com.akshay.GroceryMarketProject.Service;

import java.util.List;

import com.akshay.GroceryMarketProject.Model.Item;

public interface ItemService {
	List<Item> getAllItems();
	void saveItem(Item item);
	Item getItemById(int id);
	void deleteItemById(int id);
	
}
