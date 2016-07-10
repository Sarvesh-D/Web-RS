package com.ds.web.rs.common.exception;

import org.springframework.http.HttpStatus;

/**
 * WEB RS Exception type with details containing error code and HttpStatus
 * @author Sarvesh.Dubey@hotmail.com
 */
public enum WebRSExceptionType {
	
	BAD_REQUEST("WEBRS001",HttpStatus.BAD_REQUEST),
	RECORD_ALREADY_EXIST("WEBRS002",HttpStatus.ALREADY_REPORTED);
	
	private String exceptionCode;
	private HttpStatus httpStatus;
	
	private WebRSExceptionType(String exceptionCode, HttpStatus httpStatus) {
		this.exceptionCode = exceptionCode;
		this.httpStatus = httpStatus;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	

}
