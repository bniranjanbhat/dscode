package com.code.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;


public class Example7 {
	// extract all the numbers into an array of integers
	@Test
	public void test1() {
		List<Integer> list = new ArrayList<Integer>();
		String str = "Hi 123 6 Hello 78 1??";
		// Pattern p = Pattern.compile("\\d+");//output:[123, 6, 78, 1]
		Pattern p = Pattern.compile("\\d");// output:[1, 2, 3, 6, 7, 8, 1]
		Matcher m = p.matcher(str);
		while (m.find()) {
			list.add(Integer.parseInt(m.group()));
		}
		System.out.println(list);
	}
}
