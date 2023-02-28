package com.akshay.GroceryMarketProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akshay.GroceryMarketProject.Model.Item;



@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
