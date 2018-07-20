package com.springhibernateexample.generated;
// Generated Jul 6, 2018 11:16:07 AM by Hibernate Tools 5.3.0.Beta2

import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private int id;
	private String shortId;
	private String name;
	private String class_;
	private Set issueDetailses = new HashSet(0);

	public User() {
	}

	public User(int id, String shortId, String name) {
		this.id = id;
		this.shortId = shortId;
		this.name = name;
	}

	public User(int id, String shortId, String name, String class_, Set issueDetailses) {
		this.id = id;
		this.shortId = shortId;
		this.name = name;
		this.class_ = class_;
		this.issueDetailses = issueDetailses;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShortId() {
		return this.shortId;
	}

	public void setShortId(String shortId) {
		this.shortId = shortId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public Set getIssueDetailses() {
		return this.issueDetailses;
	}

	public void setIssueDetailses(Set issueDetailses) {
		this.issueDetailses = issueDetailses;
	}

}
