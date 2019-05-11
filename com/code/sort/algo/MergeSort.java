package com.code.sort.algo;

/*
 * The mergeSort method splits the original array into two halves.
 *  It first sorts the first half of the array, using the divide and conquer approach; 
 *  then it sorts the second half of the array using the same approach; 
 *  then it merges the two halves. To sort the first half of the array it follows the same approach, 
 *  splitting and merging. During the sorting process the splitting and merging operations are all intermingled. 
 *  However, analysis is simplified if we imagine that all of the splitting occurs first—we can view the process 
 *  this way without affecting the correctness of the algorithm.
 *  
 *  
 * Merge sort is a divide and conquer algorithm.
 * The input array is divided into two halves recursively, until the size of the array becomes 1
 * Then the arrays are merged together in a sorted order.
 * This algorithm involves two functions:
 * - mergeSort(): this function divides the two arrays recursively, until the array size becomes 1
 * - merge(): this function merges the divided array into a single sorted array.
 */
public class MergeSort {
	static void merge(int leftFirst, int leftLast, int rightFirst, int rightLast) {
		int[] tempArray = new int[SIZE];
		int index = leftFirst;
		int saveFirst = leftFirst;

		while ((leftFirst <= leftLast) && (rightFirst <= rightLast)) {
			if (values[leftFirst] < values[rightFirst]) {
				tempArray[index] = values[leftFirst];
				leftFirst++;
			} else {
				tempArray[index] = values[rightFirst];
				rightFirst++;
			}
			index++;
		}

		while (leftFirst <= leftLast) {
			tempArray[index] = values[leftFirst];
			leftFirst++;
			index++;
		}

		while (rightFirst <= rightLast) {
			tempArray[index] = values[rightFirst];
			rightFirst++;
			index++;
		}

		for (index = saveFirst; index <= rightLast; index++) {
			values[index] = tempArray[index];

		}
	}

	static int[] values = { 3, 1, 55, 2, 23, 65, 44 };
	static int SIZE = 7;

	static void mergeSort(int first, int last) {
		if (first < last) {
			System.out.println("MergeSort: First: " + first + "  Last: " + last);
			int middle = (first + last) / 2;
			System.out.println("First MergeSort: First: " + first + " Middle: " + middle);
			mergeSort(first, middle);
			System.out.println("Second MergeSort: Middle " + (middle + 1) + " Last:" + last);
			mergeSort(middle + 1, last);
			System.out.println(
					"Merge: first:" + first + " middle: " + middle + " middle+1:" + (middle + 1) + " Last: " + last);
			merge(first, middle, middle + 1, last);
		}
	}

	public static void main(String args[]) {
		mergeSort(0, 6);
		for (int i = 0; i < values.length; i++)
			System.out.println(values[i]);
	}

}
