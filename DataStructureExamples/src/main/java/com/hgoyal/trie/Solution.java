package com.hgoyal.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Trie
 * 
 * Sample test case(input): 
 * 
 * 4
 * add hack
 * add hackerrank
 * find hac
 * find hak
 * 
 * Output:
 * 2
 * 0
 * @author intel
 *
 */
public class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    
    private static TrieNodeElement trie = new TrieNodeElement();    
   
    static void add(String s)
    {
        int length = s.length();
        TrieNodeElement currentNode = trie;
        for (int i=0; i<length; i++)
        {
            char currentChar = s.charAt(i);
            
            if (currentNode.children.get(currentChar) == null)
            {
                TrieNodeElement nextNode = new TrieNodeElement();
                nextNode.c = currentChar;                
                currentNode.children.put(currentChar, nextNode);
            }
            
            currentNode = currentNode.children.get(currentChar);
        }
        currentNode.isWord = true;
    }
    
    static int find(String s)
    {
        int noOfWords = 0;
        int length = s.length();
        TrieNodeElement currentNode = trie;
        for (int i=0; i<length; i++)
        {
            char currentChar = s.charAt(i);
            
            if (currentNode.children.get(currentChar) != null)
            {
                currentNode = currentNode.children.get(currentChar);
            }
            else
            {
                return 0; //if the prefix itself is not fully matched that means 0 words startig with that prefix!
            }
        }
        
        noOfWords = findLeaves(currentNode);
        
        if (currentNode.isWord) 
        {
            noOfWords++;    
        }
        
        // find count of leaves starting from currentNode;
        return noOfWords;
    }
    
    static int findLeaves(TrieNodeElement element)
    {
        int leavesOfThisNode = 0;
        
        for (Character key : element.children.keySet())
        {
        	TrieNodeElement element1 = element.children.get(key);
            if (element1 != null)
            {
                if (element1.isWord)
                {
                    leavesOfThisNode +=1;
                }
                
                leavesOfThisNode += findLeaves(element1);
            }
        }
        
        return leavesOfThisNode;
    }
    
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];
            String contact = opContact[1];
            
            if (op.equals("add"))
            {
                add(contact);
            }
            else
            {
                System.out.println(find(contact));
            }
        }
        
        scanner.close();
    }
    
}

class TrieNodeElement{
    Character c = null;
    Map<Character, TrieNodeElement> children = new HashMap<>();
    boolean isWord = false;
    
    public String toString()
    {
        return ""+c+","+isWord;
    }
}
