package com.springhibernateexample.generated;
// Generated Jul 6, 2018 11:16:07 AM by Hibernate Tools 5.3.0.Beta2

import java.util.HashSet;
import java.util.Set;

/**
 * Book generated by hbm2java
 */
public class Book implements java.io.Serializable {

	private int id;
	private Category category;
	private String name;
	private int copies;
	private Set issueDetailses = new HashSet(0);
	private Set bookAuthors = new HashSet(0);

	public Book() {
	}

	public Book(int id, Category category, String name, int copies) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.copies = copies;
	}

	public Book(int id, Category category, String name, int copies, Set issueDetailses, Set bookAuthors) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.copies = copies;
		this.issueDetailses = issueDetailses;
		this.bookAuthors = bookAuthors;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCopies() {
		return this.copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public Set getIssueDetailses() {
		return this.issueDetailses;
	}

	public void setIssueDetailses(Set issueDetailses) {
		this.issueDetailses = issueDetailses;
	}

	public Set getBookAuthors() {
		return this.bookAuthors;
	}

	public void setBookAuthors(Set bookAuthors) {
		this.bookAuthors = bookAuthors;
	}

}