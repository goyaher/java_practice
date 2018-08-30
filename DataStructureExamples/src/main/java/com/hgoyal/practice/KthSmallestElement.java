package com.hgoyal.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This needs to to fixed.
 * 
 * @author Hershit
 *
 */
public class KthSmallestElement 
{
	private static void findKthSmallest(int arr[], int k)
	{
		int length = arr.length;
		int start = 0;
		int end = length - 1;
		
		int pivot = arr[k-1];
		while (start < end && start < pivot && end > pivot)
		{
			if (arr[start++] < pivot && start < pivot) continue;
			if (arr[end--] > pivot && end > pivot) continue;
			if (start < end)
			{
				swap(arr, start, end);
			}
		}
		System.out.println(arr[k-1]);
	}
	
	private static void swap(int[] arr, int start, int end)
	{
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
	
	public static void main(String args[]) throws FileNotFoundException
	{
		String filePath = "G:\\Study\\Git_Repository\\java_practice\\DataStructureExamples\\resources\\";
		Scanner s = new Scanner(new FileInputStream(new File(filePath + "KthSmallestElement.txt")));
		int size = s.nextInt();
		int[] arr = new int[size];
		for (int i=0; i<=size-1; i++)
		{
			arr[i] = s.nextInt();
		}
		
		findKthSmallest(arr, s.nextInt());	
		s.close();
	}
}
