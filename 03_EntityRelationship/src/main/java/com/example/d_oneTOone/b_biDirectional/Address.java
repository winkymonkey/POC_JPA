package com.example.d_oneTOone.b_biDirectional;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "T_ADDRESS")
public class Address {
	
	@OneToOne(mappedBy="address")
	private Customer customer;
	
	//Getter, Setter
}
