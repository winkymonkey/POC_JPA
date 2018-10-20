package com.example.aManyToOne_unidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_ORDER_ITEM")
@SequenceGenerator(name = "ORDER_ITEM_SEQUENCE", sequenceName = "ORDER_ITEM_SEQUENCE", allocationSize = 1)
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_ITEM_SEQUENCE")
	@Column(name = "ORDER_ITEM_ID")
	private long orderItemId;

	@Column(name = "QUANTITY")
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "fk_orderId") // If we want to use any custom name for the "foreign key" field
	private Order order;
	
	
	// Getter, Setter
}
