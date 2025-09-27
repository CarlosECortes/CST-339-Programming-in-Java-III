package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "orders")
public class OrderList {
	private List<OrderModel> orders = new ArrayList<>();
	
	public List<OrderModel> getOrders() {
		return orders;
	}
	
	public void setOrders(List<OrderModel> orders) {
		this.orders = orders;
	}
}
