package com.ds.web.rs.common.exception;

/**
 * Exception class for WEB RS
 * @author Sarvesh.Dubey@hotmail.com
 */
public class WebRSException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private WebRSExceptionType webRsExceptionType;
	
	private String detaildMsg;
	
	/**
	 * Constructs WEB RS exception using {@link WebRSExceptionType}
	 * @param exceptionType
	 */
	public WebRSException(WebRSExceptionType exceptionType) {
		this.webRsExceptionType = exceptionType;
	}
	
	/**
	 * Constructs WEB RS exception using {@link WebRSExceptionType} and a detailed message
	 * @param exceptionType
	 * @param detailedMsg
	 */
	public WebRSException(WebRSExceptionType exceptionType, String detailedMsg) {
		super(detailedMsg);
		this.webRsExceptionType = exceptionType;
		this.detaildMsg = detailedMsg;
	}
	
	public WebRSExceptionType getWebRSExceptionType() {
		return webRsExceptionType;
	}

	public String getDetaildMsg() {
		return detaildMsg;
	}
	

}
