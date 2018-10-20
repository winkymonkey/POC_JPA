package com.example.c_manyTOmany.a_uniDirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_BOOK")
public class Book {
	
	@Id
	@GeneratedValue
	@Column(name = "BOOK_ID")
	private long bookId;
	
	//Getter, Setter
}
