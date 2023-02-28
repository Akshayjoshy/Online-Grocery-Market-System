package com.akshay.GroceryMarketProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akshay.GroceryMarketProject.Model.ItemCategory;



@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Integer> {

}
