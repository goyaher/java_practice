package com.rategain.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Find first N prime numbers
 * 
 * @author Hershit
 *
 */
public class PrimeNumbers 
{
	private static List<Integer> primeNumbers = new ArrayList<Integer>(); //list of prime numbers found so far.
	
	/**
	 * Checks whether n is prime by checking if it is divisible by any number less than squarerootof(n);
	 * @param n
	 * @return
	 */
	private static boolean isPrime_1(int n)
	{
		int limit = (int)(Math.sqrt(n));
		for (int i=2; i<=limit; i++)
		{
			if (n%i == 0) return false;
		}
		return true;
	}

	
	/**
	 * Checks whether n is prime or not by checking if it is divisible by any of prime numbers less than n.
	 * Main idea here is to check divisiblity by only primes less than n, because the composites by definition will have
	 * a factor less than itself...and so on......So, only if that factor is prime (that is it doesn't not any more smaller factor), we need to check...
	 * 
	 * Faster than algo 1, but takes extra space to store & use previously computed primes.
	 * 
	 * @param n
	 */
	private static boolean isPrime_2(int n)
	{
		for (Integer primeNumber : primeNumbers)
		{
			if (n%primeNumber == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Makes use of the fact that a prime no. is of the form 6k+1 or 6k-1.
	 * 
	 * Improvement over algo 1 in time taken.
	 * 
	 * @param n
	 * @return
	 */
	private static boolean isPrime_3(int n)
	{
		if ((n-1)%6 == 0 || (n+1)%6 == 0) // i.e. only use the loop check if n is of the form 6n+1 or 6n-1
		{
			return isPrime_1(n);
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Finds first n prime numbers
	 * 
	 * @param n
	 */
	private static void findFirstNPrimeNumbers(int n, int strategy)
	{
		if (n>=1)
		{
			primeNumbers.add(2); // 2 is first prime number
		}
		if (n>=2) // loop until you have found n prime numbers
		{
			int i = 3;
			while (primeNumbers.size() != n)
			{
				boolean isPrime = false;
				switch (strategy)
				{
					case 1:
						isPrime = isPrime_1(i);
					case 2:
						isPrime = isPrime_2(i);
					case 3:
						isPrime = isPrime_3(i);
					default:
						isPrime = isPrime_1(i);
				}
				
				if (isPrime)
				{
					primeNumbers.add(i);
				}
				i++;
			}
		}
		printAll();
	}
	
	static void printAll()
	{
		System.out.println(primeNumbers);
		primeNumbers.clear();
	}
	
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(); // give input on the command prompt say n = 50
		findFirstNPrimeNumbers(n, 1);
		findFirstNPrimeNumbers(n, 2);
		findFirstNPrimeNumbers(n, 3);
		scanner.close();
	}
}
