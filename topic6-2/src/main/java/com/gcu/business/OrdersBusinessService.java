package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.OrdersDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

@Service
public class OrdersBusinessService implements OrdersBusinessServiceInterface {
	
    @Autowired
    private OrdersDataService service;

    @Override
    public void init() {
        System.out.println("OrdersBusinessService init() called");
    }

    @Override
    public void destroy() {
        System.out.println("OrdersBusinessService destroy() called");
    }
    
    @Override
    public void test() {
        System.out.println("OrdersBusinessService test() called");
    }

    @Override
    public List<OrderModel> getOrders() {
        try {
            // Get list of entities from data service
            List<OrderEntity> ordersEntity = service.findAll();

            // Convert entities to domain models
            List<OrderModel> ordersDomain = new ArrayList<>();
            for (OrderEntity entity : ordersEntity) {
                ordersDomain.add(new OrderModel(
                        entity.getId(),
                        entity.getOrderNo(),
                        entity.getProductName(),
                        entity.getPrice(),
                        entity.getQuantity()
                ));
            }
            return ordersDomain;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
    
    @Override public OrderModel getOrderById(String id) {
    	try {
    		// Get entity by ID
    		OrderEntity entity = service.findById(id);
    		
    		if (entity != null) {
    			// Convert to domain model 
    			return new OrderModel(
    					entity.getId(),
    					entity.getOrderNo(),
    					entity.getProductName(),
    					entity.getPrice(),
    					entity.getQuantity()
    					);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null;  // Return null if not found
    }
}
