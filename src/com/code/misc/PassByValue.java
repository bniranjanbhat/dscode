package com.code.misc;

public class PassByValue {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println("Before Swaping:a=" + a + "and b=" + b);
		swap(10, 20);
		System.out.println("After Swaping:a=" + a + "and b=" + b);
	}

	static void swap(int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("In swaping function:a=" + a + " and b=" + b);
	}

}
