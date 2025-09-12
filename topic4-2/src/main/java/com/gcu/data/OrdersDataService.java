package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity>{
	
	private OrdersRepository ordersRepository;
	
	// Constructor injection
	@Autowired
	public OrdersDataService(OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
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
			ordersRepository.save(order);
			return true;
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
