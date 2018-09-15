package com.springhibernateexample.generated;
// Generated Jul 6, 2018 11:16:07 AM by Hibernate Tools 5.3.0.Beta2

import java.util.Date;

/**
 * IssueDetails generated by hbm2java
 */
public class IssueDetails implements java.io.Serializable {

	private int id;
	private Book book;
	private User user;
	private Date issueDate;
	private Date issuedUntil;

	public IssueDetails() {
	}

	public IssueDetails(int id, Book book, User user, Date issueDate, Date issuedUntil) {
		this.id = id;
		this.book = book;
		this.user = user;
		this.issueDate = issueDate;
		this.issuedUntil = issuedUntil;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getIssuedUntil() {
		return this.issuedUntil;
	}

	public void setIssuedUntil(Date issuedUntil) {
		this.issuedUntil = issuedUntil;
	}

}
