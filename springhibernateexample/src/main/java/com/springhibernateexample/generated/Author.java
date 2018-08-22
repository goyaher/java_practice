package com.springhibernateexample.generated;
// Generated Jul 6, 2018 11:16:07 AM by Hibernate Tools 5.3.0.Beta2

import java.util.HashSet;
import java.util.Set;

/**
 * Author generated by hbm2java
 */
public class Author implements java.io.Serializable {

	private int id;
	private String name;
	private char gender;
	private String country;
	private Set bookAuthors = new HashSet(0);

	public Author() {
	}

	public Author(int id, String name, char gender, String country) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.country = country;
	}

	public Author(int id, String name, char gender, String country, Set bookAuthors) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.country = country;
		this.bookAuthors = bookAuthors;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return this.gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set getBookAuthors() {
		return this.bookAuthors;
	}

	public void setBookAuthors(Set bookAuthors) {
		this.bookAuthors = bookAuthors;
	}

}