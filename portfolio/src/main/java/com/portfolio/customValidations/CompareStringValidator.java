package com.portfolio.customValidations;
import com.portfolio.dto.CompareStringDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CompareStringValidator implements ConstraintValidator<DateRangeValidation, CompareStringDto>{

	@Override
	public boolean isValid(CompareStringDto value, ConstraintValidatorContext context) {
		
		if(value.getFirstString().equals(value.getSecoundString()))
			return false;
		
		return true;
	}

}
