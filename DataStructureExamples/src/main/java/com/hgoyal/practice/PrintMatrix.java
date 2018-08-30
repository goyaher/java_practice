package com.hgoyal.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
	public static void main (String[] args) throws Exception
	{
		int[] input = readInput();
		
		for (int i=1; i<=input[0]; i++)
		{
		    int n = input[i];
		    printMatrix(n);
	    }
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
	
	private static int[] readInput() throws Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string;
        string = br.readLine();
        if (string != null)
        {
            int T = Integer.parseInt(string);
            if (T>0)
            {
                int[] input = new int[T+1]; //max 100 tests + 1 for first line.
                input[0] = T;
                int i = 1;
                while ((string = br.readLine()) != null && !string.equals("exit")) 
                {
                    input[i++] = Integer.parseInt(string);
                }
                return input;
            }
            else
            {
                int[] input = new int[1];
                input[0] = T;
                return input;
            }
        }
        else
        {
            return null;
        }
    }
}