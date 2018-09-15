package test.clone;

import java.util.Date;

public class CloneInheritance {
	
	public static void main(String args[]) throws CloneNotSupportedException
	{
		//Test Clone For Inheritance
		Customer pCustomer = new PrimaryCustomer("Primary", 12, "Hershit", new Date(System.currentTimeMillis()), Boolean.TRUE);
		Customer clonedPCustomer = (Customer)pCustomer.clone();
		
		System.out.println(clonedPCustomer);
	}

}
