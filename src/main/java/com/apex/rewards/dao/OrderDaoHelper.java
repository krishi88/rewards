package com.apex.rewards.dao;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import com.apex.rewards.order.Order;

public class OrderDaoHelper {
	 
	static List<Order> randomOrders(){
		return Arrays.asList(
				new Order(101, "Order 1", 70.00d, LocalDate.of(2022, Month.MAY, 5)),//May orders
				new Order(102, "Order 2", 20d, LocalDate.of(2022, Month.MAY, 10)),
				new Order(103, "Order 3", 110.00d, LocalDate.of(2022, Month.MAY, 15)),
				new Order(104, "Order 4", 240.00d, LocalDate.of(2022, Month.MAY, 20)),
				new Order(105, "Order 5", 80.00d, LocalDate.of(2022, Month.APRIL, 5)),//April orders
				new Order(106, "Order 6", 30d, LocalDate.of(2022, Month.APRIL, 10)),
				new Order(107, "Order 7", 120.00d, LocalDate.of(2022, Month.APRIL, 15)),
				new Order(108, "Order 8", 250.00d, LocalDate.of(2022, Month.APRIL, 20)),
				new Order(109, "Order 9", 90.00d, LocalDate.of(2022, Month.MARCH, 5)),//March orders
				new Order(110, "Order 10", 40d, LocalDate.of(2022, Month.MARCH, 10)),
				new Order(111, "Order 11", 130.00d, LocalDate.of(2022, Month.MARCH, 15)),
				new Order(112, "Order 12", 260.00d, LocalDate.of(2022, Month.MARCH, 20))
				);
	}
}
