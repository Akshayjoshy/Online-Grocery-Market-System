package com.akshay.GroceryMarketProject.Service;

import java.util.List;

import com.akshay.GroceryMarketProject.Model.ItemUOM;


public interface ItemUOMService {
	List<ItemUOM> getAllItemUOM();
	void saveItemUOM(ItemUOM itemUOM);
	ItemUOM getItemUOMById(int id);
	void deleteItemUOMById(int id);

}
