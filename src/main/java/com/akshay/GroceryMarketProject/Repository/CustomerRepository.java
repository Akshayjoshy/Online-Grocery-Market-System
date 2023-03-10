package com.akshay.GroceryMarketProject.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.akshay.GroceryMarketProject.Model.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query("SELECT c FROM Customer AS c WHERE c.custDateOfJoin= ?1 ")
	List<Customer> findCustomersOnDate(Date date);
	
	@Query("SELECT c FROM Customer AS c WHERE c.custDateOfJoin>= ?1 ")
	List<Customer> findCustomersAfterDate(Date date);

}
