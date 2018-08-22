package test.clone;

import java.util.Date;

public class PrimaryCustomer extends Customer {
	
	private static final long serialVersionUID = -2070213431519845787L;
	
	private String customerClass;
	
	public PrimaryCustomer(String cClass, Integer age, String firstName, Date dob, Boolean isMarried)
	{
		super(age, firstName, dob, isMarried);
		this.customerClass = cClass;
	}

	@Override
	public String toString() {
		return "PrimaryCustomer [customerClass=" + customerClass
				+ ", Customer()=" + super.toString() + "]";
	}
	
	

}
