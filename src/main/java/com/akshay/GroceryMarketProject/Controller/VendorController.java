package com.akshay.GroceryMarketProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.akshay.GroceryMarketProject.Model.Vendor;
import com.akshay.GroceryMarketProject.Service.StockItemService;
import com.akshay.GroceryMarketProject.Service.StockService;
import com.akshay.GroceryMarketProject.Service.VendorService;



@Controller
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private StockItemService stockItemService;

	@Autowired
	private StockService stockService;
	
	// display list of vendors
    @GetMapping("/vendor")
    public String viewHomePage(Model model) {
    	//List<Vendor> vendors = vendorService.getAllVendor();
		model.addAttribute("listVendors", vendorService.getAllVendor());
	    return "vendorList";
		
        
    }
	
	@GetMapping("/vendor/showNewVendorForm")
	public String showNewVendorForm(Model model) {
		// create model attribute to bind form data
		Vendor vendor = new Vendor();
		model.addAttribute("vendor", vendor);
		return "vendor_new";
	}
	
	@PostMapping("/vendor/saveVendor")
	public String saveVendor(@ModelAttribute("vendor") Vendor vendor) {
		// save vendor to database
		vendorService.saveVendor(vendor);
		return "redirect:/vendor";
	}
	
	
	
	@GetMapping("/vendor/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		Vendor vendor=vendorService.getVendorById(id);
		// set vendor as a model attribute to pre-populate the form
		model.addAttribute("vendor", vendor);
		return "vendor_update";
	}
	
	@GetMapping("/vendor/deleteVendor/{id}")
	public String deleteVendor(@PathVariable (value = "id") int id) {
		
		// call delete employee method 
		this.vendorService.deleteVendorById(id);
		return "redirect:/vendor";
	}
	
	
}
