package com.example.d_oneTOone.a_uniDirectional;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "T_ADDRESS")
public class Address {
	
	private Customer customer;
	
	//Getter, Setter
}
