package com.example.d_oneTOone.a_uniDirectional;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "T_CUSTOMER")
public class Customer {

	@OneToOne
	@JoinColumn(name="fk_addr")
	private Address address;

	//Getter, Setter
}
