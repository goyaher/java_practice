package com.hgoyal.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Demoes few more intermediate operations - sorted(), distinct(), map()
 * 
 * @author intel
 *
 */
public class IntermediateOperationsRunner {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(2, 3, 0, 2, 14);
		
		//print sorted
		numbers.stream().sorted().forEach(el -> System.out.println(el));
		
		//print distinct
		numbers.stream().sorted().distinct().forEach(el -> System.out.println(el));
		
		//Print squares of first 10 numbers
		IntStream.range(1, 10).map(el -> el*el).forEach(el -> System.out.println(el));
	}
}
