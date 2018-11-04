package com.moglix.round3;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxAscendingSubArray 
{
	public static void main(String args[]) throws FileNotFoundException
	{
		String filePath = "G:\\Study\\Git_Repository\\java_practice\\DataStructureExamples\\resources\\";
		Scanner scanner = new Scanner(new FileInputStream(new File(filePath + "MaxAscendingSubArray.txt")));
		
		int noOfTests = scanner.nextInt();
		
		for (int k=0; k<noOfTests; k++)
		{
			int size = scanner.nextInt();
			int input[] = new int[size];
			for (int i=0; i < size; i++) 
			{
				input[i] = scanner.nextInt();
			}
			findMax(input);
		}
		
		scanner.close();
	}

	static void findMax(int args[]) 
	{
		int solStartPosition = 0;
		int startPosition = 0;
		int size = 1;
		int n = args.length;
		int i;
		for (i = 1; i < n; i++) 
		{
			if (args[i] > args[i - 1]) 
			{
				continue;
			} 
			int newSize = i - startPosition;
			if (newSize > size) 
			{
				size = newSize;
				solStartPosition = startPosition;
			} 
			startPosition = i;
		}
		//for the edge case when loop ends and the max asc sub array is at the last of the array
		int newSize = i - startPosition;
		if (newSize > size) 
		{
			size = newSize;
			solStartPosition = startPosition;
		} 
		
		System.out.println("startPosition " + solStartPosition);
		System.out.println("size " + size);
	}
}
