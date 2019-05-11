package com.code.regex;

import java.util.regex.Pattern;

/*Create a regular expression that accepts 10 digit numeric characters 
starting with 7, 8 or 9 only.*/
public class Example6 {
	public static void main(String[] args) {
		System.out.println(Pattern.matches("[789]{1}[0-9]{9}", "7894561230"));// true
		System.out.println(Pattern.matches("[789][0-9]{9}", "8894561230"));// true

		System.out.println(Pattern.matches("[789]{1}\\d{9}", "9894561230"));
	}
}
