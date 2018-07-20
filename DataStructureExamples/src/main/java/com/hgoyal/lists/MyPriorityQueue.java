package com.hgoyal.lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
 
public class MyPriorityQueue<T> 
{
	private List<T> list = new ArrayList<>(); //Represents a height balanced binary heap data structure backed by an array
													//For any element at index i, 2i, and 2i+1 are its left and right childs
													//For simplicity, let say index start from 1. e.g. for index = [1], items at [2,3] are its children
													//For index = [2], items at [4, 5] are its children, and so on...
													//A new item is inserted at the last of the array by simply doing list.add() and then heapifying().
													//The first item of the array is always removed. and then the array is heapified().
	
	private Comparator<T> itemComparator;
	
	public MyPriorityQueue(Comparator<T> itemComparator)
	{
		this.itemComparator = itemComparator;
		list.add(null);
	}
	
	//inserts at the end and heapify
	public void insert (T value)
	{
		list.add(value);
		
		int currentIndex = size()-1;
		int parentIndex = (currentIndex)/2;
		
		//keep swapping with parent until parent is max.
		while(parentIndex >= 1)
		{
			T current = list.get(currentIndex);
			T parent = list.get(parentIndex);
			if (itemComparator.compare(parent, current) < 0)
			{
				list.set(parentIndex, current);
				list.set(currentIndex, parent);
				currentIndex = parentIndex;
				parentIndex = (currentIndex)/2;
			}
			else
			{
				break;
			}
		}
	}
	
	//remove the root and heapify
	public T get()
	{
		int size = size();
		T returnValue;
		T lastElement;
		returnValue = list.get(1); //remove the root of the binary max heap
		lastElement = list.remove(size-1);
		
		if (size == 2) return returnValue;
		
		list.set(1, lastElement);
		
		int currentIndex = 1;
		int leftIndex = currentIndex*2;
		int rightIndex = currentIndex*2+1;
		
		size = size(); // reinitialize size as size is now reduced.
		
		while(true)
		{
			if (leftIndex > size-1) break;
			
			if (leftIndex == size-1) // there is no right item
			{
				T currentItem = list.get(currentIndex);
				T leftItem = list.get(leftIndex);
				if (itemComparator.compare(currentItem, leftItem) < 0)
				{
					list.set(currentIndex, leftItem);
					list.set(leftIndex, currentItem);
					currentIndex = leftIndex;
					leftIndex = currentIndex*2;
					rightIndex = leftIndex+1;
				}
				else
				{
					break;
				}
			}
			else
			{
				T currentItem = list.get(currentIndex);
				T leftItem = list.get(leftIndex);
				T rightItem = list.get(rightIndex);
	
				int toBeReplacedWithIndex = 0;
				if (itemComparator.compare(leftItem, rightItem) > 0)
				{
					toBeReplacedWithIndex = leftIndex;
				}
				else
				{
					toBeReplacedWithIndex = rightIndex;
				}
				
				T max = list.get(toBeReplacedWithIndex);
				
				if (itemComparator.compare(currentItem, max) < 0)
				{
					list.set(toBeReplacedWithIndex, currentItem);
					list.set(currentIndex, max);
					
					currentIndex = toBeReplacedWithIndex;
					leftIndex = currentIndex*2;
					rightIndex = leftIndex+1;
				}
				else
				{
					break;
				}
			}
		}
		
		return returnValue;
		
	}
	
	public int size()
	{
		return list.size();
	}
	
	

	public static void main(String args[])
	{
//		PriorityQueue<Integer> myqueue = new PriorityQueue<>();
//		myqueue.add(2);
//		myqueue.add(3);
//		myqueue.add(4);
//		myqueue.add(1);
//		
//		int size = myqueue.size();
//		
//		for (int i=1; i<=size; i++)
//		{
//			System.out.println(myqueue.remove());
//		}
		
		MyPriorityQueue<Integer> myqueue1 = new MyPriorityQueue<>(new MyComparator());
		myqueue1.insert(2);
		myqueue1.insert(3);
		myqueue1.insert(4);
		myqueue1.insert(1);
		myqueue1.insert(5);
//		myqueue1.insert(7);
		
		int size1 = myqueue1.size();
		
		System.out.println("Sorted:");
		
		for (int i=1; i<=size1-1; i++)
		{
			System.out.println(myqueue1.get());
		}
		
	}
}

class MyComparator implements Comparator<Integer>
{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1.intValue() - o2.intValue();
	}
	
}
