package com.apex.rewards.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.apex.rewards.data.RewardsData;
import com.apex.rewards.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/rewards/{id}")
	public RewardsData retrieveRewards(@PathVariable int id) {
		return orderService.getRewardsData();
	}

	
	
}
