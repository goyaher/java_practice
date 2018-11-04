package com.hgoyal.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Simple functional programming example demonstrating filter(), forEach() and map() methods which takes functions as arguments.
 * 
 * printing all - we pass a consumer or action
 * printing specific - we pass a predicate - a condition for filtering.
 * transform elements - we pass a function to transform each element.
 * 
 * Functional Interfaces used:
 * 
 * Consumer<T> - accept(T)
 * Predicate<T> - test(T)
 * Function<T,R> - R apply(T)
 * 
 * @author hgoyal
 *
 */
public class FunctionalProgrammingRunner {
	
	private static Consumer<String> print = element -> System.out.println(element); //global terminal operation to print a string

	public static void main(String[] args) 
	{ 
		List<String> fruits = Arrays.asList("apples", "mangoes", "bananas", "grapes");
		
		/*
		//Printing all
		printWithFP(fruits);
		
		//Print specific using normal loop
		printEndsWithBasic(fruits);
		
		//Printing specific using "filter"
		printEndsWithFP(fruits);
		printEndsWithFP2(fruits);
		*/
		
		//Print to upper case
		printToUpperFP(fruits);
	}

	private static void printToUpperFP(List<String> fruits) {
		fruits.stream().map(element -> element.toUpperCase()).forEach(print);
	}

	private static void printWithFP(List<String> fruits) {
		fruits.stream().forEach(System.out::println);
		
		//OR
		
//		fruits.stream().forEach(element -> System.out.println(element));
	}
	
	private static void printEndsWithFP(List<String> fruits) {
		fruits.stream().filter(f -> f.endsWith("es")).forEach(f -> System.out.println(f));
	}
	
	private static void printEndsWithFP2(List<String> fruits) {
		Predicate<String> endsWith = f -> f.endsWith("es"); //defined the test method 
		Consumer<String> print = f -> System.out.println(f); //defined the accept method
		
		fruits.stream().filter(endsWith).forEach(print);
	}

	private static void printEndsWithBasic(List<String> fruits) {
		for (String fruit: fruits)
		{
			if (fruit.endsWith("es"))
			{
				System.out.println(fruit);
			}
		}
	}
}
