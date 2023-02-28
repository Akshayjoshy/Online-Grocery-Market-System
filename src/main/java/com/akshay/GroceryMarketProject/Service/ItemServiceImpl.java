package com.akshay.GroceryMarketProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.GroceryMarketProject.Model.Item;
import com.akshay.GroceryMarketProject.Repository.ItemRepository;



@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemRepository itemRepository;
	
	

	@Override
	public List<Item> getAllItems() {
				return itemRepository.findAll();
	}

	@Override
	public void saveItem(Item item) {
		itemRepository.save(item);
		
	}

	@Override
	public Item getItemById(int id) {
		Optional<Item> optional=itemRepository.findById( id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new RuntimeException("Item not found");
		}
	}

	@Override
	public void deleteItemById(int id) {
		this.itemRepository.deleteById(id);
		
	}

}
