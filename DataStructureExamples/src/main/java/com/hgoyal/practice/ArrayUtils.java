package com.hgoyal.practice;

import java.util.Arrays;

public class ArrayUtils 
{
	/**
	 * Swaps element at position i with element at position j in the input array.
	 * @param input
	 * @param i
	 * @param j
	 */
	public static void swap(int[] input, int i, int j)
	{
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
	public static void printArrayLine(int[] input)
	{
	    for (int i=0; i<input.length; i++)
		{
		    System.out.println(input[i]);
		}
	}
	
	public static void printArraySpaceSeparated(int[] input)
	{
	    for (int i=0; i<input.length; i++)
		{
		    System.out.print(input[i] + " ");
		}
	}
	
	public static void printArray(int[] input)
	{
		Arrays.asList(input).forEach(System.out::print);
	}
}
