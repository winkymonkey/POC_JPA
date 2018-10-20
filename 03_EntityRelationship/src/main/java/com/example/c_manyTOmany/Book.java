package com.example.c_manyTOmany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_BOOK")
public class Book {
	
	@Id
	@GeneratedValue
	@Column(name = "BOOK_ID")
	private long bookId;
	
	@ManyToMany(mappedBy = "books")
	private Set<Author> stores = new HashSet<Author>();
	
	//Getter, Setter
}
