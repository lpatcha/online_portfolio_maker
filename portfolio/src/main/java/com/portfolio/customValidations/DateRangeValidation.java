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
@Constraint(validatedBy = DateRangeValidator.class)
@Documented
public @interface DateRangeValidation {

	
	String message() default "Please enter valid start date and end date, start date should be less then end date";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };

	
}
