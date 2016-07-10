package com.ds.web.rs.model;

import org.hibernate.validator.constraints.NotBlank;

import com.ds.web.rs.model.request.BaseRequest;

public class Greetings extends BaseRequest {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String msg;
	
	public Greetings() {
	}
	
	public Greetings(String name, String msg) {
		this.name = name;
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Greetings [name=" + name + ", msg=" + msg + "]";
	}
	
}
