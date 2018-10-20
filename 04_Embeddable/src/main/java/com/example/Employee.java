package com.example;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "T_EMPLOYEE")
public class Employee {

	@Id
	@Column(name = "EMP_ID")
	private long empId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "SALARY")
	private BigDecimal salary;

	@Embedded
	private EmploymentPeriod period;

	@ElementCollection
	@CollectionTable(name = "employee_courses", 
					joinColumns = @JoinColumn(name = "empId"))
	private Set<Course> courses = new HashSet<Course>();
	
	
	// getter, setter
}
