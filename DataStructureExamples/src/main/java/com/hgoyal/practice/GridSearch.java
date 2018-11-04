package com.hgoyal.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Given a 2D array of digits or grid, try to find the occurrence of a given 2D pattern of digits. For example, consider the following grid: 
1234567890  
0987654321  
1111111111  
1111111111  
2222222222  
Assume we need to look for the following 2D pattern array: 
876543  
111111  
111111
 * @author Hershit
 *
 */
public class GridSearch 
{
	// Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) 
    {
        int gRows = G.length;        
        int pRows = P.length;
        
        //find the first row in G which contains the first row of P
        for (int i=0; i<=gRows-pRows; i++)
        {
            int position = rowSearch(G[i], P[0], 0);
            while (position != -1) //first row found
            {
                //in the grid part from row=i+1 to row=i+pRows 
                int j=i+1;
                for (int k=1; j<i+pRows; j++, k++)
                {
                    int pos = rowSearch(G[j], P[k], position); 
                    if (pos != -1 && pos == position)
                    {
                        continue;
                    }
                    else
                    {
                        break;
                    }
                }
                if (j==i+pRows)
                {
                    return "YES";
                }
                
                position = rowSearch(G[i], P[0], position+1);
            }
        }
        
        //if we come to this point, we must have exhuasted outer loop, and not found the pattern
        return "NO";        
    }
    
    static int rowSearch(String g, String p, int position)
    {
        return g.indexOf(p, position);
    }
    
    static void printFound(boolean found)
    {
        if (found)
          System.out.println("YES");
        else
            System.out.println("NO");
    }
    

    public static void main(String[] args) throws IOException 
    {
    	String filePath = "G:\\Study\\Git_Repository\\java_practice\\DataStructureExamples\\resources\\";
		Scanner scanner = new Scanner(new FileInputStream(new File(filePath + "GridSearch.txt")));
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) 
        {
            String[] RC = scanner.nextLine().split(" ");
            int R = Integer.parseInt(RC[0]);
            int C = Integer.parseInt(RC[1]);
            String[] G = new String[R];
            for (int i = 0; i < R; i++) 
            {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");
            int r = Integer.parseInt(rc[0]);
            int c = Integer.parseInt(rc[1]);
            String[] P = new String[r];
            for (int i = 0; i < r; i++) 
            {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            System.out.println(result);
        }

        scanner.close();
    }
}
