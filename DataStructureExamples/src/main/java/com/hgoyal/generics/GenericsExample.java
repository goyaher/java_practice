package com.hgoyal.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {

	public static void main(String args[])
	{
		List<EvenNumber> le = new ArrayList<>();
		List<? extends NaturalNumber> ln = new ArrayList<>();
		EvenNumber nn = new EvenNumber(35);
//		ln.add(nn); not allowed
	}
}

class NaturalNumber {

    private int i;

    public NaturalNumber(int i) { this.i = i; }
    // ...
}

class EvenNumber extends NaturalNumber {

    public EvenNumber(int i) { super(i); }
    // ...
}

///Consider the following code:


