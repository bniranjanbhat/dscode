package com.code.regex;

import java.util.regex.Pattern;

//String contains number or not
public class Example8 {
	public static void main(String[] args) {
		String str = "756";
		// Pattern p = Pattern.compile("\\d");
		if (Pattern.matches("\\d+", str)) {
			System.out.println("Given String is number");
		} else {
			System.out.println("Given string is not number");
		}
	}
}
