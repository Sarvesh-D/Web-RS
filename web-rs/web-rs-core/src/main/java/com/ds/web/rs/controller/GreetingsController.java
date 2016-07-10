package com.ds.web.rs.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ds.web.rs.common.validation.GreetingsValidator;
import com.ds.web.rs.common.validation.Validate;
import com.ds.web.rs.model.Greetings;
import com.ds.web.rs.service.GreetingsService;

@RestController
public class GreetingsController {
	
	@Autowired
	private GreetingsService greetingsService;
	
	private static final Logger logger = LoggerFactory.getLogger(GreetingsController.class); 
	
	@RequestMapping(name="greet", method=RequestMethod.POST)
	@Validate(validator = GreetingsValidator.class)
	public Greetings getGreeting(@Valid @RequestBody Greetings greetings, BindingResult result) {
		return greetingsService.getGreetingService(greetings.getName(),greetings.getMsg());
	}
	
}
