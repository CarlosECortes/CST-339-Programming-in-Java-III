package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;

@Configuration
public class SpringConfig {
	// When the Spring container creates the bean it calls init() when it shuts down it calls destroy()
//	@Bean(name = "ordersBusinessService", initMethod = "init", destroyMethod = "destroy")
	
	//public OrdersBusinessServiceInterface getOrdersBusiness() {
	//	return new OrdersBusinessService();
	//}
}