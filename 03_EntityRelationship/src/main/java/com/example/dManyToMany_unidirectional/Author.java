package com.example.dManyToMany_unidirectional;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_AUTHOR")
@SequenceGenerator(name = "AUTHOR_SEQUENCE", sequenceName = "AUTHOR_SEQUENCE", allocationSize = 1)
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTHOR_SEQUENCE")
	@Column(name = "AUTHOR_ID")
	private long authorId;

	@ManyToMany
	@JoinTable(name = "author_to_book", 
				joinColumns = {@JoinColumn(name = "fk_author")}, 
				inverseJoinColumns = {@JoinColumn(name = "fk_book")})
	private Set<Book> books = new HashSet<Book>();
	
	
	//Getter, Setter
}
