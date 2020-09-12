package com.cyb.spring.boot.i18n.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping("hello")
	public String hello() {
		return "Hello, " + messageSource.getMessage("user.name", null, LocaleContextHolder.getLocale());
	}
}
