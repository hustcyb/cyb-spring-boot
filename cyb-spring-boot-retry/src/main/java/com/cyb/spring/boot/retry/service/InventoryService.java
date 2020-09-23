package com.cyb.spring.boot.retry.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class InventoryService {

	private static final Logger logger = LoggerFactory.getLogger(InventoryService.class);

	private final int total = 100;

	@Retryable(value = IllegalArgumentException.class, maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 2))
	public int reduce(int num) {
		logger.info("开始减库存");
		Assert.isTrue(num <= total, "数据超过库存数目");
		return total - num;
	}
	
	@Recover
	public int recover(IllegalArgumentException exception) {
		logger.warn(exception.getMessage());
		return 0;
	}
}
