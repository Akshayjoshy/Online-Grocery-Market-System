package com.akshay.GroceryMarketProject.Service;

import java.util.List;

import com.akshay.GroceryMarketProject.Model.StockItem;



public interface StockItemService {
	List<StockItem> getAllStockItems();
	void saveStockItem(StockItem stockItem);
	StockItem getStockItemById(int id);
	void deleteStockItemById(int id);
	StockItem getStockItemByItemId(int itemId);
	List<StockItem> getStockItemByStockId(int stockId);
	void deleteStockItemByStockId(int id);
}
