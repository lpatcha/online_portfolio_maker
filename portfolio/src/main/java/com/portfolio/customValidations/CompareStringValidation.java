package com.portfolio.customValidations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.auth0.jwt.interfaces.Payload;
import jakarta.validation.Constraint;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CompareStringValidator.class)
@Documented
public @interface CompareStringValidation {

	String message() default "The Provided 2 Strings are not equal";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}
 