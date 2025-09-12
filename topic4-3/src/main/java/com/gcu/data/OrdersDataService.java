package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity>{
	
	private OrdersRepository ordersRepository;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	// Constructor injection
	@Autowired
	public OrdersDataService(OrdersRepository ordersRepository, DataSource dataSource) {
		this.ordersRepository = ordersRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<OrderEntity> findAll() {
		try {
			List<OrderEntity> orders= new ArrayList<>();
			Iterable<OrderEntity> orderIterable = ordersRepository.findAll();
			orderIterable.forEach(orders::add);
			return orders;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	
	@Override
	public OrderEntity findById(int id) {
		return null;
	}
	
	@Override
    public boolean create(OrderEntity order) {
        try {
            String sql = "INSERT INTO ORDERS (ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES (?, ?, ?, ?)";
            int rows = jdbcTemplateObject.update(sql,
                    order.getOrderNo(),
                    order.getProductName(),
                    order.getPrice(),
                    order.getQuantity());

            return rows == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
	
	@Override
	public boolean update(OrderEntity order) {
		return true;
	}
	
	@Override
	public boolean delete(OrderEntity order) {
		return true;
	}
}
