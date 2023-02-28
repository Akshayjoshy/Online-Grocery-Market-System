package com.akshay.GroceryMarketProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.akshay.GroceryMarketProject.Model.Item;
import com.akshay.GroceryMarketProject.Service.ItemCategoryService;
import com.akshay.GroceryMarketProject.Service.ItemService;
import com.akshay.GroceryMarketProject.Service.ItemUOMService;



@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemCategoryService itemCategoryService;
	
	@Autowired
	private ItemUOMService itemUOMService;
	
	
	
    @GetMapping("/item")
    public String viewHomePage(Model model) {
    	model.addAttribute("listItems", itemService.getAllItems());
	    return "item_list";
		
        
    }
	
	@GetMapping("/item/showNewItemForm")
	public String showNewItemForm(Model model) {
		// create model attribute to bind form data
		Item item=new Item();
		model.addAttribute("item", item);
		model.addAttribute("itemCategories", itemCategoryService.getAllItemCategory());
		model.addAttribute("itemUOMs",itemUOMService.getAllItemUOM());
		return "item_new";
	}
	
	@PostMapping("/item/saveItem")
	public String savecustomer(@ModelAttribute("item") Item item) {
		// save item to database
		itemService.saveItem(item);
		return "redirect:/item";
	}
	
	
	
	@GetMapping("/item/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		Item item=itemService.getItemById(id) ;
		model.addAttribute("item", item);
		model.addAttribute("itemCategories", itemCategoryService.getAllItemCategory());
		model.addAttribute("itemUOMs",itemUOMService.getAllItemUOM());
		return "item_update";
	}
	
	@GetMapping("/item/deleteItem/{id}")
	public String deleteItem(@PathVariable (value = "id") int id) {
		
		// call delete  method 
		this.itemService.deleteItemById(id);
		return "redirect:/item";
	}
	
	
}