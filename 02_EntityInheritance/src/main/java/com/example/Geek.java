package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_GEEK")
public class Geek extends Person {
	
	@Column(name = "FAV_PROG_LANG")
	private String favouriteProgrammingLanguage;
	
	
	public String getFavouriteProgrammingLanguage() {
			return favouriteProgrammingLanguage;
	}
	public void setFavouriteProgrammingLanguage(String favouriteProgrammingLanguage) {
		this.favouriteProgrammingLanguage = favouriteProgrammingLanguage;
	}
}
