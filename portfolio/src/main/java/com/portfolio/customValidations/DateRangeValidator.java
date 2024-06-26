package com.portfolio.customValidations;

import com.portfolio.dto.DateRangeDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<DateRangeValidation, DateRangeDto>{
	@Override
	  public boolean isValid(DateRangeDto dateRangeDto, ConstraintValidatorContext context) {
		System.out.println("called");
		if(!(dateRangeDto.getStartDate().compareTo(dateRangeDto.getEndDate()) <= 0)) {
			
			return false;
		}
		
		return true;
	}

}
