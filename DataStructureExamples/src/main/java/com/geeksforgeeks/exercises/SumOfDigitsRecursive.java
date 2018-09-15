package com.geeksforgeeks.exercises;

public class SumOfDigitsRecursive {

	public static void main(String args[])
	{
		int n = 0;
		System.out.println(sumOfDigits(n));
	}
	
	/**
	 * sumOfDigits(n) = n%10 + sumOfDigits(n/10);
	 * sumOfDigits(n) = n; if n < 9;
	 * 
	 * @param n
	 * @return
	 */
	private static int sumOfDigits(int n)
	{
		return (n < 9) ? n : (n%10+sumOfDigits(n/10));
	}
}
