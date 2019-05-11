package com.code.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;


//String ends with minimum 2 digit
public class Example9 {
	@Test
	public void test1() {
		String input = "Hi Hello this is java 180";
		Pattern p=Pattern.compile("\\d{2}$");
		Matcher m=p.matcher(input);
		
		if (m.find()) {
			System.out.println("String ends with 2 digit");
		} else {
			System.out.println("String does not ends with 2 numbers");
		}
	}
}
