package com.code.misc;

/*If �n� is the positive number and �a� is an array of integers of length n-1 containing elements from 
 * 1 to n. Then find the missing number in �a� in the range from 1 to n. Occurrence of each element 
 * is only once. If n = 8, then array �a� will have 7 elements in the range from 1 to 8.
 *  For example {1, 4, 5, 3, 7, 8, 6}. One number will be missing in �a� (2 in this case). You have to find out that missing number.*/
public class Find_Missing_Number {
	public static void main(String[] args) {
		int highest_num = 10;
		int sum_highest_num = highest_num * (highest_num + 1) / 2;
		int[] arr = { 1, 4, 5, 3, 7, 2, 6,8,10 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		int mssing_num = sum_highest_num - sum;
		System.out.println(mssing_num);
	}
}
