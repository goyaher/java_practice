package com.hgoyal.generics;

import java.util.Arrays;

//Write a generic method to exchange the positions of two different elements in an array.
public class ExchangePositions 
{
	public static void main(String args[])
	{
		Integer[] input = {1, 2, 3, 4};
		exchangePosition(input, 0, 3);
		System.out.println(Arrays.asList(input).toString());
	}
	
	private static <T> void exchangePosition(T[] input, int i, int j)
	{
		T ith = input[i];
		input[i] = input[j];
		input[j] = ith;
	}
}
