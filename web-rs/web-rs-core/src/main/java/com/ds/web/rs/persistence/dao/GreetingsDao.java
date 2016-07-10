package com.ds.web.rs.persistence.dao;

import org.springframework.stereotype.Repository;

import com.ds.web.rs.model.Greetings;

@Repository
public class GreetingsDao {
	
	public Greetings getGreeting(String name, String message) {
		return new Greetings(name, message+" !!!!");
	}

}
