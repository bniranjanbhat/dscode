package com.code.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example2 {
	public static void main(String[] args) {
		String str = "Hi Hello This is Java Hih how are you";
		int count = 0;
		Pattern p = Pattern.compile("hi", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(str);
		while (m.find()) {
			count++;
		}
		System.out.println(count);
	}
}
