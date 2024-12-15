package com.portfolio.dto;

import java.sql.Date;

import com.portfolio.customValidations.DateRangeValidation;

@DateRangeValidation()
public class DateRangeDto {
		Date startDate;
		Date endDate;
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		public DateRangeDto(Date startDate, Date endDate) {
			super();
			this.startDate = startDate;
			this.endDate = endDate;
		}
		
}
