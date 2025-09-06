package com.gcu.business;

import java.util.Arrays;
import java.util.List;

import com.gcu.model.OrderModel;

public class AnotherOrdersBusinessService implements OrdersBusinessServiceInterface {
	@Override
	public void test() {
		System.out.println("Hello from the AnotherBusinessService");
	}
	
	@Override
	public List<OrderModel> getOrders() {
		return Arrays.asList(
			new OrderModel(10L, "B2001", "Compass of Light", 12.99f, 3),
			new OrderModel(11L, "B2002", "Map of Shadows", 4.99f, 5)
				);
	}
}