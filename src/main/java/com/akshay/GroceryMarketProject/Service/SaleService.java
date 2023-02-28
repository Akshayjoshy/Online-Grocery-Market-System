package com.akshay.GroceryMarketProject.Service;

import java.util.Date;
import java.util.List;

import com.akshay.GroceryMarketProject.Model.Sale;



public interface SaleService {
	List<Sale> getAllSales();
	Sale saveSale(Sale sale);
	Sale getSaleById(int id);
	void deleteSaleById(int id);

	List<Sale> findSalesOnDate(Date date );
	List<Sale> findSalesAfterDate(Date date );
	
}
