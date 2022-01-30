package com.example.demo.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Item;
import com.example.demo.domain.Order; 
public interface  ItemRepository extends CrudRepository<Item, String> {

	@Query("select i from Item i where i.price = :price ")
	List<Item> findByPrice(@Param("price") double price );
	
	//@Query("select i from Item i where i.orderid = :orderID ")
	List<Item> findItemsByOrder(Order order );	
}
