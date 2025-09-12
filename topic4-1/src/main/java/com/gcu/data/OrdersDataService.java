package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.gcu.model.OrderModel;

@Repository
public class OrdersDataService implements DataAccessInterface<OrderModel>{

	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public List<OrderModel> findAll() {
		String sql = "SELECT * FROM ORDERS";
		
		List<OrderModel> orders = new ArrayList<>();
		
		SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
		
		while (srs.next()) {
			OrderModel order = new OrderModel(
				srs.getLong("ID"),
				srs.getString("Order_NO"),
				srs.getString("PRODUCT_NAME"),
				srs.getFloat("PRICE"),
				srs.getInt("QUANTITY")
			);
			orders.add(order);
		}
		
		return orders;
	}
	
	@Override
	public OrderModel findById(int id) {
		return null;
	}
	
	@Override
	public boolean create(OrderModel order) {
	    // i) SQL INSERT statement
	    String sql = "INSERT INTO ORDERS (ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES (?, ?, ?, ?)";

	    int rows = 0;
	    try {
	        // ii) Execute INSERT with parameters from the model
	        rows = jdbcTemplateObject.update(
	            sql,
	            order.getOrderNo(),
	            order.getProductName(),
	            order.getPrice(),
	            order.getQuantity()
	        );
	    }
	    catch (Exception e) {
	        // iii) Print the stack trace for now
	        e.printStackTrace();
	    }

	    // iv) Return true if exactly one row was inserted
	    return rows == 1;
	}
	
	@Override
	public boolean update(OrderModel t) {
		return false;
	}
	
	@Override
	public boolean delete(OrderModel t) {
		return false;
	}
}
