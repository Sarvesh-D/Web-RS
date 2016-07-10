package com.ds.web.rs.common.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.ds.web.rs.common.exception.WebRSException;
import com.ds.web.rs.common.exception.WebRSExceptionType;
import com.ds.web.rs.common.validation.Validate;
import com.ds.web.rs.model.request.BaseRequest;



/**
 * Validation Aspect for validating requests
 * @author Sarvesh.Dubey@hotmail.com
 */
@Component
@Aspect
public class ValidationAspect {
	
	@Autowired
	private ApplicationContext context;
	
	@Pointcut("execution(* com.ds.web.rs..*(..)) && @annotation(validate)")
	private void allValidationMethods(Validate validate) {}
	
	@Before("allValidationMethods(validate)")
	public void doValidate(JoinPoint joinPoint, Validate validate) throws MethodArgumentNotValidException {
		Validator validator = getValidator(validate);
		Assert.notNull(validator, "Unable to get validator for "+validate.validator());
		
		Object toValidate = null;
		BindingResult bindingResult = null;
		
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			if(BaseRequest.class.isAssignableFrom(arg.getClass()))
				toValidate = arg;
			if(BindingResult.class.isAssignableFrom(arg.getClass()))
				bindingResult = (BindingResult) arg;
		}
		
		Assert.notNull(toValidate, "No parameter is of BaseRequest type which can be validated in method "+joinPoint.getSignature());
		Assert.notNull(bindingResult, "no parameter is of BindingResult type in method "+joinPoint.getSignature());
		
		validator.validate(toValidate, bindingResult);
		
		if(bindingResult.hasErrors()) {
			StringBuilder detailedMsg = new StringBuilder();
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				detailedMsg.append(fieldError.getField() +" "+ fieldError.getDefaultMessage());
				detailedMsg. append(" ; ");
			}
			throw new WebRSException(WebRSExceptionType.BAD_REQUEST, detailedMsg.toString());
		}
	}
	
	private Validator getValidator(Validate validate) {
		String validatorBeanName = StringUtils.uncapitalize(validate.validator().getSimpleName());
		return context.getBean(validatorBeanName, Validator.class);
	}

}
