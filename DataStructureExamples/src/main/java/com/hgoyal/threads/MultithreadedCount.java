package com.hgoyal.threads;

import java.util.ArrayList;
import java.util.List;

//This counts elements in a big list by n threads.
public class MultithreadedCount {

	static int CONCURRENCY_LEVEL = 4;
	static int SIZE = 10_0000;
	
	public static void main(String args[]) throws InterruptedException
	{
		System.out.println(Thread.currentThread().getName());
		
		List<Integer> list = new ArrayList<>();
		for (int i=1; i<=SIZE; i++)
		{
			list.add(i);
		}
		
		Thread[] threads = new Thread[CONCURRENCY_LEVEL];
		SizeCounter[] runnables = new SizeCounter[CONCURRENCY_LEVEL];
		
		for (int i=0; i<CONCURRENCY_LEVEL; i++)
		{
			//spawn 4 threads that count size.
			runnables[i] = new SizeCounter(list, i);
			threads[i] = new Thread(runnables[i]);
			threads[i].start();
		}
		
		threads[1].join();
		threads[2].join();
		threads[3].join();
		threads[0].join();
		
		int totalCount = 0;
		for (int i=0; i<CONCURRENCY_LEVEL; i++)
		{
			totalCount += runnables[i].getResult();
		}
		
		System.out.println(totalCount);
		
	}

}

class SizeCounter implements Runnable
{
	private List<Integer> data;
	private int sleepsecs;
	private int result;
	
	public int getResult()
	{
		return result;
	}
	
	SizeCounter(List<Integer> data, int sleepsecs)
	{
		this.data = data;
		this.sleepsecs = sleepsecs;
	}
	
	public void run() 
	{
		System.out.println(Thread.currentThread().getName());
		int count = 0;
		
		try
		{
			Thread.sleep(sleepsecs*1000);
		}
		catch (Exception e)
		{
			
		}
		
		for (Integer i : data)
		{
			count++;
		}
		
		result = count;
	}
}
