package com.ds.web.rs.common.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ds.web.rs.model.ErrorResponse;

/**
 * Controller Advice to handle exceptions and return {@link ErrorResponse}
 * @author Sarvesh.Dubey@hotmail.com
 */
@ControllerAdvice(annotations = RestController.class)
public class WebRSExceptionHandler {
	
	@Autowired
	private WebRSExceptionHelper webRSExceptionHelper;

	@ExceptionHandler(value = WebRSException.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handleException(WebRSException exception) {
		return new ResponseEntity<ErrorResponse>(buildErrorResponse(exception),exception.getWebRSExceptionType().getHttpStatus());
	}
	
	private ErrorResponse buildErrorResponse(WebRSException exception) {
		final String exceptionCode = exception.getWebRSExceptionType().getExceptionCode();
		return new ErrorResponse(exceptionCode, webRSExceptionHelper.getExceptionMsg(exceptionCode), exception.getDetaildMsg());
	}
	

}
