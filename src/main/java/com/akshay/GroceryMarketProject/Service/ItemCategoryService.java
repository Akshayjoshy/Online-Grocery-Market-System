package com.akshay.GroceryMarketProject.Service;

import java.util.List;

import com.akshay.GroceryMarketProject.Model.ItemCategory;


public interface ItemCategoryService {
	List<ItemCategory> getAllItemCategory();
	void saveItemCategory(ItemCategory itemCategory);
	ItemCategory getItemCategoryById(int id);
	void deleteItemCategoryById(int id);
	
}
