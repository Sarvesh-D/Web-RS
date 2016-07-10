package com.ds.web.rs.common.validation;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.ds.web.rs.model.Greetings;

@Component
public class GreetingsValidator extends AbstractValidator<Greetings> {

	@Override
	public void validate(Object target, Errors errors) {
		Greetings greetings = Greetings.class.cast(target);
		if(StringUtils.contains(greetings.getMsg(), " "))
			errors.rejectValue("msg", null, "should not contains space");
	}

}
