package com.akshay.GroceryMarketProject.Service;

import java.util.List;

import com.akshay.GroceryMarketProject.Model.SaleItem;



public interface SaleItemService {
	List<SaleItem> getAllSaleItems();
	void saveSaleItem(SaleItem saleItem);
	SaleItem getSaleItemById(int id);
	void deleteSaleItemById(int id);
	List<SaleItem> getSaleItemByItemId(int itemId);
	List<SaleItem> getSaleItemBySaleId(int saleId);
	void deleteSaleItemBySaleId(int SaleId);
}
