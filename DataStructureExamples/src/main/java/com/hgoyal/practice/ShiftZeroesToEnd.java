package com.hgoyal.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShiftZeroesToEnd 
{
	private static void move(int[] input)
	{
		int length = input.length;
		int leftMostZeroPosition = -1;
		
		for (int i=0; i<length; i++)
		{
			if (leftMostZeroPosition != -1) // we have found a position of zero.
			{
				if (input[i] != 0) //found a non-zero element, swap and update leftMostZeroPosition to next if next element is zero.
				{
					ArrayUtils.swap(input, i, leftMostZeroPosition);
					if (input[leftMostZeroPosition+1] == 0)
					{
						leftMostZeroPosition++; 
					}
					else
					{
						leftMostZeroPosition = -1;
					}
				}
				else
				{
					//do nothing
				}
			}
			else //we have NOT found a position of zero yet.
			{
				if (input[i] != 0) //found a non-zero element
				{
					//do nothing
				}
				else //found a zero element so set leftMostZeroPosition to i for next swap with non-zero element.
				{
					leftMostZeroPosition = i;
				}
			}
		}
	}
	
	
	public static void main(String args[]) throws FileNotFoundException
	{
		String filePath = "G:\\Study\\Git_Repository\\java_practice\\DataStructureExamples\\resources\\";
		Scanner s = new Scanner(new FileInputStream(new File(filePath + "ShiftZeroesToEnd.txt")));
		
		try
		{
			int noOfTests = s.nextInt();
			for (int j=1; j<=noOfTests; j++)
			{
				int length = s.nextInt();
				int[] input = new int[length];
			
				for (int i=0; i<length; i++)
				{
					input[i] = s.nextInt();
				}
				
				System.out.print("Input " + j + ": ");
				ArrayUtils.printArraySpaceSeparated(input);
				System.out.println();
				
				move(input);
				
				System.out.print("Output " + j + ": ");
				ArrayUtils.printArraySpaceSeparated(input);
				System.out.println();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			s.close();
		}
	}
}
