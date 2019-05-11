package com.code.sort.algo;


class QuickSort
{
	private long[] theArray ;
	private int nElems;

	public QuickSort(int max)
	{
		theArray = new long[max];
		nElems = 0;
	}

	public void insert(long value)
	{
		theArray[nElems] = value;
		nElems++;
	}

	public void display()
	{
		System.out.print("A=");
		for(int j=0; j<nElems; j++)
			System.out.print(theArray[j] + " ");
		System.out.println("");
	}


	public void quickSort()
	{
		recQuickSort(0, nElems-1);
	}

	public void recQuickSort(int left, int right)
	{
		if(right-left <= 0)
			return; 
		else 
		{
			long pivot = theArray[right]; // rightmost item
			// partition range
			int partition = partitionIt(left, right, pivot);
			recQuickSort(left, partition-1); // sort left side
			recQuickSort(partition+1, right); // sort right side
		}
	}

	public int partitionIt(int left, int right, long pivot)
	{
		int leftPtr = left-1; // left (after ++)
		int rightPtr = right; // right-1 (after --)
		while(true)
		{
			while( theArray[++leftPtr] < pivot )
			; // (nop)
			// find smaller item
			while(rightPtr > 0 && theArray[--rightPtr] > pivot)
			; // (nop)
			if(leftPtr >= rightPtr) // if pointers cross,
			break; // partition done
			else // not crossed, so
			swap(leftPtr, rightPtr); // swap elements
		} // end while(true)
		swap(leftPtr, right); // restore pivot
		return leftPtr; // return pivot location
	} // end partitionIt()

	public void swap(int dex1, int dex2) 
	{
		long temp = theArray[dex1]; // A into temp
		theArray[dex1] = theArray[dex2]; // B into A
		theArray[dex2] = temp; // temp into B
	}

	public static void main(String[] args)
	{
		int maxSize = 16; // array size
		QuickSort arr;
		arr = new QuickSort(maxSize);
		for(int j=0; j<maxSize; j++) 
		{ 
			long n = (int)(java.lang.Math.random()*99);
			arr.insert(n);
		}
		arr.display();
		arr.quickSort(); 
		arr.display();
	} 

} 
