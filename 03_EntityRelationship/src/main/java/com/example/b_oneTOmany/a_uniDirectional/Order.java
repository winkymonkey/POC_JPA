package com.example.b_oneTOmany.a_uniDirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

	@OneToMany
	@JoinColumn(name = "fk_order")
	private List<OrderItem> items = new ArrayList<OrderItem>();
	
	//Getter, Setter
}
