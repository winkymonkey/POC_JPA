package com.example.dManyToMany_unidirectional;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_BOOK")
@SequenceGenerator(name = "BOOK_SEQUENCE", sequenceName = "BOOK_SEQUENCE", 
					allocationSize = 1)
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_SEQUENCE")
	@Column(name = "BOOK_ID")
	private long bookId;
	
	@ManyToMany(mappedBy = "books")
	private Set<Author> stores = new HashSet<Author>();
	
	
	//Getter, Setter
}
