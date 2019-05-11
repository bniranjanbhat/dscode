package com.code.misc;

import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		boolean flag = true;
		System.out.println("Enter a number");
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		if (input == 1 || input == 2 || input == 3) {
			System.out.println(input + " is prime");
		} else {
			for (int i = 2; i <= input / 2; i++) {
				if (input % i == 0) {
					flag = false;
					System.out.println("Not Prime");
					break;
				}
			}
		}
		if (flag == true) {
			System.out.println("Prime");
		}
	}
}
