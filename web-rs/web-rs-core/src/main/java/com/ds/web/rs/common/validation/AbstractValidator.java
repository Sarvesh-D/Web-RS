package com.ds.web.rs.common.validation;

import org.springframework.validation.Validator;

/**
 * This class MUST be extended by any custom validator
 * @author Sarvesh.Dubey@hotmail.com
 * @param <T> Type which will be validated by this validator
 */
public abstract class AbstractValidator<T> implements Validator {
	
	private T validatorFor;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return validatorFor.getClass().isAssignableFrom(clazz);
	}
	

}
