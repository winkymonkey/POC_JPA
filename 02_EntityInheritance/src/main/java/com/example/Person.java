package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_PERSON")
@SequenceGenerator(name="PERSON_SEQUENCE", sequenceName="PERSON_SEQUENCE", allocationSize=1)
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSON_SEQUENCE")
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "WEIGHT")
	private double weight;
	
	@Column(name = "AGE")
	private int age;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
