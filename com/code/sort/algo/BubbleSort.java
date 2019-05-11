package com.code.sort.algo;


public class BubbleSort
{

static void bubbleUp(int startIndex, int endIndex)
{
  
	for(int index = endIndex; index > startIndex; index--)
	{
		if(values[index] < values[index -1])
			swap(index, index-1);
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
	
	while(current < SIZE -1)
	{
	    bubbleUp(current, SIZE -1);
	    current++;
	}    
      
	System.out.println("After:");
	for(int i=0;i<values.length;i++){
	    System.out.print(values[i]);
	    System.out.print("\t");
        }
}

}

