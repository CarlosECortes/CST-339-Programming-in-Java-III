package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.gcu.data.entity.OrderEntity;

public class OrderRowMapper implements RowMapper<OrderEntity>{
	
	@Override
	public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		// Create a new OrderEntity using values from the ResultSet
		return new OrderEntity(
				rs.getLong("ID"), // maps to id
				rs.getString("ORDER_NO"), // maps to orderNo
				rs.getString("PRODUCT_NAME"),  // maps to productName
				rs.getFloat("PRICE"),  //maps to price
				rs.getInt("QUANTITY")  // maps to quantity
				);
	}
}
