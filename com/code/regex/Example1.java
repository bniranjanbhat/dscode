package com.code.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Program t count number of 'H' in a given string
public class Example1 {
	public static void main(String[] args) {
		String str = "Hi Hello how are you";
		String ptrn = "H";
		int count = 0;
		Pattern p = Pattern.compile(ptrn, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(str);
		while (m.find()) {
			count++;
		}
		System.out.println(count);
		boolean b = Pattern.matches("a*b", "aaaaab");
		 System.out.println(Pattern.matches("a*b","aaaaab"));//in between a and b --a can come any num of times
		System.out.println(b);
	}
}
