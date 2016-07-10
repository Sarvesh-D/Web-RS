package com.ds.web.rs.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ds.web.rs.model.Greetings;
import com.ds.web.rs.persistence.dao.GreetingsDao;


@Service
public class GreetingsService {
	
	private GreetingsDao greetingsDao = new GreetingsDao();
	
	@Cacheable("Greetings")
	public Greetings getGreetingService(String name, String message) {
		return greetingsDao.getGreeting(name,message);
	}
	

}
