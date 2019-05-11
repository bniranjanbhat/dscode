package com.code.misc;

//Check whether given number is power of 2 or not
public class Number_Is_Power_Of_two {
	public static void main(String[] args) {
		int[] num = { 2, 4, 6, 8, 10, 12, 16 };
		for (int i : num) {
			if (isPowerOfTwo(i)) {
				System.out.println(i + " is power of 2");
			} else {
				System.out.println(i + " is not power of 2");
			}
		}
	}

	public static boolean isPowerOfTwo(int num) {
		int square = 2;
		while (num >= square) {
			if (num == square) {
				return true;
			}
			square *= 2;
		}
		return false;
	}
}
