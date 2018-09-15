package com.geeksforgeeks.exercises;

public class ReverseTheDigits 
{
	public static void main(String args[])
	{
		int n = 25678; //((2*10+5)*10+6
		int reversed = reverseDigits(n);
		System.out.println(reversed);
	}
	
	private static int reverseDigits(int n)
	{
		int reversed = 0;
		while (n != 0)
		{
			reversed = reversed*10 + n%10;
			n = n/10;
		}
		return reversed;
	}
}
