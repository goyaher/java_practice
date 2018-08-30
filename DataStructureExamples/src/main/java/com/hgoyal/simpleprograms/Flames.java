package com.hgoyal.simpleprograms;

public class Flames {

	public static void main(String args[]) {
		char[] array = {'F', 'L', 'A', 'M', 'E', 'S'};
		
		int countX = 0; //no of positions already made X;
		
		int i=0; //circular counter;
		
		int currentCounter = 1; //from 1 to 3; //CurrentIterations Counter;
		while (countX != 5)
		{
			if (currentCounter == 4)
			{
				if (array[i] == 'X') 
				{
					i++;
				}
				else
				{
					array[i] = 'X';
					i++;
					currentCounter = 1;
					countX++;
				}
			}
			else
			{
				if (array[i] == 'X')
				{
					i++;
				}
				else
				{
					i++;
					currentCounter++;
				}
			}
			if (i==6) i=0;
		}
		
		for (i=0; i< array.length; i++)
		{
			if (array[i] != 'X')
			System.out.println(array[i]);
		}
	}
}
