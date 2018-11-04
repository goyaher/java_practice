package com.hgoyal.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Demos reduce() method on Streams.
 * 
 * Functional Interfaces:
 * 
 * BinaryOperator<T> apply(T, T)
 *  
 * @author hgoyal
 *
 */
public class FunctionalProgrammingNumberRunner {

	private static Consumer<Integer> print = element -> System.out.println(element); //global terminal operation to print a string

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 4, 9, 13, 2); //Sum = 29
		
//		numbers.stream().forEach(System.out::println);
		
		normalSum(numbers);
		
		sumFP(numbers);
		
		sumFPDetailed(numbers);
		
		printSquaresFP(numbers);
		
	}
	
	private static void printSquaresFP(List<Integer> numbers)
	{
		numbers.stream().map(el -> el*el).forEach(print);
	}

	private static void sumFP(List<Integer> numbers) {
		int sum = numbers.stream().reduce(0, (n1, n2) -> n1+n2);
		System.out.println(sum);
	}
	
	private static void sumFPDetailed(List<Integer> numbers) {
		int sum = numbers.stream().reduce(0, (n1, n2) -> 
		{
			System.out.println(n1 + " " + n2);
			return n1+n2;
		});
		System.out.println(sum);
	}

	private static void normalSum(List<Integer> numbers) {
		int sum = 0;
		for (Integer number:numbers)
			sum+=number;
		System.out.println(sum);
	}
}
