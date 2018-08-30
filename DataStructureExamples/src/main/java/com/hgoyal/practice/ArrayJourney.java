package com.hgoyal.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Dynamic Programming problem of maximizing the score while moving in an array of integers.
 * You are at index=0 and have to go to index=arr.length-1 i.e. end of array.
 * 
 * This uses memoization.
 * 
 * @author Hershit
 *
 */
public class ArrayJourney 
{
	public static void main(String args[]) throws FileNotFoundException
	{
		String filePath = "G:\\Study\\eclipse_wspace\\DataStructures\\resources\\";
		Scanner s = new Scanner(new FileInputStream(new File(filePath + "ArrayJourney.txt")));
		int noOfTests = s.nextInt();
		for (int t=1; t<=noOfTests; t++)
		{
			int length = s.nextInt();
			int stepSize = s.nextInt();
			int[] input = new int[length];
	
			for (int i=0; i<length; i++)
			{
				input[i] = s.nextInt();
			}
			
			int score = findMaxScore(input, stepSize);
			
			System.out.println(score);
		}
		s.close();
	}
	
	private static int findMaxScore(int[] arr, int stepSize)
	{
		int length = arr.length;
		Integer[] scores = new Integer[length];
		
		for (int i=0; i<length; i++)
		{
			scores[i] = null; 
		}
		scores[length-1] = arr[length-1];
		scores[length-2] = arr[length-2]+scores[length-1];
		
		for (int i=length-1; i>=0; i--)
		{
			findScore(arr, stepSize, i, scores);
		}
		
		return scores[0];
	}
	
	private static int findScore(int[] arr, int stepSize, int pos, Integer[] scores)
	{
		if (pos==arr.length-2 || pos==arr.length-1) return scores[pos];

		int endPosition = Math.min(arr.length-1, pos+stepSize); // to avoid going to the end of array
		int score = findMax(arr, pos+1, endPosition, scores, stepSize) + arr[pos];
		scores[pos] = score;
		return score;
	}
	
	private static int findMax(int[] arr, int sp, int ep, Integer[] scores, int stepSize)
	{
		Integer max = null;
		for (int i=sp; i<=ep; i++)
		{
			int score = 0;
			if (scores[i] == null)
			{
				score = findScore(arr, stepSize, i, scores);
			}
			else
			{
				score = scores[i];
			}
			max = max==null ? score : Math.max(score, max);
		}
		
		return max;
	}
}
