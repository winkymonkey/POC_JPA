package com.example.b_oneTOmany.a_uniDirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_ORDER_ITEM")
public class OrderItem {

	@Id
	@GeneratedValue
	@Column(name = "ORDER_ITEM_ID")
	private long orderItemId;

	@Column(name = "QUANTITY")
	private int quantity;

	// Getter, Setter
}
