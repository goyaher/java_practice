package test.clone;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Cloneable, Serializable
{
	private static final long serialVersionUID = 7542778906398208854L;

	private Integer age;
	
	private String firstName;
	
	private Date dob;
	
	private Boolean isMarried;
	
	public Customer(Integer age, String firstName, Date dob, Boolean isMarried)
	{
		this.age = age;
		this.firstName = firstName;
		this.dob = dob;
		this.isMarried = isMarried;
	}
	
	public Customer(Customer customer)
	{
		this.age = customer.age; 
		this.firstName = customer.firstName;
		this.dob = new Date(customer.dob.getTime());
		this.isMarried = customer.isMarried;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Boolean getIsMarried() {
		return isMarried;
	}

	public void setIsMarried(Boolean isMarried) {
		this.isMarried = isMarried;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		Customer clone = (Customer)super.clone();
		
		return clone;
	}
	
	@Override
	public String toString() {
		return "Customer [age=" + age + ", firstName=" + firstName + ", dob="
				+ dob + ", isMarried=" + isMarried + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (isMarried == null) {
			if (other.isMarried != null)
				return false;
		} else if (!isMarried.equals(other.isMarried))
			return false;
		return true;
	}
}
