package com.code.tree;

public class Heap {
	/*
	 * Array that holds heap elements
	 */
	private Comparable[] elements; 

	/*
	 *  Index of last element in priority queue
	 */
	private int lastIndex;
	
	/*
	 * Index of last position in array
	 */
	private int maxIndex; 

	/*
	 * Constructor
	 */
	public Heap(int maxSize) {
		elements = new Comparable[maxSize];
		lastIndex = -1;
		maxIndex = maxSize - 1;
	}
	
	/*
	 * Determines whether this priority queue is empty
	 */
	public boolean isEmpty()
	{
		return (lastIndex == -1);
	}

	/*
	 * Determines whether this priority queue is full
	 */
	public boolean isFull()
	{
		return (lastIndex == maxIndex);
	}

	/*
	 *  Adds item to this priority queue
	 *  Throws PriQOverflowException if priority queue already full
	 */
	public void enqueue(Comparable item) {
		if (lastIndex == maxIndex)
			throw new IllegalStateException("Priority queue is full");
		else {
			lastIndex = lastIndex + 1;
			reheapUp(item);
		}
	}

	/*
	 * - Current lastIndex position is empty
	 * - Inserts item into the tree and maintains shape and order properties
	 * - We move this element up the tree while moving the tree elements down keeping the heap structure satisfied 
	 *   until the correct position is arrived. This is called the reHeapUp() operation.
	 */
	private void reheapUp(Comparable item)
	{
		int hole = lastIndex;
		// Hole is not root
		// Short circuit item > hole's parent
		while ((hole > 0) && (item.compareTo(elements[(hole - 1) / 2]) > 0)) {
			elements[hole] = elements[(hole - 1) / 2]; // Move hole's parent down
			hole = (hole - 1) / 2; // Move hole up
		}
		elements[hole] = item; // Place item into final hole
	}
	/*
	 * Removes element with highest priority from this priority queue and returns a reference to it 
	 * Throws PriQUnderflowException if priority queue is empty
	 */
	public Comparable delete()
	{
		Comparable hold; // Item to be dequeued and returned
		Comparable toMove; // Item to move down heap
		if (lastIndex == -1)
			throw new IllegalStateException("Heap is empty");
		else {

			hold = elements[0]; // Remember item to be returned
			toMove = elements[lastIndex]; // Item to reheap down
			lastIndex = lastIndex - 1; // Decrease priority queue size
			reheapDown(toMove); // Restore heap properties
			return hold; // Return largest element
		}

	}
	
	
	/*
	 * If either child of hole is larger than item, this returns the index
	 * of the larger child; otherwise, it returns the index of hole
	 */
	private int newHole(int hole, Comparable item)
	{
		int left = (hole * 2) + 1;
		int right = (hole * 2) + 2;
		// Case 1: Hole has no children
		if (left > lastIndex) {

			return hole;
		}
		// Case 2: Hole has left child only
		else if (left == lastIndex) {
			if (item.compareTo(elements[left]) < 0)
				// item < left child
				return left;
			else
				// item >= left child
				return hole;
		}
		// case 3: Hole has two children
		else {
			// Case 3.1: left child < right child
			if (elements[left].compareTo(elements[right]) < 0) {
				if (elements[right].compareTo(item) <= 0)
					// right child <= item
					return hole;
				else
					// item < right child
					return right;
			}
			// Case 3.2: left child >= right child
			else {
				if (elements[left].compareTo(item) <= 0)
					// left child <= item
					return hole;
				else
					// item < left child
					return left;
			}
		}
	}

	/*
	 * Current root position is "empty"
	 * Inserts item into the tree and ensures shape and order properties
	 */
	private void reheapDown(Comparable item) {
		{
			int hole = 0; // Current index of hole
			int newhole; // Index where hole should move to
			newhole = newHole(hole, item); // Find next hole
			while (newhole != hole) {
				elements[hole] = elements[newhole]; // Move element up
				hole = newhole; // Move hole down
				newhole = newHole(hole, item); // Find next hole
			}
			elements[hole] = item; // Fill in the final hole
		}
	}

}