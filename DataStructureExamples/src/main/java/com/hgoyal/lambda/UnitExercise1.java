package com.hgoyal.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class UnitExercise1 
{
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
									new Person("A", "B"),
									new Person("Hershit", "Goyal"),
									new Person("Ram", "Sharma"),
									new Person("Pramod", "Kumar"),
									new Person("Alex", "Hughes")
								);
		
		/*persons.sort(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getlName().compareTo(o2.getlName());
			}
		});*/
		
		//sort by last name
		persons.sort((o1, o2) -> o1.getlName().compareTo(o2.getlName()));
		
		//print all
		printAll(persons);
		
		System.out.println();
		
		//prints all ppl whose name starts with A
		printAll(persons, p -> p.getfName().startsWith("A"));
	}
	
	private static void printAll(List<Person> persons, Predicate<Person> p) {
		for (Person person:persons)
		{
			if (p.test(person))
			{
				System.out.println(person);
			}
		}
	}

	private static void printAll(List<Person> persons) {
		for (Person person:persons)
		{
			System.out.println(person);
		}
	}
}
