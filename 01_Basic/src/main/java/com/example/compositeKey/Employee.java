package com.example.compositeKey;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name = "T_EMPL")
@IdClass(EmployeeID.class)
public class Employee {
	
	@Id
	private String branch;
	
	@Id
	private int id;
	
	@Column(name = "SALARY")
	private int salary;
}
