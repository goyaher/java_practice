package com.hgoyal.simpleprograms;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class StringAPI {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        
// 1st line: Print the string removing all the spaces between words
// 2nd line: Print the longest word in the string
// 3rd line: print the number of occurances of the alphabet 'e'[case sensitive] in the string
// 4th line: Print the number of integer digits in the string
// 5th line: Print the number of words in the string
// 6th line: Print the number of sentences in the string
        
        String[] splits = line.split(" ");
        System.out.println(String.join("", splits));
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String string: splits)
        {
        	map.put(string, string.length());
        }
        
        map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(1).forEach(System.out::println);
        	
        
    }
}