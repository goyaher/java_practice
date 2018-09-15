package test.clone;

import java.util.Date;

public class ClonePerformance {
	
	public static void main(String args[]) throws Exception
	{
		Customer customer = new Customer(12, "Hershit", new Date(System.currentTimeMillis()), Boolean.TRUE);
//		System.out.println("Original Customer = \n" + customer + ", Hashcode = " + customer.hashCode());
		int times = 10000;
		System.out.println("Times=" + times);
		
		Long startTime = System.currentTimeMillis();
		cloneUsingCloneable(customer, times);
		Long endTime = System.currentTimeMillis();
		System.out.println("Time taken, cloneUsingCloneable = " + (endTime-startTime) + " msecs.");
		
		startTime = System.currentTimeMillis();
		cloneUsingCopyConstructor(customer, times);
		endTime = System.currentTimeMillis();
		System.out.println("Time taken, cloneUsingCopyConstructor = " + (endTime-startTime)  + " msecs.");
		
		startTime = System.currentTimeMillis();
		cloneUsingSerialization(customer, times);
		endTime = System.currentTimeMillis();
		System.out.println("Time taken, cloneUsingSerialization = " + (endTime-startTime)  + " msecs.");
	}
	
	private static void cloneUsingCloneable(Customer customer, int times) throws CloneNotSupportedException
	{
		Customer clonedCustomer = (Customer) customer.clone();
//		System.out.println("Cloned Customer, cloneUsingCloneable = \n" + clonedCustomer + ", Hashcode = " + clonedCustomer.hashCode());
			
		for (int i=0; i<times; i++)
		{
			clonedCustomer = (Customer)customer.clone();
		}
	}
	
	private static void cloneUsingCopyConstructor(Customer customer, int times) throws CloneNotSupportedException
	{
		Customer clonedCustomer = new Customer(customer);
//		System.out.println("Cloned Customer, cloneUsingCopyConstructor = \n" + clonedCustomer + ", Hashcode = " + clonedCustomer.hashCode());
			
		for (int i=0; i<times; i++)
		{
			clonedCustomer = new Customer(customer);
		}
	}
	
	private static void cloneUsingSerialization(Customer customer, int times) throws Exception
	{
		Customer clonedCustomer = (Customer) ObjectCopyUtil.deepCopy(customer);
//		System.out.println("Cloned Customer, cloneUsingSerialization = \n" + clonedCustomer + ", Hashcode = " + clonedCustomer.hashCode());
			
		for (int i=0; i<times; i++)
		{
			clonedCustomer = (Customer) ObjectCopyUtil.deepCopy(customer);
		}
	}

}
