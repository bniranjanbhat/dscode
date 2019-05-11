package com.code.stack;
/*
* Here the first element in the array remains unused.
*/
class QueueUsingArray
{
   private static final int DEFAULT_SIZE = 8;
   private int size;
   private int front;
   private int back;
   private int[] values;
   
	public QueueUsingArray()
	{
		this(DEFAULT_SIZE);
	}
   
	public QueueUsingArray(int size)
	{
		this.size = size;
		values = new int[size];
		front = 0;
		back = 0;
	}
   public boolean isFull()
   {
		if( (back+1) % size == front)
		{
			return true;
		}
		else
		{
			return false;
		}
   }
   public boolean isEmpty()
   {
		if(back == front)
		{
			return true;
		}
		else
		{
			return false;
		}
   }
   public void enqueue(int x)
   {
      if(!isFull())
      {
         back = (back+1) % size;
         //size = 2
         // back = 1
         // back = 0
         // back = 1
         System.out.println("back: "+back);
         values[back] = x;
      }
   }
   public int dequeue()
   {
      if(!isEmpty())
      {
         front = (front+1) % size;
         return values[front];
      }
      return 0;
   }

   public static void main( String args[])
   {
      QueueUsingArray queue = new QueueUsingArray(8);
      queue.enqueue(10);
      queue.enqueue(20);
      queue.enqueue(30);
      for(int i=0; i<3; i++)
      {
          System.out.println(queue.dequeue());
      }
   }
}
