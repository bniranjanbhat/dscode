package com.code.search.algo;

/*
 * demonstrates recursive binary search
 */
class BinarySearchApp {
	private long[] a;
	private int nElems; // number of data items

	public BinarySearchApp(int max) 
	{
		a = new long[max];
		nElems = 0;
	}

	public int size() {
		return nElems;
	}

	public int find(long searchKey) {
		return recFind(searchKey, 0, nElems - 1);
	}

	private int recFind(long searchKey, int lowerBound, int upperBound) {
		int curIn;
		curIn = (lowerBound + upperBound) / 2;
		if (a[curIn] == searchKey)
			return curIn; // found it
		else if (lowerBound > upperBound)
			return nElems; // can't find it
		else // divide range
		{
			if (a[curIn] < searchKey) // it's in upper half
				return recFind(searchKey, curIn + 1, upperBound);
			else // it�s in lower half
				return recFind(searchKey, lowerBound, curIn - 1);
		} 
	} 

	public void insert(long value) 
	{
		int j;
		for (j = 0; j < nElems; j++) 
			if (a[j] > value) 
				break;
		for (int k = nElems; k > j; k--) 
			a[k] = a[k - 1];
		a[j] = value; 
		nElems++; 
	} 

	public void display()
	{
		for (int j = 0; j < nElems; j++) 
			System.out.print(a[j] + ""); 
		System.out.println("");
	}
} 