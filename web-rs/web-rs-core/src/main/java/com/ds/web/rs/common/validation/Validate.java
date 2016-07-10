package com.ds.web.rs.common.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.validation.BindingResult;

import com.ds.web.rs.model.request.BaseRequest;

/**
 * Annotation for annotating a method whose parameters needs to be validated<br>
 * The annotated method must contain one parameter of type {@link BaseRequest}
 * and one parameter of type {@link BindingResult}
 * @author Sarvesh.Dubey@hotmail.com
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Validate {
	
	/**
	 * validator class which will be used to validate some type of {@link BaseRequest} 
	 */
	Class<? extends AbstractValidator<?>> validator();

}
