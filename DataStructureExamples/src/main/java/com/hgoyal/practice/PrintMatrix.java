package com.hgoyal.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Print a 2D Matrix of the form where input n = 5:
 * 
 * 555555555
 * 544444445
 * 543333345
 * 543222345
 * 543212345
 * 543222345
 * 543333345
 * 544444445
 * 555555555
 * 
 * @author Hershit
 *
 */
class PrintMatrix 
{
	public static void main (String[] args) throws FileNotFoundException
	{
		String filePath = "D:\\Study\\Git_Repository\\java_practice\\DataStructureExamples\\resources\\";
		Scanner s = new Scanner(new FileInputStream(new File(filePath + "PrintMatrix.txt")));
		
        int T = s.nextInt(); //no of tests
        int i = 0;
        
        int[] input = new int[T]; //put all inputs in the array
        while (i < T) 
        {
        	input[i++] = s.nextInt();
        }
		
        //run program for each input
		for (i=0; i<T; i++)
		{
		    int n = input[i];
		    printMatrix(n);
	    }
		
		s.close();
	}
	
	private static void print2DArray(int[][] input, int size)
	{
	    for (int i=0; i<size; i++)
		{
		    for (int j=0; j<size; j++)
		    {
		        System.out.print(input[i][j]);
		    }
		    System.out.println();
		}
	}
	
	private static void printMatrix(int n)
	{
        int size = 2*n-1;
        int lastIndex = 2*n-2;
        
        int[][] output = new int[size][size];
        
        for (int k=0;k<=n-1;k++) //k will range from 0 to n-1
        {
            for (int i=k; i<=lastIndex-k; i++)
            {
                output[k][i] = output[i][k] = output[lastIndex-k][i] = output[i][lastIndex-k] = n-k;    
            }
        }
        print2DArray(output,size);
	}
}