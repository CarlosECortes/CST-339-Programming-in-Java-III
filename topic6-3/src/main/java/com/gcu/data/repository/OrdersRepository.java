package com.gcu.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.OrderEntity;

public interface OrdersRepository extends MongoRepository<OrderEntity, String>{
	// MongoDB automatically provides all CRUD methods
	
	// Custom query method
	public OrderEntity getOrderById(String id);
}
