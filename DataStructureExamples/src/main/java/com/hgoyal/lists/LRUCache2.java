package com.hgoyal.lists;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Hershit
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache2<K, V> 
{
	private int capacity;
	private Map<K, Node<K, V>> cache;
	private Node<K, V> mRU;
	private Node<K, V> lRU;
 	
	public LRUCache2(int capacity)
	{
		this.capacity = capacity;
		cache = new HashMap<K, Node<K, V>>();
		mRU = null;
		lRU = null;
	}
	
	public V get(K key)
	{
		Node<K, V> node = cache.get(key);
		V returnValue = node.value;
		
		//remove this node and make it mRU;
		Node<K, V> previous = node.previous;
		Node<K, V> next = node.next;
		previous.next = next;
		
		mRU.next = node;
		node.previous = mRU;
		mRU = node;
		mRU.next = null;
		
		return returnValue;
	}
	
	public void remove(K key)
	{
		Node<K, V> removedNode = cache.remove(key);
		
		Node<K, V> previous = removedNode.previous;
		Node<K, V> next = removedNode.next;
		previous.next = next;
		
		if (lRU == removedNode) lRU = next;
		if (mRU == removedNode) mRU = previous;
				
		removedNode.previous = removedNode.next = null;
	}
	
	public String toString()
	{
		String value = "{";
		
		Node<K, V> node = lRU;
		while (node != null)
		{
			value += node.key.toString() + ":" + node.value.toString() + ", ";
			node = node.next;
		}
		value += "}";
		
		return value;
	}

	public void put(K key, V value)
	{
		if (isFull())
		{
			evict();
		}
		
		Node<K, V> node = new Node<>();
		node.key = key; 
		node.value = value;
		
		cache.put(key, node);
		
		node.previous = mRU;
		node.next = null;
		
		if (mRU != null)
		{
			mRU.next = node;
		}
		
		mRU = node; // this node becomes the most recently used node
		
		if (lRU == null)
		{
			lRU = mRU;
		}
	}
	
	private boolean isFull()
	{
		return cache.size() == capacity;
	}
	
	private void evict()
	{
		Node<K, V> toBeEvictedNode = lRU;
		K key = toBeEvictedNode.key;
		cache.remove(key);
		
		lRU = toBeEvictedNode.next;
	}
	
	class Node<T, U>
	{
		T key;
		U value;
		Node<T, U> previous;
		Node<T, U> next;
	}
	
	public static void main(String args[])
	{
		LRUCache2<Integer, String> myCache = new LRUCache2<>(4);
		myCache.put(1, "O1");
		myCache.put(2, "O2");
		myCache.put(3, "O3");
		myCache.put(4, "O4");
		System.out.println(myCache.toString());
		myCache.get(3);
		System.out.println(myCache.toString());
		myCache.put(5,  "O5");
		System.out.println(myCache.toString());
		myCache.put(6, "O6");
		System.out.println(myCache.toString());
		myCache.remove(6);
		System.out.println(myCache.toString());
		myCache.put(7, "O7");
		System.out.println(myCache.toString());
	}
	
}
