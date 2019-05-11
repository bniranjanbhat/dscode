package com.code.sort.algo;


public class SelectionSort
{

	/*
	* Efficiency:
	* (N-1) +(N-2) +(N-3) + ...+ 1 = N(N-1)/2
	*/
	
	public static int values[] = {4,6,5,1,6,9};
	public static int SIZE = 6;

	public static void selectionSort()
	{
		int endIndex = SIZE - 1;
		for(int current = 0; current < endIndex; current++)
			swap(current, minIndex(current, endIndex));
	}

	static void swap(int toIndex, int fromIndex){
	    int tempvalue = values[toIndex];
	    values[toIndex] = values[fromIndex];
	    values[fromIndex] = tempvalue;
	}
	
	public static int minIndex(int startIndex, int endIndex)
	{
		int indexOfMin = startIndex;
		for(int index = startIndex + 1; index <= endIndex; index++)
		{
			if(values[index] < values[indexOfMin])
				indexOfMin = index;
		}
		return indexOfMin;
	}
	
	public static void main(String args[]) {
		System.out.println("Original Array:");
		for(int i=0;i< values.length; i++)
			System.out.print(values[i]+ "    ");
		selectionSort();
		System.out.println();
		System.out.println("Sorted Array:");
		for(int i=0;i< values.length; i++)
			System.out.print(values[i]+ "    ");
	}
}