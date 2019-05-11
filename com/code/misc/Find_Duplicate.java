package com.code.misc;

//You have got a range of numbers between 1 to N, where one of the number is
//repeated. You need to write a program to find out the duplicate number.
public class Find_Duplicate {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 11, 12 };// 1 to N,
		int size = arr.length - 1;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		int duplicate = sum - (size * (size + 1) / 2);
		System.out.println(duplicate);
	}
}
