package com.ds.web.rs.model;

public class ErrorResponse {
	
	private String errorCode;
	
	private String errorMsg;
	
	private String detailedMsg;
	
	public ErrorResponse(String errorCode, String errorMsg, String detailedMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.detailedMsg = detailedMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getDetailedMsg() {
		return detailedMsg;
	}

	public void setDetailedMsg(String detailedMsg) {
		this.detailedMsg = detailedMsg;
	}
	

}
