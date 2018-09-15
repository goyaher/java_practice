package com.hgoyal.generics;

import java.util.ArrayList;
import java.util.Collection;

//Write a generic method to count the number of elements in a collection that have 
//a specific property (for example, odd integers, prime numbers, palindromes).
public class CountEvenNumbers {
	public static void main(String args[])
	{
		Collection<Integer> collection = new ArrayList<>();
		collection.add(Integer.valueOf(2));
		collection.add(Integer.valueOf(13));
		collection.add(Integer.valueOf(15));
		collection.add(Integer.valueOf(1));
		int count = countIf(collection, new OddTestPredicate());
		System.out.println(count);
	}
	
	private static int countIf(Collection<? extends Number> collection, Predicate<Number> p)
	{
		int count=0;
		for (Number n : collection)
		{
			if (p.test(n)) count++;
		}
		return count;
	}
	
}

interface Predicate<T extends Number>
{
	boolean test(T input);
}

class OddTestPredicate implements Predicate<Number>
{
	public boolean test(Number input)
	{
		return input.intValue()%2 != 0;
	}
}