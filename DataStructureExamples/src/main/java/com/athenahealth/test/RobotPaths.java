package com.athenahealth.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Algo:
 * 
 * Iterate over inputs.
 * For each robot: Get farthest button distance + no. of buttons = Time taken by O and R.
 * Return max of (O, R)
 * 
 * 
 * Sample Input:
 * 
 * 3
 * 4 O 2 B 1 B 2 O 4
 * 3 O 5 O 8 B 100
 * 2 B 2 B 1
 * 
 * Improvements:
 * 
 * - Use char instead of String for storing robot ID to save memory
 * - Put put String "O" in a static constant
 * - write Junits
 * - error handling
 * 
 * @author Hershit G
 *
 */
public class RobotPaths 
{
	public static void main(String args[]) throws FileNotFoundException
	{
		String filePath = "D:\\Study\\Git_Repository\\java_practice\\DataStructureExamples\\resources\\";
		Scanner scanner = new Scanner(new FileInputStream(new File(filePath + "RobotPaths.txt")));

		int noOfTests = scanner.nextInt();
		
		for (int i=1; i<=noOfTests; i++)
		{
			String line = scanner.nextLine();
			String[] tokens = line.split(" ");
			
			List<Integer> orangeList = new ArrayList<>();
			List<Integer> blueList = new ArrayList<>();
			
			for (int j=1; j<tokens.length; j=j+2)
			{
				String whichRobot = "";
				int distance = 0;
				
				whichRobot = tokens[j];
				distance = Integer.parseInt(tokens[j+1]);
				
				//put distance in the lists
				if (whichRobot.equals("O"))
				{
					orangeList.add(distance);
				}
				else
				{
					blueList.add(distance);
				}
			} // end single testcase "for"
			
			int time = getTime(orangeList, blueList);
			System.out.println("Case #" + i + ": " + time);
			
		}// end all test cases "for"
		
		scanner.close(); // close scanner
	}
	
	/**
	 * Main method which finds the minimum time needed.
	 * 
	 * @param orangeList list of buttons to press in input order.
	 * @param blueList list of buttons to press in input order.
	 * 
	 * @return the min time.
	 */
	static int getTime(List<Integer> orangeList, List<Integer> blueList)
	{
		int timeOrange = getRobotTime(orangeList);
		int timeBlue = getRobotTime(blueList);
		
		return Math.max(timeOrange, timeBlue);
	}
	
	/**
	 * Get time for "a" robot.
	 * 
	 * @param list
	 * @return
	 */
	static int getRobotTime(List<Integer> list)
	{
		if (list == null || list.isEmpty()) return 0;
		
		Collections.sort(list);
		int size = list.size();
		return list.get(size-1)+size; //get last element + size of list
	}
}
