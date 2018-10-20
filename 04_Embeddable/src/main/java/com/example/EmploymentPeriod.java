package com.example;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmploymentPeriod {
	
	@Column(name = "START_DATE")
	private java.sql.Date startDate;

	@Column(name = "END_DATE")
	private java.sql.Date endDate;
	
	
	//getter, setter
}
