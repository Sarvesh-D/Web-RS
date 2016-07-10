package com.ds.web.rs.common.exception;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Sarvesh.Dubey@hotmail.com
 *
 */
@Component
public class WebRSExceptionHelper {
	
	@Autowired
	private Properties errorDetails;
	
	String getExceptionMsg(String exceptionCode) {
		return errorDetails.getProperty(exceptionCode);
	}

}
