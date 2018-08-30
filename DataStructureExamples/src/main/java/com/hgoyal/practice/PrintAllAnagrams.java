package com.hgoyal.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PrintAllAnagrams 
{
	private static List<String> anagrams = new LinkedList<>();
	
	private static void findAnagrams(String str, int start, int end)
	{
		if (start == end) anagrams.add(str);
		
		for (int i=start; i<=end; i++)
		{
			str = swap(str, start, i);
			findAnagrams(str, start+1, end);
			str = swap(str, start, i);
		}
	}
	
	/**
	 * Swaps ith character with jth character in the input string "str".
	 */
	static String swap(String str, int i, int j)
	{
		char[] arr = str.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return String.valueOf(arr);
	}
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		findAnagrams(input, 0, input.length()-1);
		s.close();
		
		System.out.println(anagrams);
	}
	
}
