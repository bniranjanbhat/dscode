package com.code.sort.algo;


public class InsertionSort
{
	static void insertionSort()
	{
		for(int count = 1; count < SIZE; count ++)
			insertItem(0, count);
	}
	
	static void insertItem(int startIndex, int endIndex)
	{
		boolean finished = false;
		int current = endIndex;
		boolean moreToSearch = true;
		
		while(moreToSearch && !finished)
		{
			if(values[current] < values[current -1])
			{
				swap(current, current -1);
				current --;
				moreToSearch = (current != startIndex);
			}
			else
				finished = true;
		}
	}

   static void swap(int toIndex, int fromIndex){
      int tempvalue = values[toIndex];
      values[toIndex] = values[fromIndex];
      values[fromIndex] = tempvalue;
   }
   
   public static int values[] = {4,6,5,1,6,9};
   public static int SIZE = 6;

   public static void main(String args[]){
	
	int current = 0;
	System.out.println("Before:");
	for(int i=0;i<values.length;i++){
	    System.out.print(values[i]);
	    System.out.print("\t");
        }
	
	insertionSort();
	System.out.println("After:");
	for(int i=0;i<values.length;i++){
	    System.out.print(values[i]);
	    System.out.print("\t");
        }
  }
   
}