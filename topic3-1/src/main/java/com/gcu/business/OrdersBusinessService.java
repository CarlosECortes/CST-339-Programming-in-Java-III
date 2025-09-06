package com.gcu.business;

import java.util.Arrays;
import java.util.List;

import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface{
	@Override
	public void test() {
		System.out.println("Hello from the OrdersBusinessService");
	}
	
	@Override
	public List<OrderModel> getOrders() {
		return Arrays.asList(
			new OrderModel(1L, "A1001", "Sword of Destiny", 199.99f, 1),
			new OrderModel(2l, "A1002", "Mjolnir", 49.99f, 2),
			new OrderModel(3L, "A1003", "Blade of Truth", 29.99f, 4)
				);
	}
}