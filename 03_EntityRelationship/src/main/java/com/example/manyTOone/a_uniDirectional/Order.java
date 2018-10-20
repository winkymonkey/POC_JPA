package com.example.manyTOone.a_uniDirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_ORDER")
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	private long orderId;

	@Column(name = "TOTAL_PRICE")
	private double totalPrice;
	
	//Getter, Setter
}
