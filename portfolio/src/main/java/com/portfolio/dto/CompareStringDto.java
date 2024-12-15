package com.portfolio.dto;
import com.portfolio.customValidations.CompareStringValidation;

@CompareStringValidation()
public class CompareStringDto {
	String firstString;
	String secoundString;
	
	public CompareStringDto(String firstString, String secoundString) {
		super();
		this.firstString = firstString;
		this.secoundString = secoundString;
	}
	public String getFirstString() {
		return firstString;
	}
	public void setFirstString(String firstString) {
		this.firstString = firstString;
	}
	public String getSecoundString() {
		return secoundString;
	}
	public void setSecoundString(String secoundString) {
		this.secoundString = secoundString;
	}
	
}
