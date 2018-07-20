package com.hgoyal.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample 
{
	public static void main(String args[])
	{
		Pair p1 = new Pair(1,2);
		Pair p2 = new Pair(3,4);
		Pair p3 = new Pair(-3,4);
		Pair p4 = new Pair(3,-4);
		
		List<Pair> pairs = new ArrayList<>();
		pairs.add(p1); pairs.add(p2); pairs.add(p3); pairs.add(p4);
		
		Collections.sort(pairs, Comparator.comparing(Pair::getX)); //sort by x
		System.out.println(Arrays.toString(pairs.toArray()));
		
		Collections.sort(pairs, Comparator.comparing(Pair::getX).reversed()); //sort by x desc
		System.out.println(Arrays.toString(pairs.toArray()));
		
		Collections.sort(pairs, Comparator.comparing(Pair::getX).thenComparing(Comparator.comparing(Pair::getY))); //sort by x and then y
		System.out.println(Arrays.toString(pairs.toArray()));
	}
}

class Pair
{
	int x;
	int y;
	
	Pair(int x, int y)
	{
		this.x=x; this.y=y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}
	
}
