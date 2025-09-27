package com.gcu.business;

import java.util.List;

import com.gcu.model.OrderModel;

public interface OrdersBusinessServiceInterface {
	void test();
	
	List<OrderModel> getOrders();
	
	OrderModel getOrderById(String id); // new method for prt 2
	
	void init();
	void destroy();
}
