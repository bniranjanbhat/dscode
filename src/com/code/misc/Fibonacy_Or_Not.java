package com.code.misc;

import java.util.Scanner;
/*
 * we have to find if a given number ever occurs in a fibnaci seriees.
 * All we have to do is start arriving at the fibonacci series and then comparing the 
 * results at each stage with the number in question.
 */
public class Fibonacy_Or_Not {
	
	public static void main(String[] args) {
		System.out.println("Enter  Number");
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int f_num = 0;
		int s_num = 1;
		int t_num = 0;

		while (t_num < num) {
			t_num = f_num + s_num;
			f_num = s_num;
			s_num = t_num;

		}
		if (t_num == num) {
			System.out.println("number belongs to fibonacy series");
		} else {
			System.out.println("number does not belong to fibonacy series");
		}

	}
}
