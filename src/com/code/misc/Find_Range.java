package com.code.misc;

public class Find_Range {
	// You are given an array of numbers. Find out the array index or position
	// where sum of numbers preceeding the index is equals to sum of numbers
	// succeeding the index.
	public static void main(String[] args) {
		int[] num = {0,4, 4,3, 5};
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			sum += num[i];
			int sum_ = 0;
			for (int j = i + 1; j < num.length; j++) {
				sum_ += num[j];
			}
			if (sum == sum_) {
				System.out.println("Sum Index Matching at the index is=" + i);
				break;
			}

		}
	}
}
