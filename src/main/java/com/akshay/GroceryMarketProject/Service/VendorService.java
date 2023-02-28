package com.akshay.GroceryMarketProject.Service;

import java.util.Date;
import java.util.List;

import com.akshay.GroceryMarketProject.Model.Vendor;



public interface VendorService {
	List<Vendor> getAllVendor();
	void saveVendor(Vendor vendor);
	Vendor getVendorById(int id);
	void deleteVendorById(int id);
	

	List<Vendor> findVendorsOnDate(Date date );
	List<Vendor> findVendorsAfterDate(Date date );
	
}
