package com.cyb.spring.boot.retry.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.spring.boot.retry.service.InventoryService;

@RestController
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private InventoryService inventoryService;

	@GetMapping("createOrder")
	public String createOrder(int num) {
		int remain = inventoryService.reduce(num);
		logger.info("剩余的数量: {}", remain);
		return "减库存成功";
	}

}
