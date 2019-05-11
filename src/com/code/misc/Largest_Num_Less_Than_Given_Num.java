package com.code.misc;

public class Largest_Num_Less_Than_Given_Num {
	public static void main(String[] args) {
		int num =548624;// 123;
		getMaxNum(num,8);

	}

	public static void getMaxNum(int num, int digit) {
		int num1 = num;
		int num2 = num1;
		boolean flag = true;
		while (flag) {
			int count = 0;
			num2 = num1;
			while (num2 != 0) {
				if (num2 % 10 == digit) {
					num2--;
					count++;
					break;
				}
				num2 = num2 / 10;
			}
			if (count == 0) {
				flag = false;
			} else
				num1 = num1 - 1;

		}
		System.out.println(num1);
	}
}
