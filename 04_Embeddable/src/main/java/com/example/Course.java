package com.example;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Course {
	
	@Column(name = "COURSE_NAME")
	private String coursename;
	
	@Column(name = "DESCRIPTION")
	private String description;

	
	//getter, setter
}
