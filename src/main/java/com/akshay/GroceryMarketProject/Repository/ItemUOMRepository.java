package com.akshay.GroceryMarketProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akshay.GroceryMarketProject.Model.ItemUOM;



@Repository
public interface ItemUOMRepository extends JpaRepository<ItemUOM, Integer> {

}
