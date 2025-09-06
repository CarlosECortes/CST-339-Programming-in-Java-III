package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.business.AnotherOrdersBusinessService;
import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;

@Configuration
public class SpringConfig {
	// Step 6 will set which implementation we return here
	@Bean(name = "ordersBusinessService")
	public OrdersBusinessServiceInterface getOrdersBusiness() {
		return new AnotherOrdersBusinessService();
	}
}