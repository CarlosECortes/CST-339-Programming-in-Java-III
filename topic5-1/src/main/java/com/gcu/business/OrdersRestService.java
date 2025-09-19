package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.OrderList;
import com.gcu.model.OrderModel;

@RestController
@RequestMapping("/service")
public class OrdersRestService {
	
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	// JSON end point
	@GetMapping(value = "/getjson", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderModel> getOrdersAsJson() {
		return service.getOrders();
	}

	// XMML end point
	@GetMapping(value = "/getxml", produces = MediaType.APPLICATION_XML_VALUE)
	public OrderList getOrdersAsXml() {
		OrderList list = new OrderList();
		list.setOrders(service.getOrders());
		return list;
	}
	
	// New: get single order by ID
	@GetMapping("/getorder/{id}")
	public ResponseEntity<OrderModel> getOrder(@PathVariable("id") String id){
		try {
			// Call service to get the order
			OrderModel order = service.getOrderById(id);
			
			// If no order found, return 404
			if (order == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			// If order found, return 200 with order
			return new ResponseEntity<>(order, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// Return 500 if something unexpected happens
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
