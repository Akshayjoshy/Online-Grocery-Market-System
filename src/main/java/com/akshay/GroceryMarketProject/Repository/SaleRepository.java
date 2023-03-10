package com.akshay.GroceryMarketProject.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.akshay.GroceryMarketProject.Model.Sale;



@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

	@Query("SELECT c FROM Sale AS c WHERE c.sDate= ?1 ")
	List<Sale> findSalesOnDate(Date date);
	
	@Query("SELECT c FROM Sale AS c WHERE c.sDate>= ?1 ")
	List<Sale> findSalesAfterDate(Date date);
}
