package com.code.stack;
public class StackUsingArray
{
   private int size;
   private int top;
   private int[] values;
   
	public StackUsingArray(int size)
	{
		this.size = size;
		values = new int[size];
		top = -1;
	}

	public boolean isFull()
	{
		if(top < size-1)
        {
           return false;
        }
         else
		{
			return true;
		}
	}

	public void push(int x)
	{
		if(!isFull())
		{
			top++;
			values[top] = x;
		}
	}

	public boolean isEmpty()
	{
	   if(top == -1)
	   {
		  return true;
	   }
	   else
	   {
		  return false;
	   }
	}
	
	public int pop()
	{
	   int retVal = 0;
	   if(!isEmpty())
	   {
		  retVal = values[top];
		  top--;
	   }
	   return retVal;
	}

	public static  void main( String args[])
	{
      StackUsingArray myStack = new StackUsingArray(10);
    }

}






