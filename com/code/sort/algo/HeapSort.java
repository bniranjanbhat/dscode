package com.code.sort.algo;

/*
 * General idea behind Heap Sort:
 * 1. Convert the input array into a Heap using implicit links.
 * 2. Take the root (maximum) element off the heap, and put it into its place.
 * 3. Reheap the remaining elements. (This puts the next-largest element into the root position.)
 * 4. Repeat until there are no more elements.
 */
/*
 * The Array representation of the heap:
 * root is always at index 0
 * - If the element is not root, it’s parent is at position    (index - 1) / 2
 * - If the element has left child, the child is at position:  (index * 2) + 1 
 * - If the element has right child, the child is at position: (index * 2) + 2
 */
public class HeapSort {

	public void sort(int arr[]) {
		int n = arr.length;

		// Step 1: we will take the input array and convert it to a heap.
		// we will start reheaping from the first non-leaf node and re-heaping.
		// the first non-leaf node may be found at position SIZE/2 – 1.
		for (int i = n / 2 - 1; i >= 0; i--)
			reHeapDown(arr, n, i);

		// Step 2: One by one extract an element from the top of the heap,which would be the largest element.
		// Every time, the iteration happens, we will have one sorted element at the end of the array.
		// We will then run the next iteration on the reduced size of the array.
		for (int i = n - 1; i >= 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			reHeapDown(arr, i, 0);
		}
	}

	/*
	 *  To heapify a subtree rooted with node i which is an index in arr[].
	 *  n is size of heap
	 */
	void reHeapDown(int arr[], int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			reHeapDown(arr, n, largest);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver program
	public static void main(String args[]) {
		int arr[] = { 25,17,36,2,3,100,1,19,7};
		int n = arr.length;

		HeapSort ob = new HeapSort();
		ob.sort(arr);

		System.out.println("Sorted array is");
		printArray(arr);
	}
}
