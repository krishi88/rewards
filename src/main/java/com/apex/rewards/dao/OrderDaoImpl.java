package com.apex.rewards.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.apex.rewards.order.Order;

@Component
public class OrderDaoImpl implements OrderDao {
	 
	public List<Order> getOrders(){
		return OrderDaoHelper.randomOrders();
	}

}
