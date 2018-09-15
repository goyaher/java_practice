package com.hgoyal.lists;

public class LinkedList 
{
	Node first;
	Node last;
	
	void add(int value)
	{
		Node node = new Node(value);
		
		if (first == null && last == null) {
			first = node;
			last = node;
		}
		else
		{
			last.next = node;
			last = node;
		}
	}
	
	void printAll()
	{
		Node f = first;
		
		while (f != null)
		{
			System.out.println(f.value);
			f = f.next;
		}
	}
	
	void printFirst()
	{
		System.out.println(first==null ? null : first.value);
	}
	
	void printLast()
	{
		System.out.println(last==null ? null : last.value);
	}
	
	void reverse()
	{
		last = first;

		Node previous = null;
		while (first.next !=null)
		{
			Node temp = first.next;
			first.next = previous;
			previous = first;
			first = temp;
		}
		first.next = previous;
	}
	
	public static void main(String args[])
	{
		LinkedList linkedList = new LinkedList();
		
		for (int i=1; i<=10; ++i)
		{
			linkedList.add(i);
		}
		
		linkedList.printAll();
		linkedList.printFirst();
		linkedList.printLast();
		
		linkedList.reverse();
		
		System.out.println("Reveresed List: ");
		linkedList.printAll();
		linkedList.printFirst();
		linkedList.printLast();
		
	}
}

class Node
{
	int value;
	Node next;
	
	Node(int value)
	{
		this.value = value;
	}
}