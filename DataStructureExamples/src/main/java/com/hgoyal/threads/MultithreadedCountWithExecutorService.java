package com.hgoyal.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MultithreadedCountWithExecutorService {

	static int CONCURRENCY_LEVEL = 4;
	static int SIZE = 10_0000;
	
	public static void main(String args[]) throws InterruptedException, ExecutionException
	{
		System.out.println(Thread.currentThread().getName());
		
		List<Integer> list = new ArrayList<>();
		for (int i=1; i<=SIZE; i++)
		{
			list.add(i);
		}
		
		List<Future<Integer>> results = new ArrayList<Future<Integer>>(CONCURRENCY_LEVEL);
		ExecutorService es = Executors.newFixedThreadPool(CONCURRENCY_LEVEL);
		
		try
		{
			for (int i=0; i<CONCURRENCY_LEVEL; i++)
			{
				//spawn threads that count size.
				results.add(es.submit(new SizeCounter1(list, i)));
			}
	
			int totalCount = 0;
			System.out.println("...summing results");
			for (int i=0; i<CONCURRENCY_LEVEL; i++)
			{
				totalCount += results.get(i).get();
			}
			
			System.out.println(totalCount);
		}
		finally
		{
			es.shutdown();
		}
			
	}	
}
	
class SizeCounter1 implements Callable<Integer>
{
	private List<Integer> data;
	private int sleepsecs;
	
	SizeCounter1(List<Integer> data, int sleepsecs)
	{
		this.data = data;
		this.sleepsecs = sleepsecs;
	}
	
	public Integer call() 
	{
		System.out.println(Thread.currentThread().getName());
		int count = 0;
		
		try
		{
			Thread.sleep(5000);
		}
		catch (Exception e)
		{
			
		}
		
		for (Integer i : data)
		{
			count++;
		}
		
		return count;
	}
}