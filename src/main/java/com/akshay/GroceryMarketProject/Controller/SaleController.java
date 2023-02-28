package com.akshay.GroceryMarketProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.akshay.GroceryMarketProject.Model.Sale;
import com.akshay.GroceryMarketProject.Service.CustomerService;
import com.akshay.GroceryMarketProject.Service.ItemService;
import com.akshay.GroceryMarketProject.Service.SaleItemService;
import com.akshay.GroceryMarketProject.Service.SaleService;



@Controller
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private SaleItemService saleItemService;
	
	
    @GetMapping("/sale")
    public String viewHomePage(Model model) {
    	model.addAttribute("listSales", saleService.getAllSales());
	    return "sale_list";
		
        
    }
	
	@GetMapping("/sale/showNewSaleForm")
	public String showNewSaleForm(Model model) {
		// create model attribute to bind form data
		Sale sale=new Sale();
		model.addAttribute("sale", sale);
		model.addAttribute("items", itemService.getAllItems());

		model.addAttribute("customers", customerService.getAllCustomer());
		return "sale_new";
	}
	
	@PostMapping("/sale/saveSale")
	public String saveSale(@ModelAttribute("sale") Sale sale,Model model) {
		// save sale to database
		Sale saleout=saleService.saveSale(sale);
		
		return "redirect:/saleItem/showNewSaleItemForm/"+saleout.getsId();
	}
	
	@PostMapping("/sale/saveSaleUpdate")
	public String saveSaleUpdate(@ModelAttribute("sale") Sale sale,Model model) {
		// save sale to database
		Sale saleout=saleService.saveSale(sale);
		
		return "redirect:/saleItem/"+saleout.getsId();
	}
	
	
	
	@GetMapping("/sale/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		Sale sale=saleService.getSaleById(id) ;
		model.addAttribute("sale", sale);
		model.addAttribute("items", itemService.getAllItems());
		return "sale_update";
	}
	
	@GetMapping("/sale/deleteSale/{id}")
	public String deleteSale(@PathVariable (value = "id") int id) {
		//this.saleItemService.deleteSaleItemBySaleId(id);
		// call delete  method 
		this.saleService.deleteSaleById(id);
		return "redirect:/sale";
	}
	
	
}